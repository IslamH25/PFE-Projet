import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { data } from 'jquery';
import { FabricantService } from 'src/app/services/fabricant.service';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-add-produit',
  templateUrl: './add-produit.component.html',
  styleUrls: ['./add-produit.component.css']
})
export class AddProduitComponent implements OnInit {

  produit: any;
  fournisseurs!:any[]
  fabricants!:any[]

  constructor(private produitService:ProduitService,private router:Router, private fournisseurService:FournisseurService, private fabricantService:FabricantService) {
   this.produit={
     ref_piece:'',
     consomAnnee:'',
     prix:'',
     observation:'',
     designation:'',
     fabricant:'',
     fournisseur:''
   }
   }

  ngOnInit(): void {
    this.fournisseurService.getFournisseurList().subscribe(data=>{this.fournisseurs=data});
    this.fabricantService.getFabricantList().subscribe(data=>{this.fabricants=data})
  }

  saveProduit(){
    this.produitService.createProduit(this.produit).subscribe(data =>{console.log(data);
      this.goToProduitList();},
    error=>console.log(error))

  }

  goToProduitList(){
    this.router.navigate(['/dashboard','produitList'])
  }

  onSubmit(){
  this.saveProduit(); }

}
