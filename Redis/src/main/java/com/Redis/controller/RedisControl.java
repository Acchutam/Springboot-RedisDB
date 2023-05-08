package com.Redis.controller;

import com.Redis.entity.Product;
import com.Redis.repository.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class RedisControl {

    @Autowired
    private ProductDao dao;

    @GetMapping()
    public List<Product> findAll(){
        return dao.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable int id){
        return dao.findById(id);
    }

    @PostMapping()
    public Product save(@RequestBody Product product){
        return dao.create(product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id){
        return dao.delete(id);
    }


}
