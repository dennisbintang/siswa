package com.siswa.nilai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.siswa.nilai.model.SiswaEntity;

@Repository
public interface SiswaRepository
        extends JpaRepository<SiswaEntity, Long> {

}
