import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {TokenStorageService} from "../service/token-storage.service";
import {Users} from "../model/users";
import {UserService} from "../service/user.service";
import {FormControl, FormGroup} from "@angular/forms";
import {AngularFireStorage} from "@angular/fire/compat/storage";
import {PostStatusService} from "../service/post-status.service";
import {PostService} from "../service/post.service";
import {Post} from "../model/post";
import {PostStatus} from "../model/post-status";
import {ImagePost} from "../model/image-post";
import Swal from "sweetalert2";
import {finalize} from "rxjs";
import { LocalDateTime } from '@js-joda/core';
import {PostLike} from "../model/post-like";
import {PostComment} from "../model/post-comment";


@Component({
  selector: 'app-new-feed',
  templateUrl: './new-feed.component.html',
  styleUrls: ['./new-feed.component.css']
})
export class NewFeedComponent implements OnInit {
  listFriend: Users[] = []
  postStatus: PostStatus[] = []
  post!: Post
  listPost: Post[] = []
  formPost: FormGroup = new FormGroup({
    id: new FormControl(''),
    user: new FormGroup({
      id: new FormControl('')
    }),
    content: new FormControl(''),
    creationTime: new FormControl(''),
    postStatus: new FormGroup({
      id: new FormControl('1')
    })
  })
  postLike!: PostLike
  postComment!: PostComment
  imgSrc: string[] = []
  imageFiles: File[] = []
  listImgCreate: ImagePost[] = []
  user!: Users
  listLiked: any[]=[]
  formLike: FormGroup = new FormGroup({
    id: new FormControl(''),
    user: new FormGroup({
      id: new FormControl('')
    }),
    post: new FormGroup({
      id: new FormControl('')
    })
  })

  constructor(private router: Router,
              private tokenStorageService: TokenStorageService,
              private userService: UserService,
              private postStatusService: PostStatusService,
              private postService: PostService,
              private fireStorage: AngularFireStorage,
  ) {
  }

  ngOnInit() {
    this.findAllFriend(this.tokenStorageService.getUser().id)
    this.findPostStatus()
    this.user = this.tokenStorageService.getUser()
    this.findAllPostNewFeed(this.tokenStorageService.getUser().id)
  }


  findAllFriend(id: number) {
    this.userService.findAllFriend(id).subscribe(data => {
      this.listFriend = data

    })
  }
  findAllPostNewFeed(id: number){
    this.postService.findAllPostNewFeed(id).subscribe(data=>{
      this.listPost = data
      this.findImagesByPostId(this.listPost)
      this.findAllLikeByPost(this.listPost)
    })
  }


  createPost() {
    this.post = this.formPost.value
    // @ts-ignore
    this.post.user.id = this.user.id
    this.post.creationTime = LocalDateTime.now()
    this.postService.create(this.post).subscribe(data => {
      if(this.imageFiles.length == 0){
        this.formPost.reset();
        // @ts-ignore
        this.formPost.get("postStatus")?.get("id").setValue(1);
        Swal.fire("Success", "Create post successfully")
        document.getElementById("btn-close")?.click()
      }else{
        this.createPostImg(data)
      }
    })
  }


  createPostImg(post: Post) {
    const promises = [];
    for (let j = 0; j < this.imageFiles.length; j++) {
      const filePath = 'post/' + Date.now() + '_' + this.imageFiles[j].name;
      const fileRef = this.fireStorage.ref(filePath);
      const task = this.fireStorage.upload(filePath, this.imageFiles[j]);
      const promise = new Promise<void>((resolve) => {
        task.snapshotChanges().pipe(
          finalize(() => {
            fileRef.getDownloadURL().subscribe(url => {
              let imagePost: ImagePost = {
                post: post,
                img: url
              }
              this.listImgCreate.push(imagePost);
              resolve();
            });
          })
        ).subscribe();
      });
      promises.push(promise);
    }
    Promise.all(promises).then(() => {
      this.postService.createImage(this.listImgCreate).subscribe(data => {
        this.imgSrc = [];
        this.imageFiles = [];
        this.listImgCreate = [];
        this.formPost.reset();
        // @ts-ignore
        this.formPost.get("postStatus")?.get("id").setValue(1);
        Swal.fire("Success", "Create post successfully");
        document.getElementById("btn-close")?.click()
        this.findAllPostNewFeed(this.tokenStorageService.getUser().id)
      });
    });
  }


  submitImage(event: any) {
    const imageFile = event.target.files
    for (let i = 0; i < imageFile.length; i++) {
      this.imageFiles.push(imageFile[i])
      const reader = new FileReader()
      reader.onload = (e: any) => {
        this.imgSrc.push(e.target.result)
      }
      reader.readAsDataURL(imageFile[i])
    }
  }

  findPostStatus() {
    this.postStatusService.findAll().subscribe(data => {
      this.postStatus = data
    })
  }

  deleteImgCreate(id: any | undefined) {
    this.imgSrc.splice(id, 1)
    let a: any[] = []
    for (let j = 0; j < this.imageFiles.length; j++) {
      if (j != id) {
        a.push(this.imageFiles[j])
      }
    }
    this.imageFiles = a
  }
  logOut(){
    this.tokenStorageService.signOut()
  }
  listImg: any[]=[]
  findImagesByPostId(posts: Post[]) {
    const promises: Promise<ImagePost[]>[] = [];
    for (let i = 0; i < posts.length; i++) {
      // @ts-ignore
      const promise = this.postService.findAllImagePostByPostId(posts[i].id).toPromise();
      promises.push(promise);
    }
    return Promise.all(promises).then(imagePosts => {

      for (let i = 0; i < imagePosts.length; i++) {
        this.listImg[i] = [];
        for (let j = 0; j < imagePosts[i].length; j++) {
          if (imagePosts[i][j] !== undefined) {
            let imageObject1 = {
              image: imagePosts[i][j].img,
              thumbImage: imagePosts[i][j].img
            };
            this.listImg[i].push(imageObject1);
          }
        }
      }
    });
  }
  findAllLikeByPost(posts : Post[]){
    const promises: Promise<PostLike[]>[] = [];
    for (let i = 0; i < posts.length; i++) {
      // @ts-ignore
      const promise = this.postService.findLikeByPost(posts[i].id).toPromise();
      promises.push(promise);
    }
    return Promise.all(promises).then(postLike => {
      for (let i = 0; i < postLike.length; i++) {
        this.listLiked[i] = [];
        for (let j = 0; j < postLike[i].length; j++) {
          if (postLike[i][j] !== undefined) {
            this.listLiked[i].push(postLike[i][j]);
          }
        }
      }
    });
  }

  likePost(index:number, id: any){
    this.postLike = this.formLike.value
    // @ts-ignore
    this.postLike.user.id = this.tokenStorageService.getUser().id
    let postTest !: Post
    // @ts-ignore
    this.postLike.post.id = id
    let flag = true
    for (let i = 0; i < this.listLiked[index].length; i++) {
      // @ts-ignore
      if(this.postLike.user.id == this.listLiked[index][i].user.id && this.postLike.post.id == this.listLiked[index][i].post.id){
        flag = false
       break;
      }
    }
    if (!flag){
      // @ts-ignore
      this.postService.deletePostLikeByUserAndPost(this.postLike.user.id, this.postLike.post.id).subscribe(()=>{
      })
    }else {
      this.postService.likePost(this.postLike).subscribe(()=>{
      })
    }
    this.ngOnInit()
  }
  showLike = ''
  liked(postLike: PostLike[]){

    let flag = false
    for (let i = 0; i < postLike.length; i++) {
      // @ts-ignore
      if (postLike[i].user.id == this.user.id){
        flag = true
        break
      }
    }
    return flag
  }


  click(){
    console.log(this.listLiked)
  }
}
