package lk.ijse.dep.view.util;

public class BookTM {

    private String bId;
    private String bName;
    private String copies;

    public BookTM() {
    }

    public BookTM(String bId, String bName, String copies) {
        this.bId = bId;
        this.bName = bName;
        this.copies = copies;
    }

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

    public String getCopies() {
        return copies;
    }

    public void setCopies(String copies) {
        this.copies = copies;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bId='" + bId + '\'' +
                ", bName='" + bName + '\'' +
                ", copies='" + copies + '\'' +
                '}';
    }
}
