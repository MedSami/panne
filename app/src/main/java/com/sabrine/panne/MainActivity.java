package com.sabrine.panne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.sabrine.panne.Api.ApiRequest;
import com.sabrine.panne.Api.RetrofitService;
import com.sabrine.panne.model.ResponseDataModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {
EditText edtIdentifiant,edtPassword;
Button btnEntrer,btnInscrire;
    private SharedPrefsActivity sessionManager;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtIdentifiant=findViewById(R.id.edtIdentifiant);
        edtPassword=findViewById(R.id.edtPassword);
        btnEntrer=findViewById(R.id.btnEntrer);
        btnInscrire=findViewById(R.id.btnInscrire);
        sessionManager = new SharedPrefsActivity(getApplicationContext());

        if (sessionManager.isUserLogin()) {
            Intent i = new Intent(this, MenuClients.class);
            i.putExtra("idClient",sessionManager.getSavedUserID());
            startActivity(i);
            finish();
        }


        btnInscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,Inscrire.class);
                startActivity(intent);
            }
        });

        btnEntrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtIdentifiant.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Sasir votre Identifiant SVP", Toast.LENGTH_SHORT).show();
                }else if(edtPassword.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this, "Saisir Mot De Passe SVP", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api= RetrofitService.getClient().create(ApiRequest.class);
                    //Instance Call Methode
                    Call<ResponseDataModel> Login=api.Login(edtIdentifiant.getText().toString(),""+index);
                    Login.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                            if(response.isSuccessful()){
                                if(!response.body().getResult().isEmpty()) {
                                    if (response.body().getResult().get(0).getIdentifiant().equals(edtIdentifiant.getText().toString())) {
                                        if (response.body().getResult().get(0).getMotDePasse().equals(edtPassword.getText().toString())) {

                                            sessionManager.setUserLoggedIn(true);
                                            sessionManager.setSavedIdName( response.body().getResult().get(0).getId());

                                                Intent intent = new Intent(MainActivity.this, MenuClients.class);
                                                intent.putExtra("idClient", "" + response.body().getResult().get(0).getId());
                                                startActivity(intent);
                                            finish();



                                        } else {
                                            Toast.makeText(MainActivity.this, "Mot De Passe Incorrect", Toast.LENGTH_SHORT).show();
                                        }
                                    } else {

                                        Toast.makeText(MainActivity.this, "Identifiant Incorrect", Toast.LENGTH_SHORT).show();

                                    }
                                }else {
                                    Toast.makeText(MainActivity.this, "Identifiant Incorrect", Toast.LENGTH_SHORT).show();

                                }
                            }else {
                                Toast.makeText(MainActivity.this, "Identifiant Incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                            Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
                }
            }
        });
    }


}
