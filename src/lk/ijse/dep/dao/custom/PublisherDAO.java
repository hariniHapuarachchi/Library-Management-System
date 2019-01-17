package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.CrudDAO;
import lk.ijse.dep.entity.Publisher;

public interface PublisherDAO extends CrudDAO<Publisher,String> {

    int count() throws Exception;
}
