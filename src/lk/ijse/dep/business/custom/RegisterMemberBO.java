package lk.ijse.dep.business.custom;

import lk.ijse.dep.business.SuperBO;
import lk.ijse.dep.dto.BookDTO;
import lk.ijse.dep.dto.MemberDTO;

import java.util.List;

public interface RegisterMemberBO extends SuperBO {

    List<MemberDTO> getMembers() throws Exception;

    boolean addMembers(MemberDTO dto) throws Exception;

    boolean updateMembers(MemberDTO dto) throws Exception;

    boolean deleteMembers(String memberID) throws Exception;

    MemberDTO findMembers(String id) throws Exception;
}
