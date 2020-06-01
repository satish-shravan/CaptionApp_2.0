package shayari.world.allinonecaptionapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.ArrayList;

public class festival extends AppCompatActivity {


    //ads
    private AdView mAdView, mAdView1;
    private PublisherInterstitialAd mPublisherInterstitialAd;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;

    insta_adapter adapterRecyclerLinear;

    ArrayList<data> list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_festival );

        //ads



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
        list = new ArrayList<data> ();
        adapterRecyclerLinear = new insta_adapter ( this, list );
        recyclerView.setAdapter ( adapterRecyclerLinear );
        // Toast.makeText ( this, "CLICK TO SHARE  :)", Toast.LENGTH_LONG ).show ();
        linearList ();
    }



    private void linearList()
    {

        list.add(new data (R.drawable.logodesign,"NO DATA AVAILABLE ...!"));








        // list.add(new Data_show ( "" ));
    }
}
