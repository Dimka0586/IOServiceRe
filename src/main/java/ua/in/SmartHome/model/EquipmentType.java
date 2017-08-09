package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


public class EquipmentType implements Identity, Serializable, Cloneable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipmentType")
    List<EquipmentTypePar> equipmentTypePars;

    public EquipmentType() {
    }

    public EquipmentType(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EquipmentTypePar> getEquipmentTypePars() {
        return equipmentTypePars;
    }

    public void setEquipmentTypePars(List<EquipmentTypePar> equipmentTypePars) {
        this.equipmentTypePars = equipmentTypePars;
    }

    @Override
    public String toString() {
        return "EquipmentType{" +
                "id=" + id + ", " + '\n' +
                "   equipmentTypePars=" + equipmentTypePars +
                '}';
    }
}
