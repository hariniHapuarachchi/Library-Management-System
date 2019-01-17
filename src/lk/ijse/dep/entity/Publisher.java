package lk.ijse.dep.entity;

public class Publisher extends SuperEntity{

    private String pId;
    private String pName;

    public Publisher() {
    }

    public Publisher(String pId, String pName) {
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
