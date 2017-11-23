package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Kleinclaus Florent on 22/11/2017.
 */

public class authentification extends AppCompatActivity {

    final String EXTRA_CIV = "user_civ";
    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";
    final String EXTRA_DATEN = "user_dateN";
    final String EXTRA_MAIL = "user_mail";
    final String EXTRA_ADR = "user_adress";
    final String EXTRA_COM = "user_com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authentification);


        final RadioButton Mr = (RadioButton)findViewById(R.id.radioButton_Mr);
        final RadioButton MMe = (RadioButton)findViewById(R.id.radioButton_Mme);
        final EditText name = (EditText)findViewById(R.id.editText_Nom);
        final EditText fname = (EditText)findViewById(R.id.editText_Prenom);
        final EditText daten = (EditText)findViewById(R.id.editText_DateN);
        final EditText mail = (EditText)findViewById(R.id.editText_Mail);
        final EditText adr = (EditText)findViewById(R.id.editText_Adres);
        final EditText com = (EditText)findViewById(R.id.editText_Com);
        final Button ButtonAuthen =(Button)findViewById(R.id.button_Val);

        ButtonAuthen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentAuthen = new Intent(authentification.this,infos_ut.class);
                if (Mr.isChecked()) {
                    MonIntentAuthen.putExtra(EXTRA_CIV, Mr.getText().toString());
                } else {
                    MonIntentAuthen.putExtra(EXTRA_CIV, MMe.getText().toString());
                }

                MonIntentAuthen.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentAuthen.putExtra(EXTRA_FNAME, fname.getText().toString());
                MonIntentAuthen.putExtra(EXTRA_DATEN, daten.getText().toString());
                MonIntentAuthen.putExtra(EXTRA_MAIL, mail.getText().toString());
                MonIntentAuthen.putExtra(EXTRA_ADR, adr.getText().toString());
                MonIntentAuthen.putExtra(EXTRA_COM, com.getText().toString());
                startActivity(MonIntentAuthen);
            }
        });
    }
}
