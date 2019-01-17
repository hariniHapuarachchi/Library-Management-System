package lk.ijse.dep.business;

import lk.ijse.dep.dto.*;
import lk.ijse.dep.entity.*;

import java.util.List;
import java.util.stream.Collectors;

public class Converter {

    public static <T extends SuperDTO> T getDTO(SuperEntity entity) {

        if (entity instanceof Author) {
            Author a = (Author) entity;
            return (T) new AuthorDTO(a.getaId(),a.getaName());

        } else if (entity instanceof Book) {
            Book b = (Book) entity;
            return (T) new BookDTO(b.getbId(),b.getbName(),b.getCopies());

        }else if (entity instanceof BookWithAuthor) {
            BookWithAuthor ba = (BookWithAuthor) entity;
            return (T) new BookWithAuthorDTO(ba.getBaId(),ba.getBookId(),ba.getAuthorId());

        } else if (entity instanceof BookWithPublisher) {
            BookWithPublisher bp = (BookWithPublisher) entity;
            return (T) new BookWithPublisherDTO(bp.getBpId(),bp.getpBookId(),bp.getPubId(),bp.getPublishDate());

        } else if (entity instanceof IssuedBook) {
            IssuedBook issuedBook = (IssuedBook) entity;
            return (T) new IssuedBookDTO(issuedBook.getIssueId(),issuedBook.getiBookId(),issuedBook.getiMemId(),issuedBook.getIssuedDate(),issuedBook.getReturnId());

        } else if (entity instanceof Member) {
            Member m = (Member) entity;
            return (T) new MemberDTO(m.getmId(),m.getmName(),m.getmAddress(),m.getMobile(),m.getNic(),m.getmType());

        } else if (entity instanceof Publisher) {
            Publisher p = (Publisher) entity;
            return (T) new PublisherDTO(p.getpId(),p.getpName());

        }else if (entity instanceof ReturnBook) {
            ReturnBook r = (ReturnBook) entity;
            return (T) new ReturnBookDTO(r.getrId(),r.getrDate(),r.getFine(),r.getExDate(),r.getStatus());

        }else if (entity instanceof CustomEntity) {
            CustomEntity c = (CustomEntity) entity;
            return (T) new CustomDTO(c.getIssueId(),c.getiMemId(),c.getiBookId(),c.getExDate(),c.getrId());

        }else if (entity instanceof CustomEntity_2) {
            CustomEntity_2 c = (CustomEntity_2) entity;
            return (T) new CustomDTO(c.getbId(),c.getbName(),c.getaName(),c.getpName(),c.getPublishDate(),c.getCopies(),c.getAvailableBooks());

        }else if (entity instanceof CustomEntity_3) {
            CustomEntity_3 c1 = (CustomEntity_3) entity;
            return (T) new CustomDTO(c1.getIssueId(),c1.getrId(),c1.getiBookId(),c1.getbName(),c1.getiMemId(),c1.getExDate(),c1.getStatus(),c1.getIssuedDate(),c1.getCopies(),c1.getAvailableBooks());

        }else if (entity instanceof CustomEntity_4) {
            CustomEntity_4 c1 = (CustomEntity_4) entity;
            return (T) new CustomDTO(c1.getIssueId(),c1.getrId(),c1.getiBookId(),c1.getiMemId(),c1.getIssueDate(),c1.getReturnDate());

        }  else {
            throw new RuntimeException("This entity can't be converted to a DTO");
        }
    }

    public static <T extends SuperEntity> T getEntity(SuperDTO dto) {

        if (dto instanceof AuthorDTO) {
            AuthorDTO a = (AuthorDTO) dto;
            return (T) new Author(a.getaId(),a.getaName());

        } else if (dto instanceof BookDTO) {
            BookDTO b = (BookDTO) dto;
            return (T) new Book(b.getbId(),b.getbName(),b.getCopies(),b.getAvailableBooks());

        } else if (dto instanceof BookWithAuthorDTO) {
            BookWithAuthorDTO ba = (BookWithAuthorDTO) dto;
            return (T) new BookWithAuthor(ba.getBaId(),ba.getBookId(),ba.getAuthorId());

        } else if (dto instanceof BookWithPublisherDTO) {
            BookWithPublisherDTO bp = (BookWithPublisherDTO) dto;
            return (T) new BookWithPublisher(bp.getBpId(),bp.getpBookId(),bp.getPubId(),bp.getPublishDate());

        } else if (dto instanceof IssuedBookDTO) {
            IssuedBookDTO issuedBookDTO = (IssuedBookDTO) dto;
            return (T) new IssuedBook(issuedBookDTO.getIssueId(),issuedBookDTO.getiBookId(),issuedBookDTO.getiMemId(),issuedBookDTO.getIssuedDate(),
                    issuedBookDTO.getReturnId());

        } else if (dto instanceof MemberDTO) {
            MemberDTO m = (MemberDTO) dto;
            return (T) new Member(m.getmId(),m.getmName(),m.getmAddress(),m.getMobile(),m.getNic(),m.getmType());

        } else if (dto instanceof PublisherDTO) {
            PublisherDTO p = (PublisherDTO) dto;
            return (T) new Publisher(p.getpId(),p.getpName());

        } else if (dto instanceof ReturnBookDTO) {
            ReturnBookDTO r = (ReturnBookDTO) dto;
            return (T) new ReturnBook(r.getrId(),r.getExDate(),r.getStatus(),r.getFine(),r.getrDate());

        } else {
            throw new RuntimeException("This DTO can't be converted to an entity");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<? extends SuperEntity> entities) {
        return entities.stream().map(Converter::<T>getDTO).collect(Collectors.toList());
    }

    public static <T extends SuperEntity> List<T> getEntityList(List<? extends SuperDTO> dtos) {
        return dtos.stream().map(Converter::<T>getEntity).collect(Collectors.toList());

    }

    // =========================================================================

    public static <T extends SuperDTO> T getDTO(CustomEntity entity, Class<T> dtoClass) {
        if (dtoClass == IssuedBookDTO.class) {
            return (T) new IssuedBookDTO(entity.getIssueId(),entity.getiBookId(),entity.getiMemId());

        } else if (dtoClass == ReturnBookDTO.class) {
            return (T) new ReturnBookDTO(entity.getrId(),entity.getExDate());

        }else if (dtoClass == BookDTO.class) {
            return (T) new BookDTO(entity.getbId(),entity.getbName(),entity.getCopies());

        }else if (dtoClass == AuthorDTO.class) {
            return (T) new AuthorDTO(entity.getaName());

        } else if (dtoClass == PublisherDTO.class) {
            return (T) new PublisherDTO(entity.getpName());

        }else if (dtoClass == BookWithPublisherDTO.class) {
            return (T) new BookWithPublisherDTO(entity.getPublishDate());

        }else if (dtoClass == CustomDTO.class) {
            return (T) new CustomDTO(entity.getIssueId(),entity.getiBookId(),entity.getiMemId(),entity.getStatus(),entity.getrId());

        }else {
            throw new RuntimeException("Not Supported DTO");
        }
    }

    public static <T extends SuperDTO> List<T> getDTOList(List<CustomEntity> list, Class<T> dtoClass) {
        return list.stream().map(c -> getDTO(c, dtoClass)).collect(Collectors.toList());
    }

}
