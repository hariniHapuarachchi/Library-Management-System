package lk.ijse.dep.entity;

public class BookWithPublisher extends SuperEntity {

    private String bpId;
    private String pBookId;
    private String pubId;
    private String publishDate;

    public BookWithPublisher() {
    }

    public BookWithPublisher(String bpId, String pBookId, String pubId, String publishDate) {
        this.bpId = bpId;
        this.pBookId = pBookId;
        this.pubId = pubId;
        this.publishDate = publishDate;
    }

    public BookWithPublisher(String pubId) {
        this.pubId = pubId;
    }

    public BookWithPublisher(String bpId, String pubId) {
        this.bpId = bpId;
        this.pubId = pubId;
    }

    public String getBpId() {
        return bpId;
    }

    public void setBpId(String bpId) {
        this.bpId = bpId;
    }

    public String getpBookId() {
        return pBookId;
    }

    public void setpBookId(String pBookId) {
        this.pBookId = pBookId;
    }

    public String getPubId() {
        return pubId;
    }

    public void setPubId(String pubId) {
        this.pubId = pubId;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    @Override
    public String toString() {
        return "BookWithPublisher{" +
                "bpId='" + bpId + '\'' +
                ", pBookId='" + pBookId + '\'' +
                ", pubId='" + pubId + '\'' +
                ", publishDate='" + publishDate + '\'' +
                '}';
    }
}
