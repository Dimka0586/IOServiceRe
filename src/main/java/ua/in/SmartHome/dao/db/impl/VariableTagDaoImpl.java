package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.VariableTagDao;
import ua.in.SmartHome.model.VariableTag;

@Repository
public class VariableTagDaoImpl extends AbstractDao<VariableTag> implements VariableTagDao {

    public VariableTagDaoImpl() {
        super(VariableTag.class);
    }
}
