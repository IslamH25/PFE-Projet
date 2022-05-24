import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FabricantService } from 'src/app/services/fabricant.service';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { ProduitService } from 'src/app/services/produit.service';

@Component({
  selector: 'app-update-produit',
  templateUrl: './update-produit.component.html',
  styleUrls: ['./update-produit.component.css']
})
export class UpdateProduitComponent implements OnInit {

  id!:number
  produit:any;
  fabricants!:any[];
  fournisseurs!:any[]


 constructor(private produitService:ProduitService, private route:ActivatedRoute, private router:Router, private fournisseurService:FournisseurService, private fabricantService:FabricantService) {
   this.produit= {
     ref_piece : '',
     consomAnnee : '',
     prix : '',
     observation:'',
     designation:'',
     fabricant:'',
     fournisseur:''
    }
 }

 ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.produitService.getProduitById(this.id).subscribe(data=>{
     console.log(data)
     this.produit=data;
   },
   error=>console.log(error)
   );
   this.fournisseurService.getFournisseurList().subscribe(data=>{this.fournisseurs=data});
   this.fabricantService.getFabricantList().subscribe(data=>{this.fabricants=data})
 }
 onSubmit(){
   this.produitService.updateProduit(this.id,this.produit).subscribe(data=>{
   this.goToProduitList();
   },
   error=>console.log(error))
 }
 goToProduitList(){
   this.router.navigate(['/dashboard','produitList'])
 }

}
