package ua.in.SmartHome.dao.db.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ua.in.SmartHome.dao.db.EquipmentDao;
import ua.in.SmartHome.dao.db.VariableTagDao;
import ua.in.SmartHome.model.Equipment;
import ua.in.SmartHome.model.VariableTag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class VariableTagDaoImplTest {
	
	@Autowired
	EquipmentDao equipmentDao;
	
	@Autowired
	VariableTagDao variableTagDao;
	
	private Equipment equipment;
	
	
	@Before
	public void init(){
		equipment = equipmentDao.readById(1);
	}
	
	
	@Test
	public void create(){
		VariableTag varTag = new VariableTag(equipment.getStartAddress(), equipment.getEquipmentType().getEquipmentTypePars().get(0), equipment);
		variableTagDao.create(varTag);
	}

}
