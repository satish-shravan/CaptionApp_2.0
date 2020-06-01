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

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {




    private AdView mAdView,mAdView1;
    private PublisherInterstitialAd mPublisherInterstitialAd;


    CardView caption,hashtag,trending;
    CardView caption_of_day;
    TextView day_cap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );



        showAd ();

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

        }, 100, 250, TimeUnit.SECONDS );

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

        day_cap.setText ( "Keep smiling because life is a beautiful thing and there’s so much to smile about." );

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

        return super.onOptionsItemSelected ( item );
    }

    public void showAd()
    {
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId("ca-app-pub-8999624060144617/7469428731");

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
        builder.setNegativeButton("\uD83D\uDE4B\u200D♂️Follow Us ❣️     ",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                //dialog.cancel();
                Toast.makeText ( getApplicationContext (), "Follow us on Instagram", Toast.LENGTH_SHORT ).show ();
                Intent externalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/shayariworld88/"));
                startActivity(externalIntent);

            }
        });

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
