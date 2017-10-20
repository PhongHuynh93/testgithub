package com.example.cpu11112_local.testgithub.db;

/**
 * Created by CPU11112-local on 10/20/2017.
 */

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.util.SparseIntArray;

import com.example.cpu11112_local.testgithub.vo.Contributor;
import com.example.cpu11112_local.testgithub.vo.Repo;
import com.example.cpu11112_local.testgithub.vo.RepoSearchResult;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Dao
public abstract class RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(Repo... repos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertContributor(List<Contributor> contributors);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insertRepos(List<Repo> repositions);

    // insert a data and return a int
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract long createRepoIfNotExists(Repo repo);

    @Query("SELECT * FROM Repo WHERE owner_login = :login AND name = :name")
    public abstract LiveData<Repo> load(String login, String name);
    
    // selected query with order
    @Query("SELECT login, avatarUrl, contributions FROM Contributor " +
            "WHERE repoName = :repoName AND repoOwner = :repoOwner ORDER BY contributions DESC")
    public abstract LiveData<List<Contributor>> loadContributor(String repoOwner, String repoName);
    
    @Query("SELECT * FROM Repo WHERE owner_login = :owner ORDER BY stars DESC")
    public abstract LiveData<List<Repo>> loadReposition();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract void insert(RepoSearchResult result);

    @Query("SELECT * FROM RepoSearchResult WHERE query = :query")
    public abstract LiveData<RepoSearchResult> load(String query);

    public LiveData<List<Repo>> loadOrdered(List<Integer> repoIds) {
        SparseIntArray order = new SparseIntArray();
        int index = 0;
        for (Integer repoId : repoIds) {
            order.put(repoId, index++);
        }
        return Transformations.map(loadById(repoIds), new Function<List<Repo>, List<Repo>>() {
            @Override
            public List<Repo> apply(List<Repo> repositories) {
                Collections.sort(repositories, new Comparator<Repo>() {
                    @Override
                    public int compare(Repo r1, Repo r2) {
                        int pos1 = order.get(r1.id);
                        int pos2 = order.get(r2.id);
                        return pos1 - pos2;
                    }
                });
                return repositories;
            }
        });
    }

    @Query("SELECT * FROM Repo WHERE id in (:repoIds)")
    public abstract LiveData<List<Repo>> loadById(List<Integer> repoIds);

    @Query("SELECT * FROM RepoSearchResult WHERE query = :query")
    public abstract RepoSearchResult findSearchResult(String query);

}
