package ua.in.SmartHome.dao.db.system.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.system.IODeviceDao;
import ua.in.SmartHome.model.system.IODevice;

@Repository
public class IODeviceDaoImpl extends AbstractDao<IODevice> implements IODeviceDao {
    public IODeviceDaoImpl() {
        super(IODevice.class);
    }
}
