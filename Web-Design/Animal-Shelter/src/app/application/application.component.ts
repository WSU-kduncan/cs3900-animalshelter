import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
    imports: [CommonModule],
    selector: 'app-application',
    standalone: true,
    templateUrl: './application.component.html',
    styleUrl: './application.component.css'
})
export class ApplicationComponent {

  applications = [
    //{ id: 1, name: 'Gani Sagiev', status: 'Pending', date: '2024-12-01' },
    //{ id: 2, name: 'Hunter Mcintash', status: 'Pending', date: '2024-11-25' },
    { id: 3, name: 'Ardalan Janpour', status: 'Approved', date: '2024-11-20' },
  ];

  constructor() {}

  ngOnInit(): void {}

  approveApplication(id: number): void {
    const application = this.applications.find(app => app.id === id);
    if (application) {
      application.status = 'Approved';
      console.log(`Application with ID ${id} has been approved.`);
    }
  }

  rejectApplication(id: number): void {
    const application = this.applications.find(app => app.id === id);
    if (application) {
      application.status = 'Rejected';
      console.log(`Application with ID ${id} has been rejected.`);
    }
  }
}
