package mastermime.cretecstudios.com.mastermime;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ActivityNewMatch extends AppCompatActivity {

    SeekBar turn, time;
    TextView turns, times;
    EditText equipe1, equipe2;
    Button ok, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_match);

        findMyViews();

    }

    public Long insertMatch() {

        double tu = 5.0 + (2 * turn.getProgress());
        double ti = 60.0 + (30 * time.getProgress());

        String team1 = equipe1.getText().toString();
        String team2 = equipe2.getText().toString();

        ObjectMatch match = new ObjectMatch();
        match.setTurns(tu);
        match.setTime(ti);
        match.setTeam1(team1);
        match.setTeam2(team2);
        match.setTurn(1.0);

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();

        daoSession.getObjectMatchDao().deleteAll();

        //TODO DANDO PAU NO INSERT FUCK!
        Long id = daoSession.getObjectMatchDao().insert(match);

        Toast toast = Toast.makeText(getApplicationContext(), "Partida Salva!", Toast.LENGTH_SHORT);
        toast.show();

        return id;

    }

    public void findMyViews() {

        ok = (Button) findViewById(R.id.bt_ok_match);
        cancel = (Button) findViewById(R.id.bt_cancel_match);

        equipe1 = (EditText) findViewById(R.id.edt_equipe1);
        equipe2 = (EditText) findViewById(R.id.edt_equipe2);

        turns = (TextView) findViewById(R.id.txt_turnos);
        times = (TextView) findViewById(R.id.txt_time);

        turn = (SeekBar) findViewById(R.id.sb_turns);
        time = (SeekBar) findViewById(R.id.sb_time);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (testaValores()) {



                    showActivityPlayRoom(insertMatch());

                }

            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        turn.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int turn_count = 5 + (2 * progress);

                turns.setText("Turnos: " + turn_count);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        time.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int time_count = 60 + (30 * progress);

                times.setText("Tempo da jogada: " + time_count + "s");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    //Abre a Tela de Informações
    public void showActivityPlayRoom(Long id) {

        Intent i = new Intent(ActivityNewMatch.this, ActivityPlayRoom.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        Bundle extras = new Bundle();
        extras.putLong("MATCH_ID", id);

        i.putExtras(extras);
        startActivity(i);

    }

    public boolean testaValores() {
        boolean test = true;

        if (equipe1.getText().toString().equals("")) {
            equipe1.setError("Digite o nome da Equipe 1!");
            test = false;
        }

        if (equipe2.getText().toString().equals("")) {
            equipe2.setError("Digite o nome da Equipe 2!");
            test = false;
        }

        return test;
    }

}



