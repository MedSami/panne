package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sabrine.panne.Api.ApiRequest;
import com.sabrine.panne.Api.RetrofitService;
import com.sabrine.panne.model.ResponseDataModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsulterMessage extends AppCompatActivity {
TextView txtmsg,txtnomprenom;
EditText edtReponse;
Button btnReponse;
String NomPrenom,message,idMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulter_message);
    txtmsg=findViewById(R.id.txtMessage);
    txtnomprenom=findViewById(R.id.txtNomPrenom);
    edtReponse=findViewById(R.id.edtReponse);
    btnReponse=findViewById(R.id.btnReponse);
        Bundle data = getIntent().getExtras();
//nom msg id
        if (data != null) {
            idMessage = data.getString("id");
            message = data.getString("msg");
            NomPrenom = data.getString("nom");
            txtnomprenom.setText(NomPrenom);
            txtmsg.setText(message);
           // Toast.makeText(this, idMessage, Toast.LENGTH_SHORT).show();
        }

        btnReponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtReponse.getText().toString().equals("")){
                    Toast.makeText(ConsulterMessage.this, "Remplir champ Reponse SVP", Toast.LENGTH_SHORT).show();
                }else {
                    ApiRequest api = RetrofitService.getClient().create(ApiRequest.class);
                    Call<ResponseDataModel> reponse=api.reponse(idMessage,edtReponse.getText().toString());
                reponse.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                        Toast.makeText(ConsulterMessage.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(ConsulterMessage.this, "Problem Connexion", Toast.LENGTH_SHORT).show();
                    }
                });
                }
            }
        });



    }
}
