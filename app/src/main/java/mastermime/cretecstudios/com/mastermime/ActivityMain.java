package mastermime.cretecstudios.com.mastermime;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;

public class ActivityMain extends AppCompatActivity {


    Button play, words, info, quit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findMyViews();

        //Cria as pastas necessárias
        createEnvironment();

        //Carrega o Set de Palavras
        loadSetWords();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showGameActivity();

            }
        });

        words.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showActivityWords();

            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showActivityInfo();

            }
        });

        quit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quitApplication();

            }
        });


    }

    public void findMyViews() {

        //Fonte customizada
        Typeface myFont = Typeface.createFromAsset(getAssets(), "myfont.otf");

        play = (Button) findViewById(R.id.bt_main_play);
        play.setTypeface(myFont);
        words = (Button) findViewById(R.id.bt_main_words);
        words.setTypeface(myFont);
        info = (Button) findViewById(R.id.bt_main_info);
        info.setTypeface(myFont);
        quit = (Button) findViewById(R.id.bt_main_quit);
        quit.setTypeface(myFont);

    }

    public void createEnvironment() {

        HelperDataBase hdb = new HelperDataBase(getApplicationContext());

        String main_dir = hdb.main_folder;

        File main_folder = new File(main_dir);

        if (!main_folder.exists()) {

            main_folder.mkdir();

            Toast toast = Toast.makeText(getApplicationContext(), "Ambiente Configurado", Toast.LENGTH_SHORT);
            toast.show();

        }

    }

    public void loadSetWords(){

        HelperDataBase hdb = new HelperDataBase(getApplicationContext());
        SQLiteDatabase db = hdb.getWritableDatabase();

        Cursor c = db.query("word", new String[]{"word"}, null, null, null, null, null);

        if(c.getCount() < 1){

            hdb.loadSet(db);

        }

        db.close();
    }

    //Abre a Tela TODO.......
    public void showGameActivity() {

        Intent i = new Intent(ActivityMain.this, ActivityTeam.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

    //Abre a Tela de Palavras
    public void showActivityWords() {

        Intent i = new Intent(ActivityMain.this, ActivityWords.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

    //Abre a Tela de Informações
    public void showActivityInfo() {

        Intent i = new Intent(ActivityMain.this, ActivityInfo.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(i);

    }

    //Fecha o Aplicativo
    public void quitApplication() {

        ActivityMain.this.finish();

    }

}
