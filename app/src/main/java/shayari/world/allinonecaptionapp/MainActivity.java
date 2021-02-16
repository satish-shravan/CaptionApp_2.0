package shayari.world.allinonecaptionapp;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {




    private AdView mAdView,mAdView1;
    private PublisherInterstitialAd mPublisherInterstitialAd;


    CardView caption,hashtag,trending;
    CardView caption_of_day;
    TextView day_cap;

    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );


        showAd ();

        /*

        ScheduledExecutorService scheduledExecutorService =
                Executors.newSingleThreadScheduledExecutor ();
        scheduledExecutorService.scheduleAtFixedRate ( new Runnable () {
            @Override
            public void run() {
                runOnUiThread ( new Runnable () {
                    @Override
                    public void run() {
                        if (mPublisherInterstitialAd.isLoaded ()) {
                            mPublisherInterstitialAd.show ();
                        } else {
                            Log.d("TAG", "The interstitial wasn't loaded yet.");
                        }

                        showAd ();

                    }
                } );
            }

        }, 100, 150, TimeUnit.SECONDS );

         */

        mPublisherInterstitialAd.loadAd ( new PublisherAdRequest.Builder ().build () );
        mPublisherInterstitialAd.show ();

        mPublisherInterstitialAd.setAdListener(new AdListener () {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());
            }

        });



        caption_of_day = findViewById ( R.id.caption_of_day );
        day_cap = findViewById ( R.id.caption_day );

        final String[] arr = {"Quitter Never Win and Winners will never Quit.",

                "Men are born to succeed, not fail.",

                "Learn to wait. There’s always time for everything.",

                "Everything You need is already inside you, Get Started.",

                "If you woke up without a goal then go back to sleep.",

                "Accept the challenges so that you can feel the exhilaration of victory.",

                "I can. I will. End of story.",

                "One day all your hard work will pay off.",

                "The action is the foundational key to all success.",

                "No matter how down you are, always get up and give your best!🌸"

        };


       day_cap.post ( new Runnable () {
           int i=0;
           @Override
           public void run() {
               day_cap.setText ( arr[i] );
               i++;
               if(i==arr.length)
                   i=0;
               day_cap.postDelayed ( this,10000 );
           }
       } );

       /*
        caption_of_day.setOnClickListener ( new View.OnClickListener () {
            String text = day_cap.getText ().toString ();
            @Override
            public void onClick(View v) {

                ClipboardManager clipboardManager = (ClipboardManager)getApplicationContext ().getSystemService ( CLIPBOARD_SERVICE );
                ClipData clipData = ClipData.newPlainText ( "text",text );
                clipboardManager.setPrimaryClip ( clipData );

                Toast.makeText ( MainActivity.this, "Caption Copied !", Toast.LENGTH_SHORT ).show ();


               // Intent intent = new Intent ( getApplicationContext (),Upload_data.class );
                //startActivity ( intent );

            }
        } );

        */


        caption = findViewById ( R.id.caption );
        hashtag = findViewById ( R.id.hashtag );
        trending = findViewById ( R.id.trending );

        caption.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (), Caption.class ) );
            }
        } );

        hashtag.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),Hashtag.class ) );
            }
        } );


        trending.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                startActivity ( new Intent ( getApplicationContext (),Treading.class ) );
            }
        } );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater ().inflate ( R.menu.menu_main, menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Toast.makeText ( this, "About Us ! ", Toast.LENGTH_SHORT ).show ();
            startActivity ( new Intent ( getApplicationContext (),AboutUs.class ) );
            return true;
        }
        else if(id==R.id.Followus)
        {
            Toast.makeText ( this, "Follow Us !", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( Intent.ACTION_VIEW,Uri.parse ( "https://www.instagram.com/shayariworld88/" ) );
            startActivity ( intent );
            return true;
        }
        else if(id==R.id.moreapp)
        {
            Toast.makeText ( this, "More Apps on Play Store", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( Intent.ACTION_VIEW,Uri.parse ( "https://play.google.com/store/apps/dev?id=6075959649166349332&hl=en" ) );
            startActivity ( intent );
            return  true;
        }
        else if(id==R.id.rateus)
        {
            Toast.makeText ( this, "Rate App 5 \uD83C\uDF1F", Toast.LENGTH_SHORT ).show ();
            Intent intent = new Intent ( Intent.ACTION_VIEW,Uri.parse ( "https://play.google.com/store/apps/details?id=shayari.world.allinonecaptionapp&hl=en" ) );
            startActivity ( intent );
            return true;
        }

        return super.onOptionsItemSelected ( item );
    }

    public void showAd()
    {
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId(getString ( R.string.admob_interstial_id ));
        mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());
    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        final  View custom = getLayoutInflater ().inflate ( R.layout.exit_alert,null );
        builder.setView ( custom );

        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
            }
        });
        /*
        builder.setNegativeButton("\uD83D\uDE4B\u200D♂️Follow Us ❣️",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                //dialog.cancel();
                Toast.makeText ( getApplicationContext (), "Follow us on Instagram", Toast.LENGTH_SHORT ).show ();
                Intent externalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/shayariworld88/"));
                startActivity(externalIntent);

            }
        });

         */

        builder.setNeutralButton ( "RATE US 5\uD83C\uDF1F", new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent ( Intent.ACTION_VIEW, Uri.parse ( "https://play.google.com/store/apps/details?id=shayari.world.allinonecaptionapp&hl=en" ) );
                startActivity ( intent );
            }
        } );
        AlertDialog alert=builder.create();
        alert.show();
    }
}
