package com.project.ems.dao;

import org.springframework.data.repository.CrudRepository;

import com.project.ems.entities.Event;

public interface IEventRepository extends CrudRepository<Event, Long> {

    Iterable<Event> findTop3By();
    Iterable<Event> findByNameOrPlaceOrTypeOrDescriptionContains(String name, String place, String type, String desc);
}
