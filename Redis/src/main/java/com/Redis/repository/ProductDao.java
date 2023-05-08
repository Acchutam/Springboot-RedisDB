package com.Redis.repository;

import com.Redis.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ProductDao {

    @Autowired
    @Qualifier("redisTemplate")
    private RedisTemplate template;

    public static final String HASH_KEY = "Product";


    public Product create (Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> findAll( ){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product findById(int id){
        return (Product)template.opsForHash().get(HASH_KEY,id);
    }

    public String delete(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "Product deleted successfully";
    }

}
