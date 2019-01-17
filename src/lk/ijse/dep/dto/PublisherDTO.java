package lk.ijse.dep.dto;

public class PublisherDTO extends SuperDTO {

    private String pId;
    private String pName;

    public PublisherDTO() {
    }

    public PublisherDTO(String pId, String pName) {
        this.pId = pId;
        this.pName = pName;
    }

    public PublisherDTO(String pName) {
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
