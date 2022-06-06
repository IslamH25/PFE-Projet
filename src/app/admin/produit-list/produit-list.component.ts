import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { ProduitService } from 'src/app/services/produit.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-produit-list',
  templateUrl: './produit-list.component.html',
  styleUrls: ['./produit-list.component.css']
})
export class ProduitListComponent implements OnInit {

  produits!:any[];

  constructor(private produitService:ProduitService,private tokenStorage: TokenStorageService, private router:Router) {

  }
  isLoggedIn = false;
  roles!:any[]
  ngOnInit(): void {
    this.getProduits();
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.roles=user.roles
      console.log(this.roles)
  }}
  private getProduits(){
    this.produitService.getProduitList().subscribe(
      data=>{this.produits=data;
      console.log(data)}
    )
  }
  updateProduit(id:number){
    this.router.navigate(['/dashboard','update-produits',`${id}`])

  }
  deleteProduit(id:number){
    this.produitService.deleteProduit(id).subscribe(data=>{
      console.log(data);
      this.getProduits();
    })
  }

}
