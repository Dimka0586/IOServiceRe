package ua.in.SmartHome.dao.device.modbus.serial;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import ua.in.SmartHome.dao.device.modbus.ModbusDao;

public class J2modModbusRtuImplTest {
    @Autowired
    @Qualifier(value = "j2ModModbusSerialDaoImpl")
    ModbusDao modbusProtocolDao;

    @Test
    public void readCoils() {

    }

    @Test
    public void writeCoils() {

    }

    @Test
    public void readInputReg() {

    }

    @Test
    public void writeReg() {

    }

}