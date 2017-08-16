package ua.in.SmartHome.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "VariableTag")
public class VariableTag  implements Identity, Serializable, Cloneable{

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;

    @Column(name = "address")
    private int address;

    @ManyToOne(fetch = FetchType.EAGER)
    private EquipmentTypePar equipmentTypePar;

    @ManyToOne
    private Equipment equipment;

    public VariableTag() {
    }

    public VariableTag(int address, EquipmentTypePar equipmentTypePar) {
        this.address = address;
        this.equipmentTypePar = equipmentTypePar;
    }
    
    

    public VariableTag(int address, EquipmentTypePar equipmentTypePar, Equipment equipment) {
		this.address = address;
		this.equipmentTypePar = equipmentTypePar;
		this.equipment = equipment;
	}

	public int getId() {
        return id;
    }


    public int getAddress() {
        return address;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public EquipmentTypePar getEquipmentTypePar() {
        return equipmentTypePar;
    }

    public void setEquipmentTypePar(EquipmentTypePar equipmentTypePar) {
        this.equipmentTypePar = equipmentTypePar;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return "VariableTag{" +
                "id=" + id +
                ", address=" + address +
                ", equipmentTypePar=" + equipmentTypePar +
                ", equipment=" + equipment +
                '}';
    }
}
