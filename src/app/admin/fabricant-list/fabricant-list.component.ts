import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Fabricant } from 'src/app/models/fabricant';
import { FabricantService } from 'src/app/services/fabricant.service';

@Component({
  selector: 'app-fabricant-list',
  templateUrl: './fabricant-list.component.html',
  styleUrls: ['./fabricant-list.component.css']
})
export class FabricantListComponent implements OnInit {

  fabricants!:Fabricant[];

  constructor(private fabricantService:FabricantService, private router:Router) {

  }

  ngOnInit(): void {
    this.getFabricants();
  }
  private getFabricants(){
    this.fabricantService.getFabricantList().subscribe(
      data=>{this.fabricants=data;
      console.log(data)}
    )
  }
  updateFabricant(id:number){
    this.router.navigate(['/dashboard','update-fabricants'])
  }
  deleteFabricant(id:number){
    this.fabricantService.deleteFabricant(id).subscribe(data=>{
      console.log(data);
      this.getFabricants();
    })
  }

}
