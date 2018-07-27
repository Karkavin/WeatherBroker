package ru.touchit.api.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "location", catalog = "public")
public class Location implements Serializable {

    @Id
    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "region", nullable = false, length = 100)
    private String region;

    @Column(name = "country", nullable = false, length = 100)
    private String country;

    @Column(name = "lat", nullable = false)
    private double lat;

    @Column(name = "lon", nullable = false)
    private double lon;

    @OneToMany(mappedBy = "location", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Condition> conditions;

    public Location() {

    }

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