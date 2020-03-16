package com.example.projeto180106.service;

import java.util.Collection;
import java.util.HashMap;

import com.example.projeto180106.model.Product;
import com.example.projeto180106.repository.ProductRpository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * prodService
 */
@Service
public class prodService {

    @Autowired
    private ProductRpository pr;

    public Product getProd(Integer id)
    {
        return pr.getProductById(id);
    }
    
    public Collection<Product> getProd()
    {
        
        HashMap<Integer, Product> aux = new HashMap<Integer, Product>();
        HashMap<Integer, Product> Stock = new HashMap<Integer, Product>();

        aux = pr.getProduct();
        for(Product p:aux.values())
        {
            if(p.getStock() > 0)
            Stock.put(p.getCode(),p);
        }
        return Stock.values();
    } 

    public Collection<Product> getProdAboveValue(double value)
    {
        HashMap<Integer,Product> aux = new HashMap<Integer,Product>();
        HashMap<Integer,Product> Price = new HashMap<Integer,Product>();

        aux = pr.getProduct();
        for(Product p:aux.values())
        {
            if(p.getPrice() >= value)
                Price.put(p.getCode(), p);
        }
        return Price.values();
    }

    public Collection<Product> getProdBelowValue(double value)
    {
        HashMap<Integer,Product> aux = new HashMap<Integer,Product>();
        HashMap<Integer,Product> Price = new HashMap<Integer,Product>();

        aux = pr.getProduct();
        for(Product p:aux.values())
        {
            if(p.getPrice()<value)
                Price.put(p.getCode(), p);
        }
        return Price.values();
    }
}