package com.statusmaker_photoeditor_music.videoplayer;

import java.util.ArrayList;

public class ImageModel {
    String FolderName;
    ArrayList<String> ImagePath;

    public String getFolderName() {
        return FolderName;
    }

    public void setFolderName(String folderName) {
        FolderName = folderName;
    }

    public ArrayList<String> getVideoPath() {
        return ImagePath;
    }

    public void setVideoPath(ArrayList<String> videoPath) {
        ImagePath = videoPath;
    }
}
