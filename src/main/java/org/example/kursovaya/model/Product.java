package org.example.kursovaya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Product {
    @Id
    private String productName;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    @JsonIgnore
    private Menu menu;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String description;

    private Integer price;

    public Product(String productName, Menu menu, String description) {
        this.productName = productName;
        this.menu = menu;
        this.description = description;
    }

    public Product() {
    }

    public String getProductName() {
        return this.productName;
    }

    public Menu getMenu() {
        return this.menu;
    }

    public String getDescription() {
        return this.description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Product)) return false;
        final Product other = (Product) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$productName = this.getProductName();
        final Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName))
            return false;
        final Object this$menu = this.getMenu();
        final Object other$menu = other.getMenu();
        if (this$menu == null ? other$menu != null : !this$menu.equals(other$menu)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Product;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        final Object $menu = this.getMenu();
        result = result * PRIME + ($menu == null ? 43 : $menu.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "Product(productName=" + this.getProductName() + ", menu=" + this.getMenu() + ", description=" + this.getDescription() + ")";
    }

    public Order getOrder() {
        return this.order;
    }

    public Integer getPrice() {
        return this.price;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}