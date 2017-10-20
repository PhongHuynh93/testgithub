package com.example.cpu11112_local.testgithub.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.Nullable;

import com.example.cpu11112_local.testgithub.db.GithubTypeConverters;

import java.util.List;

/**
 * Created by CPU11112-local on 10/20/2017.
 */
@Entity(primaryKeys = {"query"})
@TypeConverters(GithubTypeConverters.class)
public class RepoSearchResult {
    public final String query;
    // note - use custome type converter to convert string into list of int
    public final List<Integer> repoIds;
    public final int totalCount;
    @Nullable
    public final Integer next;

    public RepoSearchResult(String query, List<Integer> repoIds, int totalCount,
                            Integer next) {
        this.query = query;
        this.repoIds = repoIds;
        this.totalCount = totalCount;
        this.next = next;
    }
}
