package com.patrykharanczyk.resolutions.model;

import jakarta.persistence.*;

@Entity(name="authorities")
public class UserAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @ManyToOne
    @JoinColumn(name="username", referencedColumnName = "username")
    User user;

    String authority;

    public UserAuthority() {
    }

    public UserAuthority(User user, String authority) {
        this.user = user;
        this.authority = authority;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
