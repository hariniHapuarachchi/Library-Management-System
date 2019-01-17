package lk.ijse.dep.dto;

import java.util.List;

public class ReturnBookDTO extends SuperDTO {


    private String rId;
    private String rDate;
    private double fine;
    private String exDate;
    private String status;

    private List<IssuedBookDTO> issuedBookDTOS;

    public ReturnBookDTO() {
    }

    public ReturnBookDTO(String rId, String rDate, double fine, String exDate, String status) {
        this.rId = rId;
        this.rDate = rDate;
        this.fine = fine;
        this.exDate = exDate;
        this.status = status;
    }

    public ReturnBookDTO(String rId, String exDate) {
        this.rId = rId;
        this.exDate = exDate;
        System.out.println(exDate);
        System.out.println(this.exDate);
    }

    public ReturnBookDTO(String rId,List<IssuedBookDTO> issuedBookDTOS,String exDate, String rDate, double fine, String status) {
        this.rId=rId;
        this.issuedBookDTOS=issuedBookDTOS;
        this.exDate = exDate;
        this.rDate = rDate;
        this.fine = fine;
        this.status = status;

    }

    public ReturnBookDTO(String status,double fine, String rDate,String rId) {

        this.status=status;
        this.fine=fine;
        this.rDate=rDate;
        this.rId=rId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    public String getrDate() {
        return rDate;
    }

    public void setrDate(String rDate) {
        this.rDate = rDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }

    public String getExDate() {
        return exDate;
    }

    public void setExDate(String exDate) {
        this.exDate = exDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public List<IssuedBookDTO> getIssuedBookDTOS() {
        return issuedBookDTOS;
    }

    public void setIssuedBookDTOS(List<IssuedBookDTO> issuedBookDTOS) {
        this.issuedBookDTOS = issuedBookDTOS;
    }
}
