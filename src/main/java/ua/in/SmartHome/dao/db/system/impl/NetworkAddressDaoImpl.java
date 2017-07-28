package ua.in.SmartHome.dao.db.system.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.system.NetworkAddressDao;
import ua.in.SmartHome.model.system.NetworkAddress;

@Repository
public class NetworkAddressDaoImpl extends AbstractDao<NetworkAddress> implements NetworkAddressDao {
    public NetworkAddressDaoImpl() {
        super(NetworkAddress.class);
    }
}
