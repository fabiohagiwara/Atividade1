package com.example.projeto180106.repository;

import java.util.HashMap;

import com.example.projeto180106.model.Product;

import org.springframework.stereotype.Repository;

/**
 * ProductRpository
 */
@Repository
public class ProductRpository {

    public HashMap<Integer, Product> hm = new HashMap<Integer, Product>();

    public ProductRpository(){
        hm.put(1, new Product(1,"boné",70,10));
        hm.put(2, new Product(2,"camisa",80,100));
        hm.put(3, new Product(3,"chinelo",30,24));
        hm.put(4, new Product(4,"camiseta",40,120));
        hm.put(5, new Product(5,"cueca",20,60));
        hm.put(6, new Product(6,"tenis",220,5));
        hm.put(7, new Product(7,"sapato",300,15));
        hm.put(8, new Product(8,"shorts",30,95));
        hm.put(9, new Product(9,"meia",10,50));
        hm.put(10, new Product(10,"jaqueta",130,20));

    }

    public Product getProductById(int id){
        return hm.get(id);
    }
    
    public HashMap <Integer,Product> getProduct(){
        return hm;
    }
}