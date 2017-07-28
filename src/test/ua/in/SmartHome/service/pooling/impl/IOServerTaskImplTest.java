package ua.in.SmartHome.service.pooling.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.in.SmartHome.dao.db.system.IODeviceDao;
import ua.in.SmartHome.dao.device.ProtocolDao;
import ua.in.SmartHome.dao.device.modbus.serial.J2modModbusRtuImplTest;
import ua.in.SmartHome.model.Equipment;
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.model.EquipmentTypeProperties;
import ua.in.SmartHome.model.system.IODevice;
import ua.in.SmartHome.model.system.Protocol;
import ua.in.SmartHome.service.pooling.IOServerTask;
import ua.in.SmartHome.util.EquipmentTypeBuilder;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "testProfile")
@Rollback
public class IOServerTaskImplTest {

    @Autowired
    IODeviceDao ioDeviceDao;

    @Autowired
    Protocol protocol;

    @Autowired
    IODevice ioDevice;

    @Autowired
    EquipmentTypeProperties equipmentTypeProperties;

    @Autowired
    ApplicationContext applicationContext;

    @Test
    public void pollIODevice() {

    }

    @Test
    public void pollIODevices() {



        ProtocolDao protocolDao = (ProtocolDao)applicationContext.getBean(ioDevice.getProtocol().getName());

        protocolDao.setIODevice(ioDevice);


        EquipmentTypeBuilder equipmentTypeBuilder = new EquipmentTypeBuilder();
        EquipmentType equipmentType = equipmentTypeBuilder.buildEquipmentType(equipmentTypeProperties, 0);

        Equipment equipment = new Equipment();
        equipment.setName("testEquipment");
        equipment.setEquipmentType(equipmentType);

        protocolDao.read(equipment);



    }

}