package ru.touchit.api.dao;

import org.springframework.data.repository.CrudRepository;
import ru.touchit.api.model.Condition;
import ru.touchit.api.model.Location;

import java.util.Date;
import java.util.List;

/**
 * Dao для работы с погодой {@link Condition}
 * @author Artyom Karkavin
 */
public interface ConditionDao extends CrudRepository<Condition, Long> {
    /**
     * Получить все данные о погоде по указанному местоположению, начиная от указанной даты
     * @return список данных о погоде
     * @see Condition
     * @see Location
     */
    List<Condition> findByLocationAndDateGreaterThanEqual(Location location, Date date);

    /**
     * Получить последнюю актуальную погоду по указанному местоположению
     * @return список данных о погоде
     * @see Condition
     * @see Location
     */
    Condition findFirstByLocationOrderByDateDesc(Location location);
}