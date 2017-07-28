package ua.in.SmartHome.dao.db.impl;

import com.ghgande.j2mod.modbus.util.SerialParameters;
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
import ua.in.SmartHome.dao.db.EquipmentDao;
import ua.in.SmartHome.dao.db.EquipmentTypeDao;
import ua.in.SmartHome.dao.db.EquipmentTypeParDao;
import ua.in.SmartHome.dao.device.modbus.serial.J2ModModbusSerialDaoImpl;
import ua.in.SmartHome.model.*;
import ua.in.SmartHome.util.EquipmentVarTagBuilder;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "testProfile")
@Rollback
public class EquipmentDaoImplTest {

    @Autowired
    @Qualifier(value = "realVariableTagType")
    VariableTagType realVariableTagType;

    @Autowired
    EquipmentTypeParDao equipmentTypeParDao;

    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    @Autowired
    EquipmentDao equipmentDao;
    @Autowired
    EquipmentVarTagBuilder equipmentVarTagBuilder;


    @Autowired
    SerialParameters serialParameters;

    @Test
    public void create() {
        EquipmentTypePar inAnalogSensor = new EquipmentTypePar("in", realVariableTagType);
        EquipmentTypePar outAnalogSensor = new EquipmentTypePar("out", realVariableTagType);
        List<EquipmentTypePar> analogSensorEquipmentTypePars = new ArrayList();
        analogSensorEquipmentTypePars.add(equipmentTypeParDao.create(inAnalogSensor));
        analogSensorEquipmentTypePars.add(equipmentTypeParDao.create(outAnalogSensor));

        EquipmentType analogSensorType = new EquipmentType();

        analogSensorType.setEquipmentTypePars(analogSensorEquipmentTypePars);
        analogSensorType = equipmentTypeDao.create(analogSensorType);

        Equipment temp1 = new Equipment("temp1", 0, analogSensorType);
        List<VariableTag> temp1VarTags = equipmentVarTagBuilder.createVarTagsEquipment(temp1);
        temp1.setVariableTags(temp1VarTags);
        temp1 = equipmentDao.create(temp1);
        System.out.println(temp1);

        Equipment cloneTemp1 = equipmentDao.readById(1);
        System.out.println(cloneTemp1);

        J2ModModbusSerialDaoImpl modbusDaoImpl = new J2ModModbusSerialDaoImpl(serialParameters);

        for(int i = 0; i < 2000; i++){
            List<Integer> integers = modbusDaoImpl.readInputReg(1, 0, 10);

            if (integers != null) {
                /*for (Integer integer : integers) {
                    System.out.println(integer);
                }*/
                System.out.println(integers.get(0));
                System.out.println(integers.get(1));
                System.out.println(integers.get(2));
                System.out.println(integers.get(3));
                System.out.println(integers.get(4));
                System.out.println(integers.get(5));
            }else{
                System.out.println("integers is null");
            }
            System.out.println("----------------------");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getMessage();
            }

        }


    }

    @Test
    public void readAll() {

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }

    @Test
    public void readById() {

    }

}