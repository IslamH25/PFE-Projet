import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Famille } from '../models/famille';

@Injectable({
  providedIn: 'root'
})
export class FamilleService {

  listData !: Famille[];
  constructor( private http:HttpClient) { }
  private baseUrl="http://localhost:8090/api/"
  getFamilleList(): Observable<Famille[]>{
    return this.http.get<Famille[]>(`${this.baseUrl}`+'familles')
  }

  createFamille(famille: Famille):Observable<Object>{
    return this.http.post<Famille>(`${this.baseUrl}`+'familles',famille)
  }

  getFamilleById(id:number):Observable<Famille>{
    return this.http.get<Famille>(`${this.baseUrl}`+'familles'+`/${id}`);
  }
  deleteFamille(id:number):Observable<Object>{
   return this.http.delete(`${this.baseUrl}`+'familles'+`/${id}`);
 }

  updateFamille(id:number, famille:Famille):Observable<Object>{
    return this.http.put(`${this.baseUrl}`+'familles'+`/${id}`,famille)
  }
}
