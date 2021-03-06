package com.example.cpu11112_local.testgithub.vo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;

import com.google.gson.annotations.SerializedName;

/**
 * Created by CPU11112-local on 10/20/2017.
 *  Using name/owner_login as primary key instead of id since name/owner_login is always available
 * vs id is not.
 * note - primaryKeys we can have both
 * index to increase the performance when searching
 * https://developer.android.com/reference/android/arch/persistence/room/Embedded.html
 * info - Embedded - Room will consider latitude and longitude as if they are fields of the Address class when mapping an SQLite row to Address.
 */
@Entity(indices = {@Index("id"), @Index("owner_login")},
primaryKeys = {"name", "owner_login"})
public class Repo {
    public static final int UNKNOWN_ID = -1;
    public final int id;
    @SerializedName("name")
    public final String name;
    @SerializedName("full_name")
    public final String fullName;
    @SerializedName("description")
    public final String description;
    @SerializedName("stargazers_count")
    public final int stars;
    @SerializedName("owner")
    // note - embedded with "owner" before other table
    @Embedded(prefix = "owner_")
    public final Owner owner;

    public Repo(int id, String name, String fullName, String description, Owner owner, int stars) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.owner = owner;
        this.stars = stars;
    }

    public static class Owner {
        @SerializedName("login")
        public final String login;
        @SerializedName("url")
        public final String url;

        public Owner(String login, String url) {
            this.login = login;
            this.url = url;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Owner owner = (Owner) o;

            if (login != null ? !login.equals(owner.login) : owner.login != null) {
                return false;
            }
            return url != null ? url.equals(owner.url) : owner.url == null;
        }

        @Override
        public int hashCode() {
            int result = login != null ? login.hashCode() : 0;
            result = 31 * result + (url != null ? url.hashCode() : 0);
            return result;
        }
    }
}
