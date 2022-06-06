import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fournisseur } from 'src/app/models/fournisseur';
import { FournisseurService } from 'src/app/services/fournisseur.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';


@Component({
  selector: 'app-fournisseur-list',
  templateUrl: './fournisseur-list.component.html',
  styleUrls: ['./fournisseur-list.component.css']
})
export class FournisseurListComponent implements OnInit {

  fournisseurs!:any[];
  constructor(private fournisseurService:FournisseurService, private tokenStorage: TokenStorageService, private router:Router) {

  }
  isLoggedIn = false;
  roles!:any[]
  ngOnInit(): void {
    this.getFournisseurs();
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.roles=user.roles
      console.log(this.roles)
    }
  }
  private getFournisseurs(){
    this.fournisseurService.getFournisseurList().subscribe(
      data=>{this.fournisseurs=data;}
    )
  }
  updateFournisseur(id:number){
    this.router.navigate(['/dashboard','update-fournisseurs',`${id}`])

  }
  deleteFournisseur(id:number){
    this.fournisseurService.deleteFournisseur(id).subscribe(data=>{
      console.log(data);
      this.getFournisseurs();
    })
  }

}
