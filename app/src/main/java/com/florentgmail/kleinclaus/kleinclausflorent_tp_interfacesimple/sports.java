package com.florentgmail.kleinclaus.kleinclausflorent_tp_interfacesimple;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Kleinclaus Florent on 23/11/2017.
 * But : Affichage de la liste des sports et réaction au clique sur les éléments de la liste de sports
 * Entree : Nom utilisateur et prenom / elements de ma view a remplir ou a surveiller
 * Sortie : Réaction au clique sur la liste / boutons et affichage des infos utilisateurs
 */

public class sports extends AppCompatActivity {

    final String EXTRA_NAME = "user_name";
    final String EXTRA_FNAME = "user_Fname";

    final String EXTRA_SNAME = "sport_name";
    final int EXTRA_SICON = 0 ;
    final String EXTRA_SDEF = "sport_def";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sports_list);

        ArrayList<SportClass> sportList = new ArrayList<SportClass>();

        initList(sportList);

        final Intent MonIntentSports = getIntent();
        final TextView name = (TextView)findViewById(R.id.textView_Nom_Sports);
        final TextView fname = (TextView)findViewById(R.id.textView_Prenom_Sports);


        if (MonIntentSports!= null) {
            name.setText(MonIntentSports.getStringExtra(EXTRA_NAME));
            fname.setText(MonIntentSports.getStringExtra(EXTRA_FNAME));
        }

        SportAdapter adapter = new SportAdapter(getApplicationContext(),R.layout.sports, sportList);
        final ListView list = (ListView) findViewById(R.id.myList);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                Intent MonIntentSport = new Intent(sports.this,defSport.class);

                SportClass selectedItem = (SportClass) adapter.getItemAtPosition(position);
                MonIntentSport.putExtra(EXTRA_SNAME, selectedItem.getSportName());
                MonIntentSport.putExtra(String.valueOf(EXTRA_SICON), selectedItem.getImgRes());
                MonIntentSport.putExtra(EXTRA_SDEF, selectedItem.getSportDef());

                MonIntentSport.putExtra(EXTRA_NAME, name.getText().toString());
                MonIntentSport.putExtra(EXTRA_FNAME, fname.getText().toString());

                startActivity(MonIntentSport);
            }
        });




        final Button ButtonSportsAccc =(Button)findViewById(R.id.button_Acc_Sports);

        ButtonSportsAccc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent MonIntentSportsAcc = new Intent(sports.this,MainActivity.class);

                startActivity(MonIntentSportsAcc);
            }
        });



    }

    /*
    * But : Initialiser le tableau des sport
    * Entree : Le tableau des sport / ( les valeurs proviennent de la page string.xml
    * Sortie : Le tableau rempli avec les sports / leur définition et leur icone
     */

    private void initList(ArrayList<SportClass> sportList)
    {
        String name = getString(R.string.Hand);
        String def = getString(R.string.DefHand);

        SportClass sportHandball = new SportClass();
        sportHandball.setSportName(name);
        sportHandball.setSportDef(def);
        sportHandball.setImgRes(R.drawable.handball);
        sportList.add(sportHandball);

        name = getString(R.string.Foot);
        def = getString(R.string.DefFoot);

        SportClass sportFootball = new SportClass();
        sportFootball.setSportName(name);
        sportFootball.setSportDef(def);
        sportFootball.setImgRes(R.drawable.football);
        sportList.add(sportFootball);

        name = getString(R.string.Bask);
        def = getString(R.string.DefBask);

        SportClass sportBasketball = new SportClass();
        sportBasketball.setSportName(name);
        sportBasketball.setSportDef(def);
        sportBasketball.setImgRes(R.drawable.basket);
        sportList.add(sportBasketball);
    }
}
