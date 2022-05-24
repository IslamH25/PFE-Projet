import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fournisseur } from 'src/app/models/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-fournisseur-list',
  templateUrl: './fournisseur-list.component.html',
  styleUrls: ['./fournisseur-list.component.css']
})
export class FournisseurListComponent implements OnInit {

  fournisseurs!:any[];

  constructor(private fournisseurService:FournisseurService, private router:Router) {

  }

  ngOnInit(): void {
    this.getFournisseurs();
  }
  private getFournisseurs(){
    this.fournisseurService.getFournisseurList().subscribe(
      data=>{this.fournisseurs=data;
      console.log(this.fournisseurs[0].name)}
    )
  }
  updateFournisseur(id:number){
    this.router.navigate(['/dashboard','update-fournisseurs'])
  }
  deleteFournisseur(id:number){
    this.fournisseurService.deleteFournisseur(id).subscribe(data=>{
      console.log(data);
      this.getFournisseurs();
    })
  }

}
