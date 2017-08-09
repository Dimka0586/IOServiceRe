package ua.in.SmartHome.dao.db.impl;


import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.EquipmentTypeTreeDao;
import ua.in.SmartHome.model.EquipmentTypeTree;

@Repository
public class EquipmentTypeTreeDaoImpl extends AbstractDao<EquipmentTypeTree> implements EquipmentTypeTreeDao {

    public EquipmentTypeTreeDaoImpl() {
        super(EquipmentTypeTree.class);
    }
}
