import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Users} from "../model/users";
import {UserService} from "../service/user.service";
import {AuthService} from "../service/auth.service";
import Swal from 'sweetalert2';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  formUser!: FormGroup;
  user!: Users;


  constructor(private router: Router,
              private userService: UserService,
              private authService: AuthService
  ) {
  }

  ngOnInit(): void {
    this.formUser = new FormGroup({
      id: new FormControl(''),
      name: new FormControl('', Validators.required),
      username: new FormControl('', Validators.required),
      password: new FormControl('', Validators.compose([Validators.required, Validators.minLength(6), Validators.maxLength(32)])),
      confirmPassword: new FormControl('', Validators.required),
      phone: new FormControl('', [Validators.required, Validators.pattern(/^0\d{8,9}$/)]),
      email: new FormControl('', [Validators.required, Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),
      gender: new FormControl(''),
      birthday: new FormControl(''),
      role: new FormGroup({
        id: new FormControl('')
      })

    })
  }

  register() {
    this.user = this.formUser.value;
    if (this.formUser.value.password != this.formUser.value.confirmPassword) {
      Swal.fire("Warning","Re-entered password is not the same, please re-enter", );
    } else {
      if (this.user.username == '' || this.user.username == null || this.user.password == '' || this.user.password == null || this.user.email == '' || this.user.email == null || this.user.phone == '' || this.user.phone == null || this.user.name == '' || this.user.name == null) {
        Swal.fire("Warning","Please enter enough information");
      } else{
        this.check(this.user.username, this.user.email, this.user.phone);
      }}
  }
  check(username : string, email: string, phone: string){
    this.userService.checkUsername(username).subscribe(data=>{
      this.userService.checkEmail(email).subscribe(data=>{
        this.userService.checkPhone(phone).subscribe(data=>{
          this.authService.register(this.user).subscribe(data=>{
            Swal.fire("Success","Register successfully, please login")
            setTimeout(() => {
              this.navigateLogin();
            }, 3000);
          })
        }, error => {
          Swal.fire('Warning', error.error)
        })
      }, error => {
        Swal.fire('Warning', error.error)
      })
    }, error => {
      Swal.fire('Warning', error.error)
    })
  }



  navigateLogin() {
    this.router.navigate([''])
  }

}
