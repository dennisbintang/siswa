package com.siswa.nilai.web;

import java.util.List;

import com.siswa.nilai.model.SiswaEntity;
import com.siswa.nilai.service.SiswaService;
import io.swagger.models.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.siswa.nilai.exception.RecordNotFoundException;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/siswa")
public class SiswaController
{
    @Autowired
    SiswaService service;

    @GetMapping
    public ResponseEntity<List<SiswaEntity>> getAllSiswa() {
        List<SiswaEntity> list = service.getAllSiswa();

        return new ResponseEntity<List<SiswaEntity>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SiswaEntity> getSiswaById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        SiswaEntity entity = service.getSiswaById(id);

        return new ResponseEntity<SiswaEntity>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<SiswaEntity> createOrUpdateSiswa(SiswaEntity siswa)
            throws RecordNotFoundException {
        SiswaEntity updated = service.createOrUpdateSiswa(siswa);
        return new ResponseEntity<SiswaEntity>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteSiswaById(@PathVariable("id") Long id)
            throws RecordNotFoundException {
        service.deletesiswaById(id);
        return HttpStatus.FORBIDDEN;
    }
}