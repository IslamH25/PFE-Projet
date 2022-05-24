import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Service } from '../models/service';

@Injectable({
  providedIn: 'root'
})
export class ServiceService {

  listData !: Service[];
  constructor( private http:HttpClient) { }
  private baseUrl="http://localhost:8080/api/"

  getServiceList(): Observable<Service[]>{
    return this.http.get<Service[]>(`${this.baseUrl}`+'services')
  }

  createService(service: Service):Observable<Object>{
    return this.http.post<Service>(`${this.baseUrl}`+'services',service)
  }

  getServiceById(id:number):Observable<Service>{
    return this.http.get<Service>(`${this.baseUrl}`+'services'+`/${id}`);
  }
  deleteService(id:number):Observable<Object>{
   return this.http.delete(`${this.baseUrl}`+'services'+`/${id}`);
 }

  updateService(id:number, service:Service):Observable<Object>{
    return this.http.put(`${this.baseUrl}`+'services'+`/${id}`,service)
  }
}
