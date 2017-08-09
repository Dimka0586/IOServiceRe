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
        int startAddress = equipment.getStartAddress();
        EquipmentTypeTree equipmentTypeTree = equipment.getEquipmentTypeTree();
        //findEquipmentTypeTree(equipmentTypeTree, startAddress);

        /*for(EquipmentTypePar equipmentTypePar:equipment.getEquipmentType().getEquipmentTypePars()){
            //variableTags.add(variableTagDao.create(new VariableTag(startAddress,equipmentTypePar)));
            variableTags.add(new VariableTag(startAddress,equipmentTypePar));
            startAddress += equipmentTypePar.getCountRegister();
        }*/
        return variableTags;
    }

    /*public void findEquipmentTypeTree(EquipmentTypeTree equipmentTypeTree, int startAddress){
        List<EquipmentTypePar> equipmentTypePars = equipmentTypeTree.getEquipmentTypePars();
        VariableTag variableTag = null;
        List<VariableTag> variableTags =
        if (equipmentTypePars != null){
            for(EquipmentTypePar equipmentTypePar: equipmentTypePars){
                equipmentTypePar.getName();
                //equipmentTypePar.getVariableTagType();
                variableTag = new VariableTag(startAddress, equipmentTypePar);

                variableTags.add(new VariableTag(startAddress, equipmentTypePar));
                startAddress += equipmentTypePar.getCountRegister();
            }
        }
        List<EquipmentTypeTree> equipmentTypeTrees = equipmentTypeTree.getEquipmentTypeTrees();
        if (equipmentTypeTrees != null) {
            for (EquipmentTypeTree equipmentTypeTreeCycle : equipmentTypeTrees) {
                findEquipmentTypeTree(equipmentTypeTreeCycle);
            }
        }
    }*/

}
