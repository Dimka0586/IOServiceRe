package ua.in.SmartHome.model;


import javax.persistence.*;
import java.util.LinkedHashMap;

@Entity
@Table(name = "EquipmentTypeProps")
public class EquipmentTypeProperties {
    @Id
    @Column(name = "ID")
    @GeneratedValue
    private int id;


    private LinkedHashMap<String, VariableTagType> varTagProps;

    public EquipmentTypeProperties() {
    }

    public int getId() {
        return id;
    }

    public LinkedHashMap<String, VariableTagType> getVarTagProps() {
        return varTagProps;
    }

    public void setVarTagProps(LinkedHashMap<String, VariableTagType> varTagProps) {
        this.varTagProps = varTagProps;
    }
}
