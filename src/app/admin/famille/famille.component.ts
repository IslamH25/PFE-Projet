import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Famille } from 'src/app/models/famille';
import { FamilleService } from 'src/app/services/famille.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-famille',
  templateUrl: './famille.component.html',
  styleUrls: ['./famille.component.css']
})
export class FamilleComponent implements OnInit {

  familles!:any[];

  constructor(private familleService:FamilleService,private tokenStorage: TokenStorageService, private router:Router) {

  }

  isLoggedIn = false;
  roles!:any[]
  ngOnInit(): void {
    this.getFamilles();
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.roles=user.roles
      console.log(this.roles)
  }
  }
  private getFamilles(){
    this.familleService.getFamilleList().subscribe(
      data=>{this.familles=data;
      console.log(data)}
    )
  }
  updateFamille(id:number){
    this.router.navigate(['/dashboard','update-familles',`${id}`])

  }
  deleteFamille(id:number){
    this.familleService.deleteFamille(id).subscribe(data=>{
      console.log(data);
      this.getFamilles();
    })
  }

}
