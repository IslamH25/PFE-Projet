import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fabricant } from 'src/app/models/fabricant';
import { FabricantService } from 'src/app/services/fabricant.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-fabricant-list',
  templateUrl: './fabricant-list.component.html',
  styleUrls: ['./fabricant-list.component.css']
})
export class FabricantListComponent implements OnInit {

  fabricants!:any[];

  constructor(private fabricantService:FabricantService,private tokenStorage: TokenStorageService, private router:Router) {

  }
  isLoggedIn = false;
  roles!:any[]
  ngOnInit(): void {
    this.getFabricants();
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.roles=user.roles
      console.log(this.roles)
    }
  }
  private getFabricants(){
    this.fabricantService.getFabricantList().subscribe(
      data=>{this.fabricants=data;
      console.log(data)}
    )
  }
  updateFabricant(id:number){
    this.router.navigate(['/dashboard','update-fabricants',`${id}`])

  }
  deleteFabricant(id:number){
    this.fabricantService.deleteFabricant(id).subscribe(data=>{
      console.log(data);
      this.getFabricants();
    })
  }

}
