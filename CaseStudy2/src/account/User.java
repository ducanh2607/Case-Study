package account;

import java.io.Serializable;

public class User implements Serializable {
    public static Long NUMBER = Long.valueOf(0);

    private String userName;
    private String password;
    private String name;
    private String email;
    private String phone;
    private String role;
    private Long id;
    public User(){}
    public User(String userName, String password){
        this.id =  Long.valueOf(++NUMBER);
        this.role = "USER";
        this.userName = userName;
        this.password = password;
    }
    public String getUserName(){
        return userName;
    }
    public String getPassword(){
        return password;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getPhone(){
        return phone;
    }
    public String getRole(){
        return role;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }
    public void setRole(String role){
        this.role = role;
    }

    public Long getId() {
        return id;
    }



    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
