package lk.ijse.dep.dao;

import lk.ijse.dep.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    public enum DAOTypes{
        AUTHOR,BOOK,BOOK_WITH_AUTHOR,BOOK_WITH_PUBLISHER,ISSUED_BOOK,MEMBER,PUBLISHER,RETURN_BOOK,QUERY;
    }

    private DAOFactory() {

    }

    public static DAOFactory getInstance() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public <T extends SuperDAO> T getDAO(DAOTypes daoType) {
        switch (daoType) {
            case AUTHOR:
                return (T) new AuthorDAOImpl();
            case BOOK:
                return (T) new BookDAOImpl();
            case BOOK_WITH_AUTHOR:
                return (T) new BookWithAuthorDAOImpl();
            case BOOK_WITH_PUBLISHER:
                return (T) new BookWithPublisherDAOImpl();
            case ISSUED_BOOK:
                return (T) new IssuedBookDAOImpl();
            case MEMBER:
                return (T) new MemberDAOImpl();
            case PUBLISHER:
                return (T) new PublisherDAOImpl();
            case RETURN_BOOK:
                return (T) new ReturnBookDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            default:
                return null;
        }
    }

}
