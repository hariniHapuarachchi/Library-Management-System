package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.Converter;
import lk.ijse.dep.business.custom.AddBookBO;
import lk.ijse.dep.dao.DAOFactory;
import lk.ijse.dep.dao.custom.*;
import lk.ijse.dep.db.DBConnection;
import lk.ijse.dep.dto.*;
import lk.ijse.dep.entity.*;

import java.util.List;

public class AddBookBOImpl implements AddBookBO {

    private BookDAO bookDAO;
    private AuthorDAO authorDAO;
    private PublisherDAO publisherDAO;
    private BookWithAuthorDAO bookWithAuthorDAO;
    private BookWithPublisherDAO bookWithPublisherDAO;
    private QueryDAO queryDAO;

    private int k =1;
    public AddBookBOImpl() {

        bookDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK);
        authorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.AUTHOR);
        publisherDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.PUBLISHER);
        bookWithAuthorDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK_WITH_AUTHOR);
        bookWithPublisherDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOK_WITH_PUBLISHER);
        queryDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.QUERY);
    }

    @Override
    public List<CustomDTO> getBooks() throws Exception {

        return queryDAO.displayBookAuthorAndPublisher().map(Converter::<CustomDTO>getDTOList).get();
    }

    @Override
    public void addBook(BookDTO dto) throws Exception {


        DBConnection.getConnection().setAutoCommit(false);

        try {


            boolean result = bookDAO.save(new Book(dto.getbId(), dto.getbName(),dto.getCopies(),dto.getAvailableBooks()));
//                    orderDAO.save(new Order(dto.getId(), Date.valueOf(dto.getDate()), dto.getCustomerId()));

            if (!result) {
                return;
            }


            AuthorDTO at = findAuthor(dto.getAuthorDTOS().getaName());

            System.out.println(at);
            if (at == null){

                System.out.println("HIIIIII");
                result = authorDAO.save(new Author(dto.getAuthorDTOS().getaId(), dto.getAuthorDTOS().getaName()));

                if (!result) {
                    return;
                }
                result=bookWithAuthorDAO.save(new BookWithAuthor(dto.getBookWithAuthorDTOS().getBaId(), dto.getBookWithAuthorDTOS().getBookId(), dto.getBookWithAuthorDTOS().getAuthorId()));


            }

            if (at !=null && at.getaName().equals(dto.getAuthorDTOS().getaName())) {

                result = bookWithAuthorDAO.save(new BookWithAuthor(dto.getBookWithAuthorDTOS().getBaId(), dto.getBookWithAuthorDTOS().getBookId(), at.getaId()));


            }

            if (!result) {
                return;
            }

            PublisherDTO pt = findPublisher(dto.getPublisherDTOS().getpName());

            if (pt == null){

                result = publisherDAO.save(new Publisher(dto.getPublisherDTOS().getpId(), dto.getPublisherDTOS().getpName()));


                if (!result) {
                    return;
                }

                result=bookWithPublisherDAO.save(new BookWithPublisher(dto.getBookWithPublisherDTOS().getBpId(), dto.getBookWithPublisherDTOS().getpBookId(), dto.getBookWithPublisherDTOS().getPubId(),
                        dto.getBookWithPublisherDTOS().getPublishDate()));


            }

            if (pt != null && pt.getpName().equals(dto.getPublisherDTOS().getpName())) {

                result = bookWithPublisherDAO.save(new BookWithPublisher(dto.getBookWithPublisherDTOS().getBpId(), dto.getBookWithPublisherDTOS().getpBookId(),pt.getpId(),
                        dto.getBookWithPublisherDTOS().getPublishDate()));
                

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
    public boolean updateBook(BookDTO dto) throws Exception {
        return bookDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteBook(String bookID) throws Exception {
        return bookDAO.delete(bookID);
    }

    @Override
    public BookDTO findBook(String id) throws Exception {
        return bookDAO.find(id).map(Converter::<BookDTO>getDTO).orElse(null);
    }

    @Override
    public List<AuthorDTO> getAuthor() throws Exception {
        return authorDAO.findAll().map(Converter::<AuthorDTO>getDTOList).get();
    }

//    @Override
//    public boolean addAuthor(AuthorDTO dto) throws Exception {
//        return authorDAO.save(Converter.getEntity(dto));
//    }

    public String generateAuthorId() throws Exception {
        return authorDAO.count() + 1 + "";
    }

    @Override
    public boolean updateAuthor(AuthorDTO dto) throws Exception {
        return authorDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteAuthor(String authorId) throws Exception {
        return authorDAO.delete(authorId);
    }

    @Override
    public AuthorDTO findAuthor(String id) throws Exception {
        return authorDAO.find(id).map(Converter::<AuthorDTO>getDTO).orElse(null);
    }

    @Override
    public List<PublisherDTO> getPublisher() throws Exception {
        return publisherDAO.findAll().map(Converter::<PublisherDTO>getDTOList).get();
    }

//    @Override
//    public boolean addPublisher(PublisherDTO dto) throws Exception {
//        return publisherDAO.save(Converter.getEntity(dto));
//    }

    public String generatePublisherId() throws Exception {
        return publisherDAO.count() + 1 + "";
    }
    @Override
    public boolean updatePublisher(PublisherDTO dto) throws Exception {
        return publisherDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deletePublisher(String pId) throws Exception {
        return publisherDAO.delete(pId);
    }

    @Override
    public PublisherDTO findPublisher(String id) throws Exception {
        return publisherDAO.find(id).map(Converter::<PublisherDTO>getDTO).orElse(null);
    }

    @Override
    public List<BookWithPublisherDTO> getBook_Pub() throws Exception {
        return bookWithPublisherDAO.findAll().map(Converter::<BookWithPublisherDTO>getDTOList).get();
    }

    @Override
    public boolean deleteBookPub(String bpID) throws Exception {
        return bookWithPublisherDAO.delete(bpID);
    }

    @Override
    public boolean deleteBookAuthor(String baID) throws Exception {
        return bookWithAuthorDAO.delete(baID);
    }

    @Override
    public boolean updateBookAuthor(BookWithAuthorDTO dto) throws Exception {
        return bookWithAuthorDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean updateBookPub(BookWithPublisherDTO dto) throws Exception {
        return bookWithPublisherDAO.update(Converter.getEntity(dto));
    }

    @Override
    public BookWithPublisherDTO findBookPub(String id) throws Exception {
        return bookWithPublisherDAO.find(id).map(Converter::<BookWithPublisherDTO>getDTO).orElse(null);
    }

    @Override
    public BookWithAuthorDTO findBookAuthor(String id) throws Exception {
        return bookWithAuthorDAO.find(id).map(Converter::<BookWithAuthorDTO>getDTO).orElse(null);
    }

    @Override
    public String generatePublisherBookId() throws Exception {
        return bookWithPublisherDAO.count() + 1 + "";
    }

    @Override
    public BookWithPublisherDTO findPublisherFromBook(String id) throws Exception {
        return bookWithPublisherDAO.findReturnDet(id).map(Converter::<BookWithPublisherDTO>getDTO).orElse(null);
    }

    @Override
    public String generateAuthorBookId() throws Exception {
        return bookWithAuthorDAO.count() + 1 + "";
    }

    @Override
    public BookWithAuthorDTO findAuthorFromBook(String id) throws Exception {
        return bookWithAuthorDAO.findReturnDet(id).map(Converter::<BookWithAuthorDTO>getDTO).orElse(null);
    }

    @Override
    public int getRowNumberBook() throws Exception {
        return 0;
    }

    @Override
    public int getRowNumberAuthor() throws Exception {
        return authorDAO.count();
    }

    @Override
    public int getRowNumberPublisher() throws Exception {
        return publisherDAO.count();
    }

    @Override
    public int getRowNumberBookAuthor() throws Exception {
        return bookWithAuthorDAO.count();
    }

    @Override
    public int getRowNumberBookPublisher() throws Exception {
        return bookWithPublisherDAO.count();
    }


}
