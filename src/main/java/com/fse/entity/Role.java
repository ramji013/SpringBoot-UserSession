package com.fse.entity;

import javax.persistence.*;

@Entity
@Table(name ="users_roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id", updatable = false, nullable = false)
    private Long roleId;
    @Column(name = "user_id")
    private Long userId;
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}