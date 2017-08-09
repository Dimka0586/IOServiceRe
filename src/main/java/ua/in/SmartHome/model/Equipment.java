package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Equipment")
public class Equipment implements Identity, Serializable, Cloneable {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "startAddress")
    private int startAddress;

    @ManyToOne(fetch = FetchType.EAGER)
    private EquipmentTypeTree equipmentTypeTree;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "equipment")
    private List<ScaleData> scaleDatas;


    public Equipment() {
    }

    public Equipment(String name, int startAddress, EquipmentType equipmentType) {
        this.name = name;
        this.startAddress = startAddress;
    }

    public Equipment(String name, int startAddress, EquipmentTypeTree equipmentTypeTree) {
        this.name = name;
        this.startAddress = startAddress;
        this.equipmentTypeTree = equipmentTypeTree;
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

    public int getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(int startAddress) {
        this.startAddress = startAddress;
    }

    public EquipmentTypeTree getEquipmentTypeTree() {
        return equipmentTypeTree;
    }

    public void setEquipmentTypeTree(EquipmentTypeTree equipmentTypeTree) {
        this.equipmentTypeTree = equipmentTypeTree;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<ScaleData> getScaleDatas() {
        return scaleDatas;
    }

    public void setScaleDatas(List<ScaleData> scaleDatas) {
        this.scaleDatas = scaleDatas;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id + ", " + "\n" +
                "   name='" + name + ", " + '\n' +
                "   startAddress=" + startAddress + ", " + "\n" +
                '}';
    }
}
