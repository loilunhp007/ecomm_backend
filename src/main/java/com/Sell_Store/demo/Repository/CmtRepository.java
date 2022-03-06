package com.Sell_Store.demo.Repository;

import java.util.List;

import com.Sell_Store.demo.Entity.CmtId;
import com.Sell_Store.demo.Entity.Comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CmtRepository extends JpaRepository<Comment,CmtId>{
    public List<Comment> findAllByOrderID(String masp);
    public Comment findByOrderIDAndProductID(String madh,String masp);
}
