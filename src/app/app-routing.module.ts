import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';


import { RegisterComponent } from './register/register.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { UserListComponent } from './user-list/user-list.component';

const adminModule=()=>import("./admin/admin.module").then(x=>x.AdminModule);
const routes: Routes = [

  {path: 'register', component: RegisterComponent},
  {path:'', redirectTo:'admin', pathMatch:'full'},
  {path: 'admin', loadChildren: adminModule}

];

@NgModule({
  imports: [RouterModule.forRoot(routes, {useHash : true} )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
