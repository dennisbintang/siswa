package com.siswa.nilai.web;

import java.util.List;

import com.siswa.nilai.model.NilaiEntity;
import com.siswa.nilai.service.NilaiService;
import com.siswa.nilai.service.NilaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.siswa.nilai.exception.RecordNotFoundException;

@RestController
@RequestMapping("/nilai")
public class NilaiController
{
    @Autowired
    NilaiService service;

    @GetMapping
    public ResponseEntity<List<NilaiEntity>> getAllNilai() {
        List<NilaiEntity> list = service.getAllNilai();

        return new ResponseEntity<List<NilaiEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NilaiEntity> getNilaiById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        NilaiEntity entity = service.getNilaiById(id);

        return new ResponseEntity<NilaiEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NilaiEntity> createOrUpdateNilai(NilaiEntity Nilai)
            throws RecordNotFoundException {
        NilaiEntity updated = service.createOrUpdateNilai(Nilai);
        return new ResponseEntity<NilaiEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteNilaiById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deleteNilaiById(id);
        return HttpStatus.FORBIDDEN;
    }

}