package ua.in.SmartHome.dao.device;

import ua.in.SmartHome.model.Equipment;
import ua.in.SmartHome.model.system.IODevice;

public interface ProtocolDao {

    /**Return object from device*/
    Equipment read(Equipment equipment);
    /**Update object to device*/
    void write(Equipment equipment);



    void setIODevice(IODevice ioDevice);
}
