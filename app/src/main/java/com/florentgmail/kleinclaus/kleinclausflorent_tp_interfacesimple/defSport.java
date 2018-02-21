package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kleinclaus Florent on 23/11/2017.
 * But : Page définition des sports / Utilise les extra pour afficher l'icone, la définition et le nom du sport / affiche aussi le nom et prénom de l'utilisateur
 * Réagi au clique bouton home / clique bouton retour à la page des sports
 * Entrée : elements de ma view a remplir ou a surveiller/ Les variables provenant de la page des sports et les cliques utilisateur
 * Sortie : La page associé au sport / La redirection en fonction du bouton cliqué
 */

public class defSport extends AppCompatActivity {

    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";

    final String EXTRA_SNAME = "sport_name";
    final int EXTRA_SICON = 0;
    final String EXTRA_SDEF = "sport_def";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.defsport);


        final Intent MonIntentSport = getIntent();
        final TextView name = (TextView)findViewById(R.id.textView_Nom_Foot);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_Foot);
        final TextView sname = (TextView) findViewById(R.id.textView_Sports_Title);
        final TextView sdef = (TextView) findViewById(R.id.textView_DefSport);
        final ImageView sicon = (ImageView) findViewById(R.id.imageView_IconSport);


        if (MonIntentSport!= null) {
            name.setText(MonIntentSport.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentSport.getStringExtra(EXTRA_FNAME));
            sname.setText(MonIntentSport.getStringExtra(EXTRA_SNAME));
            sdef.setText(MonIntentSport.getStringExtra(EXTRA_SDEF));
            sicon.setImageResource(MonIntentSport.getIntExtra(String.valueOf(EXTRA_SICON),1));
        }

        final Button ButtonFootAccc =(Button)findViewById(R.id.button_Acc_Foot);

        ButtonFootAccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentFootAcc = new Intent(defSport.this,MainActivity.class);

                startActivity(MonIntentFootAcc);
            }
        });

        final Button ButtonFootSP =(Button)findViewById(R.id.button_Sports_Foot);

        ButtonFootSP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentFootSP = new Intent(defSport.this,sports.class);
                MonIntentFootSP.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentFootSP.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentFootSP);
            }
        });
    }
}
