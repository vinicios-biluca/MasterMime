package mastermime.cretecstudios.com.mastermime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ActivityPlayRoom extends AppCompatActivity {

    TextView name1, name2, turn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playroom);

        findMyViews();

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        Long id = (Long) extras.get("MATCH_ID");

        ObjectMatch match = getObjectMatch(id);

        name1.setText(match.getTeam1());
        name2.setText(match.getTeam2());
        turn.setText(String.valueOf(match.getTurn()));
    }

    public void findMyViews(){

        name1 = (TextView) findViewById(R.id.txt_name_equipe1);
        name2 = (TextView) findViewById(R.id.txt_name_equipe2);
        turn = (TextView) findViewById(R.id.txt_turno);


    }


    public ObjectMatch getObjectMatch(Long id){

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        return daoSession.getObjectMatchDao().load(id);

    }
}
