package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.ReturnBookDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.ReturnBook;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReturnBookDAOImpl implements ReturnBookDAO {
    @Override
    public Optional<ReturnBook> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM ReturnBook WHERE rId=?", key);
        ReturnBook r = null;
        if (rst.next()) {
            r = new ReturnBook(rst.getString("rId"),
                    rst.getString("exDate"),
                    rst.getString("status"),
                    rst.getDouble("fine"),
                    rst.getString("rDate"));
        }
        return Optional.ofNullable(r);
    }

    @Override
    public Optional<List<ReturnBook>> findAll() throws Exception {
        ArrayList<ReturnBook> returnBooks = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM ReturnBook");
        while (rst.next()) {
            String id = rst.getString(1);
            String  exDate= rst.getString(2);
            String status = rst.getString(3);
            double fine = Double.parseDouble(rst.getString(4));
            String rDate = rst.getString(5);

            ReturnBook returnBook = new ReturnBook(id, exDate,status,fine,rDate);
            returnBooks.add(returnBook);
        }
        return Optional.ofNullable(returnBooks);
    }

    @Override
    public boolean save(ReturnBook entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO ReturnBook(fine,rDate) VALUES (?,?) WHERE rId=?",
               entity.getFine(),entity.getrDate(),entity.getrDate()) > 0;
    }

    @Override
    public boolean update(ReturnBook entity) throws Exception {
        return CrudUtil.<Integer>execute("UPDATE ReturnBook SET status=?,fine=?,rDate=? WHERE rId=?",
                entity.getStatus(),entity.getFine(),entity.getrDate(),entity.getrId()) > 0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM ReturnBook WHERE rId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(ReturnBook entity) throws Exception {

        System.out.println(entity.getExDate());
        return CrudUtil.<Integer>execute("INSERT INTO ReturnBook(rId,exDate,status) VALUES (?,?,?)",
                entity.getrId(),entity.getExDate(),entity.getStatus()) > 0;

    }

    @Override
    public Optional<ReturnBook> findReturnDet(String key) throws Exception {
        return Optional.empty();
    }

    @Override
    public int count() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT COUNT(*) FROM ReturnBook");
        if (rst.next()) {
            return rst.getInt(1);
        }
        return 0;
    }
}
