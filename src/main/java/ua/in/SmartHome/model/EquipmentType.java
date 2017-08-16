package ua.in.SmartHome.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
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

    @JsonIgnore
    @ManyToMany
    @JoinTable(name="PARENT_EQTYPE_CHILD_EQTYPE",joinColumns={@JoinColumn(name="Parent_Id")},
    inverseJoinColumns={@JoinColumn(name="Child_Id")})
    private List<EquipmentType> parents = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "parents")
    List<EquipmentType> equipmentTypes = new ArrayList<>();

    //@JsonIgnore
    @OneToMany(mappedBy = "equipmentType")
    List<EquipmentTypePar> equipmentTypePars;

    //@ManyToOne
    //private Equipment equipment;


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


    public List<EquipmentType> getParents() {
		return parents;
	}

	public void setParents(List<EquipmentType> parents) {
		this.parents = parents;
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

	/*public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}*/


}
