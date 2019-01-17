package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.QueryDAO;
import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.entity.CustomEntity_2;
import lk.ijse.dep.entity.CustomEntity_3;
import lk.ijse.dep.entity.CustomEntity_4;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class QueryDAOImpl implements QueryDAO {
    @Override
    public Optional<List<CustomEntity_2>> displayBookAuthorAndPublisher() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT Book.bId,Book.bName,Author.aName,Publisher.pName,BookWithPublisher.publishDate,Book.copies,Book.availableBooks FROM Book\n" +
                "INNER JOIN BookWithAuthor on Book.bId = BookWithAuthor.bookId \n"+
                "INNER JOIN Author on BookWithAuthor.authorId=Author.aId\n"+
                "INNER JOIN BookWithPublisher on Book.bId = BookWithPublisher.pBookId\n"+
                "INNER JOIN Publisher on BookWithPublisher.pubId=Publisher.pId");
        List<CustomEntity_2> al = new ArrayList<>();

        while (rst.next()) {
            CustomEntity_2 customEntity = new CustomEntity_2(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getInt(6),
                    rst.getInt(7));
            al.add(customEntity);

        }
        return Optional.ofNullable(al);
    }

    @Override
    public Optional<List<CustomEntity>> displayExpiredDateOfReturnedBook() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT IssuedBook.issueId,IssuedBook.iMemId,IssuedBook.iBookId,ReturnBook.exDate,ReturnBook.rId FROM IssuedBook\n" +
                "    INNER JOIN ReturnBook on IssuedBook.returnId = ReturnBook.rId");
        List<CustomEntity> al = new ArrayList<>();

        while (rst.next()) {
            CustomEntity customEntity = new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5));
            al.add(customEntity);

            System.out.println("CUSTOM");
            System.out.println(customEntity.getIssueId());
            System.out.println(customEntity.getiMemId());
            System.out.println(customEntity.getiBookId());
            System.out.println(customEntity.getExDate());

        }
        return Optional.ofNullable(al);
    }

    @Override
    public Optional<List<CustomEntity>> displayAllIssuedDetailsWithExpiredDate() throws Exception {
        return Optional.empty();
    }

    @Override
    public Optional<List<CustomEntity>> getReturnBookDetails(String returnID) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT ReturnBook.rId,IssuedBook.iBookId,IssuedBook.iMemId,ReturnBook.exDate,ReturnBook.rDate,ReturnBook.fine,ReturnBook.status FROM ReturnBook\n" +
                "    INNER JOIN IssuedBook on ReturnBook.rId = IssuedBook.returnId WHERE ReturnBook.rId=?", returnID);
        List<CustomEntity> al = new ArrayList<>();

        while (rst.next()) {
            CustomEntity customEntity = new CustomEntity(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7));
            al.add(customEntity);
        }
        return Optional.ofNullable(al);
    }

    @Override
    public Optional<List<CustomEntity_3>> showBorrowedBooks() throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT IssuedBook.issueId,IssuedBook.returnId,IssuedBook.iBookId,Book.bName,IssuedBook.iMemId,ReturnBook.exDate,ReturnBook.status,IssuedBook.issuedDate,Book.copies,Book.availableBooks FROM IssuedBook\n" +
                "INNER JOIN Book on IssuedBook.iBookId = Book.bId \n"+
                "INNER JOIN ReturnBook on IssuedBook.returnId=ReturnBook.rId WHERE ReturnBook.status = ?","NOT RETURNED");
        List<CustomEntity_3> al = new ArrayList<>();

        while (rst.next()) {
            CustomEntity_3 customEntity = new CustomEntity_3(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7),
                    rst.getString(8),
                    rst.getInt(9),
                    rst.getInt(10));
            al.add(customEntity);

            System.out.println(rst.getString(1));
            System.out.println(rst.getString(2));
            System.out.println(rst.getString(3));
            System.out.println(rst.getString(4));
            System.out.println(rst.getString(5));
            System.out.println(rst.getString(6));
            System.out.println(rst.getString(7));
            System.out.println(rst.getString(8));
            System.out.println(rst.getString(9));
            System.out.println(rst.getString(10));
        }
        return Optional.ofNullable(al);
    }

    @Override
    public Optional<List<CustomEntity_4>> showStatus() throws Exception {

        ResultSet rst = CrudUtil.execute("SELECT IssuedBook.issueId,IssuedBook.returnId,IssuedBook.iBookId,IssuedBook.iMemId,IssuedBook.issuedDate,ReturnBook.rDate FROM IssuedBook\n" +
                "INNER JOIN Book on IssuedBook.iBookId = Book.bId \n" +
                "INNER JOIN ReturnBook on IssuedBook.returnId=ReturnBook.rId WHERE ReturnBook.status = ?", "RETURNED");
        List<CustomEntity_4> al = new ArrayList<>();

        while (rst.next()) {
            CustomEntity_4 customEntity = new CustomEntity_4(rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));
            al.add(customEntity);

            System.out.println(rst.getString(1));
            System.out.println(rst.getString(2));
            System.out.println(rst.getString(3));
            System.out.println(rst.getString(4));
            System.out.println(rst.getString(5));
            System.out.println(rst.getString(6));

        }
        return Optional.ofNullable(al);
    }
}
