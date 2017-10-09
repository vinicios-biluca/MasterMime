package mastermime.cretecstudios.com.mastermime;


import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Chronometer;
import android.widget.TextView;

public class ActivityTimer extends AppCompatActivity {

    CountDownTimer cdt;

    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        findMyViews();

        final MediaPlayer timend = MediaPlayer.create(ActivityTimer.this, R.raw.time_sound);

        cdt = new CountDownTimer(30000,1000){
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(millisUntilFinished / 1000 + " s");
            }

            @Override
            public void onFinish() {

                timer.setText("FIM");
                timer.setTextColor(Color.RED);
                timend.start();

            }
        };

        cdt.start();

    }

    public void findMyViews(){

        //Fonte customizada
        Typeface myFont = Typeface.createFromAsset(getAssets(), "myfont.otf");

        timer = (TextView) findViewById(R.id.timer_text);
        timer.setTypeface(myFont);

    }

}
