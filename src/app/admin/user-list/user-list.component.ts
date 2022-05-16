import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../../models/user';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users!:User[];

  constructor(private userService:UserService, private router:Router) {

  }

  ngOnInit(): void {
    this.getUsers();
  }
  private getUsers(){
    this.userService.getUsersList().subscribe(
      data=>{this.users=data;
      console.log(data)}
    )
  }
  updateUser(id:number){
    this.router.navigate(['/dashboard','update-users',`${id}`])
  }
  deleteUser(id:number){
    this.userService.deleteUser(id).subscribe(data=>{
      console.log(data);
      this.getUsers();
    })
  }
}
