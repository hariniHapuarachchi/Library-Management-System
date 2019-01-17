package lk.ijse.dep.entity;

public class CustomEntity_3 extends SuperEntity {

    private String issueId;
    private String iBookId;
    private String iMemId;

    private String rId;
    private String exDate;
    private String issuedDate;
    private String status;
    private String fine;


    private String bName;
    private int copies;
    private int availableBooks;

    public CustomEntity_3() {
    }

    public CustomEntity_3(String issueId, String iBookId, String iMemId, String rId, String exDate, String issuedDate, String status, String fine, String bName) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.rId = rId;
        this.exDate = exDate;
        this.issuedDate = issuedDate;
        this.status = status;
        this.fine = fine;
        this.bName = bName;
    }

    public CustomEntity_3(String issueId, String rId, String iBookId, String bName, String iMemId, String exDate, String status,String issuedDate,int copies,int availableBooks) {
        this.issueId = issueId;
        this.rId = rId;
        this.iBookId = iBookId;
        this.bName = bName;
        this.iMemId = iMemId;
        this.exDate = exDate;
        this.status = status;
        this.issuedDate=issuedDate;
        this.copies=copies;
        this.availableBooks=availableBooks;
    }
    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getiBookId() {
        return iBookId;
    }

    public void setiBookId(String iBookId) {
        this.iBookId = iBookId;
    }

    public String getiMemId() {
        return iMemId;
    }

    public void setiMemId(String iMemId) {
        this.iMemId = iMemId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getbName() {
        return bName;
    }

    public void setbName(String bName) {
        this.bName = bName;
    }


    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    @Override
    public String toString() {
        return "CustomEntity_3{" +
                "issueId='" + issueId + '\'' +
                ", iBookId='" + iBookId + '\'' +
                ", iMemId='" + iMemId + '\'' +
                ", rId='" + rId + '\'' +
                ", exDate='" + exDate + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", status='" + status + '\'' +
                ", fine='" + fine + '\'' +
                ", bName='" + bName + '\'' +
                ", copies=" + copies +
                ", availableBooks=" + availableBooks +
                '}';
    }
}
