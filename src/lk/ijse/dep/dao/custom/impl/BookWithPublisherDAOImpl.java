package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.BookWithPublisherDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.BookWithPublisher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookWithPublisherDAOImpl implements BookWithPublisherDAO {
    @Override
    public Optional<BookWithPublisher> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM BookWithPublisher WHERE bpId=?", key);
        BookWithPublisher bp = null;
        if (rst.next()) {
                 bp = new BookWithPublisher(rst.getString("bpId"),
                    rst.getString("pBookId"),
                         rst.getString("pubId"),
                         rst.getString("publishDate"));
        }
        return Optional.ofNullable(bp);
    }

    @Override
    public Optional<List<BookWithPublisher>> findAll() throws Exception {
        ArrayList<BookWithPublisher> bookWithPublishers = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM BookWithPublisher");
        while (rst.next()) {
            String id = rst.getString(1);
            String bId = rst.getString(2);
            String pId = rst.getString(3);
            String pDate = rst.getString(4);
            BookWithPublisher bookWithPublisher = new BookWithPublisher(id, bId,pId,pDate);
            bookWithPublishers.add(bookWithPublisher);
        }
        return Optional.ofNullable(bookWithPublishers);
    }

    @Override
    public boolean save(BookWithPublisher entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO BookWithPublisher VALUES (?,?,?,?)",
                entity.getBpId(),entity.getpBookId(),entity.getPubId(),entity.getPublishDate()) > 0;
    }

    @Override
    public boolean update(BookWithPublisher entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM BookWithPublisher WHERE bpId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(BookWithPublisher entity) throws Exception {
        return false;
    }

    @Override
    public Optional<BookWithPublisher> findReturnDet(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT bpId,pubId FROM BookWithPublisher WHERE pBookId=?", key);
        BookWithPublisher bp = null;
        if (rst.next()) {
            bp = new BookWithPublisher(rst.getString("bpId"),
                    rst.getString("pubId"));
        }
        return Optional.ofNullable(bp);
    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM BookWithPublisher");
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
