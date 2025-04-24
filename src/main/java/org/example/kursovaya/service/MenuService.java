package org.example.kursovaya.service;

import org.example.kursovaya.model.Menu;
import org.example.kursovaya.repo.MenuRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuService {

    private final MenuRepo menuRepo;
    public MenuService(MenuRepo menuRepo) {
        this.menuRepo = menuRepo;
    }
    public void create(Menu menu) {
        menuRepo.save(menu);
    }
    public List<Menu> getAll(){
        return menuRepo.findAll();

    }
    public Menu getById(UUID id) {
        return menuRepo.findById(id).orElse(null);
    }
    public void delete(UUID id) {
        menuRepo.deleteById(id);

    }
}
