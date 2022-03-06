package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.WareHouse;
import com.Sell_Store.demo.Repository.WareHouseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class WareHouseService {
    @Autowired WareHouseRepository wareHouseRepository;
    public WareHouse addWareHouse(WareHouse wareHouse){
        return wareHouseRepository.save(wareHouse);
    }
    public List<WareHouse> getAllWareHouse(){
        return wareHouseRepository.findAll();
    }
    public WareHouse findByid(long id){
        return wareHouseRepository.findById(id).get();
    }
}
