package lk.ijse.dep.view.util;

public class PublisherTM {

    private String pId;
    private String pName;

    public PublisherTM() {
    }

    public PublisherTM(String pId, String pName) {
        this.pId = pId;
        this.pName = pName;
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

    @Override
    public String toString() {
        return "Publisher{" +
                "pId='" + pId + '\'' +
                ", pName='" + pName + '\'' +
                '}';
    }
}
