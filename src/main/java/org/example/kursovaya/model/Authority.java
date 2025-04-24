package org.example.kursovaya.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "authority_name")
    private String authority;

    public Integer getId() {
        return this.id;
    }

    public String getAuthority() {
        return this.authority;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
