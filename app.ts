import { Component, signal, ViewEncapsulation } from '@angular/core';
import { NgForm } from '@angular/forms';
import { CertificateService } from './Certificate';  // updated service import
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-certificate',
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule],
  templateUrl: './app.html',
  styleUrls: ['./app.css'],
  encapsulation: ViewEncapsulation.None
})
export class App {
  protected readonly title = signal('Certificate Service');

  // List of all certificates
  certificateDetails: any[] = [];

  // Object for register/update
  certificateToUpdate = {
    id: null as any,
    name: '',
    type: '',
    issuedBy: '',
    issuedTo: '',
    issueDate: '',
    expiryDate: ''
  };

  constructor(private certificateService: CertificateService) {
    this.getCertificateDetails();
  }

  // Register a new certificate
  register(registerForm: NgForm) {
    this.certificateService.createCertificate(registerForm.value).subscribe(
      (resp) => {
        console.log('Certificate added:', resp);
        registerForm.reset();
        this.getCertificateDetails();
      },
      (err) => console.error('Error while adding certificate:', err)
    );
  }

  // Get all certificates
  getCertificateDetails() {
    this.certificateService.getCertificates().subscribe(
      (resp: any) => {
        this.certificateDetails = resp;
      },
      (err) => console.error('Error fetching certificates:', err)
    );
  }

  // Delete a certificate
  deleteCertificate(certificate: any) {
    this.certificateService.deleteCertificate(certificate.id).subscribe(
      () => this.getCertificateDetails(),
      (err) => console.error('Error deleting certificate:', err)
    );
  }

  // Prepare certificate for update
  edit(certificate: any) {
    this.certificateToUpdate = { ...certificate };
  }

  // Update certificate
  updateCertificate() {
    this.certificateService
      .updateCertificate(this.certificateToUpdate.id, this.certificateToUpdate)
      .subscribe(
        () => this.getCertificateDetails(),
        (err) => console.error('Error updating certificate:', err)
      );
  }
}
