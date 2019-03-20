package com.sabrine.panne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuClients extends AppCompatActivity {
Button btnGererProfil,btnListDepanneur,btnChercherDepanneur,btnEnvoyerMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clients);

        btnChercherDepanneur=findViewById(R.id.btnChercherDepanneur);
        btnGererProfil=findViewById(R.id.btnGererProfile);
        btnListDepanneur=findViewById(R.id.btnConsulterDepanneur);
        btnEnvoyerMsg=findViewById(R.id.btnEnvoyerMsg);

        btnListDepanneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MenuClients.this,ListDepanneur.class);
                startActivity(intent);
            }
        });
    }
}
