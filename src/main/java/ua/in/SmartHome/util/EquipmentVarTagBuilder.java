package ua.in.SmartHome.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.in.SmartHome.dao.db.VariableTagDao;
import ua.in.SmartHome.model.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipmentVarTagBuilder {

    @Autowired
    private VariableTagDao variableTagDao;


    public List<VariableTag> createVarTagsEquipment(Equipment equipment){
        List<VariableTag> variableTags = new ArrayList<VariableTag>();
        Integer startAddress = equipment.getStartAddress();
        EquipmentTypeTree equipmentTypeTree = equipment.getEquipmentTypeTree();
        findEquipmentTypeTree(equipmentTypeTree, startAddress, variableTags);
        return variableTags;
    }

    public void findEquipmentTypeTree(EquipmentTypeTree equipmentTypeTree, Integer startAddress, List<VariableTag> variableTags){
        List<EquipmentTypePar> equipmentTypePars = equipmentTypeTree.getEquipmentTypePars();
        if (equipmentTypePars != null){
            for(EquipmentTypePar equipmentTypePar: equipmentTypePars){
                variableTags.add(new VariableTag(startAddress, equipmentTypePar));
                startAddress += equipmentTypePar.getVariableTagType().getCountRegister();
            }
        }
        List<EquipmentTypeTree> equipmentTypeTrees = equipmentTypeTree.getEquipmentTypeTrees();
        if (equipmentTypeTrees != null) {
            for (EquipmentTypeTree equipmentTypeTreeCycle : equipmentTypeTrees) {
                findEquipmentTypeTree(equipmentTypeTreeCycle, startAddress, variableTags);
            }
        }
    }

}
