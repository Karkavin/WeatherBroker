package ru.touchit.api.dao;

import org.springframework.data.repository.CrudRepository;
import ru.touchit.api.model.Condition;
import ru.touchit.api.model.Location;

import java.util.Date;
import java.util.List;

public interface ConditionDao extends CrudRepository<Condition, Long> {
    List<Condition> findByLocationAndDateGreaterThanEqual(Location location, Date date);
    Condition findFirstByLocationOrderByDateDesc(Location location);
}