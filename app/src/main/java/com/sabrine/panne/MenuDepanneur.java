package com.sabrine.panne;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuDepanneur extends AppCompatActivity {
Button btnMsg;
String idDepanneur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_depanneur);

    btnMsg=findViewById(R.id.btnMsg);
        Bundle data = getIntent().getExtras();

        if (data != null) {
            idDepanneur= data.getString("idClient");

        }



    btnMsg.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(MenuDepanneur.this,ListMsg.class);
            i.putExtra("idClient",idDepanneur);
            startActivity(i);
        }
    });
    }
}
