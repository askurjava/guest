package com.epam.guest.mapper;

import com.epam.guest.models.dto.AddressResourceDTO;
import com.epam.guest.models.dto.GuestResourceDTO;
import com.epam.guest.models.entity.AddressEntity;
import com.epam.guest.models.entity.GuestEntity;

import java.util.Optional;

/**
 * The interface Guest mapper.
 */
public class GuestMapper {


    /**
     * To guest resource guest resource dto.
     *
     * @param guestEntity the guest
     * @return the guest resource dto
     */
    public static GuestResourceDTO toGuestResource(final GuestEntity guestEntity) {
        return GuestResourceDTO.builder()
                .guestId(Optional.ofNullable(guestEntity.getId()).orElse(null))
                .firstName(guestEntity.getFirstName())
                .lastName(guestEntity.getLastName())
                .address(toAddressResource(guestEntity.getAddress()))
                .email(guestEntity.getEmail())
                .mobile(guestEntity.getMobile())
                .build();
    }

    /**
     * To address resource address resource dto.
     *
     * @param addressEntity the address
     * @return the address resource dto
     */
    public static AddressResourceDTO toAddressResource(final AddressEntity addressEntity) {
        return AddressResourceDTO.builder()
                .buildingName(addressEntity.getBuildingName())
                .city(addressEntity.getCity())
                .state(addressEntity.getState())
                .country(addressEntity.getCountry())
                .postalCode(addressEntity.getPostalCode())
                .build();
    }

    /**
     * To guest guest.
     *
     * @param guestResourceDTO the guest resource dto
     * @return the guest
     */
    public static GuestEntity toGuest(final GuestResourceDTO guestResourceDTO) {
        return GuestEntity.builder()
                .firstName(guestResourceDTO.getFirstName())
                .lastName(guestResourceDTO.getLastName())
                .email(guestResourceDTO.getEmail())
                .mobile(guestResourceDTO.getMobile())
                .address(toAddress(guestResourceDTO.getAddress()))
                .build();
    }

    /**
     * To address address.
     *
     * @param addressResourceDTO the address resource dto
     * @return the address
     */
    public static AddressEntity toAddress(final AddressResourceDTO addressResourceDTO) {
        return AddressEntity.builder()
                .buildingName(addressResourceDTO.getBuildingName())
                .city(addressResourceDTO.getCity())
                .state(addressResourceDTO.getState())
                .country(addressResourceDTO.getCountry())
                .postalCode(addressResourceDTO.getPostalCode())
                .build();
    }
}
