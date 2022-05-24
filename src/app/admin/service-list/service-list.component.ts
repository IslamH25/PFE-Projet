import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-service',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceComponent implements OnInit {


  services!:any[];

  constructor(private serviceService:ServiceService,private tokenStorage: TokenStorageService, private router:Router) {

  }
  isLoggedIn = false;
  roles!:any[]
  ngOnInit(): void {
    this.getServices();
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.roles=user.roles
      console.log(this.roles)
  }
  }
  private getServices(){
    this.serviceService.getServiceList().subscribe(
      data=>{this.services=data;
      console.log(data)}
    )
  }
  updateService(id:number){
    this.router.navigate(['/dashboard','update-services',`${id}`])
  }
  deleteService(id:number){
    this.serviceService.deleteService(id).subscribe(data=>{
      console.log(data);
      this.getServices();
    })
  }

}
