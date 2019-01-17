package lk.ijse.dep.view.util;

public class AuthorTM {

    private String aId;
    private String aName;

    public AuthorTM() {
    }

    public AuthorTM(String aId, String aName) {
        this.aId = aId;
        this.aName = aName;
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    @Override
    public String toString() {
        return "Author{" +
                "aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                '}';
    }
}
