import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FamilleComponent } from './admin/famille/famille.component';
import { LoginComponent } from './admin/login/login.component';


const adminModule=()=>import("./admin/admin.module").then(x=>x.AdminModule);
const routes: Routes = [


  //{path:'', redirectTo:'admin', pathMatch:'full'},
  {path: 'admin', component : LoginComponent},
  {path: 'administration', loadChildren: adminModule}

];

@NgModule({
  imports: [RouterModule.forRoot(routes )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
