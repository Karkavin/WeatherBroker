package ru.touchit.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 * Entity для сущности Погода
 * @author Artyom Karkavin
 */
@Entity
@Table(name = "condition", catalog = "public")
public class Condition implements Serializable{
    /** Поле: идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /** Поле: дата последнего обновления погоды */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date", nullable = false, length = 50)
    private Date date;

    /** Поле: температура в единице Фаренгейт */
    @Column(name = "temp", nullable = false)
    private short temp;

    /** Поле: текстовое описание погоды */
    @Column(name = "text", nullable = false, length = 150)
    private String text;

    /** Поле: связь с сущностью Местонахождение */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id", nullable = false)
    private Location location;

    /**
     * Конструктор
     */
    public Condition() {

    }

    /**
     * Конструктор
     * @param date дата последнего обновления погоды
     * @param temp температура в единице Фаренгейт
     * @param text текстовое описание погоды
     */
    public Condition(Date date, short temp, String text) {
        this.date = date;
        this.temp = temp;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getTemp() {
        return temp;
    }

    public void setTemp(short temp) {
        this.temp = temp;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}