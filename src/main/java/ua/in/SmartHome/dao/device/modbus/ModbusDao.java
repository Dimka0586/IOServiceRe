package ua.in.SmartHome.dao.device.modbus;

import ua.in.SmartHome.dao.device.ProtocolDao;

import java.util.List;

public interface ModbusDao {

    boolean readCoils(int unitId, int ref, byte num);
    void writeCoils(int unitId, int ref, byte num, boolean val);
    List<Integer> readInputReg(int unitId, int ref, int count);
    void writeReg(int unitId, int ref, int val);
}
