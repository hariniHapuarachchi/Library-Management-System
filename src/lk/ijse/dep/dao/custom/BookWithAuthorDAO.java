package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.CrudDAO;
import lk.ijse.dep.entity.BookWithAuthor;

public interface BookWithAuthorDAO extends CrudDAO<BookWithAuthor,String> {

    int count() throws Exception;
}
