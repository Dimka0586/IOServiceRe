package ua.in.SmartHome.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.in.SmartHome.dao.db.EquipmentDao;
import ua.in.SmartHome.dao.db.VariableTagDao;
import ua.in.SmartHome.model.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipmentVarTagBuilder {

    private static Integer startAddress = 0;

    public List<VariableTag> createVarTagsEquipment(Equipment equipment){
        startAddress = equipment.getStartAddress();
    return findEquipmentTypeTree(equipment.getEquipmentType(), new ArrayList<VariableTag>(), equipment);
    }

    public List<VariableTag> findEquipmentTypeTree(EquipmentType equipmentTypeTree, List<VariableTag> variableTags, Equipment equipment){
        List<EquipmentTypePar> equipmentTypePars = equipmentTypeTree.getEquipmentTypePars();
        if (equipmentTypePars != null){
            for(EquipmentTypePar equipmentTypePar: equipmentTypePars){
            	variableTags.add(new VariableTag(startAddress, equipmentTypePar, equipment));
            	startAddress += equipmentTypePar.getVariableTagType().getCountRegister();
            }
        }
        List<EquipmentType> equipmentTypeTrees = equipmentTypeTree.getEquipmentTypes();
        if (equipmentTypeTrees != null) {
            for (EquipmentType equipmentTypeTreeCycle : equipmentTypeTrees) {
                findEquipmentTypeTree(equipmentTypeTreeCycle, variableTags, equipment);
            }
        }
        return variableTags;
    }

}
