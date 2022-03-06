package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity. Category;
import com.Sell_Store.demo.Repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private  CategoryRepository categoryRepository;
    public List< Category> getAllLoaiMay(){
        return  categoryRepository.findAll();
    }
    public List<Category> getAllByName(String name){
        return  categoryRepository.findByTenloaiContains(name);
    }
    public  Category addLoaiMay( Category loaiMay){
        return  categoryRepository.save(loaiMay);
    }
    public Category getByID(int id) throws Exception{
        return categoryRepository.findById(id).get();
    }
    public int deleteByID(Category cate){
        categoryRepository.delete(cate);
        System.out.println(categoryRepository.findById(cate.getCateID()).isEmpty());
        if(categoryRepository.findById(cate.getCateID()).isEmpty()){
            return 1;
        }
        else
        {
            return 0;
        }
        
    }
}
