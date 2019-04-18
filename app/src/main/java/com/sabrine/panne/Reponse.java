package com.sabrine.panne;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Reponse extends AppCompatActivity {
TextView txtMsg,txtRep;
String msg,rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reponse);
        txtMsg=findViewById(R.id.txtMsg);
        txtRep=findViewById(R.id.txtRep);

        Bundle data = getIntent().getExtras();

        if (data != null) {
            msg = data.getString("msg");
            rep = data.getString("rep");
txtMsg.setText(msg);
txtRep.setText(rep);
        }

    }
}
