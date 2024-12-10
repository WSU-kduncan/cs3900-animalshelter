import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NotificationComponent } from '../notification.component'; 
import Swal from 'sweetalert2';

@Component({
    selector: 'app-staff', 
    standalone: true,
    imports: [CommonModule, FormsModule, NotificationComponent],
    templateUrl: './staff.component.html',
    styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  staff = [
    { id: 1, name: 'Gani', email: 'Gani@example.com', phone: '555-1234', role: 'Manager' },
    { id: 2, name: 'Hunter', email: 'Hunter@example.com', phone: '555-5678', role: 'Volunteer' },
  ];

  newStaff = { id: 0, name: '', email: '', phone: '', role: 'Volunteer' };
  notificationMessage = '';
  notificationType: 'success' | 'error' = 'success';


  constructor() {}

  ngOnInit(): void {}

  addStaff(): void {
    if (this.newStaff.name && this.newStaff.email && this.newStaff.phone) {
      this.newStaff.id = this.staff.length + 1;
      this.staff.push({ ...this.newStaff });
      this.showNotification('Staff added successfully!', 'success');
      this.resetForm();
    }
  }

  deleteStaff(id: number): void {
    Swal.fire({
      title: 'Are you sure?',
      text: 'You will not be able to recover this record!',
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!',
      cancelButtonText: 'Cancel',
    }).then((result) => {
      if (result.isConfirmed) {
        // Perform deletion
        this.staff = this.staff.filter(member => member.id !== id);
        Swal.fire('Deleted!', 'The record has been deleted.', 'success');
      }
    });
    
  }

  resetForm(): void {
    this.newStaff = { id: 0, name: '', email: '', phone: '', role: 'Volunteer' };
  }
  showNotification(message: string, type: 'success' | 'error') {
    this.notificationMessage = message;
    this.notificationType = type;
    setTimeout(() => {
      this.notificationMessage = ''; 
    }, 3000);
  }
}
