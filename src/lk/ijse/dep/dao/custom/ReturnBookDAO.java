package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.CrudDAO;
import lk.ijse.dep.entity.ReturnBook;

public interface ReturnBookDAO extends CrudDAO<ReturnBook,String> {

    int count() throws Exception;
}
