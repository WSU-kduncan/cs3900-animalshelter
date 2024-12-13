import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PetComponent } from './pet/pet.component';
import { ApplicationComponent } from './application/application.component';
import { HomepageComponent } from './homepage/homepage.component';
import { AdopterComponent } from './adopter/adopter.component';
import { StaffComponent } from './staff/staff.component';

export const routes: Routes = [
    {path: '', component: HomepageComponent},
    {path: 'pet', component: PetComponent },
    {path: 'application', component: ApplicationComponent},
    {path: 'home', component: HomepageComponent},
    {path: 'adopter', component: AdopterComponent},
    {path: 'staff', component: StaffComponent},

];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule],
})
export class AppRoutingModule {}
