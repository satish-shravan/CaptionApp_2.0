package shayari.world.allinonecaptionapp;

import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

import static android.os.Environment.DIRECTORY_DOWNLOADS;

public  class firebaseadapter extends RecyclerView.Adapter<firebaseadapter.ViewHolder> {

    public Context context;
    public List<upload> list;

    public firebaseadapter(Context context, List<upload> list) {
        this.context = (Context) context;
        this.list = list;
    }

    @NonNull
    @Override
    public firebaseadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View customview = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.firebase_img_layout,parent,false);

        ViewHolder viewHolder = new ViewHolder ( customview );

        return  viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull final firebaseadapter.ViewHolder holder, final int position) {

        Glide.with ( context ).load ( list.get ( position ).getUrl () ).placeholder ( R.drawable.loading ).into ( holder.imageView );

        holder.save.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                downloadFile(holder.imageView.getContext (),DIRECTORY_DOWNLOADS,list.get ( position ).getUrl ().toString ());
            }
        } );


    }

    private void downloadFile(Context context, String directoryDownloads, String url) {

        DownloadManager downloadManager = (DownloadManager) context.getSystemService ( Context.DOWNLOAD_SERVICE );

        Uri uri = Uri.parse ( url );

        DownloadManager.Request request =new DownloadManager.Request ( uri );

        request.setNotificationVisibility ( DownloadManager.Request.VISIBILITY_VISIBLE );

        request.setDestinationInExternalFilesDir ( context,directoryDownloads,"Images_" );

        downloadManager.enqueue ( request );

    }

    @Override
    public int getItemCount() {
        return list.size ();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView save,send,imageView;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );

            save =(ImageView) itemView.findViewById ( R.id.save );
           // send =(ImageView) itemView.findViewById ( R.id.send );
            imageView =(ImageView) itemView.findViewById ( R.id.imageView );


        }
    }
}


