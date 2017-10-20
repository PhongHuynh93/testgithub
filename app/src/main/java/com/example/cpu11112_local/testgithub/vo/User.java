package com.example.cpu11112_local.testgithub.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
// note - can put login here or above login field
@Entity(primaryKeys = "login", indices = {@Index("login")})
public class User {
    @SerializedName("login")
    public final String login;
    @SerializedName("avatar_url")
    public final String avatarUrl;
    @SerializedName("name")
    public final String name;
    @SerializedName("company")
    public final String company;
    @SerializedName("repos_url")
    public final String reposUrl;
    @SerializedName("blog")
    public final String blog;

    public User(String login, String avatarUrl, String name, String company,
                String reposUrl, String blog) {
        this.login = login;
        this.avatarUrl = avatarUrl;
        this.name = name;
        this.company = company;
        this.reposUrl = reposUrl;
        this.blog = blog;
    }
}
