import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {

  user: any;

  constructor(private userService:UserService,private router:Router) {
    this.user = {
     username : '',
     password : '',
     role : ''
    }
   }

  ngOnInit(): void {
  }

  saveUser(){
    this.userService.createUser(this.user).subscribe(data =>{console.log(data);
      this.goToUserList();},
    error=>console.log(error))

  }

  goToUserList(){
    this.router.navigate(['/dashboard','userList'])
  }

  onSubmit(){
   console.log(this.user)
  this.saveUser(); }

}
