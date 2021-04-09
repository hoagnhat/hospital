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
@Table(name = "phieuxetnghiem", schema = "hospital")
@NoArgsConstructor
@AllArgsConstructor
public class PhieuxetnghiemEntity {
    private long mapxn;
    private BenhnhanEntity benhnhanByMabn;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapxn", nullable = false)
    public long getMapxn() {
        return mapxn;
    }

    public void setMapxn(long mapxn) {
        this.mapxn = mapxn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhieuxetnghiemEntity that = (PhieuxetnghiemEntity) o;
        return mapxn == that.mapxn;
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapxn);
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
