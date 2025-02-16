package com.patrykharanczyk.resolutions.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    Set<Resolution> resolutions;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    Set<UserAuthority> userAuthorities = new HashSet<>();

    @Column(name="username", unique = true, nullable = false)
    String username;
    String password;
    Boolean enabled = true;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(User user) {
        this.id = user.id;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.resolutions = user.resolutions;
        this.userAuthorities = new HashSet<>(user.userAuthorities);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Resolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(Set<Resolution> resolutions) {
        this.resolutions = resolutions;
    }

    public Set<UserAuthority> getUserAuthorities() {
        return userAuthorities;
    }

    public void setUserAuthorities(Set<UserAuthority> userAuthorities) {
        this.userAuthorities = userAuthorities;
    }

    public void addAuthority(String userAuthority) {
        this.userAuthorities.add(new UserAuthority(this, userAuthority));
    }
}
