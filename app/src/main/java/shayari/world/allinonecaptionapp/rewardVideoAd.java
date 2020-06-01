package shayari.world.allinonecaptionapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class rewardVideoAd extends AppCompatActivity implements RewardedVideoAdListener {
    TextView show_text;
    Button showad,view_data;
    RewardedVideoAd mRewardedVideoAd;
    // test ads
     //String admob_app_id = "ca-app-pub-3940256099942544~3347511713";
     //String reward_video_id = "ca-app-pub-3940256099942544/5224354917";

    String admob_app_id = "ca-app-pub-8999624060144617~8061838568";
    String reward_video_id = "ca-app-pub-8999624060144617/8532206612";
    WebView webView;

    ImageView fitness,motivation,photo,cool,sorry,happy,trust,missyou,love;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_reward_video_ad );

        Toast.makeText ( this, "TURN ON MOBILE DATA", Toast.LENGTH_SHORT ).show ();

        webView = (WebView)findViewById ( R.id.webview );
        webView.loadUrl ( "file:///android_asset/gif_new.gif" );

        show_text=(TextView)findViewById ( R.id.show_text );
        showad=(Button)findViewById ( R.id.showad );
        view_data=(Button)findViewById ( R.id.view_data );



        //rewarded ads
        MobileAds.initialize(this, admob_app_id);
        // Use an activity context to get the rewarded video instance.
        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();

        view_data.setVisibility ( View.INVISIBLE );

        showad.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(mRewardedVideoAd.isLoaded ())
                {
                    mRewardedVideoAd.show ();
                }
                else
                {
                    Toast.makeText ( rewardVideoAd.this, "Ad is not loaded. Wait  a movement....", Toast.LENGTH_SHORT ).show ();
                }
            }
        } );

        view_data.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if(!(show_text.getText ().toString ().equals ( "Locked View" )))
                {
                    Intent intent = new Intent ( getApplicationContext (),Emotions.class );
                    startActivity ( intent );
                }
            }
        } );



    }

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd(reward_video_id,
                new AdRequest.Builder().build());
    }


    @Override
    public void onRewardedVideoAdLoaded() {

    }

    @Override
    public void onRewardedVideoAdOpened() {

    }

    @Override
    public void onRewardedVideoStarted() {

    }

    @Override
    public void onRewardedVideoAdClosed() {
        loadRewardedVideoAd ();
        showad.setText ( "Watch Ad to Unlock " );

    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
            show_text.setText ( "Wow  \u200B\uD83C\uDFC6\u200B\uD83C\uDFC1\u200B\uD83C\uDF89\u200B You Unlocked it." );
            view_data.setVisibility ( View.VISIBLE );
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {

    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
        loadRewardedVideoAd ();
        showad.setText ( "OOPS ! Poor network \uD83D\uDE08 , TRY LATER !!" );
    }

    @Override
    public void onRewardedVideoCompleted() {

    }
    @Override
    public void onResume() {
        mRewardedVideoAd.resume(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        mRewardedVideoAd.pause(this);
        super.onPause();
    }

    @Override
    public void onDestroy() {
        mRewardedVideoAd.destroy(this);
        super.onDestroy();
    }
}
