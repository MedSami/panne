package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class Inscrire extends AppCompatActivity {
    String client="0",depanneur="0";
    EditText edtNom,edtPrenom,edtNumTel,edtIdentifiant,edtPassword,edtAdresse;
    Spinner specialiter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscrire);
        edtNom=findViewById(R.id.edtNom);
        edtPrenom=findViewById(R.id.edtPrenom);
        edtNumTel=findViewById(R.id.edtNumTel);
        edtIdentifiant=findViewById(R.id.edtIdentifiant);
        edtPassword=findViewById(R.id.edtPassword);
        edtAdresse=findViewById(R.id.edtAdresse);
        Spinner spinner =  findViewById(R.id.spinner);


        // Spinner Drop down elements
        List<String> speciliters = new ArrayList<String>();
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
                //index= position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }

    public void RadioClient(View view) {
        client="1";
        depanneur="0";
    }

    public void RadioDepanneur(View view) {
        client="0";
        depanneur="1";
    }
}
