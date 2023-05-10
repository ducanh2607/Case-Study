import { Injectable } from '@angular/core';
import {Users} from "../model/users";
import {Router} from "@angular/router";
import {AuthService} from "./auth.service";
import {HttpHeaders} from "@angular/common/http";
const TOKEN_KEY = 'auth-token';
const USER_KEY = 'auth-user';


@Injectable({
  providedIn: 'root'
})
export class TokenStorageService {
  httpOptions: any;


  constructor(private router: Router,
              private auth: AuthService) {

  }
  getHttpOption(){
    return  this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' +  this.getUser().token
      })}
  }
  public signOut(){
    this.auth.logout(this.getUser().id).subscribe(data=>{
      window.localStorage.clear()
      window.sessionStorage.clear()
      this.router.navigate([''])
    })
  }
  public saveTokenLocal(token: string){
    window.localStorage.removeItem(TOKEN_KEY);
    window.localStorage.setItem(TOKEN_KEY, token);
  }
  public saveTokenSession(token: string){
    window.sessionStorage.removeItem(TOKEN_KEY);
    window.sessionStorage.setItem(TOKEN_KEY, token);
  }
  public getToken(): string {
    if(localStorage.getItem(TOKEN_KEY)!== null){
      // @ts-ignore
      return localStorage.getItem(TOKEN_KEY);
    }else{
      // @ts-ignore
      return sessionStorage.getItem(TOKEN_KEY);
    }
  }
  public saveUserLocal(user: Users){
    window.localStorage.removeItem(USER_KEY);
    window.localStorage.setItem(USER_KEY, JSON.stringify(user));
  }
  public saveUserSession(user: Users){
    window.sessionStorage.removeItem(USER_KEY);
    window.sessionStorage.setItem(USER_KEY, JSON.stringify(user));
  }
  public getUser() {
    if (localStorage.getItem(USER_KEY)!== null){
      // @ts-ignore
      return JSON.parse(localStorage.getItem(USER_KEY));
    }else{
      // @ts-ignore
      return JSON.parse(sessionStorage.getItem(USER_KEY));
    }
  }

}
