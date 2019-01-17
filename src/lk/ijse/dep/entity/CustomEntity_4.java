package lk.ijse.dep.entity;

public class CustomEntity_4 extends SuperEntity {

    private String issueId;
    private String iBookId;
    private String iMemId;
    private String issueDate;

    private String rId;
    private String status;
    private String returnDate;

    public CustomEntity_4() {
    }

    public CustomEntity_4(String issueId, String iBookId, String iMemId, String issueDate, String rId, String status, String returnDate) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issueDate = issueDate;
        this.rId = rId;
        this.status = status;
        this.returnDate = returnDate;
    }

    public CustomEntity_4(String issueId, String iBookId, String iMemId, String status) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.status = status;
    }

    public CustomEntity_4(String issueId, String rId, String iBookId, String iMemId, String issueDate, String returnDate) {
        this.issueId = issueId;
        this.rId = rId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issueDate=issueDate;
        this.returnDate=returnDate;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "CustomEntity_4{" +
                "issueId='" + issueId + '\'' +
                ", iBookId='" + iBookId + '\'' +
                ", iMemId='" + iMemId + '\'' +
                ", issueDate='" + issueDate + '\'' +
                ", rId='" + rId + '\'' +
                ", status='" + status + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
