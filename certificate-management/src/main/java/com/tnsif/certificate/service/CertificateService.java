package com.tnsif.certificate.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tnsif.certificate.entity.Certificate;
import com.tnsif.certificate.repository.CertificateRepository;

@Service
public class CertificateService {
    @Autowired
    private CertificateRepository repository;

    public Certificate saveCertificate(Certificate certificate) { return repository.save(certificate); }
    public List<Certificate> getAllCertificates() { return repository.findAll(); }
    public Optional<Certificate> getCertificateById(Long id) { return repository.findById(id); }
    public Certificate updateCertificate(Long id, Certificate certificate) { certificate.setId(id); return repository.save(certificate); }
    public void deleteCertificate(Long id) { repository.deleteById(id); }
}
