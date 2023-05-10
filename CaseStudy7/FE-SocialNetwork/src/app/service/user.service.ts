import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import { map, filter  } from 'rxjs/operators';
import {Users} from "../model/users";
import {TokenStorageService} from "./token-storage.service";
const API_URL=environment.apiUrl;
@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient : HttpClient,
              private tokenStorage: TokenStorageService) { }
  findAll(): Observable<Users[]> {
    return this.httpClient.get(`${API_URL}/users/all`, this.tokenStorage.getHttpOption()).pipe(
      filter((response: any): response is Users[] => response instanceof Array),
      map((response: Users[]) => response),
    );
  }
  checkUsername(username: String): Observable<any>{
    return this.httpClient.get<any>(`${API_URL}/accounts/check/username/${username}`);
  }
  checkPhone(phone: String): Observable<any>{
    return this.httpClient.get<any>(`${API_URL}/accounts/check/phone/${phone}`);
  }
  checkEmail(email: String): Observable<any>{
    return this.httpClient.get<any>(`${API_URL}/accounts/check/email/${email}`);
  }
  findAllFriend(id: number): Observable<any>{
    return this.httpClient.get<any>(`${API_URL}/users/list-friend/${id}`, this.tokenStorage.getHttpOption());
  }
  countFriend(id: number): Observable<any>{
    return this.httpClient.get<any>(`${API_URL}/users/count-friend/${id}`, this.tokenStorage.getHttpOption());
  }
}
