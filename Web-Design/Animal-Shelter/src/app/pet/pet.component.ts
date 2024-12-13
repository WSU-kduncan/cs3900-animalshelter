import { Component, OnInit } from '@angular/core';
import { Pet } from '../../model/pet.model';
import { CommonModule } from '@angular/common';
import { PetService } from '../../services/pet.service';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NotificationComponent } from '../notification.component'; 
import Swal from 'sweetalert2';

@Component({
  selector: 'app-pet',
  standalone: true,
  imports: [CommonModule, FormsModule, NotificationComponent],
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css'],
})
export class PetComponent implements OnInit {
  pets: Pet[] = [];
  selectedPet: Pet | null = null;
  newPet: Pet = {
    id: 0,
    name: '',
    species: '',
    breed: '',
    sex: '',
    weight: null,
    intake_date: '',
    age: null,
    pet_status: '', 
  };
  notificationMessage = '';
  notificationType: 'success' | 'error' = 'success';
  searchTerm: string = '';
  filteredPets = [...this.pets]
  constructor(
    private readonly petService: PetService,
    private readonly route: ActivatedRoute,
    private readonly router: Router
  ) {}
  filterPets(): void{
    this.filteredPets = this.pets.filter(pets => {
      return pets.name.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      pets.species.toLowerCase().includes(this.searchTerm.toLowerCase())||
      pets.breed.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      pets.sex.toLowerCase().includes(this.searchTerm.toLowerCase()) ||
      pets.id.toString().includes(this.searchTerm);
    })
  }
  ngOnInit(): void {
    this.loadPets();
  }

  loadPets(): void {
    this.pets = this.petService.getPets();
  }

  addPet(): void {
    if (
      this.newPet.name &&
      this.newPet.species &&
      this.newPet.breed &&
      this.newPet.sex &&
      this.newPet.pet_status
    ) {
      this.newPet.id = this.pets.length + 1; 
      this.petService.addPet({ ...this.newPet }); 
      this.showNotification('Pet added successfully!', 'success');
      this.loadPets(); 
      this.resetNewPetForm();
    } else {
      console.error('All fields are required to add a new pet!');
    }
  }

  deletePet(id: number): void {
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
        this.petService.deletePet(id); 
    this.loadPets(); 
        Swal.fire('Deleted!', 'The record has been deleted.', 'success');
      }
    });
    
  }

  resetNewPetForm(): void {
    this.newPet = {
      id: 0,
      name: '',
      species: '',
      breed: '',
      sex: '',
      weight: null,
      intake_date: '',
      age: null,
      pet_status: '',
    };
  }
  showNotification(message: string, type: 'success' | 'error') {
    this.notificationMessage = message;
    this.notificationType = type;
    setTimeout(() => {
      this.notificationMessage = ''; 
    }, 3000);
  }
}
