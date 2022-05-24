import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-update-service',
  templateUrl: './update-service.component.html',
  styleUrls: ['./update-service.component.css']
})
export class UpdateServiceComponent implements OnInit {

  id!:number
  service:any;


 constructor(private serviceService:ServiceService, private route:ActivatedRoute, private router:Router) {
   this.service = {
     nom_serv : '',
     designation_serv : ''
    }
 }

 ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.serviceService.getServiceById(this.id).subscribe(data=>{
     console.log(data)
     this.service=data;
   },
   error=>console.log(error)
   );
 }
 onSubmit(){
   this.serviceService.updateService(this.id,this.service).subscribe(data=>{
   this.goToServiceList();
   },
   error=>console.log(error))
 }
 goToServiceList(){
   this.router.navigate(['/dashboard','serviceList'])
 }

}
