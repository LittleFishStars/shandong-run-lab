package com.aliyun.svideosdk.editor;

import com.aliyun.Visible;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public interface AliyunIPlayerController {
    long getCurrentPlayPosition();

    long getCurrentStreamPosition();

    long getDuration();

    long getStreamDuration();

    boolean isMute();

    boolean isPaused();

    boolean isPlaying();

    int pause();

    int play();

    int replay();

    int resume();

    int seek(long j, TimeUnit timeUnit);

    void setMute(boolean z);

    int setVolume(int i);

    int stop();
}
