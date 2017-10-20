package com.example.cpu11112_local.testgithub.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.cpu11112_local.testgithub.vo.Contributor;
import com.example.cpu11112_local.testgithub.vo.Repo;
import com.example.cpu11112_local.testgithub.vo.RepoSearchResult;
import com.example.cpu11112_local.testgithub.vo.User;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
@Database(entities = {
        User.class,
        Repo.class,
        Contributor.class,
        RepoSearchResult.class
}, version = 3)
public abstract class GithubDb extends RoomDatabase {
    abstract public UserDao useDao();

    abstract public RepoDao repoDao();
}
