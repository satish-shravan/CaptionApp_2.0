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

public class bird extends AppCompatActivity {


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
        setContentView ( R.layout.activity_bird );

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

        list.add(new data (R.drawable .bird,"\"Some birds are not meant to be caged, that's all.\""));
        list.add(new data (R.drawable .bird,"\"In order to see birds, it is necessary to become a part of the silence.\""));
        list.add(new data (R.drawable .bird,"\"Birds are a miracle because they prove to us there is a finer, simpler state of being which we may strive to attain.\""));
        list.add(new data (R.drawable .bird,"\"Birds are the most accomplished aeronauts the world has ever seen.\""));
        list.add(new data (R.drawable .bird,"\"The sound of birds stops the noise in my mind.\""));
        list.add(new data (R.drawable .bird,"\"A bird is three things: feathers, flight and song, And feathers are the least of these.\""));
        list.add(new data (R.drawable .bird,"\"A bird in the hand is worth two in the bush.\""));
        list.add(new data (R.drawable .bird,"\"Hear how the birds, on every blooming spray, with joyous music wake the dawning day.\""));
        list.add(new data (R.drawable .bird,"\"A bird doesn't sing because he has an answer. He sings because it has a song.\""));
        list.add(new data (R.drawable .bird,"\"It is a matter of shame that in the morning the birds should be awake earlier than you.\""));









        // list.add(new Data_show ( "" ));
    }
}
