package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.Converter;
import lk.ijse.dep.business.custom.IssuedBookBO;
import lk.ijse.dep.dao.DAOFactory;
import lk.ijse.dep.dao.custom.BookDAO;
import lk.ijse.dep.dao.custom.IssuedBookDAO;
import lk.ijse.dep.dao.custom.QueryDAO;
import lk.ijse.dep.dao.custom.ReturnBookDAO;
import lk.ijse.dep.db.DBConnection;
import lk.ijse.dep.dto.*;
import lk.ijse.dep.entity.*;

import java.util.ArrayList;
import java.util.List;

public class IssuedBookBOImpl implements IssuedBookBO {

    private IssuedBookDAO issuedBookDAO;
    private ReturnBookDAO returnBookDAO;
    private QueryDAO queryDAO;
    private BookDAO bookDAO;

    public IssuedBookBOImpl() {
        issuedBookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ISSUED_BOOK);
        returnBookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RETURN_BOOK);
        queryDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
        bookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);
    }

    @Override
    public List<CustomDTO> getIssuedBooks() throws Exception {
        return queryDAO.displayExpiredDateOfReturnedBook().map(Converter::<CustomDTO>getDTOList).get();

    }

    @Override
    public void addIssuedBooks(IssuedBookDTO dto) throws Exception {

        DBConnection.getConnection().setAutoCommit(false);

        try {

            System.out.println("Return BOOK");
            System.out.println(dto.getReturnBookDTO1().getExDate());
            dto.getReturnBookDTO1().setStatus("NOT RETURNED");
            boolean result = returnBookDAO.saveSelected(new ReturnBook(dto.getReturnBookDTO1().getrId(),dto.getReturnBookDTO1().getExDate(),dto.getReturnBookDTO1().getStatus()));

            if (!result) {
                return;
            }

           result = issuedBookDAO.save(new IssuedBook(dto.getIssueId(), dto.getiBookId(),dto.getiMemId(),dto.getIssuedDate(),dto.getReturnId()));
//                    orderDAO.save(new Order(dto.getId(), Date.valueOf(dto.getDate()), dto.getCustomerId()));

            if (!result) {
                return;
            }

            if (!result) {
                DBConnection.getConnection().rollback();
                return;
            }

            DBConnection.getConnection().commit();

        } catch (Exception ex) {
            DBConnection.getConnection().rollback();
            ex.printStackTrace();
        } finally {
            DBConnection.getConnection().setAutoCommit(true);
        }

    }

    @Override
    public boolean updateIssuedBooks(IssuedBookDTO dto) throws Exception {
        return issuedBookDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteIssuedBooks(String issueID) throws Exception {
        return issuedBookDAO.delete(issueID);
    }

    @Override
    public IssuedBookDTO findIssuedBooks(String id) throws Exception {
        return issuedBookDAO.find(id).map(Converter::<IssuedBookDTO>getDTO).orElse(null);
    }

    public String generateReturnId() throws Exception {
        return issuedBookDAO.count() + 1 + "";
    }

    @Override
    public List<ReturnBookDTO> getReturnBooks() throws Exception {
        List<ReturnBook> returnBooks = returnBookDAO.findAll().get();
        ArrayList<ReturnBookDTO> tmpDTOs = new ArrayList<>();

        for (ReturnBook returnBook : returnBooks) {
            List<IssuedBookDTO> issuedBookDTOS = queryDAO.getReturnBookDetails(returnBook.getrId()).map(ce -> {
                return Converter.getDTOList(ce, IssuedBookDTO.class);
            }).get();

            ReturnBookDTO dto = new ReturnBookDTO(returnBook.getrId(),issuedBookDTOS,returnBook.getExDate(),
                    returnBook.getrDate(),returnBook.getFine(),
                    returnBook.getStatus());
            // CustomDTO dto = new CustomDTO(returnBookDTOS);
            tmpDTOs.add(dto);
        }

        return tmpDTOs;
    }

    @Override
    public boolean addReturnBooks(ReturnBookDTO dto) throws Exception {
        return returnBookDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateReturnBooks(ReturnBookDTO dto) throws Exception {
        return returnBookDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteReturndBooks(String returnID) throws Exception {
        return returnBookDAO.delete(returnID);
    }

    @Override
    public ReturnBookDTO findReturnBooks(String id) throws Exception {
        return returnBookDAO.find(id).map(Converter::<ReturnBookDTO>getDTO).orElse(null);
    }

    public int getRowNumber() throws Exception {
        return issuedBookDAO.count();
    }

    public int getRowNumberReturn() throws Exception {
        return returnBookDAO.count();
    }

    @Override
    public IssuedBookDTO findIssuedReturns(String id) throws Exception {
        return issuedBookDAO.findReturnDet(id).map(Converter::<IssuedBookDTO>getDTO).orElse(null);
    }

    @Override
    public List<CustomDTO> showBorrowed() throws Exception {
        return queryDAO.showBorrowedBooks().map(Converter::<CustomDTO>getDTOList).get();
    }

    @Override
    public boolean updateAvailableBook(BookDTO dto) throws Exception {
        return bookDAO.saveSelected(Converter.getEntity(dto));
    }

    @Override
    public BookDTO checkAvailableQuantity(String bookId) throws Exception {

        return bookDAO.find(bookId).map(Converter::<BookDTO>getDTO).orElse(null);
    }

    @Override
    public List<CustomDTO> showReturnBookList() throws Exception {
        return queryDAO.showStatus().map(Converter::<CustomDTO>getDTOList).orElse(null);
    }


}
