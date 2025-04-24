package org.example.kursovaya.controller;


import org.example.kursovaya.model.Product;
import org.example.kursovaya.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-api")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/{menuId}/add")
    public ResponseEntity<?> addProductToMenu(
            @PathVariable UUID menuId,
            @RequestBody Product product) {
        productService.addProductToMenu(menuId, product);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{menuId}")
    public ResponseEntity<List<Product>> getProductsByMenu(
            @PathVariable UUID menuId) {
        List<Product> products = productService.getProductsByMenu(menuId);
        return ResponseEntity.ok(products);
    }

    @DeleteMapping("/{menuId}/{productName}")
    public ResponseEntity<?> removeProductFromMenu(
            @PathVariable UUID menuId,
            @PathVariable String productName) {
        productService.delete(productName);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{menuId}/{productName}")
    public ResponseEntity<?> updateProductInMenu(
            @PathVariable UUID menuId,
            @PathVariable String productName,
            @RequestBody Product product) {
        productService.updateProductInMenu(menuId, productName, product);
        return ResponseEntity.ok().build();
    }
}
