package com.example.timequest;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InfoService {
    /**
    @GET("w/api.php")
    Call<Info> getInfo(@Query("format") String json,
                           @Query("action") String query,
                           @Query("prop") String extracts,
                           //@Query("redirects") int one,
                           @Query("titles") String Legionary);  **/
         /**
    Call<Info> getInfo(@Query("action") String query,
                         @Query("prop") String extracts,
                         @Query("format") String json,
                         @Query("exintro") String zero,
                         @Query("titles") String StackOverflow);
          **/
    //@GET("w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Legionary")
    //Call<Info> getInfo();

    //@GET("w/api.php?format=json&action=query&prop=extracts&exintro&explaintext")
    //Call<Info> getInfo(@Query("redirects") int redirect,@Query("titles") String civilisation);


    //@GET("jokes/random?category=dev")
    //Call<PageInfo> getInfo();

    //https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro&explaintext&redirects=1&titles=Legionary

    //http://en.wikipedia.org/w/api.php?action=query&prop=extracts&format=json&exintro=&titles=Legionary

}
