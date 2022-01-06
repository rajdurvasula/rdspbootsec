package com.example.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
@Table(name="siteuser")
public class SiteUser
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="user_name")
    private String userName;
    @Column(name="password")
    private String password;
    @Transient
    private String passwordConfirm;
    @ManyToMany
    private Set<SiteRole> roles;
    
    public SiteUser() {}
    
    public SiteUser(Long id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }
    
    public void setId(Long id) { this.id = id; }
    public Long getId() { return this.id; }
    public void setUserName(String userName) { this.userName = userName; }
    public String getUserName() { return this.userName; }
    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return this.password; }
    public void setPasswordConfirm(String passwordConfirm) { this.passwordConfirm = passwordConfirm; }
    public String getPasswordConfirm() { return this.passwordConfirm; }
    public void setRoles(Set<SiteRole> roles) { this.roles = roles; }
    public Set<SiteRole> getRoles() { return this.roles; }
}