package com.epam.guest.service;

import com.epam.guest.TestData;
import com.epam.guest.dal.GuestRepository;
import com.epam.guest.exceptions.GuestNotFoundException;
import com.epam.guest.models.dto.GuestResourceDTO;
import com.epam.guest.models.entity.GuestEntity;
import com.epam.guest.services.GuestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

public class GuestServiceTest {

    @InjectMocks
    private GuestServiceImpl guestService;

    @Mock
    private GuestRepository guestRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddGuest(){
        GuestEntity guestEntity = TestData.guestEntity();
        Mockito.when(guestRepository.save(ArgumentMatchers.any())).thenReturn(guestEntity);
        GuestResourceDTO guestResourceDTO = guestService.addGuest(TestData.guestResourceDTO());
        Assert.assertNotNull(guestResourceDTO);
        Mockito.verify(guestRepository).save(ArgumentMatchers.any());
    }

    @Test
    public void testGetGuest(){
        Mockito.when(guestRepository.findById(1L)).thenReturn(java.util.Optional.ofNullable(TestData.guestEntity()));
        GuestResourceDTO guest = guestService.getGuest(1L);
        Assert.assertNotNull(guest);
        Mockito.verify(guestRepository).findById(1L);
    }

    @Test
    public void testGetGuestWhenNoRecordFound(){
        GuestResourceDTO guest = guestService.getGuest(2L);
        Assert.assertNull(guest);
    }

    @Test(expected = GuestNotFoundException.class)
    public void testDeleteGuestWhenGuestIdNotFound(){
        guestService.deleteGuest(1L);
    }

    @Test
    public void testDeleteGuest(){
        GuestEntity guestEntity = TestData.guestEntity();
        Mockito.when(guestRepository.findById(guestEntity.getId())).thenReturn(java.util.Optional.of(guestEntity));
        guestService.deleteGuest(guestEntity.getId());
        Mockito.verify(guestRepository).findById(guestEntity.getId());
    }
}
