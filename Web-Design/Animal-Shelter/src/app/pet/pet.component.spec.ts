import { ComponentFixture, TestBed } from '@angular/core/testing';
import { FormsModule } from '@angular/forms';

import { PetComponent } from './pet.component';

describe('PetComponent', () => {
  let component: PetComponent;
  let fixture: ComponentFixture<PetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PetComponent],
      imports: [FormsModule]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should have invalid form when empty', () => {
    const form = fixture.nativeElement.querySelector('form');
    expect(form.checkValidity()).toBeFalsy(); 
  });

  it('should validate required fields', () => {
    component.newPet = { id: 0, name: '', species: '', breed: '', sex: '', weight: 0, intake_date: '', age: 0, pet_status: '' };
    fixture.detectChanges();

    const form = fixture.nativeElement.querySelector('form');
    expect(form.checkValidity()).toBeFalsy();

    
    /*component.newPet.id = 1;
    component.newPet.name = 'Buddy';
    component.newPet.species = 'Dog';
    component.newPet.breed = 'Golden Retriever';
    component.newPet.sex = 'Male';
    component.newPet.weight = 30;
    component.newPet.intake_date = '2023-01-01';
    component.newPet.age = 3;
    component.newPet.pet_status = 'Available'; */

    fixture.detectChanges();
    expect(form.checkValidity()).toBeTruthy(); 
  });


});
