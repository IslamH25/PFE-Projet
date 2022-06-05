import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FilialeService } from 'src/app/services/filiale.service';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-update-filiale',
  templateUrl: './update-filiale.component.html',
  styleUrls: ['./update-filiale.component.css']
})
export class UpdateFilialeComponent implements OnInit {

  id!:number
  filiale:any;
  services!:any[];


 constructor(private filialeService:FilialeService, private route:ActivatedRoute, private router:Router, private serviceService:ServiceService) {
   this.filiale= {
     nom_fil : '',
     desc_fil: '',
     sect_fil : '',
     service:''
    }
 }

 ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.filialeService.getFilialeById(this.id).subscribe(data=>{
     console.log(data)
     this.filiale=data;
   },
   error=>console.log(error)
   );
   this.serviceService.getServiceList().subscribe(data=>{this.services=data});
 }
 onSubmit(){
   this.filialeService.updateFiliale(this.id,this.filiale).subscribe(data=>{
   this.goToFilialeList();
   },
   error=>console.log(error))
 }
 goToFilialeList(){
   this.router.navigate(['/dashboard','filialeList'])
 }

}
