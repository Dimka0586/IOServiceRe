package ua.in.SmartHome.dao.impl;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ua.in.SmartHome.dao.AbstractDaoTest;
import ua.in.SmartHome.model.EquipmentType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "testProfile")
@Rollback
public class EquipmentTypeDaoImplTest extends AbstractDaoTest<EquipmentType> {


    public EquipmentTypeDaoImplTest() {
        super(EquipmentType.class, new EquipmentType());
    }

    @Override
    public EquipmentType changeObjForUpdate(EquipmentType obj) {
        /*obj.setStartAddress(25);*/
        return obj;
    }
}