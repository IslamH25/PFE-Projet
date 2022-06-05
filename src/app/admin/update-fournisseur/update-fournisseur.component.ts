import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FournisseurService } from 'src/app/services/fournisseur.service';

@Component({
  selector: 'app-update-fournisseur',
  templateUrl: './update-fournisseur.component.html',
  styleUrls: ['./update-fournisseur.component.css']
})
export class UpdateFournisseurComponent implements OnInit {

  id!:number
  fournisseur:any;


 constructor(private fournisseurService:FournisseurService, private route:ActivatedRoute, private router:Router) {
   this.fournisseur = {
     nom_four : ''
    }
 }

 ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.fournisseurService.getFournisseurById(this.id).subscribe(data=>{
     console.log(data)
     this.fournisseur=data;
   },
   error=>console.log(error)
   );
 }
 onSubmit(){
   this.fournisseurService.updateFournisseur(this.id,this.fournisseur).subscribe(data=>{
   this.goToFournisseurList();
   },
   error=>console.log(error))
 }
 goToFournisseurList(){
   this.router.navigate(['/dashboard','fournisseurList'])
 }

}
