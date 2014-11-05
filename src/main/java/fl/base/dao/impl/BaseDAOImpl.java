package fl.base.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;

import fl.base.dao.BaseDAO;

public abstract class BaseDAOImpl<T> implements BaseDAO<T> {

    protected SessionFactory sessionFactory;

    protected SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public T get(Serializable id) {
        return (T) sessionFactory.getCurrentSession().get(getDomainClass(), id);
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return sessionFactory.getCurrentSession().createQuery("from " + getDomainClass().getName() + " x").list();
    }

    public long count() {
        Number n = (Number) sessionFactory.getCurrentSession()
                .createQuery("select count(*) from " + getDomainClass().getName() + " x").uniqueResult();
        return n.longValue();
    }

    public void create(T baseDomain) {
        sessionFactory.getCurrentSession().save(baseDomain);
    }

    public void update(T baseDomain) {
        sessionFactory.getCurrentSession().update(baseDomain);
    }

    public void delete(T baseDomain) {
        sessionFactory.getCurrentSession().delete(baseDomain);
    }

    public void deleteById(Serializable id) {
        delete(get(id));
    }

    public void deleteAll() {
        sessionFactory.getCurrentSession().createQuery("delete from " + getDomainClass().getName() + " x")
                .executeUpdate();
    }

    protected abstract Class<T> getDomainClass();

}