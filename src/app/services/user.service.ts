import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { User} from '../models/user';
import { DatePipe } from '@angular/common';
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
  constructor(private http: HttpClient,private datePipe: DatePipe) { }
  login(username:any, password:any) {
     return this.http.post(`${this.baseUrl1}`,{username, password});
   }
}
