import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { FamilleService } from 'src/app/services/famille.service';

@Component({
  selector: 'app-add-famille',
  templateUrl: './add-famille.component.html',
  styleUrls: ['./add-famille.component.css']
})
export class AddFamilleComponent implements OnInit {
  famille:any;
  constructor(private familleService:FamilleService, private route :Router) {
    this.famille={
      nom_famille:'',
      desc_famille:''

    }
  }

  ngOnInit(): void {
  }
  saveFamille(){
    this.familleService.createFamille(this.famille).subscribe(data=>{this.goToFamilleList();},
   error=>console.log(error)
    )
  }
  goToFamilleList(){
    this.route.navigate(['/dashboard','familleList'])
  }
  onSubmit(){
    this.saveFamille();
  }
}
