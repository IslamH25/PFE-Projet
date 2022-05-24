import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Produit } from '../models/produits';

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  listData !: Produit[];
  constructor( private http:HttpClient) { }
  private baseUrl="http://localhost:8080/api/"
  getProduitList(): Observable<any>{
    return this.http.get(`${this.baseUrl}`+'produits')
  }

  createProduit(produit: Produit):Observable<Object>{
    return this.http.post<Produit>(`${this.baseUrl}`+'produits',produit)
  }

  getProduitById(id:number):Observable<Produit>{
    return this.http.get<Produit>(`${this.baseUrl}`+'produits'+`/${id}`);
  }
  deleteProduit(id:number):Observable<Object>{
   return this.http.delete(`${this.baseUrl}`+'produits'+`/${id}`);
 }

  updateProduit(id:number, produit:Produit):Observable<Object>{
    return this.http.put(`${this.baseUrl}`+'produits'+`/${id}`,produit)
  }
}
