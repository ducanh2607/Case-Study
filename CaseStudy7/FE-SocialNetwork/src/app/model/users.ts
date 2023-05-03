import {Role} from "./role";

export interface Users {
  id?: number
  username?: string
  password?: string
  name?: string
  email?: string
  phone?: string
  gender?: string
  birthday?: string
  status: boolean
  active?: true
  showFriend: 0
  avatar?: string
  commentPermission: 0
  address?: string
  hobby?: string
  roles : Role[]

}
