import {Users} from "./users";
import {Post} from "./post";
import {LocalDateTime} from "@js-joda/core";

export interface PostComment {
  id: number
  users: Users
  post: Post
  content: string
  creationTime: LocalDateTime
}
