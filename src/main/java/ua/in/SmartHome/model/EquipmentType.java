package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EquipmentType")
public class EquipmentType implements Identity, Serializable, Cloneable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipmentType")
    List<EquipmentTypePar> equipmentTypePars;

    public EquipmentType() {
    }

    public int getId() {
        return id;
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
                "id=" + id +
                ", equipmentTypePars=" + equipmentTypePars +
                '}';
    }
}
