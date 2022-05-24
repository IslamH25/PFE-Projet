import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FilialeService } from 'src/app/services/filiale.service';
import { ServiceService } from 'src/app/services/service.service';

@Component({
  selector: 'app-add-filiale',
  templateUrl: './add-filiale.component.html',
  styleUrls: ['./add-filiale.component.css']
})
export class AddFilialeComponent implements OnInit {


  filiale: any;
  services!:any[];

  constructor(private filialeService:FilialeService,private router:Router, private serviceService:ServiceService) {
    this.filiale = {
    nom_fil:'',
    desc_fil:'',
    sect_fil:'',
    service:''
    }
   }

  ngOnInit(): void {
    this.serviceService.getServiceList().subscribe(data=>{this.services=data;
    console.log(data)})
  }

  saveFiliale(){
    this.filialeService.createFiliale(this.filiale).subscribe(data =>{console.log(data);
      this.goToFilialeList();},
    error=>console.log(error))

  }

  goToFilialeList(){
    this.router.navigate(['/dashboard','filialeList'])
  }

  onSubmit(){
  this.saveFiliale(); }

}
