package ua.in.SmartHome.util;

import org.springframework.stereotype.Component;
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.model.EquipmentTypeProperties;
import ua.in.SmartHome.model.VariableTag;
import ua.in.SmartHome.model.VariableTagType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class EquipmentTypeBuilder {

    public EquipmentTypeBuilder() {
    }

    public EquipmentType buildEquipmentType(EquipmentTypeProperties equipmentTypeProperties, int startAddress){
        EquipmentType equipmentType = new EquipmentType();
        List<VariableTag> variableTags = new ArrayList<VariableTag>();
        VariableTag variableTag = null;
        int incrementAddress = 0;

        /*for (Map.Entry<String, VariableTagType> varTag:equipmentTypeProperties.getVarTagProps().entrySet()){
            variableTag = new VariableTag();
            variableTag.setName(varTag.getKey());
            variableTag.setAddress(startAddress + incrementAddress);
            variableTag.setTypeAddressVariable(varTag.getValue());
            variableTags.add(variableTag);
            incrementAddress += varTag.getValue().getCountRegister();
        }
        equipmentType.setStartAddress(startAddress);
        equipmentType.setVariableTags(variableTags);*/

        return equipmentType;
    }
}
