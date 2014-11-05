package fl.base.service.impl;

import java.io.Serializable;
import java.util.List;

import fl.base.dao.BaseDAO;
import fl.base.service.BaseService;

public abstract class BaseServiceImpl<T> implements BaseService<T> {

    public T get(Serializable id) {
        return getBaseDAO().get(id);
    }

    public List<T> getAll() {
        return getBaseDAO().getAll();
    }

    public long count() {
        return getBaseDAO().count();
    }

    public void create(T baseDomain) {
        getBaseDAO().create(baseDomain);
    }

    public void update(T baseDomain) {
        getBaseDAO().update(baseDomain);
    }

    public void delete(T baseDomain) {
        getBaseDAO().delete(baseDomain);
    }

    public void deleteById(Serializable id) {
        getBaseDAO().deleteById(id);
    }

    public void deleteAll() {
        getBaseDAO().deleteAll();
    }

    protected abstract BaseDAO<T> getBaseDAO();

}
