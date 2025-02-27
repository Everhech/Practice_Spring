package dev.edwin.pruebas.controller;

import dev.edwin.pruebas.model.Product;
import dev.edwin.pruebas.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/get")
    public List<Product> getProducts(){
        return productService.getProducts();
    }
}
