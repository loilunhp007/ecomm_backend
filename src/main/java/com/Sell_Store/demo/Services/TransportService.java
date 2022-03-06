package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.Transport;
import com.Sell_Store.demo.Repository.TransportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class TransportService {
    @Autowired TransportRepository transportRepository;

    public Transport addTransport(Transport tranSport){
        return transportRepository.save(tranSport);
    }
    public List<Transport> getAlltranSport(){
        return transportRepository.findAll();
    }
    public Transport findByTid(int tid){
        return transportRepository.findById(tid).get();
    }
}
