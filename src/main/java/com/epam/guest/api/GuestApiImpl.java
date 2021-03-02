package com.epam.guest.api;

import com.epam.guest.models.dto.GuestResourceDTO;
import com.epam.guest.services.GuestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Guest controller.
 */
@RestController
public class GuestApiImpl implements GuestApi {

    private final GuestService guestService;

    public GuestApiImpl(final GuestService guestService) {
        this.guestService = guestService;
    }

    /**
     * Gets guest information.
     *
     * @param guestId the guest id
     * @return the guest information
     */
    @Override
    public ResponseEntity<GuestResourceDTO> getGuestInformation(Long guestId) {
        return ResponseEntity.ok().body(guestService.getGuest(guestId));
    }

    /**
     * Add guest guest resource.
     *
     * @param guestResourceDTO the guest resource
     * @return the guest resource
     */
    @Override
    public ResponseEntity<GuestResourceDTO> addGuest(GuestResourceDTO guestResourceDTO) {
        return ResponseEntity.ok().body(guestService.addGuest(guestResourceDTO));

    }

    /**
     * Delete guest response entity.
     *
     * @param guestId the guest id
     * @return the response entity
     */
    @Override
    public ResponseEntity<String> deleteGuest(Long guestId) {
        guestService.deleteGuest(guestId);
        return ResponseEntity.ok().body("Guest with Id: " + guestId + " is deleted SuccessFully");
    }


}
