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
import { AddProduitComponent } from './add-produit/add-produit.component';
import { AddFamilleComponent } from './add-famille/add-famille.component';
import { AddFournisseurComponent } from './add-fournisseur/add-fournisseur.component';
import { AddFilialeComponent } from './add-filiale/add-filiale.component';
import { AddServiceComponent } from './add-service/add-service.component';
import { AddFabricantComponent } from './add-fabricant/add-fabricant.component';
import { UpdateFabricantComponent } from './update-fabricant/update-fabricant.component';
import { UpdateFamilleComponent } from './update-famille/update-famille.component';
import { UpdateFournisseurComponent } from './update-fournisseur/update-fournisseur.component';
import { UpdateProduitComponent } from './update-produit/update-produit.component';
import { UpdateFilialeComponent } from './update-filiale/update-filiale.component';
import { UpdateServiceComponent } from './update-service/update-service.component';


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
      {path:'fournisseurList',component:FournisseurListComponent},
      {path:'addFamille', component:AddFamilleComponent},
      {path:'addProduit',component:AddProduitComponent},
      {path:'addFournisseur',component:AddFournisseurComponent},
      {path:'addFiliale',component:AddFilialeComponent},
      {path:'addService',component:AddServiceComponent},
      {path:'addFabricant',component:AddFabricantComponent},
      {path:'update-fabricants/:id',component:UpdateFabricantComponent},
      {path:"update-familles/:id",component:UpdateFamilleComponent},
      {path:"update-fournisseurs/:id",component:UpdateFournisseurComponent},
      {path:"update-produits/:id",component:UpdateProduitComponent},
      {path:"update-filiales/:id",component:UpdateFilialeComponent},
      {path:"update-services/:id", component:UpdateServiceComponent}


  ]},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
