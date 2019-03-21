package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sabrine.panne.Api.ApiRequest;
import com.sabrine.panne.Api.RetrofitService;
import com.sabrine.panne.model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EnvoyerMsg extends AppCompatActivity {
String idClient,idDepanneur;
EditText edtMsg;
Button btnEnvoyer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_envoyer_msg);
        edtMsg=findViewById(R.id.edtMsg);
        btnEnvoyer=findViewById(R.id.btnEnvoyer);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            idClient = data.getString("idClient");
            idDepanneur = data.getString("idDepanneur");
        }

        btnEnvoyer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtMsg.getText().toString().equals("")){
                    Toast.makeText(EnvoyerMsg.this, "Remplir Chammp Message ", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
                    Call<ResponseDataModel> envoyerMsg=api.EnvoyerMsg(idClient,idDepanneur,edtMsg.getText().toString());

                    envoyerMsg.enqueue(new Callback<ResponseDataModel>() {
                        @Override
                        public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                            Toast.makeText(EnvoyerMsg.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                            Toast.makeText(EnvoyerMsg.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                        }
                    });

                }
            }
        });
    }
}
