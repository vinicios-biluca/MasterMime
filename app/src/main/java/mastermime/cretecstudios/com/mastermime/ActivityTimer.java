package mastermime.cretecstudios.com.mastermime;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ActivityTimer extends AppCompatActivity {

    CountDownTimer cdt;

    TextView timer, timer2;

    TextView word_label, tip_label;
    ImageView word_icon;

    Button acertei;

    ObjectWord word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        findMyViews();

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        double time = extras.getDouble("TIME");

        startFreezeTime(time);

    }

    public void startFreezeTime(final double main_time) {

        int time_limit = 3000;

        cdt = new CountDownTimer(time_limit, 1) {
            @Override
            public void onTick(long millisUntilFinished) {

                String time;
                long sec = millisUntilFinished;

                if (millisUntilFinished % 1000 == 0) {
                    sec = sec - 1000;
                }

                time = (sec / 1000 + " s");


                if (sec > 1000) {
                    timer.setText(time);
                    timer2.setText("");
                } else {
                    timer.setTextColor(Color.GREEN);
                    timer.setText("VAI");
                    timer2.setText("");
                }

                Random gerador = new Random();
                String crazy_word = "";

                tip_label.setText("Sorteando Palavra!");

                if ((sec % 3) == 0) {

                    for (int i = 0; i < 9; i++) {

                        crazy_word += ((char) (gerador.nextInt(25) + 97));

                    }

                    word_label.setText(crazy_word.toUpperCase());
                }


            }

            @Override
            public void onFinish() {

                word = getWordToGuess();
                word_label.setText(word.getWord());
                tip_label.setText(word.getTip());
                word_icon.setImageResource(word.getImage());

                timer.setTextColor(Color.BLACK);

                starMainTimer((int) main_time * 1000);


            }
        };

        cdt.start();


    }

    public void starMainTimer(int time_limit) {

        final MediaPlayer timend = MediaPlayer.create(ActivityTimer.this, R.raw.time_sound);

        cdt = new CountDownTimer(time_limit, 1) {
            @Override
            public void onTick(long millisUntilFinished) {

                String time;
                long sec = millisUntilFinished;

                if (millisUntilFinished % 1000 == 0) {
                    sec = sec - 1000;
                }

                time = (sec / 1000 + " s");

                timer.setText(time);

                Random gerador = new Random();

                time = (gerador.nextInt(99) + ":" + gerador.nextInt(99) + ":" + gerador.nextInt(99));

                timer2.setText(time);


            }


            @Override
            public void onFinish() {

                timer.setText("FIM");
                timer2.setText("00:00:00");
                timer.setTextColor(Color.RED);
                timend.start();

            }
        };

        cdt.start();

    }

    public void findMyViews() {

        //Fonte customizada
        Typeface myFont = Typeface.createFromAsset(getAssets(), "myfont.otf");

        timer = (TextView) findViewById(R.id.timer_text);
        timer.setTypeface(myFont);

        timer2 = (TextView) findViewById(R.id.timer_text2);
        timer2.setTypeface(myFont);

        word_label = (TextView) findViewById(R.id.timer_word);
        tip_label = (TextView) findViewById(R.id.timer_tip);
        word_icon = (ImageView) findViewById(R.id.timer_icon);

        acertei = (Button) findViewById(R.id.bt_acertei);

        acertei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cdt.cancel();

                finish();

            }
        });
    }

    public ObjectWord getWordToGuess() {

        DaoSession daoSession = ((AppORM) getApplication()).getDaoSession();
        List<ObjectWord> words = daoSession.getObjectWordDao().loadAll();

        int size = words.size();
        int key = getKey(size);

        boolean notFind = true;

        if (words.get(key).getStatus().equals("FREE")) {

            words.get(key).setStatus("BLOCK");
            daoSession.update(words.get(key));

            return words.get(key);
        } else {
            return getWordToGuess();
        }

    }

    public int getKey(int size) {
        Random gerador = new Random();
        return gerador.nextInt(size);
    }

}
