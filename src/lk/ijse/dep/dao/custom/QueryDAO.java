package lk.ijse.dep.dao.custom;

import lk.ijse.dep.dao.SuperDAO;
import lk.ijse.dep.entity.CustomEntity;
import lk.ijse.dep.entity.CustomEntity_2;
import lk.ijse.dep.entity.CustomEntity_3;
import lk.ijse.dep.entity.CustomEntity_4;

import java.util.List;
import java.util.Optional;

public interface QueryDAO extends SuperDAO {

    Optional<List<CustomEntity_2>> displayBookAuthorAndPublisher() throws Exception;

    Optional<List<CustomEntity>> displayExpiredDateOfReturnedBook() throws Exception;

    Optional<List<CustomEntity>> displayAllIssuedDetailsWithExpiredDate() throws Exception;

    Optional<List<CustomEntity>> getReturnBookDetails(String returnID) throws Exception;

    Optional<List<CustomEntity_3>> showBorrowedBooks() throws Exception;

    Optional<List<CustomEntity_4>> showStatus() throws Exception;
}
