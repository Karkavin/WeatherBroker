package ru.touchit.api.dao;

import org.springframework.data.repository.CrudRepository;
import ru.touchit.api.model.Location;

public interface LocationDao extends CrudRepository<Location, String> {

}