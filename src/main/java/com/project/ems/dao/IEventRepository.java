package com.project.ems.dao;

import com.project.ems.entities.Event;
import org.springframework.data.repository.CrudRepository;

public interface IEventRepository extends CrudRepository<Event, Long> {

    Iterable<Event> findTop3By();
    Iterable<Event> findByNameOrPlaceOrTypeOrDescriptionContains(String name, String place, String type, String desc);
}
