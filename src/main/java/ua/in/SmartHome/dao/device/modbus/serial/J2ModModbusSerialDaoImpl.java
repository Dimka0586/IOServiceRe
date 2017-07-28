package ua.in.SmartHome.dao.device.modbus.serial;

import com.ghgande.j2mod.modbus.ModbusException;
import com.ghgande.j2mod.modbus.io.ModbusSerialTransaction;
import com.ghgande.j2mod.modbus.msg.ReadInputRegistersRequest;
import com.ghgande.j2mod.modbus.msg.ReadInputRegistersResponse;
import com.ghgande.j2mod.modbus.net.SerialConnection;
import com.ghgande.j2mod.modbus.util.SerialParameters;
import org.springframework.stereotype.Component;
import ua.in.SmartHome.dao.device.ProtocolDao;
import ua.in.SmartHome.dao.device.modbus.ModbusDao;
import ua.in.SmartHome.model.Equipment;
import ua.in.SmartHome.model.system.IODevice;

import java.util.ArrayList;
import java.util.List;


public class J2ModModbusSerialDaoImpl implements ModbusDao, ProtocolDao {

    private SerialParameters serialParameters = null;

    private IODevice ioDevice;

    public J2ModModbusSerialDaoImpl() {
    }

    public J2ModModbusSerialDaoImpl(IODevice ioDevice){
        serialParameters = new SerialParameters();
        serialParameters.setPortName(ioDevice.getPort().getName());
        serialParameters.setBaudRate(ioDevice.getPort().getBaudRate());
        serialParameters.setDatabits(ioDevice.getPort().getDataBit());
        serialParameters.setParity(ioDevice.getPort().getParity());
        serialParameters.setStopbits(ioDevice.getPort().getStopBit());
        serialParameters.setEncoding(ioDevice.getPort().getEncoding());
        serialParameters.setEcho(ioDevice.getPort().isEcho());
    }

    public J2ModModbusSerialDaoImpl(String portName, int baudRate, int dataBit,
                                    int parity, int stopBit, String encoding, boolean echo){
        serialParameters = new SerialParameters();
        serialParameters.setPortName(portName);
        serialParameters.setBaudRate(baudRate);
        serialParameters.setDatabits(dataBit);
        serialParameters.setParity(parity);
        serialParameters.setStopbits(stopBit);
        serialParameters.setEncoding(encoding);
        serialParameters.setEcho(echo);
    }

    public J2ModModbusSerialDaoImpl(SerialParameters serialParameters) {
        this.serialParameters = serialParameters;
    }

    public SerialParameters getSerialParameters() {
        return serialParameters;
    }

    public void setSerialParameters(SerialParameters serialParameters) {
        this.serialParameters = serialParameters;
    }

    public IODevice getIoDevice() {
        return ioDevice;
    }

    public void setIoDevice(IODevice ioDevice) {
        this.ioDevice = ioDevice;
    }

    public boolean readCoils(int unitId, int ref, byte num) {
        return false;
    }

    public void writeCoils(int unitId, int ref, byte num, boolean val) {

    }

    public List<Integer> readInputReg(int unitId, int ref, int count) {
        SerialConnection connection = getConnection();
        ReadInputRegistersRequest req = new ReadInputRegistersRequest(ref, count);
        req.setUnitID(unitId);
        req.setHeadless();
        ModbusSerialTransaction trans = new ModbusSerialTransaction(connection);
        trans.setRequest(req);
        ReadInputRegistersResponse resp = null;
        try {
            trans.execute();
            resp = (ReadInputRegistersResponse) trans.getResponse();
            System.out.println("resp: " + resp);
        } catch (ModbusException e) {
            e.getMessage();
        }finally {
            if (connection != null){
                connection.close();
            }
        }
        return (resp != null)?parseInputRegisterResponse(resp):null;
    }

    public void writeReg(int unitId, int ref, int val) {

    }

    private SerialConnection getConnection(){
        SerialConnection connection = new SerialConnection(serialParameters);
        try {
            connection.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    private void closeConnection(SerialConnection connection){
        connection.close();
    }

    private List<Integer> parseInputRegisterResponse(ReadInputRegistersResponse resp){
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < resp.getWordCount(); i++){
            list.add(i, resp.getRegisterValue(i));
        }
        return list;
    }


    public Equipment read(Equipment equipment) {


        return null;
    }

    public void write(Equipment equipment) {

    }

    public void setIODevice(IODevice ioDevice) {

    }
}
