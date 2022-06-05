import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FabricantService } from 'src/app/services/fabricant.service';

@Component({
  selector: 'app-update-fabricant',
  templateUrl: './update-fabricant.component.html',
  styleUrls: ['./update-fabricant.component.css']
})
export class UpdateFabricantComponent implements OnInit {

  id!:number
  fabricant:any;


 constructor(private fabricantService:FabricantService, private route:ActivatedRoute, private router:Router) {
   this.fabricant = {
     nom_fab : '',
     type_fab : ''
    }
 }

 ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.fabricantService.getFabricantById(this.id).subscribe(data=>{
     console.log(data)
     this.fabricant=data;
   },
   error=>console.log(error)
   );
 }
 onSubmit(){
   this.fabricantService.updateFabricant(this.id,this.fabricant).subscribe(data=>{
   this.goToFabricantList();
   },
   error=>console.log(error))
 }
 goToFabricantList(){
   this.router.navigate(['/dashboard','fabricantList'])
 }

}
