package ua.in.SmartHome.service.model.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.in.SmartHome.dao.db.EquipmentTypeDao;
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.service.model.AbstractService;
import ua.in.SmartHome.service.model.EquipmentTypeService;

@Service
public class EquipmentTypeServiceImpl extends AbstractService<EquipmentType> implements EquipmentTypeService {
	@Autowired
	EquipmentTypeDao equipmentTypeDao;

	@Override
	public void prepareCreateNew() {
		//EquipmentType getEquipmentTypeById(1);

	}

	public EquipmentType getEquipmentTypeById(int id){
		return equipmentTypeDao.readById(id);
	}



}
