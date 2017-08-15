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

import ua.in.SmartHome.dao.GeneratorTestData;
import ua.in.SmartHome.dao.db.EquipmentDao;
import ua.in.SmartHome.dao.db.EquipmentTypeDao;
import ua.in.SmartHome.dao.db.EquipmentTypeParDao;
import ua.in.SmartHome.dao.db.VariableTagDao;
import ua.in.SmartHome.dao.db.system.IODeviceDao;
import ua.in.SmartHome.model.*;
import ua.in.SmartHome.util.EquipmentVarTagBuilder;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class EquipmentDaoImplTest {

    //@Autowired
    //@Qualifier(value = "realVariableTagType")
    //EquipmentTypePar realVariableTagType;

    @Autowired
    VariableTagDao variableTagDao;

    @Autowired
    EquipmentTypeParDao equipmentTypeParDao;

    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    @Autowired
    EquipmentDao equipmentDao;

    @Autowired
    IODeviceDao iODeviceDao;

    @Autowired
    EquipmentVarTagBuilder equipmentVarTagBuilder;

    @Autowired
    GeneratorTestData generatorTestData;

    EquipmentType inOutEquipmentType;
    EquipmentType alarmStateEquipmentType;

    
    @Before
    public void init() throws Exception{
    	generatorTestData.createTestData();
    	inOutEquipmentType = equipmentTypeDao.readById(1);
    	alarmStateEquipmentType = equipmentTypeDao.readById(2);
    }

    @Test
    public void create() {
    	Equipment inOut1 = new Equipment("inOut-1", 122, inOutEquipmentType);
    	Equipment inOut2 = new Equipment("inOut-2", 125, inOutEquipmentType);
    	Equipment alarmState1 = new Equipment("alarmState-1", 128, alarmStateEquipmentType);
    	Equipment alarmState2 = new Equipment("alarmState-2", 132, alarmStateEquipmentType);
    	equipmentDao.create(inOut1);
    	equipmentDao.create(inOut2);
    	equipmentDao.create(alarmState1);
    	equipmentDao.create(alarmState2);
    }

    public void readAll() {

    }

    public void update() {

    }

    public void delete() {

    }

    public void readById() {
    	Equipment temp1 = equipmentDao.readById(1);
    	System.out.println(temp1.getName());
    	EquipmentType temp1_ett = temp1.getEquipmentType();
    	System.out.println(temp1_ett.getName());
    	List<EquipmentType> ett = temp1_ett.getEquipmentTypes();
    	ett.forEach(ettTmp -> {System.out.println(ettTmp.getName()); System.out.println(", ");});
    }

}