package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "VariableTagType")
public class VariableTagType implements Identity, Serializable, Cloneable{

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "count_register")
    private byte countRegister;

    @Column(name = "comment")
    private String comment;

    @OneToMany
    private List<EquipmentTypePar> equipmentTypePars;

    public VariableTagType() {
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

    public byte getCountRegister() {
        return countRegister;
    }

    public void setCountRegister(byte countRegister) {
        this.countRegister = countRegister;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<EquipmentTypePar> getEquipmentTypePars() {
        return equipmentTypePars;
    }

    public void setEquipmentTypePars(List<EquipmentTypePar> equipmentTypePars) {
        this.equipmentTypePars = equipmentTypePars;
    }
}
