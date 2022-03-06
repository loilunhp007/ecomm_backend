package com.Sell_Store.demo.Services;

import com.Sell_Store.demo.Entity.TypeMember;
import com.Sell_Store.demo.Entity.UserDetail;
import com.Sell_Store.demo.Repository.TypeMemberRepository;
import com.Sell_Store.demo.Repository.UserDetailRepository;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserService {
    @Autowired
    private UserDetailRepository tvRepository;
    @Autowired
    private TypeMemberRepository typeMemberRepository;
    public List<UserDetail> getAllThanhVien(){
        return tvRepository.findAll();
    }
    public UserDetail getUserDetailById(String matv){
        Optional<UserDetail> op = tvRepository.findById(matv);
        if( op.isEmpty()){
            return null;
        }
        return op.get();
    }
    public UserDetail save(UserDetail userDetail){
        return tvRepository.save(userDetail);
    }
    public void xoa (String id){
        tvRepository.deleteById(id);
    }
    public List<TypeMember> getAllType(){
        return typeMemberRepository.findAll();
    }
    public List<UserDetail> getAllByTypeMember(TypeMember typeMember){
        return tvRepository.findByTypeMember(typeMember);
    }
    public TypeMember getTypeByID(long id){
        return typeMemberRepository.findById(id).get();
    }
    public String deleteUser(UserDetail u){
         tvRepository.delete(u);
         if(tvRepository.findById(u.getId()).isPresent()){
                return 0+"";
         }else{
             return 1+"";
         }
    }
}
