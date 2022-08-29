package com.statusmaker_photoeditor_music.videoplayer.statussaver.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.cd.statussaver.R;
import com.cd.statussaver.databinding.ActivityWhatsappBinding;
import com.cd.statussaver.databinding.ItemsWhatsappViewBinding;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.activity.WhatsappActivity;
import com.statusmaker_photoeditor_music.videoplayer.statussaver.model.WhatsappStatusModel;
import com.statusmaker_photoeditor_music.videoplayer.themes.WhatsappScreen;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.RootDirectoryWhatsappShow;
import static com.statusmaker_photoeditor_music.videoplayer.statussaver.util.Utils.createFileFolder;


public class WhatsappStatusAdapter extends RecyclerView.Adapter<WhatsappStatusAdapter.ViewHolder> {
    private Context context;
    private ArrayList<WhatsappStatusModel> fileArrayList;
    private LayoutInflater layoutInflater;
    public String SaveFilePath = RootDirectoryWhatsappShow+ "/";
    public WhatsappStatusAdapter(Context context, ArrayList<WhatsappStatusModel> files) {
        this.context = context;
        this.fileArrayList = files;
    }

    @NonNull
    @Override
    public WhatsappStatusAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new ViewHolder(DataBindingUtil.inflate(layoutInflater, R.layout.items_whatsapp_view, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WhatsappStatusAdapter.ViewHolder viewHolder, int i) {
        WhatsappStatusModel fileItem = fileArrayList.get(i);
        if (fileItem.getUri().toString().endsWith(".mp4")){
            viewHolder.binding.ivPlay.setVisibility(View.VISIBLE);
        }else {
            viewHolder.binding.ivPlay.setVisibility(View.GONE);
        }
        Glide.with(context)
                .load(fileItem.getPath())
                .into(viewHolder.binding.pcw);

        WhatsappScreen whatsappScreen = new WhatsappScreen();


        SharedPreferences theme_pref = PreferenceManager.getDefaultSharedPreferences(context);

        String current_theme = theme_pref.getString("Theme", "default");

        if (current_theme.equals("theme1")){
            whatsappScreen.theme1Adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals("theme2")){
            whatsappScreen.theme2Adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_1))){
            whatsappScreen.flat_theme1_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_2))){
            whatsappScreen.flat_theme2_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_3))){
            whatsappScreen.flat_theme3_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_4))){
            whatsappScreen.flat_theme4_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_5))){
            whatsappScreen.flat_theme5_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_6))){
            whatsappScreen.flat_theme6_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_7))){
            whatsappScreen.flat_theme7_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_8))){
            whatsappScreen.flat_theme8_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_9))){
            whatsappScreen.flat_theme9_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_10))){
            whatsappScreen.flat_theme10_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_11))){
            whatsappScreen.flat_theme11_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_12))){
            whatsappScreen.flat_theme12_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_13))){
            whatsappScreen.flat_theme13_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_14))){
            whatsappScreen.flat_theme14_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_15))){
            whatsappScreen.flat_theme15_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_16))){
            whatsappScreen.flat_theme16_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_17))){
            whatsappScreen.flat_theme17_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_18))){
            whatsappScreen.flat_theme18_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_19))){
            whatsappScreen.flat_theme19_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.flat_theme_20))){
            whatsappScreen.flat_theme20_adapter(viewHolder.binding.tvDownload);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_1))){
            whatsappScreen.grad_theme1_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_2))){
            whatsappScreen.grad_theme2_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_3))){
            whatsappScreen.grad_theme3_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_4))){
            whatsappScreen.grad_theme4_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_5))){
            whatsappScreen.grad_theme5_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_6))){
            whatsappScreen.grad_theme6_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_7))){
            whatsappScreen.grad_theme7_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_8))){
            whatsappScreen.grad_theme8_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_9))){
            whatsappScreen.grad_theme9_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_10))){
            whatsappScreen.grad_theme10_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_11))){
            whatsappScreen.grad_theme11_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_12))){
            whatsappScreen.grad_theme12_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_13))){
            whatsappScreen.grad_theme13_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_14))){
            whatsappScreen.grad_theme14_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_15))){
            whatsappScreen.grad_theme15_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_16))){
            whatsappScreen.grad_theme16_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_17))){
            whatsappScreen.grad_theme17_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_18))){
            whatsappScreen.grad_theme18_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_19))){
            whatsappScreen.grad_theme19_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.grad_theme_20))){
            whatsappScreen.grad_theme20_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto1))){
            whatsappScreen.picto_theme1_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto2))){
            whatsappScreen.picto_theme2_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto3))){
            whatsappScreen.picto_theme3_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto4))){
            whatsappScreen.picto_theme4_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto5))){
            whatsappScreen.picto_theme5_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto6))){
            whatsappScreen.picto_theme6_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto7))){
            whatsappScreen.picto_theme7_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto8))){
            whatsappScreen.picto_theme8_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto9))){
            whatsappScreen.picto_theme9_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto10))){
            whatsappScreen.picto_theme10_adapter(viewHolder.binding.tvDownload);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto11))){
            whatsappScreen.picto_theme11_adapter(viewHolder.binding.tvDownload);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto12))){
            whatsappScreen.picto_theme12_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto13))){
            whatsappScreen.picto_theme13_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto14))){
            whatsappScreen.picto_theme14_adapter(viewHolder.binding.tvDownload);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto15))){
            whatsappScreen.picto_theme15_adapter(viewHolder.binding.tvDownload);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto16))){
            whatsappScreen.picto_theme16_adapter(viewHolder.binding.tvDownload);
        }

        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto17))){
            whatsappScreen.picto_theme17_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto18))){
            whatsappScreen.picto_theme18_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto19))){
            whatsappScreen.picto_theme19_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto20))){
            whatsappScreen.picto_theme20_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto21))){
            whatsappScreen.picto_theme21_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto22))){
            whatsappScreen.picto_theme22_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto23))){
            whatsappScreen.picto_theme23_adapter(viewHolder.binding.tvDownload);
        }
        else if (current_theme.equals(String.valueOf(com.royalplayer.lite.R.drawable.picto24))){
            whatsappScreen.picto_theme24_adapter(viewHolder.binding.tvDownload);
        }
        else {

        }


        viewHolder.binding.tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createFileFolder();
                final String path = fileItem.getPath();
                String filename=path.substring(path.lastIndexOf("/")+1);
                final File file = new File(path);
                File destFile = new File(SaveFilePath);
                try {
                    FileUtils.copyFileToDirectory(file, destFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String fileNameChange=filename.substring(12);
                File newFile = new File(SaveFilePath+fileNameChange);
                String ContentType = "image/*";
                if (fileItem.getUri().toString().endsWith(".mp4")){
                   ContentType = "video/*";
                }else {
                    ContentType = "image/*";
                }
                MediaScannerConnection.scanFile(context, new String[]{newFile.getAbsolutePath()}, new String[]{ContentType},
                        new MediaScannerConnection.MediaScannerConnectionClient() {
                            public void onMediaScannerConnected() {
                            }

                            public void onScanCompleted(String path, Uri uri) {
                            }
                        });

                File from = new File(SaveFilePath,filename);
                File to = new File(SaveFilePath,fileNameChange);
                from.renameTo(to);

                Toast.makeText(context, context.getResources().getString(R.string.saved_to) + SaveFilePath + fileNameChange, Toast.LENGTH_LONG).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return fileArrayList == null ? 0 : fileArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemsWhatsappViewBinding binding;

        public ViewHolder(ItemsWhatsappViewBinding mbinding) {
            super(mbinding.getRoot());
            this.binding = mbinding;
        }
    }
}