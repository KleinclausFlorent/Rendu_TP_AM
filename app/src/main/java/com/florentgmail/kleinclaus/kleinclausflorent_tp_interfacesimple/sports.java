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

public class sports extends AppCompatActivity {

    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports);


        final Intent MonIntentSports = getIntent();
        final TextView name = (TextView)findViewById(R.id.textView_Nom_Sports);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_Sports);


        if (MonIntentSports!= null) {
            name.setText(MonIntentSports.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentSports.getStringExtra(EXTRA_FNAME));
        }

        final Button ButtonSportsAccc =(Button)findViewById(R.id.button_Acc_Sports);

        ButtonSportsAccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentSportsAcc = new Intent(sports.this,MainActivity.class);

                startActivity(MonIntentSportsAcc);
            }
        });

        final Button ButtonSpFoot =(Button)findViewById(R.id.button_Foot);

        ButtonSpFoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentSpfoot = new Intent(sports.this,football.class);
                MonIntentSpfoot.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentSpfoot.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentSpfoot);
            }
        });
        final Button ButtonSpHand =(Button)findViewById(R.id.button_Hand);

        ButtonSpHand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentSpHand = new Intent(sports.this, handball.class);
                MonIntentSpHand.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentSpHand.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentSpHand);
            }
        });
        final Button ButtonSpBasket =(Button)findViewById(R.id.button_Basket);

        ButtonSpBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentSpBasket = new Intent(sports.this,basketball.class);
                MonIntentSpBasket.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentSpBasket.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentSpBasket);
            }
        });
    }
}
