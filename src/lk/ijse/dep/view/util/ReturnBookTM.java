package lk.ijse.dep.view.util;

public class ReturnBookTM {


    private String returnId;
    private String returnDate;
    private double fine;
    private String expireDate;
    private String status;
    private String bookID;
    private String memberID;

    public ReturnBookTM() {
    }

    public ReturnBookTM(String bookID, String memberID, String expireDate, String status) {

        this.bookID = bookID;
        this.memberID = memberID;
        this.expireDate = expireDate;
        this.status = status;

    }

    public ReturnBookTM(String returnId,String bookID, String memberID, String expireDate, String status) {
        this.returnId=returnId;
        this.bookID = bookID;
        this.memberID = memberID;
        this.expireDate = expireDate;
        this.status = status;

    }
    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }
}
