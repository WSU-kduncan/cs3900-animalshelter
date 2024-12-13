import { Injectable } from "@angular/core";
import { Staff } from "../model/staff.model";
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class StaffService {

  private staff:Staff[] = [ ];

  getStaff(): Staff[] {
    return this.staff;
    this.http.get("url for microservice").subscribe({
        next:(res: any) => {
            this.staff = res.staff
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('List of Staff')
        },
      })      
  }

  getStaffByCode(staffCode: number): Staff | undefined {
    return this.staff.find(staff => staff.staffCode === staffCode)
  }

  addStaffMember(staff: Staff) {
    this.staff.push(staff);
    this.http.post("url for microservice", staff).subscribe({
        next:(res: any) => {
            this.staff = res.staff
        }, error(err){
            console.error(err)
        }, complete(){
            console.log('Staff member added successfully!')
        },
      })
  }

  updateStaff(staff:Staff) {
    const index = this.staff.findIndex(u => u.staffCode === staff.staffCode);
    this.http.post("url for microservice", staff).subscribe({
      next:(res: any) => {
          this.staff = res.staff
      }, error(err){
          console.error(err)
      }, complete(){
          console.log('Staff updated successfully!')
      },
    })
  }

  deleteStaffMember(staffCode: number) {
    this.staff = this.staff.filter (staff => staff.staffCode !== staffCode);
    this.http.delete("url for microservice").subscribe({
      next:(res: any) => {
          this.staff = res.staff
      }, error(err){
          console.error(err)
      }, complete(){
          console.log('Staff member deleted successfully!')
      },
    })
  }

  constructor(private http: HttpClient) { }
}
