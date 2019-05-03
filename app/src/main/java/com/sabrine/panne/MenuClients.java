package com.sabrine.panne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MenuClients extends AppCompatActivity {
Button btnReponse,btnEnvoyerMsg;
String idClient;
ImageView logout;

    private SharedPrefsActivity sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_clients);
        sessionManager = new SharedPrefsActivity(getApplicationContext());
        btnReponse=findViewById(R.id.btnReponse);
        btnEnvoyerMsg=findViewById(R.id.btnEnvoyerMsg);
        logout=findViewById(R.id.imageView2);

        Bundle data = getIntent().getExtras();
        if (data != null) {
            idClient = data.getString("idClient");

        }


        btnEnvoyerMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MenuClients.this,ListDepanneur.class);
                intent.putExtra("idClient",idClient);
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
       logout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               sessionManager.clearSession();
               Intent i=new Intent(MenuClients.this,MainActivity.class);
               startActivity(i);
           }
       });
    }
}
