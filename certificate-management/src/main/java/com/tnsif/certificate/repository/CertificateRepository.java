package com.tnsif.certificate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tnsif.certificate.entity.Certificate;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {}
