import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Filiale } from 'src/app/models/filiale';
import { FilialeService } from 'src/app/services/filiale.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-filiale',
  templateUrl: './filiale.component.html',
  styleUrls: ['./filiale.component.css']
})
export class FilialeComponent implements OnInit {

  filiales!:any[];

  constructor(private filialeService:FilialeService,private tokenStorage: TokenStorageService, private router:Router) {

  }
  isLoggedIn = false;
  roles!:any[]

  ngOnInit(): void {
    this.getFiliales();
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.roles=user.roles
      console.log(this.roles)
    }
  }
  private getFiliales(){
    this.filialeService.getFilialeList().subscribe(
      data=>{this.filiales=data;
      console.log(data)}
    )
  }
  updateFiliale(id:number){
    this.router.navigate(['/dashboard','update-filiales',`${id}`])

  }
  deleteFiliale(id:number){
    this.filialeService.deleteFiliale(id).subscribe(data=>{
      console.log(data);
      this.getFiliales();
    })
  }

}
