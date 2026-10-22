package com.aliyun.svideosdk.player;

import android.content.Context;
import android.view.Surface;
import com.aliyun.Visible;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public interface AliyunISVideoPlayer {
    int draw(long j);

    long getCurrentPosition();

    int init(Context context);

    int pause();

    int play();

    void release();

    int resume();

    int seek(long j);

    int setDisplay(Surface surface);

    int setDisplaySize(int i, int i2);

    void setPlayerCallback(PlayerCallback playerCallback);

    int setSource(String str);

    int stop();
}
