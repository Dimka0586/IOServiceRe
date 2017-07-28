package ua.in.SmartHome.service.pooling.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ua.in.SmartHome.dao.db.system.IODeviceDao;
import ua.in.SmartHome.model.system.IODevice;
import ua.in.SmartHome.service.pooling.IOServerTask;

@Service
public class IOServerTaskImpl implements IOServerTask {

    @Autowired
    IODeviceDao ioDeviceDao;

    public void pollIODevice(IODevice ioDevice) {

    }

    public void pollIODevices() {

    }




}
