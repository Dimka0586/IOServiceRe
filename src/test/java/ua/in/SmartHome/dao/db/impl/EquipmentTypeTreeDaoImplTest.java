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
import ua.in.SmartHome.util.EquipmentVarTagBuilder;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class EquipmentTypeTreeDaoImplTest {
	
	@PersistenceContext
	EntityManager entityManager;
	
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
    
    @Autowired
    EquipmentVarTagBuilder equipmentVarTagBuilder;

    @Test
    public void create() throws Exception {
        //variableTagTypeDao.create(realVariableTagType);

        EquipmentTypeTree anSensorType = new EquipmentTypeTree("AnSensor");
        equipmentTypeTreeDao.create(anSensorType);

        EquipmentTypeTree inOutType = new EquipmentTypeTree("InOut");
        inOutType.setParent(anSensorType);
        equipmentTypeTreeDao.create(inOutType);

        /**EquipmentTypePar inPar = new EquipmentTypePar("in", realVariableTagType);
        inPar.setEquipmentTypeTree(inOutType);
        equipmentTypeParDao.create(inPar);

        EquipmentTypePar outPar = new EquipmentTypePar("out", realVariableTagType);
        outPar.setEquipmentTypeTree(inOutType);
        equipmentTypeParDao.create(outPar);**/

        Equipment temp1 = new Equipment("temp1", 0, anSensorType);
        equipmentDao.create(temp1);
        
        
        List result = entityManager.createQuery(
        	    "SELECT c FROM EquipmentTypeTree c WHERE c.id LIKE :equipmentTypeTreeId")
        	    .setParameter("equipmentTypeTreeId", 1)
        	    .setMaxResults(10)
        	    .getResultList();
        System.out.println("result: " + result + " child: " + result.get(0));
        
        /**List<VariableTag> variableTags = equipmentVarTagBuilder.createVarTagsEquipment(temp1);
        System.out.println("variabletags: " + variableTags);
        for(VariableTag variabletag:variableTags){
        	System.out.println(variabletag.getAddress());
        }**/
        
        
        /**ScaleData temp1InParScaleData = new ScaleData(0, 100, 0.0f, 100.0f);
        temp1InParScaleData.setEng(25);
        temp1InParScaleData.setEquipment(temp1);
        scaleDataDao.create(temp1InParScaleData);

        ScaleData temp1OutParScaleData = new ScaleData(0, 200, 0.0f, 200.0f);
        temp1InParScaleData.setEng(50);
        temp1OutParScaleData.setEquipment(temp1);
        scaleDataDao.create(temp1OutParScaleData);


        List<Equipment> temps = equipmentDao.readAll();
        System.out.println(temps.get(0).getScaleDatas());**/
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