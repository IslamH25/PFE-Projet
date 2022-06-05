import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FamilleComponent } from './admin/famille/famille.component';
import { FilialeComponent } from './admin/filiale/filiale.component';
import { LoginComponent } from './admin/login/login.component';
import { AboutComponent } from './web/about/about.component';
import { CatalogueComponent } from './web/catalogue/catalogue.component';
import { GeneralComponent } from './web/general/general.component';


const adminModule=()=>import("./admin/admin.module").then(x=>x.AdminModule);
const webModule=()=>import("./web/web.module").then(x=>x.WebModule);

const routes: Routes = [
  {path:'', redirectTo:'catalogue', pathMatch:'full'},
  {path:'web', component:GeneralComponent},
  {path: 'admin', component : LoginComponent},
  {path: 'administration', loadChildren: adminModule},
  {path:'webPage',loadChildren:webModule},
  {path: 'about', component : AboutComponent},
  {path: 'catalogue', component : CatalogueComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes )],
  exports: [RouterModule]
})
export class AppRoutingModule { }
