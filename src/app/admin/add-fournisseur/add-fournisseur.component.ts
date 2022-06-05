import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-add-fournisseur',
  templateUrl: './add-fournisseur.component.html',
  styleUrls: ['./add-fournisseur.component.css']
})
export class AddFournisseurComponent implements OnInit {

  fournisseur:any;
  constructor(private fournisseurService:FournisseurService, private route :Router) {
    this.fournisseur={
      nom_four:''

    }
  }

  ngOnInit(): void {
  }
  saveFournisseur(){
    this.fournisseurService.createFournisseur(this.fournisseur).subscribe(data=>{this.goToFournisseurList();},
   error=>console.log(error)
    )
  }
  goToFournisseurList(){
    this.route.navigate(['/dashboard','fournisseurList'])
  }
  onSubmit(){
    this.saveFournisseur();
  }
}
