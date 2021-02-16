package shayari.world.allinonecaptionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class splash extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT =2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_splash );

        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        new Handler (  ).postDelayed ( new Runnable () {
            @Override
            public void run() {
                Intent intent = new Intent ( splash.this,MainActivity.class);
                startActivity ( intent );
                finish ();
            }
        },SPLASH_TIME_OUT );


    }
}
