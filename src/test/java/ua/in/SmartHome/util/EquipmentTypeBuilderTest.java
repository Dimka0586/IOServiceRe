package ua.in.SmartHome.util;

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
import ua.in.SmartHome.dao.db.EquipmentTypeDao;
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.model.EquipmentTypeProperties;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "testProfile")
@Rollback
public class EquipmentTypeBuilderTest {

    @Autowired
    @Qualifier(value = "analogSensorTypeProps")
    private EquipmentTypeProperties equipmentTypeProperties;

    @Autowired
    EquipmentTypeBuilder equipmentTypeBuilder;

    @Autowired
    EquipmentTypeDao equipmentTypeDao;

    @Test
    public void buildEquipmentType() {
        EquipmentType analogSensorType = equipmentTypeBuilder.buildEquipmentType(equipmentTypeProperties, 100);
        analogSensorType = equipmentTypeDao.create(analogSensorType);
        assertNotNull(analogSensorType.getId());

    }

}