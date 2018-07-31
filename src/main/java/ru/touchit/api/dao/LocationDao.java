package ru.touchit.api.dao;

import org.springframework.data.repository.CrudRepository;
import ru.touchit.api.model.Location;

import java.util.List;

/**
 * Dao для работы с местонахождением {@link Location}
 * @author Artyom Karkavin
 */
public interface LocationDao extends CrudRepository<Location, Long> {
    /**
     * Получить список всех местонахождений по наименованию города
     * @return список всех местонахождений
     * @see Location
     */
    List<Location> findByCity(String city);
}