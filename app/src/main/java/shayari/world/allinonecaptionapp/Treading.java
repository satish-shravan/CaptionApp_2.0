package shayari.world.allinonecaptionapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Treading extends AppCompatActivity {

    private AdView mAdView,mAdView1;
    private PublisherInterstitialAd mPublisherInterstitialAd;



    private RecyclerView recyclerView;

    //adapter object
    private RecyclerView.Adapter adapter;

    //database reference
    private DatabaseReference mDatabase;

    //progress dialog
    private ProgressDialog progressDialog;

    //list to hold all the uploaded images
    private List<upload> uploadlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_treading );

        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );


//ads
        AdView adView = new AdView ( this );
        adView.setAdSize ( AdSize.BANNER );
        adView.setAdUnitId ( getString ( R.string.admob_banner_id ) );
        mAdView = (AdView) findViewById ( R.id.adView );
        AdRequest adRequest = new AdRequest.Builder ().build ();
        mAdView.loadAd ( adRequest );

        showAd ();

        mPublisherInterstitialAd.loadAd ( new PublisherAdRequest.Builder ().build () );
        mPublisherInterstitialAd.show ();






        mPublisherInterstitialAd.setAdListener(new AdListener () {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());
            }

        });


        recyclerView = findViewById ( R.id.recyclerView );
        LinearLayoutManager ly = new LinearLayoutManager ( this );
        ly.setReverseLayout ( true );
        ly.setStackFromEnd ( true );
        recyclerView.setLayoutManager ( ly );
        recyclerView.setHasFixedSize ( true );


        progressDialog = new ProgressDialog(this);

        uploadlist = new ArrayList<> ();


        //displaying progress dialog while fetching images
        progressDialog.setMessage("Fetching data from Server... \n Please wait... ");
        progressDialog.setCancelable ( false );
        progressDialog.show();


        mDatabase = FirebaseDatabase.getInstance ().getReference ("Trending");

       // Toast.makeText ( this, "Click Image to Download !!", Toast.LENGTH_LONG ).show ();


        mDatabase.addValueEventListener ( new ValueEventListener () {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                progressDialog.dismiss ();


                for(DataSnapshot post : dataSnapshot.getChildren ())
                {
                    upload up = post.getValue (upload.class);

                    uploadlist.add(up);


                }

                recyclerView.setAdapter ( new firebaseadapter ( getApplicationContext (),uploadlist ));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss ();
            }
        } );
    }

    public void showAd()
    {
        mPublisherInterstitialAd = new PublisherInterstitialAd(this);
        mPublisherInterstitialAd.setAdUnitId(getString ( R.string.admob_interstial_id ));

        mPublisherInterstitialAd.loadAd(new PublisherAdRequest.Builder().build());

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

    @Override
    public void onBackPressed() {
        if (mPublisherInterstitialAd.isLoaded()) {
            mPublisherInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
        super.onBackPressed ();
    }
}
