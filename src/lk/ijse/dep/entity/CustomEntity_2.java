package lk.ijse.dep.entity;

public class CustomEntity_2 extends SuperEntity {

    private String issueId;
    private String iBookId;
    private String iMemId;

    private String rId;
    private String exDate;
    private String returnDate;
    private String status;
    private String fine;


    private String bId;
    private String bName;
    private int copies;
    private int availableBooks;

    private String aId;
    private String aName;

    private String pId;
    private String pName;

    private String publishDate;

    public CustomEntity_2() {
    }

    public CustomEntity_2(String issueId, String iBookId, String iMemId, String rId, String exDate, String returnDate, String status, String fine, String bId, String bName, int copies, int availableBooks, String aId, String aName, String pId, String pName, String publishDate) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.rId = rId;
        this.exDate = exDate;
        this.returnDate = returnDate;
        this.status = status;
        this.fine = fine;
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.availableBooks = availableBooks;
        this.aId = aId;
        this.aName = aName;
        this.pId = pId;
        this.pName = pName;
        this.publishDate = publishDate;
    }

    public CustomEntity_2(String issueId, String rId, String iBookId, String bName, String iMemId, String exDate, String status, String returnDate) {
        this.issueId = issueId;
        this.rId = rId;
        this.iBookId = iBookId;
        this.bName = bName;
        this.iMemId = iMemId;
        this.exDate = exDate;
        this.status = status;
        this.returnDate=returnDate;
    }

//    public CustomEntity_2(String bId, String bName, String copies, String aId, String aName, String pId, String pName, String publishDate) {
//        this.bId = bId;
//        this.bName = bName;
//        this.copies = copies;
//        this.aId = aId;
//        this.aName = aName;
//        this.pId = pId;
//        this.pName = pName;
//        this.publishDate = publishDate;
//    }

    public CustomEntity_2(String bId, String bName, String aName, String pName, String publishDate, int copies,int availableBooks) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
        this.aName = aName;
        this.pName = pName;
        this.publishDate = publishDate;
        this.availableBooks=availableBooks;
    }

//    public CustomEntity_2(String bId, String string1, String string2, String string3, String string4, String string5, String string6) {
//        super();
//    }

    public String getbId() {
        return bId;
    }

    public void setbId(String bId) {
        this.bId = bId;
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

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
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

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
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

    public int getAvailableBooks() {
        return availableBooks;
    }

    public void setAvailableBooks(int availableBooks) {
        this.availableBooks = availableBooks;
    }
}
