package lk.ijse.dep.view.util;

public class IssuedBookTM {

    private String issueId;
    private String iBookId;
    private String iMemId;
    private String issuedDate;
    private String returnId;

    public IssuedBookTM() {
    }

    public IssuedBookTM(String issueId, String iBookId, String iMemId, String issuedDate, String returnId) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issuedDate = issuedDate;
        this.returnId = returnId;
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

    public String getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId;
    }

    @Override
    public String toString() {
        return "IssuedBook{" +
                "issueId='" + issueId + '\'' +
                ", iBookId='" + iBookId + '\'' +
                ", iMemId='" + iMemId + '\'' +
                ", issuedDate='" + issuedDate + '\'' +
                ", returnId='" + returnId + '\'' +
                '}';
    }
}
