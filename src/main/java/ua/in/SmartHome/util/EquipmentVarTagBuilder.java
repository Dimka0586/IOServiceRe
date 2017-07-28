package ua.in.SmartHome.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.in.SmartHome.dao.db.VariableTagDao;
import ua.in.SmartHome.model.Equipment;
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.model.EquipmentTypePar;
import ua.in.SmartHome.model.VariableTag;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipmentVarTagBuilder {

    @Autowired
    private VariableTagDao variableTagDao;


    public List<VariableTag> createVarTagsEquipment(Equipment equipment){
        List<VariableTag> variableTags = new ArrayList<VariableTag>();
        int startAddress = equipment.getStartAddress();
        for(EquipmentTypePar equipmentTypePar:equipment.getEquipmentType().getEquipmentTypePars()){
            variableTags.add(variableTagDao.create(new VariableTag(startAddress,equipmentTypePar)));
            startAddress += equipmentTypePar.getVariableTagType().getCountRegister();
        }
        return variableTags;
    }


}
