package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.BookDTO;
import lk.ijse.dep.dto.CustomDTO;
import lk.ijse.dep.dto.IssuedBookDTO;
import lk.ijse.dep.dto.ReturnBookDTO;

import java.util.List;

public interface IssuedBookBO extends SuperBO {

    List<CustomDTO> getIssuedBooks() throws Exception;

    void addIssuedBooks(IssuedBookDTO dto) throws Exception;

    boolean updateIssuedBooks(IssuedBookDTO dto) throws Exception;

    boolean deleteIssuedBooks(String issueID) throws Exception;

    IssuedBookDTO findIssuedBooks(String id) throws Exception;



    String generateReturnId() throws Exception;

    List<ReturnBookDTO> getReturnBooks() throws Exception;

    boolean addReturnBooks(ReturnBookDTO dto) throws Exception;

    boolean updateReturnBooks(ReturnBookDTO dto) throws Exception;

    boolean deleteReturndBooks(String returnID) throws Exception;

    ReturnBookDTO findReturnBooks(String id) throws Exception;


    int getRowNumber() throws Exception;

    int getRowNumberReturn() throws Exception;

    IssuedBookDTO findIssuedReturns(String id) throws Exception;

    List<CustomDTO> showBorrowed() throws Exception;

    boolean updateAvailableBook(BookDTO dto) throws Exception;

    BookDTO checkAvailableQuantity(String bookId) throws Exception;

    List<CustomDTO> showReturnBookList() throws Exception;
}
