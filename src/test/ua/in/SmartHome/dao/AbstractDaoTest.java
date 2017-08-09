package ua.in.SmartHome.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ua.in.SmartHome.dao.db.GeneralDao;
import ua.in.SmartHome.model.Identity;
import ua.in.SmartHome.util.CloneMaker;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context.xml")
@WebAppConfiguration
@Transactional
@ActiveProfiles(profiles = "prodProfile")
@Rollback
public abstract class AbstractDaoTest<T extends Identity>{

    @Autowired
    private GeneralDao<T> generalDao;

    @Autowired
    private CloneMaker<T> prototypeMaker;

    private Class<T> tClass;

    private T obj, cloneObj;


    public AbstractDaoTest(Class<T> tClass, T obj) {
        this.tClass = tClass;
        this.obj = obj;
    }

    @Test
    public void create() {
        cloneObj = generalDao.create(prototypeMaker.deepClone(obj));
        assertNotNull(cloneObj.getId());
    }

    @Test
    public void readAll() {
        int n = 10;
        for (int i = 0; i < n; i++){
            cloneObj = generalDao.create(prototypeMaker.deepClone(obj));
        }
        assertEquals(generalDao.readAll().size(), n);
    }

    @Test
    public void update() {
        cloneObj = generalDao.create(prototypeMaker.deepClone(obj));
        cloneObj = changeObjForUpdate(cloneObj);
        T actualObj = generalDao.update(cloneObj);
        assertEquals(cloneObj, actualObj);
    }

    @Test
    public void delete() {
        cloneObj = generalDao.create(prototypeMaker.deepClone(obj));
        generalDao.delete(cloneObj.getId());
        assertNull(generalDao.readById(cloneObj.getId()));
    }

    @Test
    public void readById() {
        cloneObj = generalDao.create(prototypeMaker.deepClone(obj));
        T actualObj = generalDao.readById(cloneObj.getId());
        assertEquals(cloneObj, actualObj);
    }

    public abstract T changeObjForUpdate(T obj);

}