import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../../services/user.service';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {
   id!:number
   user:any;


  constructor(private userService:UserService, private route:ActivatedRoute, private router:Router) {
    this.user = {
      username : '',
      password : '',
      role : ''
     }
  }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    console.log(this.id)
    this.userService.getUserById(this.id).subscribe(data=>{
      console.log(data)
      this.user=data;
    },
    error=>console.log(error)
    );
  }
  onSubmit(){
    this.userService.updateUser(this.id,this.user).subscribe(data=>{
    this.goToUserList();
    },
    error=>console.log(error))
  }
  goToUserList(){
    this.router.navigate(['/dashboard','userList'])
  }

}
