package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;
import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.VariableTagTypeDao;
import ua.in.SmartHome.model.VariableTagType;

@Repository
public class VariableTagTypeDaoImpl extends AbstractDao<VariableTagType> implements VariableTagTypeDao {

    public VariableTagTypeDaoImpl() {
        super(VariableTagType.class);
    }
}
