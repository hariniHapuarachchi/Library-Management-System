package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.CrudDAO;
import lk.ijse.dep.entity.Author;

public interface AuthorDAO extends CrudDAO<Author,String> {

    int count() throws Exception;
}
