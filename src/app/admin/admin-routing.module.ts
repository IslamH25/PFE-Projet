import { LoginComponent } from './login/login.component';
import { DashboardComponent } from "./dashboard/dashboard.component";
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserListComponent } from './user-list/user-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { UpdateUserComponent } from './update-user/update-user.component';
import { ProduitListComponent } from './produit-list/produit-list.component';
import { FabricantListComponent } from './fabricant-list/fabricant-list.component';
import { FilialeComponent } from './filiale/filiale.component';
import { FamilleComponent } from './famille/famille.component';
import { ServiceComponent } from './service-list/service-list.component';
import { FournisseurListComponent } from './fournisseur-list/fournisseur-list.component';

const routes: Routes = [
  {path :'dashboard' , component: DashboardComponent,
  children : [
      {path :'userList' , component: UserListComponent },
      {path :'addUser' , component: AddUserComponent },
      {path:'update-users/:id', component:UpdateUserComponent},
      {path:'produitList',component:ProduitListComponent},
      {path:'fabricantList',component:FabricantListComponent},
      {path:'filialeList', component:FilialeComponent},
      {path:'familleList', component:FamilleComponent},
      {path:'serviceList',component:ServiceComponent},
      {path:'fournisseurList',component:FournisseurListComponent}

  ]},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
