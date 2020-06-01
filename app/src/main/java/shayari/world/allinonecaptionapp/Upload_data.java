package shayari.world.allinonecaptionapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;

public class Upload_data extends AppCompatActivity {

        Button upload,choose;
        ImageView img;

        static final int PICK_UP_CODE=1;

        Uri filepath;

        StorageReference storageReference; // entry point for the firebase storage
        DatabaseReference databaseReference; // refers to the some part of the database

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data != null && data.getData () != null)
        {
            if(requestCode==PICK_UP_CODE && resultCode==RESULT_OK)
            {
                filepath = data.getData ();

               Bitmap bitmap = null;

                try {
                    bitmap = MediaStore.Images.Media.getBitmap ( getContentResolver (),filepath );
                } catch (IOException e) {
                    e.printStackTrace ();
                }

                img.setImageBitmap ( bitmap );


            }
        }

        super.onActivityResult ( requestCode, resultCode, data );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_upload_data );

        upload = (Button) findViewById ( R.id.upload );
        choose = (Button) findViewById ( R.id.choose );
        img = (ImageView) findViewById ( R.id.img );

        choose.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                showFileChooser();
            }
        } );

        upload.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                uploadFile();
            }
        } );

        storageReference = FirebaseStorage.getInstance ().getReference ();

        databaseReference = FirebaseDatabase.getInstance ().getReference ("Trending");







    }

    public  void showFileChooser()
    {
        Intent intent = new Intent (  );
        intent.setType ( "image/*" );
        intent.setAction ( Intent.ACTION_GET_CONTENT );
        startActivityForResult ( Intent.createChooser ( intent,"Choose Image" ),PICK_UP_CODE );
    }
    public void uploadFile()
    {
        if(filepath != null)
        {

            final ProgressDialog progressDialog = new ProgressDialog ( this );

            progressDialog.setTitle ( "Uploading......." );
            progressDialog.show ();

            StorageReference sRef = storageReference.child ( "Trending/"+System.currentTimeMillis ()+"."+getFileExtension ( filepath ) );

            sRef.putFile ( filepath ).addOnSuccessListener ( new OnSuccessListener<UploadTask.TaskSnapshot> () {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss ();

                    taskSnapshot.getMetadata ().getReference ().getDownloadUrl ().addOnSuccessListener ( new OnSuccessListener<Uri> () {
                        @Override
                        public void onSuccess(Uri uri) {
                            upload mupload = new upload ( uri.toString () );

                            databaseReference.push ().setValue ( mupload );

                            Toast.makeText ( Upload_data.this, "Uploaded Succesful...", Toast.LENGTH_SHORT ).show ();
                        }
                    } );
                }
            } ).addOnProgressListener ( new OnProgressListener<UploadTask.TaskSnapshot> () {
                @Override
                public void onProgress(@NonNull UploadTask.TaskSnapshot taskSnapshot) {
                        double progress = (100.00 * taskSnapshot.getBytesTransferred () / taskSnapshot.getTotalByteCount ());
                        progressDialog.setMessage ( "Uploading.." + ((int)progress) +"%"+"....");

                }
            } ).addOnFailureListener ( new OnFailureListener () {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText ( Upload_data.this, "Failed to Upload File...Try Again!!", Toast.LENGTH_SHORT ).show ();
                }
            } );



        }
    }

    public String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

}
