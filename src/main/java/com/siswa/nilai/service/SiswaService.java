package com.siswa.nilai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.siswa.nilai.model.SiswaEntity;
import com.siswa.nilai.repository.NilaiRepository;
import com.siswa.nilai.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siswa.nilai.exception.RecordNotFoundException;

@Service
public class SiswaService {

    @Autowired
    SiswaRepository repository;
    @Autowired
    NilaiRepository nilairepository;

    public List<SiswaEntity> getAllSiswa()
    {
        List<SiswaEntity> siswaList = repository.findAll();

        if(siswaList.size() > 0) {
            return siswaList;
        } else {
            return new ArrayList<SiswaEntity>();
        }
    }

    public SiswaEntity getSiswaById(Long id) throws RecordNotFoundException
    {
        Optional<SiswaEntity> siswa = repository.findById(id);

        if(siswa.isPresent()) {
            return siswa.get();
        } else {
            throw new RecordNotFoundException("No siswa record exist for given id");
        }
    }

    public SiswaEntity createOrUpdateSiswa(SiswaEntity entity) throws RecordNotFoundException
    {
        long nol = 0;
        if(entity.getId() == null){
            entity.setId(nol);
        }

        Optional<SiswaEntity> siswa = repository.findById(entity.getId());

        if(siswa.isPresent())
        {
            SiswaEntity newEntity = siswa.get();
            newEntity.setNama(entity.getNama());
            newEntity.setNomorinduk(entity.getNomorinduk());
            newEntity.setKelas(entity.getKelas());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deletesiswaById(Long id) throws RecordNotFoundException
    {
        Optional<SiswaEntity> siswa = repository.findById(id);

        if(siswa.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No siswa  record exist for given id");
        }
    }
}