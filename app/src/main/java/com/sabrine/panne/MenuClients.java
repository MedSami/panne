package com.sabrine.panne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuClients extends AppCompatActivity {
Button btnReponse,btnListDepanneur,btnEnvoyerMsg;
String idClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clients);

        btnReponse=findViewById(R.id.btnReponse);
        btnListDepanneur=findViewById(R.id.btnConsulterDepanneur);
        btnEnvoyerMsg=findViewById(R.id.btnEnvoyerMsg);
        Bundle data = getIntent().getExtras();
        if (data != null) {
            idClient = data.getString("idClient");

        }
        btnListDepanneur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MenuClients.this,ListDepanneur.class);
                intent.putExtra("idClient",idClient);
                intent.putExtra("btnClicked","list");
                startActivity(intent);
            }
        });

        btnEnvoyerMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MenuClients.this,ListDepanneur.class);
                intent.putExtra("idClient",idClient);
                intent.putExtra("btnClicked","msg");
                startActivity(intent);
            }
        });
        btnReponse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MenuClients.this,ListReponse.class);
                intent.putExtra("idClient",idClient);
                intent.putExtra("btnClicked","msg");
                startActivity(intent);
            }
        });
    }
}
