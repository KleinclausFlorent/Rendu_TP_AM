package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Interface : (convention Java mettre ici ses composants)
    private Button ButtonMain;
    private CheckBox CheckboxMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Récupérer données d'un table
        Resources maResource=getResources();
        final String[] monTableau= maResource.getStringArray(R.array.jour);
        Log.i("VALEUR TABLEAU ICI :",monTableau[0]);
        //Fin exemple

        CheckboxMain =(CheckBox)findViewById(R.id.checkBox_Main);
        ButtonMain =(Button)findViewById(R.id.button_Main);

        CheckboxMain.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(MainActivity.this, "J'ai checké ?"+CheckboxMain.isChecked(), Toast.LENGTH_SHORT).show();
            }
        });

        ButtonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentMain = new Intent(MainActivity.this,authentification.class);

                startActivity(MonIntentMain);
                //Affichage d'un toast (petit pastille contenant un message)
                Toast.makeText(MainActivity.this,"Valeur du tableau : "+ monTableau[0],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
