package lk.ijse.dep.view.util;

public class ReturnAndIssuedTM {

    private String id;
    private String bookId;
    private String memId;
    private String issueDate;
    private String returnId;

    private String expireDate;
    private String status;
    private double fine;
    private long dateDiff;
    private String bookName;
    private String returnDate;

    public ReturnAndIssuedTM() {
    }

    public ReturnAndIssuedTM(String id, String bookId, String memId, String issueDate, String returnId, String expireDate, String status, double fine, long dateDiff, String bookName) {
        this.id = id;
        this.bookId = bookId;
        this.memId = memId;
        this.issueDate = issueDate;
        this.returnId = returnId;
        this.expireDate = expireDate;
        this.status = status;
        this.fine = fine;
        this.dateDiff = dateDiff;
        this.bookName = bookName;
    }

//    public ReturnAndIssuedTM(String id, String bookId, String memId, String returnId, String expireDate) {
//        this.id = id;
//        this.bookId=bookId;
//        this.memId = memId;
//        this.returnId = returnId;
//        this.expireDate=expireDate;
//    }

    public ReturnAndIssuedTM(String id, String memId, String bookId, String expireDate,String returnId) {

        this.id = id;
        this.memId = memId;
        this.bookId=bookId;
        this.expireDate=expireDate;
        this.returnId=returnId;
    }

    public ReturnAndIssuedTM(String id, String returnId, String bookId, String memId, String issueDate, String returnDate) {
        this.id = id;
        this.returnId = returnId;
        this.bookId = bookId;
        this.memId = memId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public ReturnAndIssuedTM(long dateDiff,double fine) {
        this.dateDiff = dateDiff;
        this.fine = fine;
        
    }

    public ReturnAndIssuedTM(double fine, Long dateDiff) {

        this.fine=fine;
        this.dateDiff=dateDiff;
    }

    public ReturnAndIssuedTM(String id, String returnId, String bookId, String bookName, String memId, String expireDate, String status, Long dateDiff, double fine) {
        this.id = id;
        this.returnId = returnId;
        this.bookId = bookId;
        this.bookName = bookName;
        this.memId = memId;
        this.expireDate = expireDate;
        this.status = status;
        this.dateDiff=dateDiff;
        this.fine=fine;

    }

    public ReturnAndIssuedTM(String expireDate, String returnDate) {

        this.expireDate=expireDate;
        this.returnDate=returnDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemId() {
        return memId;
    }

    public void setMemId(String memId) {
        this.memId = memId;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public long getDateDiff() {
        return dateDiff;
    }

    public void setDateDiff(long dateDiff) {
        this.dateDiff = dateDiff;
    }


    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "ReturnAndIssuedTM{" +
                "id='" + id + '\'' +
                ", bookId='" + bookId + '\'' +
                ", memId='" + memId + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", returnId='" + returnId + '\'' +
                ", expireDate='" + expireDate + '\'' +
                ", status='" + status + '\'' +
                ", fine=" + fine +
                ", dateDiff=" + dateDiff +
                ", bookName='" + bookName + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
