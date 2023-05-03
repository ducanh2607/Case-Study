package com.example.besocialnetwork.security.jwt;


import org.springframework.security.core.GrantedAuthority;
import java.time.LocalDate;
import java.util.Collection;


public class JwtResponse {
    private String type = "Bearer";
    private String token;
    private Collection<? extends GrantedAuthority> roles;
    private Long id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private LocalDate birthday;
    private boolean status = true;
    private boolean active = true;
    private String gender;
    private Integer showFriend = 0;
    private Integer commentPermission = 0;
    private String avatar;
    private String address;
    private String hobby;

    public JwtResponse(String token, Long id, String username, String name, Collection<? extends GrantedAuthority> roles, String email, String phone, LocalDate birthday, boolean status, boolean active, String gender, Integer showFriend, Integer commentPermission, String avatar, String address, String hobby) {
        this.token = token;
        this.roles = roles;
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.birthday = birthday;
        this.status = status;
        this.active = active;
        this.gender = gender;
        this.showFriend = showFriend;
        this.commentPermission = commentPermission;
        this.avatar = avatar;
        this.address = address;
        this.hobby = hobby;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getShowFriend() {
        return showFriend;
    }

    public void setShowFriend(Integer showFriend) {
        this.showFriend = showFriend;
    }

    public Integer getCommentPermission() {
        return commentPermission;
    }

    public void setCommentPermission(Integer commentPermission) {
        this.commentPermission = commentPermission;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
