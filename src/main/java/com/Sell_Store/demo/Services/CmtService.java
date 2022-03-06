package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.CmtId;
import com.Sell_Store.demo.Entity.Comment;
import com.Sell_Store.demo.Repository.CmtRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Transactional(rollbackFor = Exception.class)
@Service
public class CmtService {
    @Autowired
    private CmtRepository cmtRepository;
    public List<Comment> getAllCmt(){
        return cmtRepository.findAll();
    }
    public Comment addCmt(Comment cmt){
        return cmtRepository.save(cmt);
    }
    public List<Comment> getAllCmtBySp(String orderID){
        return cmtRepository.findAllByOrderID(orderID);
    }
    public Comment getCmt(String orderID,String productID){
        return cmtRepository.findByOrderIDAndProductID(orderID, productID);
    }
}
