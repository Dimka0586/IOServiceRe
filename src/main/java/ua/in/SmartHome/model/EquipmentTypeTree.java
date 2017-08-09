package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EquipmentTypeTree")
public class EquipmentTypeTree implements Identity, Serializable, Cloneable  {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private EquipmentTypeTree parent;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "parent")
    List<EquipmentTypeTree> equipmentTypeTrees;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipmentTypeTree")
    List<EquipmentTypePar> equipmentTypePars;

    public EquipmentTypeTree() {
    }

    public EquipmentTypeTree(String name) {
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

    public EquipmentTypeTree getParent() {
        return parent;
    }

    public void setParent(EquipmentTypeTree parent) {
        this.parent = parent;
    }

    public List<EquipmentTypeTree> getEquipmentTypeTrees() {
        return equipmentTypeTrees;
    }

    public void setEquipmentTypeTrees(List<EquipmentTypeTree> equipmentTypeTrees) {
        this.equipmentTypeTrees = equipmentTypeTrees;
    }

    public List<EquipmentTypePar> getEquipmentTypePars() {
        return equipmentTypePars;
    }

    public void setEquipmentTypePars(List<EquipmentTypePar> equipmentTypePars) {
        this.equipmentTypePars = equipmentTypePars;
    }
}
