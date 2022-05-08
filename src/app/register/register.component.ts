import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  signupForm = this.formBuilder.group({
    name: '',
    pass: ''
  });

  constructor(
    private formBuilder: FormBuilder,private authService: AuthService) { }


  ngOnInit(): void {
  }
  onSubmit(){
    this.authService.signUp(this.signupForm.value.name,this.signupForm.value.pass).subscribe(
      (data:any)=>{
        console.log('succes');
      },
      (error :any)=>{
        console.log('error');
      }
    )

  }
}
