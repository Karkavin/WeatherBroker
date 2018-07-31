package ru.touchit.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity для сущности Местонахождение
 * @author Artyom Karkavin
 */
@Entity
@Table(name = "location", catalog = "public")
public class Location implements Serializable {
    /** Поле: идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** Поле: наименование города */
    @Column(name = "city", nullable = false, length = 100)
    private String city;

    /** Поле: регион */
    @Column(name = "region", nullable = false, length = 100)
    private String region;

    /** Поле: страна */
    @Column(name = "country", nullable = false, length = 100)
    private String country;

    /** Поле: широта */
    @Column(name = "lat", nullable = false)
    private double lat;

    /** Поле: долгота */
    @Column(name = "lon", nullable = false)
    private double lon;

    /** Поле: связь с сущностью Погода */
    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Condition> conditions;

    /**
     * Конструктор
     */
    public Location() {

    }

    /**
     * Конструктор
     * @param city наименование города
     * @param region регион
     * @param country страна
     * @param lat широта
     * @param lon долгота
     */
    public Location(String city, String region, String country, double lat, double lon) {
        this.city = city;
        this.region = region;
        this.country = country;
        this.lat = lat;
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public Set<Condition> getConditions() {
        if (conditions == null) {
            return new HashSet<>();
        }
        return conditions;
    }

    public void addCondition(Condition condition) {
        getConditions().add(condition);
        condition.setLocation(this);
    }

    public void removeCondition(Condition condition) {
        getConditions().remove(condition);
        condition.setLocation(null);
    }
}