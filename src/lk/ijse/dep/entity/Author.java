package lk.ijse.dep.entity;

public class Author extends SuperEntity{

    private String aId;
    private String aName;

    public Author() {
    }

    public Author(String aId, String aName) {
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
