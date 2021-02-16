package shayari.world.allinonecaptionapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class AboutUs extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_about_us );

        getSupportActionBar ().setDisplayHomeAsUpEnabled ( true );

        imageView = findViewById ( R.id.followus );

        imageView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText ( getApplicationContext (), "Follow us on Instagram", Toast.LENGTH_SHORT ).show ();
                //open a browser with a link
                Intent externalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/shayariworld88/"));
                startActivity(externalIntent);
            }
        } );

        FloatingActionButton fab = findViewById ( R.id.fab );
        fab.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
             //   Snackbar.make ( view, "Replace with your own action", Snackbar.LENGTH_LONG )
              //          .setAction ( "Action", null ).show ();
                Toast.makeText (getApplicationContext (), "More Apps on Play Store", Toast.LENGTH_SHORT ).show ();
                //open a browser with a link
                Intent externalIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=6075959649166349332&hl=en"));
                startActivity(externalIntent);
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
}
