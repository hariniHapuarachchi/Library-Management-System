package lk.ijse.dep.dto;

public class MemberDTO extends SuperDTO {

    private String mId;
    private String mName;
    private String mAddress;
    private String mobile;
    private String nic;
    private String mType;

    public MemberDTO() {
    }

    public MemberDTO(String mId, String mName, String mAddress, String mobile, String nic, String mType) {
        this.mId = mId;
        this.mName = mName;
        this.mAddress = mAddress;
        this.mobile = mobile;
        this.nic = nic;
        this.mType = mType;
    }

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmAddress() {
        return mAddress;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mId='" + mId + '\'' +
                ", mName='" + mName + '\'' +
                ", mAddress='" + mAddress + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nic='" + nic + '\'' +
                ", mType='" + mType + '\'' +
                '}';
    }
}
