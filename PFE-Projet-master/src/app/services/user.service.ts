
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User} from '../models/user';
import { FormGroup } from '@angular/forms';




@Injectable({
  providedIn: 'root'
})
export class UserService {


  private baseUrl1 = '/api/auth';
  islogin = false;
  admin = false;
  suser = false;
  choixmenu : string  = 'A';
  listData !: User[];
  public dataForm !:  FormGroup;
  constructor(private http: HttpClient) { }
  login(username:any, password:any) {
     return this.http.post(`${this.baseUrl1}`,{username, password});
   }


 private baseUrl="http://localhost:8090/api/"



 getUsersList(): Observable<User[]>{
   return this.http.get<User[]>(`${this.baseUrl}`+'users')
 }

 createUser(user: User):Observable<Object>{
   return this.http.post<User>(`${this.baseUrl}`+'users',user)
 }

 getUserById(id:number):Observable<User>{
   return this.http.get<User>(`${this.baseUrl}`+'users'+`/${id}`);
 }
 deleteUser(id:number):Observable<Object>{
  return this.http.delete(`${this.baseUrl}`+'users'+`/${id}`);
}

 updateUser(id:number, user:User):Observable<Object>{
   return this.http.put(`${this.baseUrl}`+'users'+`/${id}`,user)
 }
}
