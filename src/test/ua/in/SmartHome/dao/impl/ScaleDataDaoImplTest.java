package ua.in.SmartHome.dao.impl;

import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.in.SmartHome.dao.AbstractDaoTest;
import ua.in.SmartHome.model.ScaleData;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "testProfile")
@Rollback
public class ScaleDataDaoImplTest extends AbstractDaoTest<ScaleData> {

    public ScaleDataDaoImplTest() {
        super(ScaleData.class, new ScaleData());
    }

    @Override
    public ScaleData changeObjForUpdate(ScaleData obj) {
        obj.setEng(125);
        return obj;
    }


}