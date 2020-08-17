package com.siswa.nilai.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="TBL_NILAI")
public class NilaiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nomor_induk")
    private String nomorinduk;

    @Column(name="mata_pelajaran")
    private String matapelajaran;

    @Column(name="nilai")
    private String nilai;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomorinduk() {
        return nomorinduk;
    }

    public void setNomorinduk(String nomorinduk) {
        this.nomorinduk = nomorinduk;
    }

    public String getMatapelajaran() {
        return matapelajaran;
    }

    public void setMatapelajaran(String matapelajaran) {
        this.matapelajaran = matapelajaran;
    }

    public String getNilai() {
        return nilai;
    }

    public void setNilai(String nilai) {
        this.nilai = nilai;
    }


}