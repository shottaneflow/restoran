package org.example.kursovaya.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    private LocalDateTime date;
    private Integer guestCount;

    public Booking(UUID id, Client client, LocalDateTime date, Integer guestCount) {
        this.id = id;
        this.client = client;
        this.date = date;
        this.guestCount = guestCount;
    }

    public Booking() {
    }

    public UUID getId() {
        return this.id;
    }

    public Client getClient() {
        return this.client;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public Integer getGuestCount() {
        return this.guestCount;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setGuestCount(Integer guestCount) {
        this.guestCount = guestCount;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof Booking)) return false;
        final Booking other = (Booking) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$client = this.getClient();
        final Object other$client = other.getClient();
        if (this$client == null ? other$client != null : !this$client.equals(other$client)) return false;
        final Object this$date = this.getDate();
        final Object other$date = other.getDate();
        if (this$date == null ? other$date != null : !this$date.equals(other$date)) return false;
        final Object this$guestCount = this.getGuestCount();
        final Object other$guestCount = other.getGuestCount();
        if (this$guestCount == null ? other$guestCount != null : !this$guestCount.equals(other$guestCount))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Booking;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $client = this.getClient();
        result = result * PRIME + ($client == null ? 43 : $client.hashCode());
        final Object $date = this.getDate();
        result = result * PRIME + ($date == null ? 43 : $date.hashCode());
        final Object $guestCount = this.getGuestCount();
        result = result * PRIME + ($guestCount == null ? 43 : $guestCount.hashCode());
        return result;
    }

    public String toString() {
        return "Booking(id=" + this.getId() + ", client=" + this.getClient() + ", date=" + this.getDate() + ", guestCount=" + this.getGuestCount() + ")";
    }
}
