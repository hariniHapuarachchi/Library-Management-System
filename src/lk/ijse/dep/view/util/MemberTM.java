package lk.ijse.dep.view.util;

public class MemberTM {

    private String id;
    private String name;
    private String address;
    private String mobile;
    private String nicCard;
    private String memType;

    public MemberTM() {
    }

    public MemberTM(String id, String name, String address, String mobile, String nicCard, String memType) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.mobile = mobile;
        this.nicCard = nicCard;
        this.memType = memType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNicCard() {
        return nicCard;
    }

    public void setNicCard(String nicCard) {
        this.nicCard = nicCard;
    }

    public String getMemType() {
        return memType;
    }

    public void setMemType(String memType) {
        this.memType = memType;
    }

    @Override
    public String toString() {
        return "MemberTM{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nicCard='" + nicCard + '\'' +
                ", memType='" + memType + '\'' +
                '}';
    }
}
