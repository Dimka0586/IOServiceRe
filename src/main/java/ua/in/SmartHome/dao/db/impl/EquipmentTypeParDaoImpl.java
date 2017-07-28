package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.EquipmentTypeParDao;
import ua.in.SmartHome.model.EquipmentTypePar;

@Repository
public class EquipmentTypeParDaoImpl extends AbstractDao<EquipmentTypePar> implements EquipmentTypeParDao{
    public EquipmentTypeParDaoImpl() {
        super(EquipmentTypePar.class);
    }
}
