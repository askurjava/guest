package com.epam.guest.api;

import com.epam.guest.TestData;
import com.epam.guest.models.dto.GuestResourceDTO;
import com.epam.guest.services.GuestServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

public class GuestApiTest {

    @InjectMocks
    private GuestApiImpl guestApi;

    @Mock
    private GuestServiceImpl guestService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testAddGuest() {
        Mockito.when(guestService.addGuest(ArgumentMatchers.any())).thenReturn(TestData.guestResourceDTO());
        ResponseEntity<GuestResourceDTO> guestResourceDTOResponseEntity = guestApi.addGuest(TestData.guestResourceDTO());
        Assert.assertEquals(guestResourceDTOResponseEntity.getStatusCodeValue(), 200);
    }

    @Test
    public void testGetGuestInformation() {
        Mockito.when(guestService.getGuest(ArgumentMatchers.any())).thenReturn(TestData.guestResourceDTO());
        ResponseEntity<GuestResourceDTO> guestResourceDTOResponseEntity = guestApi.getGuestInformation(TestData.guestResourceDTO().getGuestId());
        Assert.assertEquals(guestResourceDTOResponseEntity.getStatusCodeValue(), 200);
    }
}
