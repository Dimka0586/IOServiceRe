package ua.in.SmartHome.dao.db.system.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.system.IOServerDao;
import ua.in.SmartHome.model.system.IOServer;

@Repository
public class IOServerDaoImpl extends AbstractDao<IOServer> implements IOServerDao {
    public IOServerDaoImpl() {
        super(IOServer.class);
    }
}
