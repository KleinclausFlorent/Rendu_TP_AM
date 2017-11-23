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

public class basketball  extends AppCompatActivity {

    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basketball);


        final Intent MonIntentBasket = getIntent();
        final TextView name = (TextView)findViewById(R.id.textView_Nom_Basket);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_Basket);


        if (MonIntentBasket!= null) {
            name.setText(MonIntentBasket.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentBasket.getStringExtra(EXTRA_FNAME));
        }

        final Button ButtonBasketAccc =(Button)findViewById(R.id.button_Acc_Basket);

        ButtonBasketAccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentBasketAcc = new Intent(basketball.this,MainActivity.class);

                startActivity(MonIntentBasketAcc);
            }
        });

        final Button ButtonBasketSP =(Button)findViewById(R.id.button_Sports_Basket);

        ButtonBasketSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentBasketSP = new Intent(basketball.this,sports.class);
                MonIntentBasketSP.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentBasketSP.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentBasketSP);
            }
        });


    }
}
