package com.alibaba.triver.embed.video.video;

import androidx.camera.video.AudioStats;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VideoModel implements Serializable {
    private static final long serialVersionUID = 1;
    public String apFilePath;
    public long duration;
    public long height;
    public String relativeFilePath;
    public double size = AudioStats.AUDIO_AMPLITUDE_NONE;
    public long width;

    public String toString() {
        return "VideoModel{apFilePath='" + this.apFilePath + "', duration=" + this.duration + ", size=" + this.size + ", width=" + this.width + ", height=" + this.height + '}';
    }
}
