package org.example.kursovaya.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue
    private UUID id;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonIgnore
    private Client client;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Product> products;

    public Order(UUID id, LocalDateTime date, Client client, List<Product> products) {
        this.id = id;
        this.date = date;
        this.client = client;
        this.products = products;
    }

    public Order() {
    }

    public UUID getId() {
        return this.id;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Client getClient() {
        return this.client;
    }

    public List<Product> getOrderedProducts() {
        return this.products;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOrderedProducts(List<Product> products) {
        this.products = products;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Order)) return false;
        final Order other = (Order) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$client = this.getClient();
        final Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) return false;
        final Object this$orderedProducts = this.getOrderedProducts();
        final Object other$orderedProducts = other.getOrderedProducts();
        if (this$orderedProducts == null ? other$orderedProducts != null : !this$orderedProducts.equals(other$orderedProducts))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Order;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $client = this.getClient();
        result = result * PRIME + ($client == null ? 43 : $client.hashCode());
        final Object $orderedProducts = this.getOrderedProducts();
        result = result * PRIME + ($orderedProducts == null ? 43 : $orderedProducts.hashCode());
        return result;
    }

    public String toString() {
        return "Order(id=" + this.getId() + ", date=" + this.getDate() + ", client=" + this.getClient() + ", orderedProducts=" + this.getOrderedProducts() + ")";
    }
}
