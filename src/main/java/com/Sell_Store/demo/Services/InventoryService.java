package com.Sell_Store.demo.Services;

import java.util.List;

import com.Sell_Store.demo.Entity.Inventory;
import com.Sell_Store.demo.Entity.InventoryID;
import com.Sell_Store.demo.Entity.Product;
import com.Sell_Store.demo.Entity.WareHouse;
import com.Sell_Store.demo.Repository.InventoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(rollbackFor = Exception.class)
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getAllInventories(){
        return inventoryRepository.findAll();
    }
    public Inventory getInventoryByID(InventoryID id){
        if(!inventoryRepository.findById(id).isEmpty())
        {return inventoryRepository.findById(id).get();
        }
        return null;
    }
    public Inventory addProductToInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }
    public Inventory getInventoryByProduct(Product product,WareHouse wareHouse){
        return inventoryRepository.findByProductAndWareHouse(product,wareHouse);
    }
    public int deteleProductByID(Product product){
        InventoryID id = new InventoryID();
        id.setProductID(product.getProductID()); 
        id.setWareid((long)1);
        Inventory inventory = inventoryRepository.findById(id).get();
        inventoryRepository.delete(inventory);
        if(!inventoryRepository.findById(id).isPresent()){
            return 1;
        }
        else return 0;
    }
   
}
