package com.Sell_Store.demo.Controller;

import java.util.List;

import com.Sell_Store.demo.Entity.Comment;
import com.Sell_Store.demo.Services.CmtService;

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

@Controller
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "cmt")
public class CmtController {
    @Autowired
    private CmtService cmtService;
    @GetMapping("/get")
    public ResponseEntity<List<Comment>> getAllCmt(){
        List<Comment> cmts =cmtService.getAllCmt();
        return ResponseEntity.status(HttpStatus.OK).body(cmts);
    }
    @PostMapping("/add")
    public ResponseEntity<Comment> addCmt(@RequestBody Comment cmt){
        System.out.println(cmt.toString());
        Comment cmt2 = cmtService.addCmt(cmt);
        
        return ResponseEntity.status(HttpStatus.OK).body(cmt2);

    }
    @GetMapping("/get/{masp}")
    public ResponseEntity<List<Comment>> getAllCmtByMasp(@PathVariable(name = "masp")String masp){
        List<Comment> cmts =cmtService.getAllCmtBySp(masp);
        return ResponseEntity.status(HttpStatus.OK).body(cmts);
    }
    @GetMapping("/get/{madh}/{masp}")
    public ResponseEntity<Comment> getCmtByMadhAndMasp(@PathVariable(name = "madh")String madh,@PathVariable(name = "masp")String masp){
        Comment cmt =cmtService.getCmt(madh,masp);
        return ResponseEntity.status(HttpStatus.OK).body(cmt);
    }

}
