import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FamilleService } from 'src/app/services/famille.service';

@Component({
  selector: 'app-update-famille',
  templateUrl: './update-famille.component.html',
  styleUrls: ['./update-famille.component.css']
})
export class UpdateFamilleComponent implements OnInit {

  id!:number
  famille:any;


 constructor(private familleService:FamilleService, private route:ActivatedRoute, private router:Router) {
   this.famille = {
     nom_famille : '',
     desc_famille : ''
    }
 }

 ngOnInit(): void {
   this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.familleService.getFamilleById(this.id).subscribe(data=>{
     console.log(data)
     this.famille=data;
   },
   error=>console.log(error)
   );
 }
 onSubmit(){
   this.familleService.updateFamille(this.id,this.famille).subscribe(data=>{
   this.goToFabricantList();
   },
   error=>console.log(error))
 }
 goToFabricantList(){
   this.router.navigate(['/dashboard','familleList'])
 }

}
