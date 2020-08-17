package com.siswa.nilai.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.siswa.nilai.model.NilaiEntity;
import com.siswa.nilai.model.SiswaEntity;
import com.siswa.nilai.repository.NilaiRepository;
import com.siswa.nilai.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siswa.nilai.exception.RecordNotFoundException;

@Service
public class NilaiService {

    @Autowired
    NilaiRepository repository;

    public List<NilaiEntity> getAllNilai()
    {
        List<NilaiEntity> nilaiList = repository.findAll();

        if(nilaiList.size() > 0) {
            return nilaiList;
        } else {
            return new ArrayList<NilaiEntity>();
        }
    }

    public NilaiEntity getNilaiById(Long id) throws RecordNotFoundException
    {
        Optional<NilaiEntity> nilai = repository.findById(id);

        if(nilai.isPresent()) {
            return nilai.get();
        } else {
            throw new RecordNotFoundException("No nilai record exist for given id");
        }
    }

    public NilaiEntity createOrUpdateNilai(NilaiEntity entity) throws RecordNotFoundException
    {
        long nol = 0;
        if(entity.getId() == null){
            entity.setId(nol);
        }

        Optional<NilaiEntity> nilai = repository.findById(entity.getId());

        if(nilai.isPresent())
        {
            NilaiEntity newEntity = nilai.get();
            newEntity.setMatapelajaran(entity.getMatapelajaran());
            newEntity.setNomorinduk(entity.getNomorinduk());
            newEntity.setNilai(entity.getNilai());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public void deleteNilaiById(Long id) throws RecordNotFoundException
    {
        Optional<NilaiEntity> nilai = repository.findById(id);

        if(nilai.isPresent())
        {
            repository.deleteById(id);
        } else {
            throw new RecordNotFoundException("No nilai record exist for given id");
        }
    }
}