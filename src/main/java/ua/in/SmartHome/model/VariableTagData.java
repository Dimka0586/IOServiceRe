package ua.in.SmartHome.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "VariableTagData")
public class VariableTagData {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "eng")
    private Number eng;

    @Column(name = "r")
    private Number r;

    @Column(name = "curr_time")
    private Time time;

    public VariableTagData() {
    }

    public int getId() {
        return id;
    }

    public Number getEng() {
        return eng;
    }

    public void setEng(Number eng) {
        this.eng = eng;
    }

    public Number getR() {
        return r;
    }

    public void setR(Number r) {
        this.r = r;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
