package lk.ijse.dep.dto;

import java.util.List;

public class IssuedBookDTO extends SuperDTO {

    private String issueId;
    private String iBookId;
    private String iMemId;
    private String issuedDate;
    private String returnId;

    private List<ReturnBookDTO> returnBookDTOS;

    private ReturnBookDTO returnBookDTO1;

    public IssuedBookDTO() {
    }

    public IssuedBookDTO(String issueId, String iBookId, String iMemId, String issuedDate, String returnId) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issuedDate = issuedDate;
        this.returnId = returnId;
    }

    public IssuedBookDTO(String issueId, String iBookId, String iMemId) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
    }

    public IssuedBookDTO(String issueId, String iBookId, String iMemId, String issuedDate, String returnId, List<ReturnBookDTO> returnBookDTOS, ReturnBookDTO returnBookDTO1) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issuedDate = issuedDate;
        this.returnId = returnId;
        this.returnBookDTOS = returnBookDTOS;
        this.returnBookDTO1 = returnBookDTO1;
    }

    public IssuedBookDTO(String issueId, String iBookId, String iMemId, String issuedDate, String returnId,ReturnBookDTO returnBookDTO1) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issuedDate = issuedDate;
        this.returnId = returnId;
        this.returnBookDTO1 = returnBookDTO1;
    }


    public IssuedBookDTO(String issueId, String iBookId, String iMemId, String issuedDate, String returnId, List<ReturnBookDTO> returnBookDTOS) {
        this.issueId = issueId;
        this.iBookId = iBookId;
        this.iMemId = iMemId;
        this.issuedDate = issuedDate;
        this.returnId = returnId;
        this.returnBookDTOS=returnBookDTOS;
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

    public List<ReturnBookDTO> getReturnBookDTOS() {
        return returnBookDTOS;
    }

    public void setReturnBookDTOS(List<ReturnBookDTO> returnBookDTOS) {
        this.returnBookDTOS = returnBookDTOS;
    }

    public ReturnBookDTO getReturnBookDTO1() {
        return returnBookDTO1;
    }

    public void setReturnBookDTO1(ReturnBookDTO returnBookDTO1) {
        this.returnBookDTO1 = returnBookDTO1;
    }
}
