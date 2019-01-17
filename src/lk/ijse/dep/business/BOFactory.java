package lk.ijse.dep.business;

import lk.ijse.dep.business.custom.RegisterMemberBO;
import lk.ijse.dep.business.custom.impl.AddBookBOImpl;
import lk.ijse.dep.business.custom.impl.IssuedBookBOImpl;
import lk.ijse.dep.business.custom.impl.RegisterMemberBOImpl;

public class BOFactory {

    public enum BOTypes{
        MANAGE_BOOKS,MANAGE_MEMBERS,MANAGE_ISSUED
    }

    private static BOFactory boFactory;

    private BOFactory(){

    }

    public static BOFactory getInstance(){
        if (boFactory == null){
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public <T extends SuperBO> T getBO(BOTypes boType){
        switch (boType){
            case MANAGE_BOOKS:
                return (T) new AddBookBOImpl();
            case MANAGE_MEMBERS:
                return (T) new RegisterMemberBOImpl();
            case MANAGE_ISSUED:
                return (T) new IssuedBookBOImpl();
            default:
                return null;
        }
    }
}
