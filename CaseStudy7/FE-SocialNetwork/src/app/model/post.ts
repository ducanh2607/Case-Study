import {Users} from "./users";
import {PostStatus} from "./post-status";
import {LocalDateTime} from "@js-joda/core";

export interface Post {
  id?: number
  user?: Users
  content?: string
  creationTime?: LocalDateTime
  postStatus?: PostStatus
}

