import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Users} from "../model/users";
const apiUrl=environment.apiUrl;
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient : HttpClient) { }
  findAll(): Observable<Users[]>{
    return this.httpClient.get<Users[]>(`${apiUrl}/users/all`);
  }
  checkUsername(username: String): Observable<any>{
    return this.httpClient.get<any>(`${apiUrl}/accounts/check/username/${username}`);
  }
  checkPhone(phone: String): Observable<any>{
    return this.httpClient.get<any>(`${apiUrl}/accounts/check/phone/${phone}`);
  }
  checkEmail(email: String): Observable<any>{
    return this.httpClient.get<any>(`${apiUrl}/accounts/check/email/${email}`);
  }
}
