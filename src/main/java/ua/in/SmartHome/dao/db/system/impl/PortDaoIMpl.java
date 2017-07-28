package ua.in.SmartHome.dao.db.system.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.system.PortDao;
import ua.in.SmartHome.model.system.Port;

@Repository
public class PortDaoIMpl extends AbstractDao<Port> implements PortDao {
    public PortDaoIMpl() {
        super(Port.class);
    }
}
