package ua.in.SmartHome.service.pooling;

import ua.in.SmartHome.model.system.IODevice;

public interface IOServerTask {

    void pollIODevice(IODevice ioDevice);

    void pollIODevices();
}
