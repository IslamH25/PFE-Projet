import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FabricantService } from 'src/app/services/fabricant.service';

@Component({
  selector: 'app-add-fabricant',
  templateUrl: './add-fabricant.component.html',
  styleUrls: ['./add-fabricant.component.css']
})
export class AddFabricantComponent implements OnInit {

  fabricant: any;

  constructor(private fabricantService:FabricantService,private router:Router) {
    this.fabricant = {
    nom_fab:'',
    type_fab:''
    }
   }

  ngOnInit(): void {
  }

  saveFabricant(){
    this.fabricantService.createFabricant(this.fabricant).subscribe(data =>{console.log(data);
      this.goToFabricantList();},
    error=>console.log(error))

  }

  goToFabricantList(){
    this.router.navigate(['/dashboard','fabricantList'])
  }

  onSubmit(){
  this.saveFabricant(); }


}
