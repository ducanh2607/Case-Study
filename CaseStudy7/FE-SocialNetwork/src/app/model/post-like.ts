import {Users} from "./users";
import {Post} from "./post";

export interface PostLike {
  id?: number
  user?: Users
  post?: Post
}
