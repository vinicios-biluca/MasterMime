package mastermime.cretecstudios.com.mastermime;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ActivitySplash extends AppCompatActivity {

    //Tempo de Delay da Tela de Splash
    //int DELAY = 4035;
    int DELAY = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Toca a Intro Sound
        MediaPlayer intro = MediaPlayer.create(ActivitySplash.this, R.raw.intro_sound);
       ///////////////// intro.start();

        StartAnimations();

    }

    //Método que faz as animações
    private void StartAnimations() {
        //Declaração da Animação de Fade in (alpha)
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.alpha);
        animation.reset();

        LinearLayout linear_splash = (LinearLayout) findViewById(R.id.lin_splash);

        if (linear_splash != null) {
            linear_splash.clearAnimation();
            linear_splash.startAnimation(animation);
        }

        //Declaração da Animação de Translado
        animation = AnimationUtils.loadAnimation(this, R.anim.tranlate_mime);
        animation.reset();

        ImageView mime = (ImageView) findViewById(R.id.img_splash);

        if (mime != null) {
            mime.clearAnimation();
            mime.startAnimation(animation);
        }

        animation = AnimationUtils.loadAnimation(this, R.anim.tranlate_logo);
        animation.reset();

        ImageView cretec = (ImageView) findViewById(R.id.img_cretec);

        if (cretec != null) {
            cretec.clearAnimation();
            cretec.startAnimation(animation);
        }

        //Chamada do Delay!
        delaySplash();

    }

    //Método que trata o delay da Tela Splash
    public void delaySplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //Abre a Tela principal
                Intent intent = new Intent(ActivitySplash.this, ActivityMain.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                ActivitySplash.this.finish();


            }
        }, DELAY);



    }


}
