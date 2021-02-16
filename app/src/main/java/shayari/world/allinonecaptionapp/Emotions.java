package shayari.world.allinonecaptionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

public class Emotions extends AppCompatActivity {

    PublisherInterstitialAd mPublisherInterstitialAd;

    CardView angry,annoyed,confuse,calm,foodie,hurt,shy,sleepy,sad,happy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_emotions );

        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

        //ads

        showAd ();

        mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());
        mPublisherInterstitialAd.show ();


        mPublisherInterstitialAd.setAdListener(new AdListener () {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());
            }

        });

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
                if(mPublisherInterstitialAd.isLoaded ())
                {
                    mPublisherInterstitialAd.show ();
                    mPublisherInterstitialAd.setAdListener ( new AdListener ()
                    {
                        @Override
                        public void onAdClosed() {
                            startActivity ( new Intent ( getApplicationContext (), angry.class ) );
                        }
                    });
                }
                else {
                    Intent intent = new Intent ( getApplicationContext (), angry.class );
                    startActivity ( intent );
                }
               // startActivity ( new Intent ( getApplicationContext (),angry.class ) );
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
                if(mPublisherInterstitialAd.isLoaded ())
                {
                    mPublisherInterstitialAd.show ();
                    mPublisherInterstitialAd.setAdListener ( new AdListener ()
                    {
                        @Override
                        public void onAdClosed() {
                            startActivity ( new Intent ( getApplicationContext (), calm.class ) );
                        }
                    });
                }
                else {
                    Intent intent = new Intent ( getApplicationContext (), calm.class );
                    startActivity ( intent );
                }
            }
        } );

        foodie.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(mPublisherInterstitialAd.isLoaded ())
                {
                    mPublisherInterstitialAd.show ();
                    mPublisherInterstitialAd.setAdListener ( new AdListener ()
                    {
                        @Override
                        public void onAdClosed() {
                            startActivity ( new Intent ( getApplicationContext (), foodie.class ) );
                        }
                    });
                }
                else {
                    Intent intent = new Intent ( getApplicationContext (), foodie.class );
                    startActivity ( intent );
                }
            }
        } );
        happy.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(mPublisherInterstitialAd.isLoaded ())
                {
                    mPublisherInterstitialAd.show ();
                    mPublisherInterstitialAd.setAdListener ( new AdListener ()
                    {
                        @Override
                        public void onAdClosed() {
                            startActivity ( new Intent ( getApplicationContext (), happy.class ) );
                        }
                    });
                }
                else {
                    Intent intent = new Intent ( getApplicationContext (), happy.class );
                    startActivity ( intent );
                }
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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId () == android.R.id.home)
        {
            finish ();
            return  true;
        }
        return super.onOptionsItemSelected ( item );
    }

    public void showAd()
    {
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId( getString ( R.string.admob_interstial_id ) );
        mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());
    }

    @Override
    public void onBackPressed() {
        if (mPublisherInterstitialAd.isLoaded()) {
            mPublisherInterstitialAd.show();
            mPublisherInterstitialAd.setAdListener(new AdListener () {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        }else{
            super.onBackPressed();
        }

    }



}
