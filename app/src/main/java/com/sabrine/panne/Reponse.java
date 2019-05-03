package com.sabrine.panne;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Reponse extends AppCompatActivity {
TextView txtMsg,txtRep;
String msg,rep,idClient;
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
            idClient = data.getString("idClient");
            if (rep.equals("Pas encore")) {
                AlertDialog alertDialog = new AlertDialog.Builder(Reponse.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("Le depanneur pas encore repondre a votre message");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                                Intent intent=new Intent(Reponse.this,ListReponse.class);
                                intent.putExtra("idClient",idClient);

                                startActivity(intent);
                                finish();
                            }
                        });
                alertDialog.show();
            }else {

            txtMsg.setText(msg);
            txtRep.setText(rep);

        }}

    }
}
