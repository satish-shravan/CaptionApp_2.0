package shayari.world.allinonecaptionapp;

import android.os.Bundle;
import android.view.MenuItem;

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

        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

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
        list = new ArrayList<data> ();
        adapterRecyclerLinear = new insta_adapter ( this, list );
        recyclerView.setAdapter ( adapterRecyclerLinear );
        // Toast.makeText ( this, "CLICK TO SHARE  :)", Toast.LENGTH_LONG ).show ();
        linearList ();
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


    private void linearList()
    {

        list.add(new data (R.drawable.logodesign,"NO DATA AVAILABLE ...!"));








        // list.add(new Data_show ( "" ));
    }
}
