package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.CrudDAO;
import lk.ijse.dep.entity.IssuedBook;

public interface IssuedBookDAO extends CrudDAO<IssuedBook,String> {

    int count() throws Exception;

}
