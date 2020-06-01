package shayari.world.allinonecaptionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Emotions extends AppCompatActivity {

    CardView angry,annoyed,confuse,calm,foodie,hurt,shy,sleepy,sad,happy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_emotions );

        angry = (CardView) findViewById ( R.id.angry );
        annoyed = (CardView) findViewById ( R.id.annoyed );
        confuse = (CardView) findViewById ( R.id.confused );
        calm = (CardView) findViewById ( R.id.calm );
        foodie = (CardView) findViewById ( R.id.foodie );
        hurt = (CardView) findViewById ( R.id.hurt );
        shy = (CardView) findViewById ( R.id.shy );
        sleepy = (CardView) findViewById ( R.id.sleepy );
        sad = (CardView) findViewById ( R.id.sad );
        happy = (CardView) findViewById ( R.id.happy );

        angry.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),angry.class ) );
            }
        } );


        annoyed.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),annoyed.class ) );
            }
        } );

        confuse.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),confused.class ) );
            }
        } );

        calm.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),calm.class ) );
            }
        } );

        foodie.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),foodie.class ) );
            }
        } );
        happy.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),happy.class ) );
            }
        } );

        hurt.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),hurt.class ) );
            }
        } );

        shy.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),shy.class ) );
            }
        } );

        sleepy.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),sleepy.class ) );
            }
        } );

        sad.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),sad.class ) );
            }
        } );








    }


}
