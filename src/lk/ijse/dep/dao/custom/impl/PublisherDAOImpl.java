package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.PublisherDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.Publisher;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PublisherDAOImpl implements PublisherDAO {
    @Override
    public Optional<Publisher> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Publisher WHERE pName=?", key);
        Publisher p = null;
        if (rst.next()) {
            p = new Publisher(rst.getString("pId"),
                    rst.getString("pName"));
        }
        return Optional.ofNullable(p);
    }

    @Override
    public Optional<List<Publisher>> findAll() throws Exception {
        ArrayList<Publisher> publishers = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM Publisher");
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            Publisher publisher = new Publisher(id, name);
            publishers.add(publisher);
        }
        return Optional.ofNullable(publishers);
    }

    @Override
    public boolean save(Publisher entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO Publisher VALUES (?,?)",
               entity.getpId(),entity.getpName()) > 0;
    }

    @Override
    public boolean update(Publisher entity) throws Exception {
        return CrudUtil.<Integer>execute("UPDATE Publisher SET pName=? WHERE pId=?",
                entity.getpName(),entity.getpId()) > 0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM Publisher WHERE pId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(Publisher entity) throws Exception {
        return false;
    }

    @Override
    public Optional<Publisher> findReturnDet(String key) throws Exception {
        return Optional.empty();
    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM Publisher");
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
