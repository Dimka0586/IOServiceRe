package ua.in.SmartHome.dao.db.impl;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ua.in.SmartHome.dao.GeneratorTestData;
import ua.in.SmartHome.dao.db.*;
import ua.in.SmartHome.model.*;
import ua.in.SmartHome.util.EquipmentVarTagBuilder;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class EquipmentTypeDaoImplTest {

	@PersistenceContext
	EntityManager entityManager;

    @Autowired
    @Qualifier(value = "realVariableTagType")
    VariableTagType realVariableTagType;

    @Autowired
    @Qualifier(value = "intVariableTagType")
    VariableTagType intVariableTagType;

    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    @Autowired
    EquipmentTypeParDao equipmentTypeParDao;

    @Autowired
    EquipmentDao equipmentDao;

    @Autowired
    VariableTagTypeDao variableTagTypeDao;

    @Autowired
    ScaleDataDao scaleDataDao;

    @Autowired
    EquipmentVarTagBuilder equipmentVarTagBuilder;

    @Autowired
    VariableTagDao variableTagDao;

    @Autowired
    GeneratorTestData generatorTestData;

    List<EquipmentType> equipmentTypes;
    List<EquipmentTypePar> equipmentTypePars;
    String nameNewEquipmentType = null;

    @Before
    public void init() throws Exception{
    	generatorTestData.createTestData();
    	nameNewEquipmentType = "AnalogSensorType";
    	equipmentTypes = equipmentTypeDao.readAll();
    	equipmentTypePars = equipmentTypeParDao.readAll();
    	equipmentTypePars = Arrays.asList(new EquipmentTypePar("Eng", intVariableTagType),
    										new EquipmentTypePar("R", realVariableTagType));
    }

    public void setParentEquipmentTypes(EquipmentType root, List<EquipmentType> equipmentTypes){
    	equipmentTypes.forEach(equipmentType -> equipmentType.setParent(root));
    }

    @Test
    public void create(){
    	final EquipmentType newEquipmentType = new EquipmentType();
    	newEquipmentType.setName(nameNewEquipmentType);
    	setParentEquipmentTypes(newEquipmentType, equipmentTypes);
    	equipmentTypePars.forEach(equipmentTypePar -> {
    		equipmentTypeParDao.create(equipmentTypePar);
    		equipmentTypePar.setEquipmentType(newEquipmentType);
    	});
    	equipmentTypeDao.create(newEquipmentType);
    }

    public void readAll() throws Exception {

    }

    public void update() throws Exception {

    }

    public void delete() throws Exception {

    }

    public void readById() throws Exception {

    }

}