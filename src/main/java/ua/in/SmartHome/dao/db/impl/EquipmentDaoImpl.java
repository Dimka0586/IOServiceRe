package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.EquipmentDao;
import ua.in.SmartHome.model.Equipment;

@Repository
public class EquipmentDaoImpl extends AbstractDao<Equipment> implements EquipmentDao {
    public EquipmentDaoImpl() {
        super(Equipment.class);
    }
}
