package shayari.world.allinonecaptionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.ArrayList;

public class Hashtag extends AppCompatActivity {

    //ads
    private AdView mAdView, mAdView1;
    private PublisherInterstitialAd mPublisherInterstitialAd;

    insta_adapter insta_adapter;
    ArrayList<data> list;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_hashtag );

        //ads
        showAd ();


        AdView adView = new AdView ( this );
        // AdView adView1 = new AdView ( this );
        adView.setAdSize ( AdSize.BANNER );
        adView.setAdUnitId ( "ca-app-pub-8999624060144617/7678695184" );
        //adView1.setAdSize ( AdSize.BANNER );
        //adView1.setAdUnitId ( "ca-app-pub-3940256099942544/6300978111" );

        mAdView = (AdView) findViewById ( R.id.adView );
        // mAdView1 = (AdView) findViewById ( R.id.adView1 );

        AdRequest adRequest = new AdRequest.Builder ().build ();
        mAdView.loadAd ( adRequest );
//        mAdView1.loadAd ( adRequest );

        AdRequest adRequest1 = new AdRequest.Builder ().build ();





        recyclerView = findViewById ( R.id.recycler );
        recyclerView.setHasFixedSize ( true );

        layoutManager = new LinearLayoutManager ( this );
        recyclerView.setLayoutManager ( layoutManager );

        list = new ArrayList<data> (  );

        insta_adapter = new insta_adapter ( this,list );
        recyclerView.setAdapter ( insta_adapter );

        linearlist();

    }

    public  void linearlist()
    {


        list.add ( new data ( R.drawable.hashtag,"#photo #instadaily #lfl #music #cute #k #likeforlikeback #follows #life #following #happy #viral #likeme #art #style #sdv #explorepage #memes #model #s #follower #beauty #smile #likesforfollow #girl #chuvadeseguidores #explore #likelike #tiktok #selfie" ) );

        list.add ( new data ( R.drawable.hashtag,"#likes #like #follow #likeforlikes #love #instagood #l #instagram #followme #likeforlike #followforfollowback #likeforfollow #followers #f #instalike #photooftheday #followback #photography #likesforlikes #comment #followforfollow #bhfyp #picoftheday #fashion #liker #likesforlike #me #likeback #beautiful #bhfyp" ) );

        list.add ( new data ( R.drawable.hashtag,"Photo of the day\n"+"#photooftheday #photography #instagood #love #picoftheday #like #follow #photo #instagram #beautiful #nature #instadaily #fashion #photographer #happy #travel #art #followme #cute #instalike #style #me #ig #likes #likeforlikes #photoshoot #smile #naturephotography #travelphotography #bhfyp" ) );
        list.add ( new data ( R.drawable.hashtag,"#model #portrait #l #beauty #igers #life #fun #selfie #tbt #amazing #bestoftheday #instapic #landscape #canon #f #instamood #sunset #followforfollowback #india #instaphoto #food #lifestyle #bhfyp #summer #likeforlike #travelgram #friends #insta #photographylovers #sky" ) );
        list.add ( new data ( R.drawable.hashtag,"Style"+"\n"+"style #fashion #love #instagood #like #follow #photooftheday #photography #beautiful #ootd #model #beauty #art #instagram #picoftheday #moda #fashionblogger #instadaily #smile #girl #instafashion #cute #followme #me #happy #look #design #lifestyle #fashionista #bhfyp" ) );

        list.add ( new data ( R.drawable.hashtag,"#outfit #photo #selfie #instalike #makeup #l #stylish #fun #shopping #likeforlikes #streetstyle #hair #likes #fashionstyle #handmade #amazing #myself #mensfashion #luxury #summer #styleblogger #bhfyp #dress #nature #igers #travel #shoes #blogger #swag #outfitoftheday" ) );
        list.add ( new data ( R.drawable.hashtag,"#happy #love #instagood #like #photooftheday #smile #beautiful #cute #follow #fashion #picoftheday #instagram #fun #photography #me #life #followme #instadaily #girl #art #friends #style #nature #selfie #family #photo #instalike #happiness #travel #bhfyp" ) );
        list.add ( new data ( R.drawable.hashtag,"#likeforlikes #beauty #summer #lifestyle #motivation #l #music #fitness #myself #likes #amazing #model #food #goodvibes #f #bhfyp #instamood #makeup #followforfollowback #inspiration #party #likeforlike #igers #insta #funny #repost #sun #baby #bestoftheday #quotes" ) );

        list.add ( new data ( R.drawable.hashtag,"#friends #love #like #fun #instagood #happy #follow #family #photooftheday #smile #friendship #instagram #picoftheday #life #cute #photography #beautiful #fashion #followme #me #nature #instadaily #art #music #travel #party #selfie #girl #summer #bhfyp" ) );
        list.add ( new data ( R.drawable.hashtag,"#food #likeforlikes #instalike #tbt #photo #l #bestfriends #girls #followforfollowback #memories #lifestyle #repost #likes #funny #f #fitness #myself #amazing #bhfyp #igers #friendshipgoals #happiness #likeforlike #amigos #memes #dance #beauty #friend #weekend #bestoftheday" ) );
        list.add ( new data ( R.drawable.hashtag,"#selfie #like #me #love #follow #instagood #smile #photooftheday #myself #picoftheday #photography #followme #instagram #happy #instadaily #cute #l #style #fashion #girl #beautiful #life #photo #fun #instalike #makeup #likeforlikes #art #friends #bhfyp" ) );

        list.add ( new data ( R.drawable.hashtag,"#model #likes #igers #beauty #instaselfie #portrait #tbt #f #selfietime #pic #nature #summer #ootd #fitness #self #likeforlike #mylife #selfies #pose #followforfollowback #instapic #gay #insta #bhfyp #igdaily #travel #hair #lifestyle #selflove #mood" ) );
        list.add ( new data ( R.drawable.hashtag,"#instamood #instagood #instadaily #instagram #like #follow #photooftheday #love #picoftheday #instalike #igers #me #followme #photography #l #instapic #insta #life #smile #style #selfie #likeforlikes #fashion #beautiful #happy #myself #igdaily #fun #likes #bhfyp" ) );
        list.add ( new data ( R.drawable.hashtag,"#instapic #instagood #instagram #picoftheday #like #photooftheday #instadaily #photography #instalike #love #follow #instaphoto #insta #instamood #likeforlikes #photo #nature #beautiful #likes #followme #travel #fashion #instalove #me #l #instamoment #likeforfollow #myself #instafashion #bhfyp" ) );


    }

    public void showAd()
    {
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId("ca-app-pub-8999624060144617/7469428731");

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
