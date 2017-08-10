package ua.in.SmartHome.dao.db.impl;

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
import ua.in.SmartHome.dao.db.*;
import ua.in.SmartHome.model.*;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class EquipmentTypeTreeDaoImplTest {

    @Autowired
    @Qualifier(value = "realVariableTagType")
    VariableTagType realVariableTagType;

    @Autowired
    EquipmentTypeTreeDao equipmentTypeTreeDao;

    @Autowired
    EquipmentTypeParDao equipmentTypeParDao;

    @Autowired
    EquipmentDao equipmentDao;

    @Autowired
    VariableTagTypeDao variableTagTypeDao;

    @Autowired
    ScaleDataDao scaleDataDao;

    @Test
    public void create() throws Exception {
        //variableTagTypeDao.create(realVariableTagType);

        EquipmentTypeTree anSensorType = new EquipmentTypeTree("AnSensor");
        equipmentTypeTreeDao.create(anSensorType);

        EquipmentTypeTree inOutType = new EquipmentTypeTree("InOut");
        inOutType.setParent(anSensorType);
        equipmentTypeTreeDao.create(inOutType);

        EquipmentTypePar inPar = new EquipmentTypePar("in", 1);
        inPar.setEquipmentTypeTree(inOutType);
        equipmentTypeParDao.create(inPar);

        EquipmentTypePar outPar = new EquipmentTypePar("out", 1);
        outPar.setEquipmentTypeTree(inOutType);
        equipmentTypeParDao.create(outPar);

        Equipment temp1 = new Equipment("temp1", 0, anSensorType);
        equipmentDao.create(temp1);

        ScaleData temp1InParScaleData = new ScaleData(0, 100, 0.0f, 100.0f);
        temp1InParScaleData.setEng(25);
        temp1InParScaleData.setEquipment(temp1);
        scaleDataDao.create(temp1InParScaleData);

        ScaleData temp1OutParScaleData = new ScaleData(0, 200, 0.0f, 200.0f);
        temp1InParScaleData.setEng(50);
        temp1OutParScaleData.setEquipment(temp1);
        scaleDataDao.create(temp1OutParScaleData);


        List<Equipment> temps = equipmentDao.readAll();
        System.out.println(temps.get(0).getScaleDatas());
        //EquipmentTypeTree temp1RootEquipmentTypeTree = temp1.getEquipmentTypeTree();
        //System.out.println(temp1RootEquipmentTypeTree.getEquipmentTypeTrees());
        //System.out.println(temp1.getScaleDatas());
        /*EquipmentTypePar inAnalogSensor = new EquipmentTypePar("in");
        inAnalogSensor.setEquipmentType(analogSensorType);
        equipmentTypeParDao.create(inAnalogSensor);
        */
    }

    @Test
    public void readAll() throws Exception {

    }

    @Test
    public void update() throws Exception {

    }

    @Test
    public void delete() throws Exception {

    }

    @Test
    public void readById() throws Exception {

    }

}