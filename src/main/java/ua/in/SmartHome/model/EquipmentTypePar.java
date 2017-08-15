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

    @ManyToOne
    private EquipmentType equipmentType;

    @ManyToOne
    private VariableTagType variableTagType;

    public EquipmentTypePar() {
    }

    public EquipmentTypePar(String name, VariableTagType variableTagType) {
        this.name = name;
        this.variableTagType = variableTagType;
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

    public EquipmentType getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(EquipmentType equipmentType) {
        this.equipmentType = equipmentType;
    }



    public VariableTagType getVariableTagType() {
		return variableTagType;
	}

	public void setVariableTagType(VariableTagType variableTagType) {
		this.variableTagType = variableTagType;
	}

	@Override
    public String toString() {
        return "EquipmentTypePar{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
