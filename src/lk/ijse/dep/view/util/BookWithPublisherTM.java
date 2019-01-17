package lk.ijse.dep.view.util;

public class BookWithPublisherTM {

    private String bpId;
    private String pBookId;
    private String pubId;
    private String publishDate;

    public BookWithPublisherTM() {
    }

    public BookWithPublisherTM(String bpId, String pBookId, String pubId, String publishDate) {
        this.bpId = bpId;
        this.pBookId = pBookId;
        this.pubId = pubId;
        this.publishDate = publishDate;
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
