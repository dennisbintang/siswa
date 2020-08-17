package com.siswa.nilai.model;
import com.siswa.nilai.service.NilaiService;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="TBL_SISWA")
public class SiswaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nomor_induk")
    private String nomorinduk;

    @Column(name="nama")
    private String nama;

    @Column(name="kelas")
    private String kelas;

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

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

}