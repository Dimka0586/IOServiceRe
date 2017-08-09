package ua.in.SmartHome.model;

import javax.persistence.*;

@Entity
@Table(name = "EquipmentTypePar")
public class EquipmentTypePar {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "count_register")
    private int countRegister;

    @ManyToOne
    EquipmentTypeTree equipmentTypeTree;

    public EquipmentTypePar() {
    }

    public EquipmentTypePar(String name) {
        this.name = name;
    }

    public EquipmentTypePar(String name, int countRegister) {
        this.name = name;
        this.countRegister = countRegister;
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

    public int getCountRegister() {
        return countRegister;
    }

    public void setCountRegister(int countRegister) {
        this.countRegister = countRegister;
    }

    public EquipmentTypeTree getEquipmentTypeTree() {
        return equipmentTypeTree;
    }

    public void setEquipmentTypeTree(EquipmentTypeTree equipmentTypeTree) {
        this.equipmentTypeTree = equipmentTypeTree;
    }

    @Override
    public String toString() {
        return "EquipmentTypePar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
