import { UserListComponent } from './user-list/user-list.component';
import { AddUserComponent } from './add-user/add-user.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DashboardComponent } from './dashboard/dashboard.component';
import { LoginComponent } from './login/login.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AdminRoutingModule } from './admin-routing.module';
import { UpdateUserComponent } from './update-user/update-user.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { FournisseurListComponent } from './fournisseur-list/fournisseur-list.component';
import { FabricantListComponent } from './fabricant-list/fabricant-list.component';
import { FamilleComponent } from './famille/famille.component';
import { FilialeComponent } from './filiale/filiale.component';
import { ServiceComponent } from './service-list/service-list.component';
import { ProduitListComponent } from './produit-list/produit-list.component';
import { AddProduitComponent } from './add-produit/add-produit.component';
import { UpdateProduitComponent } from './update-produit/update-produit.component';
import { AddFamilleComponent } from './add-famille/add-famille.component';
import { UpdateFournisseurComponent } from './update-fournisseur/update-fournisseur.component';
import { UpdateFilialeComponent } from './update-filiale/update-filiale.component';
import { UpdateServiceComponent } from './update-service/update-service.component';
import { UpdateFamilleComponent } from './update-famille/update-famille.component';
import { UpdateFabricantComponent } from './update-fabricant/update-fabricant.component';
import { AddFilialeComponent } from './add-filiale/add-filiale.component';
import { AddFabricantComponent } from './add-fabricant/add-fabricant.component';
import { AddFournisseurComponent } from './add-fournisseur/add-fournisseur.component';
import { AddServiceComponent } from './add-service/add-service.component';



@NgModule({
  declarations: [
    AddUserComponent,
    SidebarComponent,
    DashboardComponent,
    LoginComponent,
    UserListComponent,
    UpdateUserComponent,
    FournisseurListComponent,
    FabricantListComponent,
    FamilleComponent,
    FilialeComponent,
    ServiceComponent,
    ProduitListComponent,
    AddProduitComponent,
    UpdateProduitComponent,
    AddFamilleComponent,
    UpdateFournisseurComponent,
    UpdateFilialeComponent,
    UpdateServiceComponent,
    UpdateFamilleComponent,
    UpdateFabricantComponent,
    AddFilialeComponent,
    AddFabricantComponent,
    AddFournisseurComponent,
    AddServiceComponent
  ],
  imports: [
    CommonModule,
    AdminRoutingModule,
    ReactiveFormsModule,
    FormsModule,

  ], exports :[

  LoginComponent
]
})
export class AdminModule { }
