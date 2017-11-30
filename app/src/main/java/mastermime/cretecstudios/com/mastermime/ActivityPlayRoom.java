package mastermime.cretecstudios.com.mastermime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityPlayRoom extends AppCompatActivity {

    TextView name1, name2, turn, points1, points2;
    Button play, minus1, plus1, minus2, plus2;

    double time, turns;

    int pts1, pts2;

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

        turn.setText("Play Room");

        points1.setText(String.valueOf((int) match.getPts_team1()));
        points2.setText(String.valueOf((int) match.getPts_team2()));

        time = match.getTime();
        turns = match.getTurns();

    }

    public void findMyViews() {

        name1 = (TextView) findViewById(R.id.txt_name_equipe1);
        name2 = (TextView) findViewById(R.id.txt_name_equipe2);
        turn = (TextView) findViewById(R.id.txt_turno);
        points1 = (TextView) findViewById(R.id.txt_points_equipe1);
        points2 = (TextView) findViewById(R.id.txt_points_equipe2);

        play = (Button) findViewById(R.id.bt_play_room);

        minus1 = (Button) findViewById(R.id.bt_equipe1_minus);
        plus1 = (Button) findViewById(R.id.bt_equipe1_plus);
        minus2 = (Button) findViewById(R.id.bt_equipe2_minus);
        plus2 = (Button) findViewById(R.id.bt_equipe2_plus);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGuessRoom();
            }
        });

        minus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pts1 > 0) {
                    pts1--;
                }

                setPts1(pts1);

            }
        });

        plus1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pts1 < 99) {
                    pts1++;
                }

                setPts1(pts1);

            }
        });

        minus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pts2 > 0) {
                    pts2--;
                }

                setPts2(pts2);

            }
        });

        plus2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (pts2 < 99) {
                    pts2++;
                }

                setPts2(pts2);

            }
        });


    }

    public void startGuessRoom() {

        Intent i = new Intent(ActivityPlayRoom.this, ActivityTimer.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

        Bundle extras = new Bundle();
        extras.putDouble("TIME", this.time);

        i.putExtras(extras);
        startActivity(i);

    }


    public ObjectMatch getObjectMatch(Long id) {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();
        return daoSession.getObjectMatchDao().load(id);

    }

    public void setPts1(int pt) {

        this.points1.setText("" + pt);

    }

    public void setPts2(int pt) {

        this.points2.setText("" + pt);

    }
}
