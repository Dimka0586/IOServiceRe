package ua.in.SmartHome.dao.db.impl;

import org.springframework.stereotype.Repository;

import ua.in.SmartHome.dao.db.AbstractDao;
import ua.in.SmartHome.dao.db.MenuDao;
import ua.in.SmartHome.model.Menu;

@Repository
public class MenuDaoImpl extends AbstractDao<Menu> implements MenuDao {

    public MenuDaoImpl() {
        super(Menu.class);
    }
}
