package ua.in.SmartHome.dao.db;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public abstract class AbstractDao<T> implements GeneralDao<T> {

    @PersistenceContext
    EntityManager entityManager;

    private Class<T> tClass;

    public AbstractDao(Class<T> tClass) {
        this.tClass = tClass;
    }

    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    public List<T> readAll() {
        CriteriaQuery<T> criteria = entityManager.getCriteriaBuilder().createQuery(tClass);
        criteria.select(criteria.from(tClass));
        return entityManager.createQuery(criteria).getResultList();
    }

    public T update(T t) {
        return entityManager.merge(t);
    }

    public void delete(int id) {
        entityManager.remove(readById(id));
    }

    public T readById(int id) {
        System.out.println("entityManager: " + entityManager);
        return entityManager.find(tClass, id);
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> gettClass() {
        return tClass;
    }

    public void settClass(Class<T> tClass) {
        this.tClass = tClass;
    }
}
