import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';



const adminModule=()=>import("./admin/admin.module").then(x=>x.AdminModule);
const routes: Routes = [


  {path:'', redirectTo:'admin', pathMatch:'full'},
  {path: 'admin', loadChildren: adminModule}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash : true} )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
