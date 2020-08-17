package com.siswa.nilai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siswa.nilai.model.NilaiEntity;

@Repository
public interface NilaiRepository
        extends JpaRepository<NilaiEntity, Long> {

}
