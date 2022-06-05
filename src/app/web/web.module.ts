import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { WebRoutingModule } from './web-routing.module';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { AboutComponent } from './about/about.component';
import { ServiceComponent } from './service/service.component';
import { ProduitComponent } from './produit/produit.component';
import { FilialeComponent } from './filiale/filiale.component';
import { ContactComponent } from './contact/contact.component';
import { GeneralComponent } from './general/general.component';
import { CatalogueComponent } from './catalogue/catalogue.component';


@NgModule({
  declarations: [
    HeaderComponent,
    FooterComponent,
    AboutComponent,
    ServiceComponent,
    ProduitComponent,
    FilialeComponent,
    ContactComponent,
    GeneralComponent,
    CatalogueComponent
  ],
  imports: [
    CommonModule,
    WebRoutingModule
  ]
})
export class WebModule { }
