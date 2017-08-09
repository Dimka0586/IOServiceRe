package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;

@Entity
@Table(name = "ScaleData")
public class ScaleData implements Identity, Serializable, Cloneable{
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "eng")
    int eng;

    @Column(name = "engMin")
    int engMin;

    @Column(name = "engMax")
    int engMax;

    @Column(name = "r")
    float r;

    @Column(name = "rMin")
    float rMin;

    @Column(name = "rMax")
    float rMax;

    @Column(name = "curr_time")
    private Time time;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Equipment equipment;

    public ScaleData(){

    }

    public ScaleData(int engMin, int engMax, float rMin, float rMax){
        this.engMin = engMin;
        this.engMax = engMax;
        this.rMin = rMin;
        this.rMax = rMax;
    }

    public int getId() {
        return id;
    }

    public int getEng(){
        return eng;
    }

    public float getR() {
        return (eng - engMin)*(rMax - rMin)/(engMax - engMin)+rMin;
    }

    public float getrMin() {
        return rMin;
    }

    public float getrMax() {
        return rMax;
    }

    public int getEngMin() {
        return engMin;
    }

    public int getEngMax() {
        return engMax;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public void setR(float r) {
        this.r = r;
    }

    public void setrMin(float rMin) {
        this.rMin = rMin;
    }

    public void setrMax(float rMax) {
        this.rMax = rMax;
    }

    public void setEngMin(int engMin) {
        this.engMin = engMin;
    }

    public void setEngMax(int engMax) {
        this.engMax = engMax;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }
}
