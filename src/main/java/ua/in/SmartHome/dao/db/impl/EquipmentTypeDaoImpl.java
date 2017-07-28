package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.EquipmentTypeDao;
import ua.in.SmartHome.model.EquipmentType;

@Repository
public class EquipmentTypeDaoImpl extends AbstractDao<EquipmentType> implements EquipmentTypeDao {

    public EquipmentTypeDaoImpl() {
        super(EquipmentType.class);
    }
}
