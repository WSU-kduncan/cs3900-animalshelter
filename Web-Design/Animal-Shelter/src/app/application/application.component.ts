import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PetService } from '../../services/pet.service';
/* 
Things to be worked on:
- available pets to be adopted when creating new application: line 24, 38, pets.services.ts
*/
@Component({
    imports: [CommonModule, FormsModule],
    selector: 'app-application',
    standalone: true,
    templateUrl: './application.component.html',
    styleUrl: './application.component.css'
})
export class ApplicationComponent {

  applications = [
    { id: 123, first_name: 'Gani', last_name: 'Sagiev', phone: '(937)123-4567', email: 'sagiev@example.com',pet_name: "Stitch",status: 'Pending', date: '2024-12-01' },
    { id: 133, first_name: 'Shapiy', last_name:'Sagiev', phone: '(937)987-6565',email: 'sagiev2@example.com',pet_name: "twitch",status: 'Pending', date: '2024-12-01' },
    { id: 242, first_name: 'Hunter', last_name:'Mcintash', phone: '(603)123-4567', email: 'mcintash2@example.com',pet_name: "alex",status: 'Pending', date: '2024-11-25' },
    { id: 344, first_name: 'Ardalan', last_name:'Janpour', phone: '(937)111-2222', email: 'janpour@example.com',pet_name: "beemo",status: 'Approved', date: '2024-11-20' },
  ];
  availablePets: any[] = []; //fetch from PetServices
  searchTerm: string = '';// the string the user types to look for.
  filteredApplications = [...this.applications];// the component to look under for search.
  showAddForm: boolean = false;
  newApplication = {
    first_name:'',
    last_name:'',
    phone:'',
    email:'',
    pet_name:'',
  };

  constructor(private petService: PetService) {}

  ngOnInit(): void {// petService suppose to get the list of available pets for adoption. NOT WORKING.
    this.petService.getAvailablePets().subscribe(pets => {
      this.availablePets = pets;
    });
  }

  filterApplications(): void{// This filters the results based off certain criteria.
    this.filteredApplications = this.applications.filter(application => {
      return application.first_name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      application.last_name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      application.email.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      application.id.toString().includes(this.searchTerm);
    })
  }
  toggleAddApplicationForm(): void{
    this.showAddForm = !this.showAddForm;
  }

  submitApplication(): void {
    const newId = this.applications.length + 1; // Simple ID generation, can be enhanced
    const currentDate = new Date().toLocaleDateString();
    const newApp = {
      ...this.newApplication,
      id: newId,
      status: 'Pending',
      date: currentDate
    };
    this.applications.push(newApp);
    this.newApplication = { first_name: '', last_name: '', phone: '', email: '', pet_name: '' }; // Clear the form
    this.showAddForm = false; // Hide the form after submission
    console.log('New application submitted:', newApp);
  }
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
