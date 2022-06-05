
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fournisseur } from '../models/fournisseur';
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};
@Injectable({
  providedIn: 'root'
})
export class FournisseurService {
  listData !: Fournisseur[];
  constructor( private http:HttpClient) { }
  private baseUrl="http://localhost:8090/api/"
  getFournisseurList(): Observable<Fournisseur[]>{
    return this.http.get<Fournisseur[]>(`${this.baseUrl}`+'fournisseurs')
  }

  createFournisseur(fournisseur: Fournisseur):Observable<Object>{
    return this.http.post<Fournisseur>(`${this.baseUrl}`+'fournisseurs',fournisseur)
  }

  getFournisseurById(id:number):Observable<Fournisseur>{
    return this.http.get<Fournisseur>(`${this.baseUrl}`+'fournisseurs'+`/${id}`);
  }
  deleteFournisseur(id:number):Observable<Object>{
   return this.http.delete(`${this.baseUrl}`+'fournisseurs'+`/${id}`);
 }

  updateFournisseur(id:number, fournisseur:Fournisseur):Observable<Object>{
    return this.http.put(`${this.baseUrl}`+'fournisseurs'+`/${id}`,fournisseur)
  }
}
