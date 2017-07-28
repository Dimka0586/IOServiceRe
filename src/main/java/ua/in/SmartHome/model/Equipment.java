package ua.in.SmartHome.model;

import ua.in.SmartHome.model.system.IODevice;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
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
    private EquipmentType equipmentType;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "equipment")
    List<VariableTag> variableTags;

    @ManyToOne(fetch = FetchType.EAGER)
    private IODevice ioDevice;

    public Equipment() {
    }

    public Equipment(String name, int startAddress, EquipmentType equipmentType) {
        this.name = name;
        this.startAddress = startAddress;
        this.equipmentType = equipmentType;
        List<VariableTag> variableTags = new ArrayList<VariableTag>();
        for(EquipmentTypePar equipmentTypePar:equipmentType.getEquipmentTypePars()){
            equipmentTypePar.getName();
            equipmentTypePar.getVariableTagType();
            variableTags.add(new VariableTag(startAddress, equipmentTypePar));
            startAddress += equipmentTypePar.getVariableTagType().getCountRegister();

        }
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

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public IODevice getIoDevice() {
        return ioDevice;
    }

    public void setIoDevice(IODevice ioDevice) {
        this.ioDevice = ioDevice;
    }

    public List<VariableTag> getVariableTags() {
        return variableTags;
    }

    public void setVariableTags(List<VariableTag> variableTags) {
        this.variableTags = variableTags;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id + "\n" +
                ", name='" + name + '\n' +
                ", startAddress=" + startAddress + "\n" +
                ", equipmentType=" + equipmentType + "\n" +
                ", variableTags=" + variableTags + "\n" +
                ", ioDevice=" + ioDevice +
                '}';
    }
}
