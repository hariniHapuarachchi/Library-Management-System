package lk.ijse.dep.dto;

import java.util.ArrayList;
import java.util.List;

public class BookWithPublisherDTO extends SuperDTO {

    private String bpId;
    private String pBookId;
    private String pubId;
    private String publishDate;
    private List<PublisherDTO> publisherDTOS = new ArrayList<>();

    public BookWithPublisherDTO() {
    }

    public BookWithPublisherDTO(String bpId, String pBookId, String pubId, String publishDate) {
        this.bpId = bpId;
        this.pBookId = pBookId;
        this.pubId = pubId;
        this.publishDate = publishDate;
    }

    public BookWithPublisherDTO(String publishDate) {
        this.publishDate = publishDate;
    }

    public BookWithPublisherDTO(String publishDate, List<PublisherDTO> publisherDTOS) {
        this.publishDate = publishDate;
       this.publisherDTOS=publisherDTOS;

    }

    public BookWithPublisherDTO(String bpId, String pBookId, String pubId, String publishDate, List<PublisherDTO> publisherDTOS) {
        this.bpId = bpId;
        this.pBookId = pBookId;
        this.pubId = pubId;
        this.publishDate = publishDate;
        this.publisherDTOS = publisherDTOS;
    }

    public BookWithPublisherDTO(String bpId, String publishDate) {
        this.bpId = bpId;
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

    public List<PublisherDTO> getPublisherDTOS() {
        return publisherDTOS;
    }

    public void setPublisherDTOS(List<PublisherDTO> publisherDTOS) {
        this.publisherDTOS = publisherDTOS;
    }

    @Override
    public String toString() {
        return "BookWithPublisherDTO{" +
                "bpId='" + bpId + '\'' +
                ", pBookId='" + pBookId + '\'' +
                ", pubId='" + pubId + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", publisherDTOS=" + publisherDTOS +
                '}';
    }
}
