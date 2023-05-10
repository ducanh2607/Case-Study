import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Users} from "../model/users";
import {Observable} from "rxjs";
const apiUrl = environment.apiUrl
@Injectable({
  providedIn: 'root'
})
export class AuthService {
  httpOptions: any;
  isLoggedIn!: boolean;

  constructor(private http: HttpClient) {
    this.httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      'Access-Control-Allow-Origin': 'http://localhost:4200',
      'Access-Control-Allow-Methods': 'GET,PUT,POST,DELETE,PATCH,OPTIONS'
    }
  };
  login(user: Users): Observable<any>{
    return this.http.post(`${apiUrl}/accounts/login`, {
      username: user.username,
      password: user.password
    }, this.httpOptions);
  }
  register(user: Users): Observable<any>{
    return this.http.post(`${apiUrl}/accounts/register`, user);
  }
  logout(id: number): Observable<any>{
    // @ts-ignore
    return this.http.put(`${apiUrl}/accounts/logout/${id}`);
  }
}
