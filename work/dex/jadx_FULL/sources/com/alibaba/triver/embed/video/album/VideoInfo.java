package com.alibaba.triver.embed.video.album;

import android.graphics.Bitmap;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoInfo implements Serializable {
    private static final long serialVersionUID = 12345;
    public String duration;
    public Bitmap frame;
    public String path;

    public VideoInfo() {
    }

    public VideoInfo(String str, String str2, Bitmap bitmap) {
        this.path = str;
        this.duration = str2;
        this.frame = bitmap;
    }
}
