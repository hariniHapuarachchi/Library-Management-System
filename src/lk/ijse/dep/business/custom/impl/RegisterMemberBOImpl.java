package lk.ijse.dep.business.custom.impl;

import lk.ijse.dep.business.Converter;
import lk.ijse.dep.business.custom.RegisterMemberBO;
import lk.ijse.dep.dao.DAOFactory;
import lk.ijse.dep.dao.custom.MemberDAO;
import lk.ijse.dep.dto.MemberDTO;

import java.util.List;

public class RegisterMemberBOImpl implements RegisterMemberBO {

    private MemberDAO memberDAO;

    public RegisterMemberBOImpl() {
        memberDAO = DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.MEMBER);
    }

    @Override
    public List<MemberDTO> getMembers() throws Exception {
        return memberDAO.findAll().map(Converter::<MemberDTO>getDTOList).get();
    }

    @Override
    public boolean addMembers(MemberDTO dto) throws Exception {
        return memberDAO.save(Converter.getEntity(dto));
    }

    @Override
    public boolean updateMembers(MemberDTO dto) throws Exception {
        return memberDAO.update(Converter.getEntity(dto));
    }

    @Override
    public boolean deleteMembers(String memberID) throws Exception {
        return memberDAO.delete(memberID);
    }

    @Override
    public MemberDTO findMembers(String id) throws Exception {
        return memberDAO.find(id).map(Converter::<MemberDTO>getDTO).orElse(null);
    }
}
