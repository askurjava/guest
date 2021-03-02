package com.epam.guest;

import com.epam.guest.models.dto.AddressResourceDTO;
import com.epam.guest.models.dto.GuestResourceDTO;
import com.epam.guest.models.entity.AddressEntity;
import com.epam.guest.models.entity.GuestEntity;

public class TestData {

    public static GuestResourceDTO guestResourceDTO() {
        return GuestResourceDTO.builder()
                .firstName("Shubham")
                .lastName("Shukla")
                .mobile(1212121212)
                .email("test@test.com")
                .guestId(1L)
                .address(addressResourceDTO())
                .build();
    }

    private static AddressResourceDTO addressResourceDTO() {
        return AddressResourceDTO.builder()
                .buildingName("Test Complex")
                .city("Noida")
                .state("UP")
                .country("India")
                .postalCode(201301)
                .build();
    }

    public static GuestEntity guestEntity(){
        return GuestEntity.builder()
                .id(1L)
                .firstName("Shubham")
                .lastName("Shukla")
                .mobile(2121212121)
                .email("test@test.com")
                .address(addressEntity())
                .build();
    }
    private static AddressEntity addressEntity(){
        return AddressEntity.builder()
                .buildingName("test")
                .city("Noida")
                .state("UP")
                .country("India")
                .postalCode(201301)
                .build();
    }
}
