import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Service } from 'src/app/models/service';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-service',
  templateUrl: './service-list.component.html',
  styleUrls: ['./service-list.component.css']
})
export class ServiceComponent implements OnInit {


  services!:any[];

  constructor(private serviceService:ServiceService, private router:Router) {

  }

  ngOnInit(): void {
    this.getServices();
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
