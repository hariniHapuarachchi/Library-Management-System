package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.*;

import java.util.List;

public interface AddBookBO extends SuperBO {

    List<CustomDTO> getBooks() throws Exception;

    void addBook(BookDTO dto) throws Exception;

    boolean updateBook(BookDTO dto) throws Exception;

    boolean deleteBook(String bookID) throws Exception;

    BookDTO findBook(String id) throws Exception;


    List<AuthorDTO> getAuthor() throws Exception;

    String generateAuthorId() throws Exception;

    boolean updateAuthor(AuthorDTO dto) throws Exception;

    boolean deleteAuthor(String authorId) throws Exception;

    AuthorDTO findAuthor(String id) throws Exception;



    List<PublisherDTO> getPublisher() throws Exception;

    String generatePublisherId() throws Exception;

    boolean updatePublisher(PublisherDTO dto) throws Exception;

    boolean deletePublisher(String pId) throws Exception;

    PublisherDTO findPublisher(String id) throws Exception;


    List<BookWithPublisherDTO> getBook_Pub() throws Exception;

    boolean deleteBookPub(String bpID) throws Exception;

    boolean updateBookPub(BookWithPublisherDTO dto) throws Exception;

    BookWithPublisherDTO findBookPub(String id) throws Exception;

    String generatePublisherBookId() throws Exception;

    BookWithPublisherDTO findPublisherFromBook(String id) throws Exception;



    boolean deleteBookAuthor(String baID) throws Exception;

    boolean updateBookAuthor(BookWithAuthorDTO dto) throws Exception;

    BookWithAuthorDTO findBookAuthor(String id) throws Exception;

    String generateAuthorBookId() throws Exception;

    BookWithAuthorDTO findAuthorFromBook(String id) throws Exception;


    int getRowNumberBook() throws Exception;

    int getRowNumberAuthor() throws Exception;

    int getRowNumberPublisher() throws Exception;

    int getRowNumberBookAuthor() throws Exception;

    int getRowNumberBookPublisher() throws Exception;
}
