package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.BookDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.Book;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookDAOImpl implements BookDAO {
    @Override
    public Optional<Book> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT bId,bName,copies,availableBooks FROM Book WHERE bId=?", key);
        Book b = null;
        if (rst.next()) {
            b = new Book(rst.getString("bId"),
                    rst.getString("bName"),
                    rst.getInt("copies"),
                    rst.getInt("availableBooks"));
        }
        return Optional.ofNullable(b);
    }

    @Override
    public Optional<List<Book>> findAll() throws Exception {
        ArrayList<Book> books = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM Book");
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            int qty = rst.getInt(3);
            int available = rst.getInt(4);
            Book book = new Book(id, name,qty,available);
            books.add(book);
        }
        return Optional.ofNullable(books);
    }

    @Override
    public boolean save(Book entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO Book VALUES (?,?,?,?)",
                entity.getbId(),entity.getbName(),entity.getCopies(),entity.getAvailableBooks()) > 0;
    }

    @Override
    public boolean update(Book entity) throws Exception {
        return CrudUtil.<Integer>execute("UPDATE Book SET bName=?,copies=? WHERE bId=?",
                entity.getbName(),entity.getCopies(),entity.getbId()) > 0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM Book WHERE bId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(Book entity) throws Exception {
        System.out.println("Enity Available :"+entity.getAvailableBooks());
        return CrudUtil.<Integer>execute("UPDATE Book SET availableBooks=? WHERE bId=?",
                entity.getAvailableBooks(),entity.getbId()) > 0;
    }

    @Override
    public Optional<Book> findReturnDet(String key) throws Exception {
        return Optional.empty();
    }

//    @Override
//    public Optional<List<Book>> findBookList() throws Exception {
//        return Optional.empty();
//    }
//
//    @Override
//    public Optional<List<Book>> findBookList(String key) throws Exception {
//        ResultSet rst = CrudUtil.execute("SELECT bId,bName,copies,availableBooks FROM Book WHERE bId=?", key);
//        List<Book> b = new ArrayList<>();
//        while (rst.next()) {
//            Book book = new Book(rst.getString(1),
//                    rst.getString(2),
//                    rst.getInt(3),
//                    rst.getInt(4));
//
//            b.add(book);
//        }
//        return Optional.ofNullable(b);
//    }
}
