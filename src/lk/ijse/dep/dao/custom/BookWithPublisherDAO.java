package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.CrudDAO;
import lk.ijse.dep.entity.BookWithPublisher;

public interface BookWithPublisherDAO extends CrudDAO<BookWithPublisher,String> {

    int count() throws Exception;
}
