import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import * as http from "http";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {TokenStorageService} from "./token-storage.service";
const API_URL = environment.apiUrl

@Injectable({
  providedIn: 'root'
})
export class PostStatusService {

  constructor(private httpClient: HttpClient,
              private tokenStorage: TokenStorageService) { }
  findAll(): Observable<any>{
    return this.httpClient.get(`${API_URL}/post_status/all`, this.tokenStorage.getHttpOption());
  }
  findById(id: number): Observable<any>{
    return this.httpClient.get(`${API_URL}/post_status/id/${id}`, this.tokenStorage.getHttpOption())
  }
}
