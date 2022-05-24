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
    ProduitListComponent
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
