package ru.touchit.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.touchit.api.dao.ConditionDao;
import ru.touchit.api.dao.LocationDao;
import ru.touchit.api.model.Condition;
import ru.touchit.api.model.Location;
import ru.touchit.api.view.WeatherView;
import ru.touchit.weather.exception.NoSuchCityException;
import ru.touchit.weather.response.ConditionResponse;
import ru.touchit.weather.response.LocationResponse;
import ru.touchit.weather.response.WeatherResponse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;

@Service("weatherService")
public class WeatherServiceImpl implements WeatherService {
    private final LocationDao locationDao;
    private final ConditionDao conditionDao;

    @Autowired
    public WeatherServiceImpl(LocationDao locationDao, ConditionDao conditionDao) {
        this.locationDao = locationDao;
        this.conditionDao = conditionDao;
    }

    @Override
    @Transactional
    public void add(WeatherResponse weatherResponse) {
        LocationResponse locationResponse = weatherResponse.getQuery().getResults().getChannel().getLocation();
        ConditionResponse conditionResponse = weatherResponse.getQuery().getResults().getChannel().getItem().getCondition();

        Optional<Location> locationOptional = locationDao.findById(locationResponse.getCity());

        Location location;
        if (locationOptional.isPresent()) {
            location = locationOptional.get();
            location.setCity(locationResponse.getCity());
            location.setRegion(locationResponse.getRegion());
            location.setCountry(locationResponse.getCountry());
            location.setLat(Double.parseDouble(weatherResponse.getQuery().getResults().getChannel().getItem().getLat()));
            location.setLon(Double.parseDouble(weatherResponse.getQuery().getResults().getChannel().getItem().getLon()));
        } else {
            location = new Location(
                    locationResponse.getCity(),
                    locationResponse.getRegion(),
                    locationResponse.getCountry(),
                    Double.parseDouble(weatherResponse.getQuery().getResults().getChannel().getItem().getLat()),
                    Double.parseDouble(weatherResponse.getQuery().getResults().getChannel().getItem().getLon()));
        }
        locationDao.save(location);

        DateFormat incomeDf = new SimpleDateFormat("EEE, dd MMM yyyy hh:mm a zzzz", Locale.US);
        Date resultDate;
        try {
            resultDate = incomeDf.parse(conditionResponse.getDate());
        } catch (ParseException e) {
            resultDate = new Date();
        }

        if (conditionDao.findByLocationAndDateGreaterThanEqual(location, resultDate).size() == 0) {
            Condition condition = new Condition(
                    resultDate,
                    Short.parseShort(conditionResponse.getTemp()),
                    conditionResponse.getText());
            location.addCondition(condition);
            conditionDao.save(condition);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public WeatherView getCurrentWeather(String city) throws NoSuchCityException {
        Optional<Location> locationOptional = locationDao.findById(city);

        Location location;
        if (!locationOptional.isPresent()) {
            throw new NoSuchCityException("There is no such city " + city + " in database");
        } else {
            location = locationOptional.get();
        }

        Condition condition = conditionDao.findFirstByLocationOrderByDateDesc(location);

        if (condition != null) {
            DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm");
            return new WeatherView(
                    df.format(condition.getDate()),
                    condition.getTemp(),
                    condition.getText(),
                    location.getLat(),
                    location.getLon(),
                    city,
                    location.getRegion(),
                    location.getCountry());
        } else {
            return null;
        }
    }
}