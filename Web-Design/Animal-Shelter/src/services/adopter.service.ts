import { Injectable } from '@angular/core';
import { Adopter } from '../model/adopter.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AdopterService {

private adopters:Adopter[] = [
  //add adopter information
]

  constructor(private http: HttpClient) { }

  getAdopters(): Adopter[] {
    return this.adopters;
    this.http.get("url for microservice").subscribe({
        next:(res: any) => {
            this.adopters = res.pets
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('List of Adopters')
        },
        })
        
}
  //Should change this to name
  getAdopterByID(id: number): Adopter | undefined {
    return this.adopters.find(adopter => adopter.adopter_id === id)
}


  addAdopter(adopter: Adopter) {
    this.adopters.push(adopter);
    this.http.post("url for microservice", adopter).subscribe({
        next:(res: any) => {
            this.adopters = res.adopters
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Adopter added successfully!')
        },
        })
}

  updateAdopter(adopter:Adopter) {
    const index = this.adopters.findIndex(u => u.adopter_id === adopter.adopter_id);
    this.http.post("url for microservice", adopter).subscribe({
        next:(res: any) => {
            this.adopters = res.adopter
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Adopter updated successfully!')
        },
        })
}

  deleteAdopter (id: number) {
    this.adopters = this.adopters.filter (adopter => adopter.adopter_id !== id);
    this.http.delete("url for microservice").subscribe({
        next:(res: any) => {
            this.adopters = res.adopters
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Adopter deleted successfully!')
        },
        })
}
}
