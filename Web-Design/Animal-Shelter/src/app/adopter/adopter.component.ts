import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { NotificationComponent } from '../notification.component';
import Swal from 'sweetalert2';

@Component({
    selector: 'app-adopter',
    standalone: true,
    imports: [CommonModule, FormsModule, NotificationComponent],
    templateUrl: './adopter.component.html',
    styleUrls: ['./adopter.component.css']
})
export class AdopterComponent implements OnInit {
  adopters = [
    { id: 1, name: 'Ava Macintash', email: 'Ava@example.com', phone: '123-456-7890', status: 'Approved' },
    { id: 2, name: 'Cara Zozokos', email: 'Cara@example.com', phone: '987-654-3210', status: 'Pending' },
    
  ];

  notificationMessage = '';
  notificationType: 'success' | 'error' = 'success';
  searchTerm: string = '';
  filteredAdopters = [...this.adopters];
  newAdopter = { id: 0, name: '', email: '', phone: '', status: 'Pending' };

  constructor() {}

  ngOnInit(): void {}

  filterAdopters(): void{
    this.filteredAdopters = this.adopters.filter(adopters => {
      return adopters.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      adopters.email.toLowerCase().includes(this.searchTerm.toLowerCase())||
      adopters.phone.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      adopters.id.toString().includes(this.searchTerm);
    })
  }
  addAdopter(): void {
    if (this.newAdopter.name && this.newAdopter.email && this.newAdopter.phone) {
      this.newAdopter.id = this.adopters.length + 1;
      this.adopters.push({ ...this.newAdopter });
      this.showNotification('Adopter added successfully!', 'success');
      this.resetForm();
    }
  }

  deleteAdopter(id: number): void {
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
        this.adopters = this.adopters.filter(adopter => adopter.id !== id);
        Swal.fire('Deleted!', 'The record has been deleted.', 'success');
      }
    });
  }

  resetForm(): void {
    this.newAdopter = { id: 0, name: '', email: '', phone: '', status: 'Pending' };
  }

  showNotification(message: string, type: 'success' | 'error') {
    this.notificationMessage = message;
    this.notificationType = type;
    setTimeout(() => {
      this.notificationMessage = ''; 
    }, 3000);
  }
}
