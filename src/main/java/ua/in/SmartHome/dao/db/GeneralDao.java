package ua.in.SmartHome.dao.db;

import java.util.List;

public interface GeneralDao<T> {

    T create(T t);
    List<T> readAll();
    T update(T t);
    void delete(int id);
    T readById(int id);

}
