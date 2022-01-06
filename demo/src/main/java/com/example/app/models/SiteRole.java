package com.example.app.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;

@Entity
@Table(name="siterole")
public class SiteRole
{
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name="role_name")
    private String roleName;
    @ManyToMany(mappedBy="roles")
    private Set<SiteUser> users;
    
    public SiteRole() {}
    public SiteRole(Long id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    
    public void setId(Long id) { this.id = id; }
    public Long getId() { return this.id; }
    public void setRoleName(String roleName) { this.roleName = roleName; }
    public String getRoleName() { return this.roleName; }
    public void setUsers(Set<SiteUser> users) { this.users = users; }
    public Set<SiteUser> getUsers() { return this.users; }
    
}
