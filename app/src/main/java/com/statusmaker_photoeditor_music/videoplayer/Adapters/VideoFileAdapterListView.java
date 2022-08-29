package com.statusmaker_photoeditor_music.videoplayer.Adapters;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.PopupMenu;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.statusmaker_photoeditor_music.videoplayer.AppLockPatternActivity;
import com.statusmaker_photoeditor_music.videoplayer.MainActivity;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.VideoDeleteInterface;

import java.io.File;
import java.util.ArrayList;

public class VideoFileAdapterListView extends RecyclerView.Adapter<VideoFileAdapterListView.ViewHolder> {

    ArrayList<String> applications_list;
    String status;
    //   ArrayList<String> mex_List;
    Context context;
    String folder_name;

    VideoDeleteInterface videoDeleteInterface;

    //LayoutInflater inflater;


    public VideoFileAdapterListView(ArrayList<String> applications_list, String folder_name, String status, Context context, VideoDeleteInterface videoDeleteInterface){
        //  this.inflater = LayoutInflater.from(context);

        this.applications_list = applications_list;
        this.status = status;
        this.context = context;
        this.folder_name = folder_name;
        this.videoDeleteInterface = videoDeleteInterface;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_thumb_item_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoFileAdapterListView.ViewHolder holder, int position) {
        holder.thumb_name.setText(applications_list.get(position).split(folder_name+"/")[1]);

        Glide.with(context).load(new File(applications_list.get(position))).thumbnail(0).into(holder.thumb_img);

        holder.thumb_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, MainActivity.class);
                intent.putExtra("VideoFilePath", applications_list);
                intent.putExtra("Position", position);
                intent.putExtra("Type", 1);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

        holder.more_op.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(context, v);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.video_pop_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {

                        if (item.getItemId()==R.id.delete_vid){
                            File file = new File(applications_list.get(position));
                            deleteImage(file);
                            videoDeleteInterface.videoDelete(position);
                        }
                        if (item.getItemId()==R.id.share_vid){
                            File file = new File(applications_list.get(position));
                            Uri uri = Uri.fromFile(file);
                            Intent intent = new Intent(Intent.ACTION_SEND);
                            intent .setType("video/*");
                            intent .putExtra(Intent.EXTRA_STREAM, uri);
                            context.startActivity(intent );
                        }
                        if (item.getItemId()==R.id.hide_video){
                            Intent intent = new Intent(context, AppLockPatternActivity.class);
                            intent.putExtra("Task", "HideFile");
                            intent.putExtra("FilePath", applications_list.get(position));
                            intent.putExtra("position", position);
                            context.startActivity(intent);
                            ((Activity)context).finish();

                        }
                        return true;
                    }
                });

                popup.show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return applications_list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder  {
        TextView thumb_name;
        ConstraintLayout thumb_rel;
        ImageView thumb_img, more_op;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            thumb_name = itemView.findViewById(R.id.thumb_name);
            thumb_rel = itemView.findViewById(R.id.thumb_rel);
            thumb_img = itemView.findViewById(R.id.thumb_img);
            more_op = itemView.findViewById(R.id.more_op);


        }

    }

    private void deleteImage(File file) {
        // Set up the projection (we only need the ID)
        String[] projection = {MediaStore.Video.Media._ID};

        // Match on the file path
        String selection = MediaStore.Video.Media.DATA + " = ?";
        String[] selectionArgs = new String[]{file.getAbsolutePath()};

        // Query for the ID of the media matching the file path
        Uri queryUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ContentResolver contentResolver = context.getContentResolver();
        Cursor c = contentResolver.query(queryUri, projection, selection, selectionArgs, null);
        if (c.moveToFirst()) {
            // We found the ID. Deleting the item via the content provider will also remove the file
            long id = c.getLong(c.getColumnIndexOrThrow(MediaStore.Video.Media._ID));
            Uri deleteUri = ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
            contentResolver.delete(deleteUri, null, null);
        } else {
            // File not found in media store DB
        }
        c.close();
    }

}

