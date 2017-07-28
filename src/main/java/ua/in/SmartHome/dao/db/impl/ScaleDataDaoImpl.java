package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.ScaleDataDao;
import ua.in.SmartHome.model.ScaleData;

@Repository
public class ScaleDataDaoImpl extends AbstractDao<ScaleData> implements ScaleDataDao {

    public ScaleDataDaoImpl() {
        super(ScaleData.class);
    }
}
