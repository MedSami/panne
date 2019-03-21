package com.sabrine.panne.Api;

import com.sabrine.panne.model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    /*************** Envoyer Msg  *******************/
    @FormUrlEncoded
    @POST("EnvoyerMsg.php")
    Call<ResponseDataModel> EnvoyerMsg(
            @Field("idClient") String id_client,
            @Field("idDepanneur") String id_depanneur,
            @Field("msg") String msg
    );

}
