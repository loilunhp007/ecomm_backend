package com.Sell_Store.demo.Controller;

import java.util.List;

import com.Sell_Store.demo.Entity.Transport;
import com.Sell_Store.demo.Services.TransportService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "transport")
public class TransportController {
    @Autowired
    private TransportService transportService;
    @GetMapping("/get")
    public ResponseEntity<List<Transport>> getAllTransport(){
        List<Transport> list= transportService.getAlltranSport();
        return ResponseEntity.status(HttpStatus.OK).body(list);
    } 
    @GetMapping("/get/{tid}")
    public ResponseEntity<Transport> getTransport(@PathVariable(name = "tid")int tid){
        Transport tranSport= transportService.findByTid(tid);
        return ResponseEntity.status(HttpStatus.OK).body(tranSport);
    } 
    @PostMapping("/add")
    public ResponseEntity<Transport> addTransport(@RequestBody Transport transport){
        Transport transport2= transportService.addTransport(transport);
        return ResponseEntity.status(HttpStatus.OK).body(transport2);
    }
    
}
