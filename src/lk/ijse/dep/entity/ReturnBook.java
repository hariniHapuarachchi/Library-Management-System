package lk.ijse.dep.entity;

public class ReturnBook extends SuperEntity{

    private String rId;
    private String rDate;
    private double fine;
    private String exDate;
    private String status;

    public ReturnBook() {
    }

//    public ReturnBook(String rId, String rDate, double fine, String exDate, String status) {
//        this.rId = rId;
//        this.rDate = rDate;
//        this.fine = fine;
//        this.exDate = exDate;
//        this.status = status;
//    }

    public ReturnBook(String rId, String exDate) {
        this.rId = rId;
        this.exDate = exDate;
        System.out.println(exDate);
    }

    public ReturnBook(String rId, String exDate, String status) {
        this.rId = rId;
        this.exDate = exDate;
        this.status = status;
    }

    public ReturnBook(String rId, String exDate, String status, double fine, String rDate) {
        this.rId = rId;
        this.exDate = exDate;
        this.status = status;
        this.fine = fine;
        this.rDate = rDate;
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

    @Override
    public String toString() {
        return "ReturnBook{" +
                "rId='" + rId + '\'' +
                ", rDate='" + rDate + '\'' +
                ", fine=" + fine +
                ", exDate='" + exDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
