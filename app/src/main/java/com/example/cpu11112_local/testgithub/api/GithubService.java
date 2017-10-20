package com.example.cpu11112_local.testgithub.api;

import android.arch.lifecycle.LiveData;

import com.example.cpu11112_local.testgithub.vo.Contributor;
import com.example.cpu11112_local.testgithub.vo.Repo;
import com.example.cpu11112_local.testgithub.vo.User;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by CPU11112-local on 10/20/2017.
 */

public interface GithubService {
    @GET("users/{login}")
    LiveData<ApiResponse<User>> getUser(@Path("login") String login);

    @GET("users/{login}/repos")
    LiveData<ApiResponse<List<Repo>>> getRepos(@Path("login") String login);

    @GET("repos/{owner}/{name}")
    LiveData<ApiResponse<Repo>> getRepo(@Path("owner") String owner, @Path("name") String name);

    @GET("repos/{owner}/{name}/contributors")
    LiveData<ApiResponse<List<Contributor>>> getContributors(@Path("owner") String owner, @Path("name") String name);

    @GET("search/repositories")
    LiveData<ApiResponse<RepoSearchResponse>> searchRepos(@Query("q") String query);

    @GET("search/repositories")
    Call<RepoSearchResponse> searchRepos(@Query("q") String query, @Query("page") int page);
}
