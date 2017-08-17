package ua.in.SmartHome.service.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.in.SmartHome.dao.db.GeneralDao;
import ua.in.SmartHome.service.model.GeneralCRUDService;

import java.util.List;

import javax.transaction.Transactional;

@Service
@Transactional
public abstract class AbstractService<T> implements GeneralCRUDService<T> {

    @Autowired
    private GeneralDao<T> generalDao;

    public AbstractService(){

    }

    public T create(T t) {
        return generalDao.create(t);
    }

    public List<T> readAll() {
        return generalDao.readAll();
    }

    public T update(T t) {
        return generalDao.update(t);
    }

    public void delete(int id) {
        generalDao.delete(id);
    }

    public T readById(int id) {
        return null;
    }
}
