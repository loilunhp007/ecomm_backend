package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.TypeMember;
import com.Sell_Store.demo.Entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetail, String> {
    public List<UserDetail> findByTypeMember(TypeMember typeMember);
}
