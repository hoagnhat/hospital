package com.assigment.hospital.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "taikhoan", schema = "hospital")
public class TaikhoanEntity {
    private long id;
    private String username;
    private String password;
    private String role;
    private long manv;
    private NhanvienEntity nhanvienByManv;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "manv")
    public long getManv() {
        return manv;
    }

    public void setManv(long manv) {
        this.manv = manv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaikhoanEntity that = (TaikhoanEntity) o;
        return id == that.id && manv == that.manv && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(role, that.role);
    }

    @OneToOne
    public NhanvienEntity getNhanvienByManv() {
        return nhanvienByManv;
    }

    public void setNhanvienByManv(NhanvienEntity nhanvienByManv) {
        this.nhanvienByManv = nhanvienByManv;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, role, manv);
    }
}
