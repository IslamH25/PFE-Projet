import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Produit } from 'src/app/models/produits';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.css']
})
export class ProduitListComponent implements OnInit {

  produits!:Produit[];

  constructor(private produitService:ProduitService, private router:Router) {

  }

  ngOnInit(): void {
    this.getProduits();
  }
  private getProduits(){
    this.produitService.getProduitList().subscribe(
      data=>{this.produits=data;
      console.log(data)}
    )
  }
  updateProduit(id:number){
    this.router.navigate(['/dashboard','update-produits'])
  }
  deleteProduit(id:number){
    this.produitService.deleteProduit(id).subscribe(data=>{
      console.log(data);
      this.getProduits();
    })
  }

}
