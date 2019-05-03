package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

public class Inscrire extends AppCompatActivity {
    String adr="",spec="",type="0";
    RadioButton c,d;
    EditText edtNom,edtPrenom,edtNumTel,edtIdentifiant,edtPassword,edtAdresse;
    Spinner spinner;
    Button btnInscire;
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);
        edtNom=findViewById(R.id.edtNom);
        edtPrenom=findViewById(R.id.edtPrenom);
        edtNumTel=findViewById(R.id.edtNumTel);
        c=findViewById(R.id.rdbClient);
        d=findViewById(R.id.rdbDepanneur);
        edtIdentifiant=findViewById(R.id.edtIdentifiant);
        edtPassword=findViewById(R.id.edtPassword);
        edtAdresse=findViewById(R.id.edtAdresse);
        btnInscire=findViewById(R.id.btnInscrire);
         spinner =  findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> speciliters = new ArrayList<String>();
        speciliters.add("Choisir Votre Specialite");
        speciliters.add("Plombier");
        speciliters.add("Mecancien");
        speciliters.add("mrameji");
        speciliters.add("najjar");


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, speciliters);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                index= position;
                spec = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnInscire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if(edtNom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Nom SVP ", Toast.LENGTH_SHORT).show();
            }else if (edtPrenom.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Prenom SVP", Toast.LENGTH_SHORT).show();
            }else if (edtNumTel.getText().toString().equals("") || edtNumTel.getText().toString().length()!=8){
                Toast.makeText(Inscrire.this, "Verifier Votre Num Tel", Toast.LENGTH_SHORT).show();
            }else if (edtIdentifiant.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Identifiant SVP", Toast.LENGTH_SHORT).show();
            }else if (edtPassword.getText().toString().equals("")){
                Toast.makeText(Inscrire.this, "Saisir Votre Mot De Passe", Toast.LENGTH_SHORT).show();
            }else if(!c.isChecked() && !d.isChecked()){
                Toast.makeText(Inscrire.this, "coché type client SVP", Toast.LENGTH_SHORT).show();
            }else if(d.isChecked() && (edtAdresse.getText().toString().equals(""))){
                Toast.makeText(Inscrire.this, "Saisir Votre Adresse SVP", Toast.LENGTH_SHORT).show();
            }else if(d.isChecked() && index ==0){
                Toast.makeText(Inscrire.this, "Choisir votre Specialite SVP", Toast.LENGTH_SHORT).show();
            }else {
                adr=edtAdresse.getText().toString();
                ApiRequest api= RetrofitService.getClient().create(ApiRequest.class);
                //Instance Call Methode
                Call<ResponseDataModel> inscrire=api.Inscrire(type,edtNom.getText().toString(),
                        edtPrenom.getText().toString(),
                        edtNumTel.getText().toString(),edtIdentifiant.getText().toString()
                        ,spec,adr,edtPassword.getText().toString());
                inscrire.enqueue(new Callback<ResponseDataModel>() {
                    @Override
                    public void onResponse(Call<ResponseDataModel> call, Response<ResponseDataModel> response) {
                        Toast.makeText(Inscrire.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<ResponseDataModel> call, Throwable t) {
                        Toast.makeText(Inscrire.this, "f : "+t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
            }
        });
    }



    public void RadioClient(View view) {

        type="1";
        edtAdresse.setVisibility(View.GONE);
        spinner.setVisibility(View.GONE);
    }

    public void RadioDepanneur(View view) {
        type="2";
        edtAdresse.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.VISIBLE);
    }
}
