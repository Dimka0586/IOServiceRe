package ua.in.SmartHome.service.model;

import java.util.List;

public interface GeneralCRUDService<T> {

    T create(T t);
    List<T> readAll();
    T update(T t);
    void delete(int id);
    T readById(int id);
}
