package ua.in.SmartHome.util;

import java.util.List;

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
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.model.VariableTag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class EquipmentVarTagBuilderTest {

	@Autowired
	private EquipmentDao equipmentDao;

	@Autowired
	EquipmentVarTagBuilder equipmentVarTagBuilder;

	@Autowired
	private VariableTagDao variableTagDao;

	@Test
	public void createVarTagsEquipmentTest(){
		Equipment temp1 = equipmentDao.readById(1);
    	List<VariableTag> variableTags = equipmentVarTagBuilder.createVarTagsEquipment(temp1);
    	System.out.println(temp1.getName());
    	variableTags.forEach(variableTag -> {
    		System.out.print(variableTag.getEquipment().getEquipmentTypeTree().getName() + " -> ");
    		System.out.print(variableTag.getEquipmentTypePar().getEquipmentType().getName() + " -> ");
    		System.out.print(variableTag.getEquipmentTypePar().getName() + ": ");
    		System.out.println(variableTag.getAddress());
    	});




	}

}
