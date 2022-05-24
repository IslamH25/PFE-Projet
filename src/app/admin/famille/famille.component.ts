import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Famille } from 'src/app/models/famille';
import { FamilleService } from 'src/app/services/famille.service';

@Component({
  selector: 'app-famille',
  templateUrl: './famille.component.html',
  styleUrls: ['./famille.component.css']
})
export class FamilleComponent implements OnInit {

  familles!:any[];

  constructor(private familleService:FamilleService, private router:Router) {

  }

  ngOnInit(): void {
    this.getFamilles();
  }
  private getFamilles(){
    this.familleService.getFamilleList().subscribe(
      data=>{this.familles=data;
      console.log(data)}
    )
  }
  updateFamille(id:number){
    this.router.navigate(['/dashboard','update-familles'])
  }
  deleteFamille(id:number){
    this.familleService.deleteFamille(id).subscribe(data=>{
      console.log(data);
      this.getFamilles();
    })
  }

}
