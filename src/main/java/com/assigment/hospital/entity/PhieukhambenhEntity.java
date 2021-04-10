package com.assigment.hospital.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phieukhambenh", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class PhieukhambenhEntity {
    private Long id;
    private String chuandoan;
    private String ketluan;
    private String donthuoc;
    private Date ngaytaikham;
    private Boolean cantaikham;
    private BenhnhanEntity benhnhanByMabn;
    private NhanvienEntity nhanvienByManv;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "chuandoan", nullable = true, length = 255)
    public String getChuandoan() {
        return chuandoan;
    }

    public void setChuandoan(String chuandoan) {
        this.chuandoan = chuandoan;
    }

    @Basic
    @Column(name = "ketluan", nullable = true, length = 255)
    public String getKetluan() {
        return ketluan;
    }

    public void setKetluan(String ketluan) {
        this.ketluan = ketluan;
    }

    @Basic
    @Column(name = "donthuoc", nullable = true, length = 255)
    public String getDonthuoc() {
        return donthuoc;
    }

    public void setDonthuoc(String donthuoc) {
        this.donthuoc = donthuoc;
    }

    @Basic
    @Column(name = "ngaytaikham", nullable = true)
    public Date getNgaytaikham() {
        return ngaytaikham;
    }

    public void setNgaytaikham(Date ngaytaikham) {
        this.ngaytaikham = ngaytaikham;
    }

    @Basic
    @Column(name = "cantaikham", nullable = true)
    public Boolean getCantaikham() {
        return cantaikham;
    }

    public void setCantaikham(Boolean cantaikham) {
        this.cantaikham = cantaikham;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieukhambenhEntity that = (PhieukhambenhEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(chuandoan, that.chuandoan) && Objects.equals(ketluan, that.ketluan) && Objects.equals(donthuoc, that.donthuoc) && Objects.equals(ngaytaikham, that.ngaytaikham) && Objects.equals(cantaikham, that.cantaikham);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chuandoan, ketluan, donthuoc, ngaytaikham, cantaikham);
    }

    @ManyToOne
    @JoinColumn(name = "mabn", referencedColumnName = "mabn", nullable = false)
    public BenhnhanEntity getBenhnhanByMabn() {
        return benhnhanByMabn;
    }

    public void setBenhnhanByMabn(BenhnhanEntity benhnhanByMabn) {
        this.benhnhanByMabn = benhnhanByMabn;
    }

    @ManyToOne
    @JoinColumn(name = "manv", referencedColumnName = "manv", nullable = false)
    public NhanvienEntity getNhanvienByManv() {
        return nhanvienByManv;
    }

    public void setNhanvienByManv(NhanvienEntity nhanvienByManv) {
        this.nhanvienByManv = nhanvienByManv;
    }
    
}
