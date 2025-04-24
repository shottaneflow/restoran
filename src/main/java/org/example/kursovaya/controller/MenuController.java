package org.example.kursovaya.controller;

import org.example.kursovaya.model.Menu;
import org.example.kursovaya.service.MenuService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/menu-api")
public class MenuController {

    private MenuService menuService;
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }
    @PostMapping("/create")
    public ResponseEntity<?> createMenu(@RequestBody Menu menu) {
        this.menuService.create(menu);
        return ResponseEntity.ok().build();
    }
    @GetMapping()
    public ResponseEntity<?> getAllMenus() {
        List<Menu> menuList=this.menuService.getAll();
        return ResponseEntity.ok().body(menuList);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getMenuById(@PathVariable UUID id) {
        Menu menu=this.menuService.getById(id);
        return ResponseEntity.ok().body(menu);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMenuById(@PathVariable UUID id) {
        this.menuService.delete(id);
        return ResponseEntity.ok().build();
    }
}
