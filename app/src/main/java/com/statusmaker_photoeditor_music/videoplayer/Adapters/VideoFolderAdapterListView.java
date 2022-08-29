package com.statusmaker_photoeditor_music.videoplayer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.royalplayer.lite.R;
import com.statusmaker_photoeditor_music.videoplayer.VideoListInterface;

import java.io.File;
import java.util.ArrayList;

public class VideoFolderAdapterListView extends RecyclerView.Adapter<VideoFolderAdapterListView.ViewHolder> {

    ArrayList<String> applications_list;
    ArrayList<String> status = new ArrayList<>();
    //   ArrayList<String> mex_List;
    Context context;
    //LayoutInflater inflater;
    VideoListInterface videoListInterface;

    String list_layout;

    public VideoFolderAdapterListView(ArrayList<String> applications_list, ArrayList<String> status, String list_layout, Context context, VideoListInterface videoListInterface){
        //  this.inflater = LayoutInflater.from(context);

        this.applications_list = applications_list;
        this.status = status;
        this.context = context;
        this.videoListInterface = videoListInterface;
        this.list_layout = list_layout;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_thumb_item_list_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoFolderAdapterListView.ViewHolder holder, int position) {
        holder.thumb_name.setText(applications_list.get(position));

        Glide.with(context).load(new File(status.get(position))).thumbnail(1).into(holder.thumb_img);

        holder.thumb_rel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoListInterface.videoListInerface(v, applications_list.get(position));
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
        ImageView thumb_img;

        ImageView more_op;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            thumb_name = itemView.findViewById(R.id.thumb_name);
            thumb_rel = itemView.findViewById(R.id.thumb_rel);
            thumb_img = itemView.findViewById(R.id.thumb_img);
            more_op = itemView.findViewById(R.id.more_op);

            more_op.setVisibility(View.GONE);

        }

    }
}

