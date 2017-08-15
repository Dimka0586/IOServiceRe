package ua.in.SmartHome.dao;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ua.in.SmartHome.dao.db.EquipmentTypeDao;
import ua.in.SmartHome.dao.db.EquipmentTypeParDao;
import ua.in.SmartHome.dao.db.VariableTagTypeDao;
import ua.in.SmartHome.model.EquipmentType;
import ua.in.SmartHome.model.EquipmentTypePar;
import ua.in.SmartHome.model.VariableTagType;

@Component
public class GeneratorTestData {
	
	@Autowired
	VariableTagTypeDao variableTagTypeDao;
	
	@Autowired
    @Qualifier(value = "realVariableTagType")
    VariableTagType realVariableTagType;

    @Autowired
    @Qualifier(value = "intVariableTagType")
    VariableTagType intVariableTagType;
    
    @Autowired
    EquipmentTypeParDao equipmentTypeParDao;
    
    @Autowired
    EquipmentTypeDao equipmentTypeDao;
	
	public void createTestData() throws Exception {
        variableTagTypeDao.create(realVariableTagType);
        variableTagTypeDao.create(intVariableTagType);

        EquipmentType inOutType = new EquipmentType("InOut");
        EquipmentType alarmStateType = new EquipmentType("AlarmState");

        EquipmentTypePar inPar = new EquipmentTypePar("in", realVariableTagType);
        EquipmentTypePar outPar = new EquipmentTypePar("out", realVariableTagType);
        equipmentTypeParDao.create(inPar);
        equipmentTypeParDao.create(outPar);

        EquipmentTypePar inAlarmPar = new EquipmentTypePar("inAlarm", realVariableTagType);
        EquipmentTypePar outAlarmPar = new EquipmentTypePar("outAlarm", realVariableTagType);
        equipmentTypeParDao.create(inAlarmPar);
        equipmentTypeParDao.create(outAlarmPar);

        inPar.setEquipmentType(inOutType);
        outPar.setEquipmentType(inOutType);

        inAlarmPar.setEquipmentType(alarmStateType);
        outAlarmPar.setEquipmentType(alarmStateType);

        inOutType.setEquipmentTypePars(Arrays.asList(inPar, outPar));
        alarmStateType.setEquipmentTypePars(Arrays.asList(inAlarmPar, outAlarmPar));

        equipmentTypeDao.create(inOutType);
        equipmentTypeDao.create(alarmStateType);

    }

	
	
}
