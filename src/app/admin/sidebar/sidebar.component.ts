import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor( private tokenStorage: TokenStorageService, private router:Router) { }

  isLoggedIn = false;
  username!: string;
  roles!:any[]

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorage.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorage.getUser();
      this.username = user.username;
      this.roles=user.roles
      console.log(this.roles)

    }

  }

  logout(): void {
    this.tokenStorage.signOut();
    this.router.navigate(['/admin']);
  }
}
