package shayari.world.allinonecaptionapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

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

        getSupportActionBar ().setDisplayHomeAsUpEnabled (true );

        //ads
        showAd ();

//ads
        AdView adView = new AdView ( this );
        adView.setAdSize ( AdSize.BANNER );
        adView.setAdUnitId ( getString ( R.string.admob_banner_id ) );
        mAdView = (AdView) findViewById ( R.id.adView );
        AdRequest adRequest = new AdRequest.Builder ().build ();
        mAdView.loadAd ( adRequest );


        recyclerView = findViewById ( R.id.recycler );
        recyclerView.setHasFixedSize ( true );

        layoutManager = new LinearLayoutManager ( this );
        recyclerView.setLayoutManager ( layoutManager );

        list = new ArrayList<data> (  );

        insta_adapter = new insta_adapter ( this,list );
        recyclerView.setAdapter ( insta_adapter );

        linearlist();

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

    public  void linearlist()
    {
        list.add ( new data ( R.drawable.hashtag,"#love" ) );

        list.add ( new data ( R.drawable.hashtag,"#instagood" ) );

        list.add ( new data ( R.drawable.hashtag,"#photooftheday" ) );

        list.add ( new data ( R.drawable.hashtag,"#fashion" ) );

        list.add ( new data ( R.drawable.hashtag,"#beautiful" ) );

        list.add ( new data ( R.drawable.hashtag,"#happy" ) );

        list.add ( new data ( R.drawable.hashtag,"#like4like" ) );

        list.add ( new data ( R.drawable.hashtag,"#followme" ) );

        list.add ( new data ( R.drawable.hashtag,"#picoftheday" ) );

        list.add ( new data ( R.drawable.hashtag,"#follow" ) );

        list.add ( new data ( R.drawable.hashtag,"#selfie" ) );

        list.add ( new data ( R.drawable.hashtag,"#instadaily" ) );
        list.add ( new data ( R.drawable.hashtag,"#repost" ) );

        list.add ( new data ( R.drawable.hashtag,"#nature" ) );

        list.add ( new data ( R.drawable.hashtag,"#girl" ) );

        list.add ( new data ( R.drawable.hashtag,"#tagsforlikes" ) );

        list.add ( new data ( R.drawable.hashtag,"#amazing" ) );

        list.add ( new data ( R.drawable.hashtag,"#photography" ) );

        list.add ( new data ( R.drawable.hashtag,"#instamood" ) );

        list.add ( new data ( R.drawable.hashtag,"#dog #cat #dogsofinstagram #catsofinstagram #puppy #dogs #cats #pet #dogstagram #instadog #animals #catsagram #pets" ) );

        list.add ( new data ( R.drawable.hashtag,"#art #design #handmade #artist #drawing #ilustration #architecture #vintage #artwork #sketch #painting #interiordesign #picture #picture #color #kpop #homemade #jewelry #draw #creative #arte #instaart #digitalart #aesthetic" ) );

        list.add ( new data ( R.drawable.hashtag,"#beauty #makeup #hair #nails #makeupartist #nailsart #hairstyle" ) );

        list.add ( new data ( R.drawable.hashtag,"#fitness #gym #workout #fit #fitfam #bodybuilding #training #nike #fitnessmotivation #sport #yoga #hiphop #football #fitinspo #running #dance" ) );

        list.add ( new data ( R.drawable.hashtag,"#food #foodporn #instafood #foodie #yummy #delicious #sweet #vegan #breakfast #cake #chocolate #lunch #healthyfood #yum #foodstagram #dinner #coffee" ) );

        list.add ( new data ( R.drawable.hashtag,"#photooftheday #photography #photo #vsco #vscocam #photographer #blackandwhite #portrait #naturephotography #photoshoot #canon #instaphoto #pic #streetphotography #nikon #all_shots" ) );

        list.add ( new data ( R.drawable.hashtag,"#memes #lol #meme #dankmeme" ) );

        list.add ( new data ( R.drawable.hashtag,"#instagood #picoftheday #follow #instagram #tbt #followme #like4like #repost #instadaily #girl #instalike #likeforlike #follow4follow #igers #nofilter #instamood #likeforlikes #followforfollow #l4l #f4f #tagsforlikes #bestoftheday #instapic #likeforfollow #explore #followforfollowback #instafashion #travelgram #insta #tflers #instalove #new #likes #followback #instafollow #throwback #instacool #LFL #exporepage #fff #tweegram #igdaily #instago #bhfyp #webstagram #instagramers #followers #latepost #tb #likesforlikes #like4follow #regrann #top #bts" ) );

        list.add ( new data ( R.drawable.hashtag,"#blogger #tiktok #sale #video #youtube #tumblr " ) );

        list.add ( new data ( R.drawable.hashtag,"#fashion #style #ootd #model #moda #look #fashionblogger #shopping #dress #shoes #fashionista #outfit #stylish " ) );

        list.add ( new data ( R.drawable.hashtag,"#nature #summer #sunset #beach #sun #sky #flower #mountains #view #water #naturelovers #sunshine #natural #sunrise #ocean #sea " ) );

        list.add ( new data ( R.drawable.hashtag,"#italy #travel #london #travelphotography #japan #nyc #trip #paris #vacation #indonesia #usa #instatravel #instambul #dubai #india #brasil #newyork" ) );

        list.add ( new data ( R.drawable.hashtag,"#music #musica #musician #livemusic #newmusic #instamusic" ) );

        list.add ( new data ( R.drawable.hashtag,"#sexy #love #beautiful #happy #cute #selfie #me #friends #fun #smile #family #life #amazing #motivation #lifestyle #funny #baby #wedding #girls #inspiration #pretty #party #cool #healthy #christmas #swag #home #black #holiday #pink #blue #tattoo #happiness #winter #daily #night #anime #weekend #work #amor #blessed #health #wanderlust #spring #green #luxury #goodmorning #red #birthday #quotes #relax #adventure #sunday #mood #goodvibes #boy #morning #kids #autumn #awesome #live #iphoneonly #white #halloween #nice #goals #eyes #happybirthday #peace #memories #streetstyle #gay #colorful #homedecor #iphonesia #babygirl #healthylifestyle #loveit #ink #familia #light #day #good #friday #car #disney #entrepreneur #best #beer #loveyourself " ) );

        list.add ( new data ( R.drawable.hashtag,"#popularpage #comment #art #india #meme #f #followers #new #instamood #pop #happy #insta #foryou #m #youtube #instalike #l #me #likeforlike #k #life #edit #edits #attitude #video #followback #followforfollow #best #top #bhfyp" ) );





    }

    public void showAd()
    {
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId(getString ( R.string.admob_interstial_id ));

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
