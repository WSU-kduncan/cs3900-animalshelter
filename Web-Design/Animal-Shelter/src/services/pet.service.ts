import { Injectable } from '@angular/core';
import { Pet } from '../model/pet.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
providedIn: 'root'
})
export class PetService {

private pets:Pet[] = [
    {  id: 1,
        name: 'Buddy',
        species: 'Dog',
        breed: 'Golden Retriever',
        sex: 'Male',
        weight: 68.5, 
        intake_date: '2024-10-15', 
        age: 3, 
        pet_status: 'Not Adopted', 
    },
    {  id: 2,
        name: 'Mittens',
        species: 'Cat',
        breed: 'Maine Coon',
        sex: 'Female',
        weight: 12.3, 
        intake_date: '2024-11-01', 
        age: 2, 
        pet_status: 'Adopted', 
    }
    
];
constructor(private http: HttpClient) { }

//Haven't tested if this works yet

//http call 
//idk why its saying this code is unreachable, i need to ask ryan
getPets(): Pet[] {
    return this.pets;
    this.http.get("url for microservice").subscribe({
        next:(res: any) => {
            this.pets = res.pets
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('List of Pets')
        },
        })
        
}

//http post (create/update) - request object, pass pet(what object you are working on) object in after url for microservice
//property for pets to render if pet is activated or not, ngif

//should change this to be by name
getPetByID(id: number): Pet | undefined {
    return this.pets.find(pet => pet.id === id)
}

addPet(pet: Pet) {
    this.pets.push(pet);
    this.http.post("url for microservice", pet).subscribe({
        next:(res: any) => {
            this.pets = res.pets
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Pet added successfully!')
        },
        })
}

updatePet(pet:Pet) {
    const index = this.pets.findIndex(u => u.id === pet.id);
    this.http.post("url for microservice", pet).subscribe({
        next:(res: any) => {
            this.pets = res.pets
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Pet updated successfully!')
        },
        })
}

deletePet (id: number) {
    this.pets = this.pets.filter (pet => pet.id !== id);
    this.http.delete("url for microservice").subscribe({
        next:(res: any) => {
            this.pets = res.pets
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Pet deleted successfully!')
        },
        })
}
}