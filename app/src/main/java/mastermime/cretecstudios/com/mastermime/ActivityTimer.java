package mastermime.cretecstudios.com.mastermime;


import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.TextView;

import java.util.Random;

public class ActivityTimer extends AppCompatActivity {

    CountDownTimer cdt;

    TextView timer, timer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        findMyViews();

        final MediaPlayer timend = MediaPlayer.create(ActivityTimer.this, R.raw.time_sound);

        final int time_limit = 30000;

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

                time = (gerador.nextInt(99) + " " + gerador.nextInt(99) + " " + gerador.nextInt(99));

                timer2.setText(time);


            }


            @Override
            public void onFinish() {

                timer.setText("FIM");
                timer2.setText("00 00 00");
                timer.setTextColor(Color.RED);
                //timend.start();

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

    }

}
