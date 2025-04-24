package org.example.kursovaya.service;


import org.example.kursovaya.model.Menu;
import org.example.kursovaya.model.Product;
import org.example.kursovaya.repo.MenuRepo;
import org.example.kursovaya.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepo productRepo;
    private final MenuRepo menuRepo;

    public ProductService(ProductRepo productRepo,
                          MenuRepo menuRepo) {
        this.productRepo = productRepo;
        this.menuRepo = menuRepo;
    }

    public void addProductToMenu(UUID menuId, Product product) {
        Menu menu = menuRepo.findById(menuId).orElse(null);
        product.setMenu(menu);
        productRepo.save(product);
    }
    public List<Product> getProductsByMenu(UUID menuId) {
        return productRepo.findByMenuId(menuId);
    }
    public void removeProductFromMenu(UUID menuId, String productName) {
        Menu menu = menuRepo.findById(menuId).orElse(null);
        menu.getProducts().remove(productName);
        menuRepo.save(menu);

    }
    public void updateProductInMenu(UUID menuId,String productName ,Product product) {
        Menu menu = menuRepo.findById(menuId).orElse(null);
        product.setMenu(menu);
        productRepo.save(product);
    }
    public void delete(String productName) {
        this.productRepo.deleteById(productName);
    }

}
