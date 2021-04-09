package com.assigment.hospital.entity;

import java.sql.Date;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "phieuxetnghiem", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class PhieuxetnghiemEntity {
    private long mapxn;
    private Integer ketqua;
    private String ghichu;
    private Date ngaychidinh;
    private Date ngaythuchien;
    private XetnghiemEntity xetnghiemByMaxn;
    private BenhnhanEntity benhnhanByMabn;

    @Id
    @Column(name = "mapxn", nullable = false)
    public long getMapxn() {
        return mapxn;
    }

    public void setMapxn(long mapxn) {
        this.mapxn = mapxn;
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
        PhieuxetnghiemEntity that = (PhieuxetnghiemEntity) o;
        return mapxn == that.mapxn && Objects.equals(ketqua, that.ketqua) && Objects.equals(ghichu, that.ghichu) && Objects.equals(ngaychidinh, that.ngaychidinh) && Objects.equals(ngaythuchien, that.ngaythuchien);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapxn, ketqua, ghichu, ngaychidinh, ngaythuchien);
    }

    @ManyToOne
    @JoinColumn(name = "maxn", referencedColumnName = "maxn", nullable = false)
    public XetnghiemEntity getXetnghiemByMaxn() {
        return xetnghiemByMaxn;
    }

    public void setXetnghiemByMaxn(XetnghiemEntity xetnghiemByMaxn) {
        this.xetnghiemByMaxn = xetnghiemByMaxn;
    }

    @ManyToOne
    @JoinColumn(name = "mabn", referencedColumnName = "mabn", nullable = false)
    public BenhnhanEntity getBenhnhanByMabn() {
        return benhnhanByMabn;
    }

    public void setBenhnhanByMabn(BenhnhanEntity benhnhanByMabn) {
        this.benhnhanByMabn = benhnhanByMabn;
    }
}
