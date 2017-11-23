package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kleinclaus Florent on 23/11/2017.
 */

public class football  extends AppCompatActivity {

    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.football);


        final Intent MonIntentFoot = getIntent();
        final TextView name = (TextView)findViewById(R.id.textView_Nom_Foot);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_Foot);


        if (MonIntentFoot!= null) {
            name.setText(MonIntentFoot.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentFoot.getStringExtra(EXTRA_FNAME));
        }

        final Button ButtonFootAccc =(Button)findViewById(R.id.button_Acc_Foot);

        ButtonFootAccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentFootAcc = new Intent(football.this,MainActivity.class);

                startActivity(MonIntentFootAcc);
            }
        });

        final Button ButtonFootSP =(Button)findViewById(R.id.button_Sports_Foot);

        ButtonFootSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentFootSP = new Intent(football.this,sports.class);
                MonIntentFootSP.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentFootSP.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentFootSP);
            }
        });
    }
}
