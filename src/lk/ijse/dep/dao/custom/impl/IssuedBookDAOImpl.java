package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.IssuedBookDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.IssuedBook;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class IssuedBookDAOImpl implements IssuedBookDAO {
    @Override
    public Optional<IssuedBook> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM IssuedBook WHERE issueId=?", key);
        IssuedBook i = null;
        if (rst.next()) {
            i = new IssuedBook(rst.getString("issueId"),
                    rst.getString("iBookId"),
                    rst.getString("iMemId"),
                    rst.getString("issuedDate"),
                    rst.getString("returnId"));
        }
        return Optional.ofNullable(i);
    }

    @Override
    public Optional<List<IssuedBook>> findAll() throws Exception {
        ArrayList<IssuedBook> issuedBooks = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM IssuedBook");
        while (rst.next()) {
            String id = rst.getString(1);
            String bId = rst.getString(2);
            String mId = rst.getString(3);
            String iDate = rst.getString(4);
            String rId = rst.getString(5);
            IssuedBook issuedBook = new IssuedBook(id, bId,mId,iDate,rId);
            issuedBooks.add(issuedBook);
        }
        return Optional.ofNullable(issuedBooks);
    }

    @Override
    public boolean save(IssuedBook entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO IssuedBook VALUES (?,?,?,?,?)",
                entity.getIssueId(),entity.getiBookId(),entity.getiMemId(),entity.getIssuedDate(),entity.getReturnId()) > 0;
    }

    @Override
    public boolean update(IssuedBook entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM IssuedBook WHERE issueId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(IssuedBook entity) throws Exception {
        return false;
    }

    @Override
    public Optional<IssuedBook> findReturnDet(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT iBookId,iMemId FROM IssuedBook WHERE returnId=?", key);
        IssuedBook i = null;
        if (rst.next()) {
            i = new IssuedBook(rst.getString("iBookId"),
                    rst.getString("iMemId"));
        }
        return Optional.ofNullable(i);
    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM IssuedBook");
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
