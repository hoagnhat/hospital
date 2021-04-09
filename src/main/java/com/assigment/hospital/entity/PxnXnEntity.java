package com.assigment.hospital.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pxn_xn", schema = "hospital")
@IdClass(PxnXnEntityPK.class)
public class PxnXnEntity {
    private long mapxn;
    private long maxn;
    private Integer ketqua;
    private String ghichu;
    private Date ngaychidinh;
    private Date ngaythuchien;
    private XetnghiemEntity xetnghiemByMaxn;
    private PhieuxetnghiemEntity phieuxetnghiemByMapxn;

    @Id
    @Column(name = "mapxn", nullable = false)
    public long getMapxn() {
        return mapxn;
    }

    public void setMapxn(long mapxn) {
        this.mapxn = mapxn;
    }

    @Id
    @Column(name = "maxn", nullable = false)
    public long getMaxn() {
        return maxn;
    }

    public void setMaxn(long maxn) {
        this.maxn = maxn;
    }

    @Basic
    @Column(name = "ketqua", nullable = true)
    public Integer getKetqua() {
        return ketqua;
    }

    public void setKetqua(Integer ketqua) {
        this.ketqua = ketqua;
    }

    @Basic
    @Column(name = "ghichu", nullable = true, length = 100)
    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    @Basic
    @Column(name = "ngaychidinh", nullable = true)
    public Date getNgaychidinh() {
        return ngaychidinh;
    }

    public void setNgaychidinh(Date ngaychidinh) {
        this.ngaychidinh = ngaychidinh;
    }

    @Basic
    @Column(name = "ngaythuchien", nullable = true)
    public Date getNgaythuchien() {
        return ngaythuchien;
    }
    
    public void setNgaythuchien(Date ngaythuchien) {
        this.ngaythuchien = ngaythuchien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PxnXnEntity that = (PxnXnEntity) o;
        return mapxn == that.mapxn && maxn == that.maxn && Objects.equals(ketqua, that.ketqua) && Objects.equals(ghichu, that.ghichu) && Objects.equals(ngaychidinh, that.ngaychidinh) && Objects.equals(ngaythuchien, that.ngaythuchien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapxn, maxn, ketqua, ghichu, ngaychidinh, ngaythuchien);
    }

    @ManyToOne
    @JoinColumn(name = "mapxn", referencedColumnName = "mapxn", nullable = false, insertable = false, updatable = false)
    public PhieuxetnghiemEntity getPhieuxetnghiemByMapxn() {
        return phieuxetnghiemByMapxn;
    }

    public void setPhieuxetnghiemByMapxn(PhieuxetnghiemEntity phieuxetnghiemByMapxn) {
        this.phieuxetnghiemByMapxn = phieuxetnghiemByMapxn;
    }

    @ManyToOne
    @JoinColumn(name = "maxn", referencedColumnName = "maxn", nullable = false, insertable = false, updatable = false)
    public XetnghiemEntity getXetnghiemByMaxn() {
        return xetnghiemByMaxn;
    }

    public void setXetnghiemByMaxn(XetnghiemEntity xetnghiemByMaxn) {
        this.xetnghiemByMaxn = xetnghiemByMaxn;
    }
}
