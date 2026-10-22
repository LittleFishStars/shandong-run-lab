package com.kwad.components.offline.api.core.imageplayer;

import android.content.Context;
import android.widget.FrameLayout;
import com.kwad.components.offline.api.core.video.listener.OfflineMediaPlayStateListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IImagePlayer {
    void destroy();

    FrameLayout getImagePlayerView(Context context);

    void pause();

    void play();

    void prepareToPlay();

    void registerMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener);

    void resume();

    void setDuration(long j);

    void setEnableCache(boolean z);

    void setHorizontalGravity(int i);

    void setImageResize(int i);

    void setRadius(float f, float f2, float f3, float f4);

    void setSpeed(float f);

    void setURLs(List<String> list);

    void setVerticalGravity(int i);

    void stop();

    void unregisterMediaPlayStateListener(OfflineMediaPlayStateListener offlineMediaPlayStateListener);
}
