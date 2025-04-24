package org.example.kursovaya.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String username;
    private String password;

    private String clientName;
    private String phone;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "t_user_authority",
            joinColumns = @JoinColumn(name = "id_user"),
            inverseJoinColumns = @JoinColumn(name = "id_authority"))
    private List<Authority> authorities;

    public Client() {
        this.authorities = new ArrayList<>();
    }

    public Client(UUID id, String username, String password, String clientName, String phone, List<Booking> bookings, List<Order> orders, List<Authority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.clientName = clientName;
        this.phone = phone;
        this.bookings = bookings;
        this.orders = orders;
        this.authorities = authorities;
    }

    public void addAuthorities(Authority authority) {
        this.authorities.add(authority);
    }

    public List<Authority> getAuthorities() {
        return this.authorities;
    }

    public UUID getId() {
        return this.id;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getPhone() {
        return this.phone;
    }

    public List<Booking> getBookings() {
        return this.bookings;
    }

    public List<Order> getOrders() {
        return this.orders;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Client)) return false;
        final Client other = (Client) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$password = this.getPassword();
        final Object other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) return false;
        final Object this$clientName = this.getClientName();
        final Object other$clientName = other.getClientName();
        if (this$clientName == null ? other$clientName != null : !this$clientName.equals(other$clientName))
            return false;
        final Object this$phone = this.getPhone();
        final Object other$phone = other.getPhone();
        if (this$phone == null ? other$phone != null : !this$phone.equals(other$phone)) return false;
        final Object this$bookings = this.getBookings();
        final Object other$bookings = other.getBookings();
        if (this$bookings == null ? other$bookings != null : !this$bookings.equals(other$bookings)) return false;
        final Object this$orders = this.getOrders();
        final Object other$orders = other.getOrders();
        if (this$orders == null ? other$orders != null : !this$orders.equals(other$orders)) return false;
        final Object this$authorities = this.getAuthorities();
        final Object other$authorities = other.getAuthorities();
        if (this$authorities == null ? other$authorities != null : !this$authorities.equals(other$authorities))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Client;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $password = this.getPassword();
        result = result * PRIME + ($password == null ? 43 : $password.hashCode());
        final Object $clientName = this.getClientName();
        result = result * PRIME + ($clientName == null ? 43 : $clientName.hashCode());
        final Object $phone = this.getPhone();
        result = result * PRIME + ($phone == null ? 43 : $phone.hashCode());
        final Object $bookings = this.getBookings();
        result = result * PRIME + ($bookings == null ? 43 : $bookings.hashCode());
        final Object $orders = this.getOrders();
        result = result * PRIME + ($orders == null ? 43 : $orders.hashCode());
        final Object $authorities = this.getAuthorities();
        result = result * PRIME + ($authorities == null ? 43 : $authorities.hashCode());
        return result;
    }

    public String toString() {
        return "Client(id=" + this.getId() + ", username=" + this.getUsername() + ", password=" + this.getPassword() + ", clientName=" + this.getClientName() + ", phone=" + this.getPhone() + ", bookings=" + this.getBookings() + ", orders=" + this.getOrders() + ", authorities=" + this.getAuthorities() + ")";
    }
}