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

    /*************** Inscrire  *******************/
    @FormUrlEncoded
    @POST("Inscrire.php")
    Call<ResponseDataModel> Inscrire(
            @Field("type") String type,
            @Field("nom") String nom,
            @Field("prenom") String prenom,
            @Field("numTel") String numTel,
            @Field("identifiant") String Identifiant,
            @Field("specialite") String specialite,
            @Field("adresse") String adresse,
            @Field("motdepasse") String motdepasse
    );
    /******************** Messages*******************/
    @GET("getMessages.php")
    Call<ResponseDataModel> getMessages(@Query("idDepanneur") String idDepanneur);
    /******************** Messages*******************/
    @GET("getReponse.php")
    Call<ResponseDataModel> getResponse(@Query("idClient") String idClient);
    /*************** Envoyer Reponse  *******************/

    @GET("reponseMessage.php")
    Call<ResponseDataModel> reponse(
            @Query("id") String id,
            @Query("reponse") String reponse
    );
}
