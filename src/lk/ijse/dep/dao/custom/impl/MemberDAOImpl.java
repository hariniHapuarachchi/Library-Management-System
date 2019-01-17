package lk.ijse.dep.dao.custom.impl;

import lk.ijse.dep.dao.CrudUtil;
import lk.ijse.dep.dao.custom.MemberDAO;
import lk.ijse.dep.entity.Author;
import lk.ijse.dep.entity.Member;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDAOImpl implements MemberDAO {
    @Override
    public Optional<Member> find(String key) throws Exception {
        ResultSet rst = CrudUtil.execute("SELECT * FROM Member WHERE mId=?", key);
        Member m = null;
        if (rst.next()) {
            m = new Member(rst.getString("mId"),
                    rst.getString("mName"),
                    rst.getString("mAddress"),
                    rst.getString("mobile"),
                    rst.getString("nic"),
                    rst.getString("mType"));
        }
        return Optional.ofNullable(m);
    }

    @Override
    public Optional<List<Member>> findAll() throws Exception {
        ArrayList<Member> members = new ArrayList<>();
        ResultSet rst = CrudUtil.<ResultSet>execute("SELECT * FROM Member");
        while (rst.next()) {
            String id = rst.getString(1);
            String name = rst.getString(2);
            String address = rst.getString(3);
            String mobile = rst.getString(4);
            String nic = rst.getString(5);
            String type = rst.getString(6);

            Member member = new Member(id, name,address,mobile,nic,type);
            members.add(member);
        }
        return Optional.ofNullable(members);
    }

    @Override
    public boolean save(Member entity) throws Exception {
        return CrudUtil.<Integer>execute("INSERT INTO Member VALUES (?,?,?,?,?,?)",
               entity.getmId(),entity.getmName(),entity.getmAddress(),entity.getMobile(),entity.getNic(),entity.getmType()) > 0;
    }

    @Override
    public boolean update(Member entity) throws Exception {
        return CrudUtil.<Integer>execute("UPDATE Member SET mName=?,mAddress=?,mobile=?,nic=?,mType=? WHERE mId=?",
                entity.getmName(),entity.getmAddress(),entity.getMobile(),entity.getNic(),entity.getmType(),entity.getmId()) > 0;
    }

    @Override
    public boolean delete(String key) throws Exception {
        return CrudUtil.<Integer>execute("DELETE FROM Member WHERE mId=?", key) > 0;
    }

    @Override
    public boolean saveSelected(Member entity) throws Exception {
        return false;
    }

    @Override
    public Optional<Member> findReturnDet(String key) throws Exception {
        return Optional.empty();
    }
}
