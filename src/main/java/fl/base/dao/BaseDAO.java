package fl.base.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDAO<T> {

    T get(Serializable id);

    List<T> getAll();

    long count();

    void create(T baseDomain);

    void update(T baseDomain);

    void delete(T baseDomain);

    void deleteById(Serializable id);

    void deleteAll();

}
