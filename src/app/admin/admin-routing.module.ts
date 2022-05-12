import { DashboardComponent } from "./dashboard/dashboard.component";
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from "./login/login.component";
import { AdminComponent } from "./admin/admin.component";
const routes: Routes = [
  {path: '', component : AdminComponent,
  children : [

  ]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AdminRoutingModule { }
