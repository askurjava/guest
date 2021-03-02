package com.epam.guest.services;

import com.epam.guest.models.dto.GuestResourceDTO;

/**
 * The interface Guest service.
 */
public interface GuestService {

    /**
     * Add guest guest resource dto.
     *
     * @param guestEntity the guest
     * @return the guest resource dto
     */
    GuestResourceDTO addGuest(GuestResourceDTO guestEntity);

    /**
     * Gets guest.
     *
     * @param guestId the guest id
     * @return the guest
     */
    GuestResourceDTO getGuest(Long guestId);

    /**
     * Delete guest string.
     *
     */
    void deleteGuest(Long guestId);

}
