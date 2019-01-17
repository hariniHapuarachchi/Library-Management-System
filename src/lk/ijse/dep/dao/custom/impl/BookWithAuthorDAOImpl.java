package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.BookWithAuthorDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.BookWithAuthor;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookWithAuthorDAOImpl implements BookWithAuthorDAO {
    @Override
    public Optional<BookWithAuthor> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM BookWithAuthor WHERE baId=?", key);
        BookWithAuthor ba = null;
        if (rst.next()) {
            ba = new BookWithAuthor(rst.getString("baId"),
                    rst.getString("bookId"),
                    rst.getString("authorId"));
        }
        return Optional.ofNullable(ba);
    }

    @Override
    public Optional<List<BookWithAuthor>> findAll() throws Exception {
        ArrayList<BookWithAuthor> bookWithAuthors = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM BookWithAuthor");
        while (rst.next()) {
            String id = rst.getString(1);
            String bId = rst.getString(2);
            String aId = rst.getString(3);
            BookWithAuthor bookWithAuthor = new BookWithAuthor(id, bId,aId);
            bookWithAuthors.add(bookWithAuthor);
        }
        return Optional.ofNullable(bookWithAuthors);
    }

    @Override
    public boolean save(BookWithAuthor entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO BookWithAuthor VALUES (?,?,?)",
                entity.getBaId(),entity.getBookId(),entity.getAuthorId()) > 0;
    }

    @Override
    public boolean update(BookWithAuthor entity) throws Exception {
       return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM BookWithAuthor WHERE baId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(BookWithAuthor entity) throws Exception {
        return false;
    }

    @Override
    public Optional<BookWithAuthor> findReturnDet(String key) throws Exception {

            ResultSet rst = CrudUtil.execute("SELECT authorId FROM BookWithAuthor WHERE bookId=?", key);
            BookWithAuthor ba = null;
            if (rst.next()) {
                ba = new BookWithAuthor(rst.getString("authorId"));
            }
            return Optional.ofNullable(ba);

    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM BookWithAuthor");
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
