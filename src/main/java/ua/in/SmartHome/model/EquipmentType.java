package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "EquipmentType")
@NamedQueries({
@NamedQuery(query = "Select ett from EquipmentType ett where ett.id = :id", name = "find equipmentType by id"),
@NamedQuery(query = "Select ett from EquipmentType ett", name = "find all equipmentTypes")
})
public class EquipmentType implements Identity, Serializable, Cloneable  {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    private EquipmentType parent;

    @OneToMany(mappedBy = "parent")
    List<EquipmentType> equipmentTypes;

    @OneToMany(mappedBy = "equipmentType")
    List<EquipmentTypePar> equipmentTypePars;

    @ManyToOne
    private Equipment equipment;


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

    public EquipmentType getParent() {
        return parent;
    }

    public void setParent(EquipmentType parent) {
        this.parent = parent;
    }

    public List<EquipmentType> getEquipmentTypes() {
        return equipmentTypes;
    }

    public void setEquipmentTypes(List<EquipmentType> equipmentTypes) {
        this.equipmentTypes = equipmentTypes;
    }

    public List<EquipmentTypePar> getEquipmentTypePars() {
        return equipmentTypePars;
    }

    public void setEquipmentTypePars(List<EquipmentTypePar> equipmentTypePars) {
        this.equipmentTypePars = equipmentTypePars;
    }

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}


}
