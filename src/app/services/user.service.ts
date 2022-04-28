import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User} from '../model/user';
import { DatePipe } from '@angular/common';


@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl1 = '/api/auth';
  islogin = false;
  admin = false;
  suser = false;
  choixmenu : string  = 'A';
  listData : User[];
  public dataForm:  FormGroup;
  constructor(private http: HttpClient,private datePipe: DatePipe) { }
  login(username, password) {
     return this.http.post(`${this.baseUrl1}`,{username, password});
   }
}
