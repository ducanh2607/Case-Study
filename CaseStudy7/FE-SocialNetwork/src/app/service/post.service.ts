import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {Observable} from "rxjs";
import {Post} from "../model/post";
import {ImagePost} from "../model/image-post";
import {TokenStorageService} from "./token-storage.service";
const API_URL = environment.apiUrl

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private httpClient: HttpClient,
              private tokenStorage: TokenStorageService) { }
  create(post: Post): Observable<any>{
    return this.httpClient.post(`${API_URL}/post/create`, post, this.tokenStorage.getHttpOption());
  }
  createImage(image: ImagePost[]): Observable<any>{
    return this.httpClient.post(`${API_URL}/post/create/img`, image, this.tokenStorage.getHttpOption())
  }
  findAllPostNewFeed(id: number): Observable<any>{
    return this.httpClient.get(`${API_URL}/post/all/new_feed/${id}`, this.tokenStorage.getHttpOption())
  }
  findAllImagePostByPostId(id:number): Observable<any>{
    return this.httpClient.get(`${API_URL}/post/img/${id}`, this.tokenStorage.getHttpOption())
  }
}
