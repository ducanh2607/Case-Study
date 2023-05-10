import { Component, OnInit } from '@angular/core';
import {Users} from "../model/users";
import {FormControl, FormGroup} from "@angular/forms";
import {TokenStorageService} from "../service/token-storage.service";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth.service";
import Swal from "sweetalert2";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  user!: Users;
  formUser!: FormGroup;
  roles: string[]=[];
  username!:string;
  active!:boolean;


  constructor(private tokenStorageService: TokenStorageService,
              private router: Router,
              private authService: AuthService

              ) {
  }
  ngOnInit(): void{
    this.formUser = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    })
    if (this.tokenStorageService.getToken()){
      this.authService.isLoggedIn = true;
      this.roles = this.tokenStorageService.getUser().roles;
      this.username = this.tokenStorageService.getUser().username;
    }
  }
  onSubmit(){
    this.authService.login(this.formUser.value).subscribe(data=>{
      this.user= data
      if (this.user && !this.user.active){
        Swal.fire("Warning",'Account has been locked!');
      }else {
        this.tokenStorageService.saveTokenSession(data.accessToken);
        this.tokenStorageService.saveUserLocal(data);
        this.authService.isLoggedIn = true;
        this.formUser.reset();
        this.router.navigate(['home']);
      }
    },(error) => {
      this.authService.isLoggedIn = false;
      Swal.fire("Warning", "Incorrect username or password");
    })
  }
}
