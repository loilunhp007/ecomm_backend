package com.Sell_Store.demo.Controller;

import com.Sell_Store.demo.Entity.TypeMember;
import com.Sell_Store.demo.Entity.UserDetail;
import com.Sell_Store.demo.Services.UserService;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.*;
@Controller
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path = "userdetail")
public class UserDetailController {
    @Autowired
    private UserService tvService;
    @GetMapping("/get")
    public ResponseEntity<?> getAllThanhVien(){
        List<UserDetail> lThanhVien=  tvService.getAllThanhVien();
        return ResponseEntity.status(HttpStatus.OK).body(lThanhVien);
    }
    @GetMapping("/get/type/{typeID}")
    public ResponseEntity<List<UserDetail>> getAllByTypeMember(@PathVariable(name = "typeID")long id){
        TypeMember typeMember = tvService.getTypeByID(id);
        List<UserDetail> lThanhVien=  tvService.getAllByTypeMember(typeMember);
        return ResponseEntity.status(HttpStatus.OK).body(lThanhVien);
    }
    @PostMapping({"/add"})
    public ResponseEntity<UserDetail> addThanhVien(@RequestBody UserDetail userDetail){
        try { 
            String matv = userDetail.getId();
            System.out.println(userDetail); 
              UserDetail existUser = tvService.getUserDetailById(matv);
              UserDetail _userDetail = null;
              if(existUser == null){
                _userDetail= tvService.save(userDetail); 
              }               
               return ResponseEntity.status(HttpStatus.OK).body(_userDetail);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<UserDetail>(userDetail, HttpStatus.EXPECTATION_FAILED);
        }

    }
    @GetMapping("/get/{id}")
    public ResponseEntity<UserDetail> getThanhVienByID(@PathVariable(name = "id")String id){
        UserDetail thanhvien = tvService.getUserDetailById(id);
        return ResponseEntity.status(HttpStatus.OK).body(thanhvien);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<UserDetail> updateThanhVienByID(@PathVariable(name = "id")String id, @RequestBody UserDetail userDetail ){
        UserDetail thanhvien = tvService.getUserDetailById(id);
        thanhvien.setPhone(userDetail.getPhone());
        thanhvien.setFirstname(userDetail.getFirstname());
        thanhvien.setLastname(userDetail.getLastname());
        thanhvien.setAddress(userDetail.getAddress());
        thanhvien.setGmail(userDetail.getGmail());
        thanhvien.setBirthday(userDetail.getBirthday());
        thanhvien.setState(userDetail.getState());
        thanhvien.setTypeMember(userDetail.getTypeMember());
        UserDetail tv2 = tvService.save(thanhvien);
        return ResponseEntity.status(HttpStatus.OK).body(tv2);
    }
    
    @GetMapping("/gettype")
    public ResponseEntity<List<TypeMember>> getAllType(){
        List<TypeMember> listType=  tvService.getAllType();
        return ResponseEntity.status(HttpStatus.OK).body(listType);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable(name = "id")String id){
        UserDetail u= this.tvService.getUserDetailById(id);
        
        String result =this.tvService.deleteUser(u);
        JSONObject obj = new JSONObject();
        if(result.equals(0)){
            obj.put("result", 0);
        }else{
            obj.put("result", 1);
        }
        return ResponseEntity.status(HttpStatus.OK).body(obj.toString());
    }   

    
}
