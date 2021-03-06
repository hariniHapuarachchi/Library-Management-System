package lk.ijse.dep.dao;

import lk.ijse.dep.entity.SuperEntity;

import java.util.List;
import java.util.Optional;

public interface CrudDAO<T extends SuperEntity, ID> extends SuperDAO{

    Optional<T> find(ID key) throws Exception;

    Optional<List<T>> findAll() throws Exception;

    boolean save(T entity) throws Exception;

    boolean update(T entity) throws Exception;

    boolean delete(ID key) throws Exception;

    boolean saveSelected(T entity) throws Exception;

    Optional<T> findReturnDet(ID key) throws Exception;

    //Optional<List<T>> findBookList(String key) throws Exception;
}
