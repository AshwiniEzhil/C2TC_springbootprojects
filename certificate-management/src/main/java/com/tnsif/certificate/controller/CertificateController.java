package com.tnsif.certificate.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.tnsif.certificate.entity.Certificate;
import com.tnsif.certificate.service.CertificateService;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {
    @Autowired
    private CertificateService service;

    @PostMapping
    public Certificate createCertificate(@RequestBody Certificate certificate) { return service.saveCertificate(certificate); }

    @GetMapping
    public List<Certificate> getAllCertificates() { return service.getAllCertificates(); }

    @GetMapping("/{id}")
    public ResponseEntity<Certificate> getCertificateById(@PathVariable Long id) {
        Optional<Certificate> certificate = service.getCertificateById(id);
        return certificate.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public Certificate updateCertificate(@PathVariable Long id, @RequestBody Certificate certificate) { return service.updateCertificate(id, certificate); }

    @DeleteMapping("/{id}")
    public String deleteCertificate(@PathVariable Long id) { service.deleteCertificate(id); return "Certificate deleted successfully!"; }
}
