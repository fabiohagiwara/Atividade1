package com.example.projeto180106.controller;

import java.util.Collection;

import com.example.projeto180106.model.Product;
import com.example.projeto180106.service.prodService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * ProductController
 */
@Controller
public class ProductController {

    @Autowired
    private prodService ps;

    @RequestMapping("/produtosEmEstoque")
    public ModelAndView getAllProd()
    {
        ModelAndView mv = new ModelAndView("allProd");
        Collection<Product> prods = ps.getProd();
        mv.addObject("prods", prods);
        return mv;
    }

    @RequestMapping("/produto/{id}")
    public ModelAndView getProdID(
        @PathVariable("id") int id)
    {
        ModelAndView mv = new ModelAndView("prodById");
        Product prod = ps.getProd(id);
        mv.addObject("prod", prod);

        return mv;
    }

    @RequestMapping("/produtosValorAcima/{value}")
    public ModelAndView getProdAbove(
        @PathVariable("value") int value)
    {
        ModelAndView mv = new ModelAndView("prodAbove");
        Collection<Product> prods = ps.getProdAboveValue(value);
        mv.addObject("prods", prods);
        return mv;
    }

    @RequestMapping("/produtosValorAbaixo/{value}")
    public ModelAndView getProdBelow(
        @PathVariable("value") int value)
    {
        ModelAndView mv = new ModelAndView("allBelow");
        Collection<Product> prods = ps.getProdBelowValue(value);
        mv.addObject("prods", prods);
        return mv;
    }
}