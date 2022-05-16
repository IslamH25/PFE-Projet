import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Filiale } from '../models/filiale';

@Injectable({
  providedIn: 'root'
})
export class FilialeService {


  listData !: Filiale[];
  constructor( private http:HttpClient) { }
  private baseUrl="http://localhost:8080/api/"
  getFilialeList(): Observable<Filiale[]>{
    return this.http.get<Filiale[]>(`${this.baseUrl}`+'filiales')
  }

  createFiliale(filiale: Filiale):Observable<Object>{
    return this.http.post<Filiale>(`${this.baseUrl}`+'filiales',filiale)
  }

  getFilialeById(id:number):Observable<Filiale>{
    return this.http.get<Filiale>(`${this.baseUrl}`+'filiales'+`/${id}`);
  }
  deleteFiliale(id:number):Observable<Object>{
   return this.http.delete(`${this.baseUrl}`+'filiales'+`/${id}`);
 }

  updateFiliale(id:number, filiale:Filiale):Observable<Object>{
    return this.http.put(`${this.baseUrl}`+'filiales'+`/${id}`,filiale)
  }
}
