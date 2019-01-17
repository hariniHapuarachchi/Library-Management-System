package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.AuthorDAO;
import lk.ijse.dep.entity.Author;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AuthorDAOImpl implements AuthorDAO {
    @Override
    public Optional<Author> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Author WHERE aName=?", key);
        Author a = null;
        if (rst.next()) {
            a = new Author(rst.getString("aId"),
                    rst.getString("aName"));
        }
        return Optional.ofNullable(a);
    }

    @Override
    public Optional<List<Author>> findAll() throws Exception {
        ArrayList<Author> authors = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM Author");
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            Author author = new Author(id, name);
            authors.add(author);
        }
        return Optional.ofNullable(authors);
    }

    @Override
    public boolean save(Author entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO Author VALUES (?,?)",
                entity.getaId(), entity.getaName()) > 0;
    }

    @Override
    public boolean update(Author entity) throws Exception {
        return CrudUtil.<Integer>execute("UPDATE Author SET aName=? WHERE aId=?",
                entity.getaName(),entity.getaId()) > 0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM Author WHERE aId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(Author entity) throws Exception {
        return false;
    }

    @Override
    public Optional<Author> findReturnDet(String key) throws Exception {
        return Optional.empty();
    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM Author");
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
