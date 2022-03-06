package com.Sell_Store.demo.Repository;

import com.Sell_Store.demo.Entity.TypeMember;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeMemberRepository extends JpaRepository<TypeMember,Long>{
    
}
