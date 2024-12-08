import { Injectable } from "@angular/core";
import { Application } from "../model/application.model";
import { HttpClient } from '@angular/common/http';
import { app } from "../../server";
import { application } from "express";

@Injectable({
  providedIn: 'root'
})
export class ApplicationService {

  private applications:Application[] = [ ];

  getApplications(): Application[] {
    return this.applications;
    this.http.get("url for microservice").subscribe({
        next:(res: any) => {
            this.applications = res.applications
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('List of Applications')
        },
      })      
  }

//http post (create/update) - request object, pass pet(what object you are working on) object in after url for microservice
//property for pets to render if pet is activated or not, ngif

  getApplicationById(applicationId: number): Application | undefined {
    return this.applications.find(application => application.applicationId === applicationId)
  }

  addApplication(application: Application) {
    this.applications.push(application);
    this.http.post("url for microservice", application).subscribe({
        next:(res: any) => {
            this.applications = res.applications
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Application added successfully!')
        },
      })
  }

  updateApplication(application:Application) {
    const index = this.applications.findIndex(u => u.applicationId === application.applicationId);
    this.http.post("url for microservice", application).subscribe({
      next:(res: any) => {
          this.applications = res.applications
      }, error(err){
          console.error(err)
      }, complete(){
          console.log('Application updated successfully!')
      },
    })
  }

  deleteApplication (applicationId: number) {
    this.applications = this.applications.filter (application => application.applicationId !== applicationId);
    this.http.delete("url for microservice").subscribe({
      next:(res: any) => {
          this.applications = res.applications
      }, error(err){
          console.error(err)
      }, complete(){
          console.log('Application deleted successfully!')
      },
    })
  }

  constructor(private http: HttpClient) { }
}
