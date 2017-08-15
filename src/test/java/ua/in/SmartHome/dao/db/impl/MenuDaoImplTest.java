package ua.in.SmartHome.dao.db.impl;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import ua.in.SmartHome.dao.db.MenuDao;
import ua.in.SmartHome.model.Menu;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback(false)
public class MenuDaoImplTest {

	@Autowired
	MenuDao menuDao;

	@Test
	public void create(){
		Menu subSubRootMenu1_1 = new Menu("sub-sub-root-1-1");
			menuDao.create(subSubRootMenu1_1);
		Menu subSubRootMenu1_2 = new Menu("sub-sub-root-1-2");
			menuDao.create(subSubRootMenu1_2);
		Menu subSubRootMenu2_1 = new Menu("sub-sub-root-2-1");
			menuDao.create(subSubRootMenu2_1);
		Menu subSubRootMenu2_2 = new Menu("sub-sub-root-2-2");
			menuDao.create(subSubRootMenu2_2);

		Menu subRootMenu1 = new Menu("sub-root-1");
			menuDao.create(subRootMenu1);
		Menu subRootMenu2 = new Menu("sub-root-2");
			menuDao.create(subRootMenu2);

		Menu rootMenu = new Menu("root");

		subSubRootMenu1_1.setParent(subRootMenu1);
		subSubRootMenu1_2.setParent(subRootMenu1);
		subSubRootMenu2_1.setParent(subRootMenu2);
		subSubRootMenu2_2.setParent(subRootMenu2);
		subRootMenu1.setParent(rootMenu);
		subRootMenu2.setParent(rootMenu);
		menuDao.create(rootMenu);

	}

	@Test
	public void readAll(){
		//List<Menu> menus = menuDao.readAll();
		//menus.forEach(menu -> System.out.println(menu.getName()));

	}

	@Test
	public void readById(){
		Menu menu = menuDao.readById(7);
		List<Menu> menus = menu.getMenus();
		menus.forEach(menuTmp -> System.out.println(menuTmp.getName()));
		menus.get(0).getMenus().forEach(menuTmp -> System.out.println(menuTmp.getName()));
		menus.get(1).getMenus().forEach(menuTmp -> System.out.println(menuTmp.getName()));
	}
}
