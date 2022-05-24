import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css']
})
export class AddServiceComponent implements OnInit {


  service: any;

  constructor(private serviceService:ServiceService,private router:Router) {
    this.service = {
    nom_serv:'',
    designation_serv:''
    }
   }

  ngOnInit(): void {
  }

  saveService(){
    this.serviceService.createService(this.service).subscribe(data =>{console.log(data);
      this.goToServiceList();},
    error=>console.log(error))

  }

  goToServiceList(){
    this.router.navigate(['/dashboard','serviceList'])
  }

  onSubmit(){
  this.saveService(); }


}
