package com.epam.guest.services;

import com.epam.guest.dal.GuestRepository;
import com.epam.guest.exceptions.GuestNotFoundException;
import com.epam.guest.mapper.GuestMapper;
import com.epam.guest.models.dto.GuestResourceDTO;
import com.epam.guest.models.entity.GuestEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * The type Guest service.
 */
@Slf4j
@Service
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;

    /**
     * Instantiates a new Guest service.
     *
     * @param guestRepository the guest repository
     */
    public GuestServiceImpl(final GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }


    /**
     * Add guest guest resource dto.
     *
     * @return the guest resource dto
     */
    @Override
    public GuestResourceDTO addGuest(GuestResourceDTO resourceDTO) {
        log.info("Request for adding a guest: "+ resourceDTO);
        GuestEntity guestEntity = GuestMapper.toGuest(resourceDTO);
        GuestEntity response = guestRepository.save(guestEntity);
        log.info("Guest is added successfully with Id: "+ response.getId());
        return GuestMapper.toGuestResource(response);
    }

    /**
     * Gets guest.
     *
     * @param guestId the guest id
     * @return the guest
     */
    @Override
    public GuestResourceDTO getGuest(Long guestId) {
        log.info("Request for fetching the Guest information for guest Id: "+ guestId);
        return Optional.ofNullable(guestId)
                .flatMap(guestRepository::findById)
                .map(GuestMapper::toGuestResource)
                .orElse(null);
    }

    /**
     * Delete guest string.
     */
    @Override
    public void deleteGuest(final Long guestId) {
        log.info("Request for deleting the Guest with guest Id:"+ guestId);
        if (guestId != null) {
            Optional<GuestEntity> guestEntity = guestRepository.findById(guestId);
            if (guestEntity.isEmpty()) {
                throw new GuestNotFoundException("Guest is not found");
            }
        }
    }
}
