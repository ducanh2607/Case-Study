package com.example.besocialnetwork.DTO;


public class UsersDTO {
    private Long id;
    private String name;
    private String username;
    private String avatar;
    private boolean status;



    public UsersDTO(Long id, String name, String username, String avatar, boolean status) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.avatar = avatar;
        this.status = status;
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
