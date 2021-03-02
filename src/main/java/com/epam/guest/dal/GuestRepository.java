package com.epam.guest.dal;

import com.epam.guest.models.entity.GuestEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends CrudRepository<GuestEntity, Long> {
}
