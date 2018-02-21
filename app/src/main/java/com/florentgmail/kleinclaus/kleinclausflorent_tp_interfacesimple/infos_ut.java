package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by Kleinclaus Florent on 22/11/2017.
 * BUT : Réaction au cliques bouton / remplissage de la page avec les infos utilisateurs ou infos par default
 * ENTREE : Les valeurs reçus de la vue précédente ou les cliques utilisateurs
 * Sortie : Page remplie avec info utilisateur / redirection vers la vue d'accueil ou la page des sports
 */

public class infos_ut extends AppCompatActivity {

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
        setContentView(R.layout.infos_ut);


        Intent MonIntentInfo_ut = getIntent();
        TextView civ = (TextView) findViewById((R.id.textView_Civ_IU));
        final TextView name = (TextView)findViewById(R.id.textView_Nom_IU);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_IU);
        TextView daten = (TextView)findViewById(R.id.textView_DateN_IU);
        TextView mail = (TextView)findViewById(R.id.textView_mail_IU);
        TextView adr = (TextView)findViewById(R.id.textView_Adres_IU);
        TextView com = (TextView)findViewById(R.id.textView_Com_IU);

        if (MonIntentInfo_ut != null) {
            civ.setText(MonIntentInfo_ut.getStringExtra(EXTRA_CIV));
            name.setText(MonIntentInfo_ut.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentInfo_ut.getStringExtra(EXTRA_FNAME));
            daten.setText(MonIntentInfo_ut.getStringExtra(EXTRA_DATEN));
            mail.setText(MonIntentInfo_ut.getStringExtra(EXTRA_MAIL));
            adr.setText(MonIntentInfo_ut.getStringExtra(EXTRA_ADR));
            com.setText(MonIntentInfo_ut.getStringExtra(EXTRA_COM));
        }

        final Button ButtonInfoUt =(Button)findViewById(R.id.button_Acc);

        ButtonInfoUt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentAcc = new Intent(infos_ut.this,MainActivity.class);

                startActivity(MonIntentAcc);
            }
        });

        final Button ButtonSportUT =(Button)findViewById(R.id.button_Sport);

        ButtonSportUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentSportUT = new Intent(infos_ut.this,sports.class);
                MonIntentSportUT.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentSportUT.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentSportUT);
            }
        });

    }
}
