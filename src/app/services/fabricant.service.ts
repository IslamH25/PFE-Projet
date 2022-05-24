import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Fabricant } from '../models/fabricant';

@Injectable({
  providedIn: 'root'
})
export class FabricantService {

  listData !: Fabricant[];
  constructor( private http:HttpClient) { }
  private baseUrl="http://localhost:8080/api/"

  getFabricantList(): Observable<Fabricant[]>{
    return this.http.get<Fabricant[]>(`${this.baseUrl}`+'fabricants')
  }

  createFabricant(fabricant: Fabricant):Observable<Object>{
    return this.http.post<Fabricant>(`${this.baseUrl}`+'fabricants',fabricant)
  }

  getFabricantById(id:number):Observable<Fabricant>{
    return this.http.get<Fabricant>(`${this.baseUrl}`+'fabricants'+`/${id}`);
  }
  deleteFabricant(id:number):Observable<Object>{
   return this.http.delete(`${this.baseUrl}`+'fabricants'+`/${id}`);
 }

  updateFabricant(id:number, fabricant:Fabricant):Observable<Object>{
    return this.http.put(`${this.baseUrl}`+'fabricants'+`/${id}`,fabricant)
  }
}
