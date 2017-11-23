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

public class handball  extends AppCompatActivity {

    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.handball);


        final Intent MonIntentHand = getIntent();
        final TextView name = (TextView)findViewById(R.id.textView_Nom_Hand);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_Hand);


        if (MonIntentHand!= null) {
            name.setText(MonIntentHand.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentHand.getStringExtra(EXTRA_FNAME));
        }

        final Button ButtonHandAccc =(Button)findViewById(R.id.button_Acc_Hand);

        ButtonHandAccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentHandAcc = new Intent(handball.this,MainActivity.class);

                startActivity(MonIntentHandAcc);
            }
        });

        final Button ButtonHandSP =(Button)findViewById(R.id.button_Sports_Hand);

        ButtonHandSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentHandSP = new Intent(handball.this,sports.class);
                MonIntentHandSP.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentHandSP.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentHandSP);
            }
        });
    }
}
