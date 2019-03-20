package com.sabrine.panne.Api;

import com.sabrine.panne.model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {
    /******************** Authentification Login*******************/
    @GET("Login.php")
    Call<ResponseDataModel> Login(@Query("identifiant") String identifiant,
    @Query("type") String type
    );

    /******************** Authentification Login*******************/
    @GET("getDepanneurs.php")
    Call<ResponseDataModel> getDepanneurs();

}
