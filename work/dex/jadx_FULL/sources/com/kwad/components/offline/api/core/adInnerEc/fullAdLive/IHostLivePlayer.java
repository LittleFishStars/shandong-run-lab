package com.kwad.components.offline.api.core.adInnerEc.fullAdLive;

import android.view.ViewGroup;
import androidx.annotation.Keep;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.info.HostLiveInfo;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener.IHostLivePlayerCompleteListener;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener.IHostLivePlayerErrorListener;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener.IHostLivePlayerStateChangeListener;
import com.kwad.components.offline.api.core.adInnerEc.fullAdLive.listener.IHostLiveUrlSwitchListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@Keep
public interface IHostLivePlayer {
    void addLivePlayerErrorListener(IHostLivePlayerErrorListener iHostLivePlayerErrorListener);

    void addLiveUrlSwitchListener(IHostLiveUrlSwitchListener iHostLiveUrlSwitchListener);

    void addOnCompletionListener(IHostLivePlayerCompleteListener iHostLivePlayerCompleteListener);

    void addStateChangeListener(IHostLivePlayerStateChangeListener iHostLivePlayerStateChangeListener);

    void destroy();

    long getPlayDurationMs();

    void intLivePlayer(ViewGroup viewGroup, HostLiveInfo hostLiveInfo);

    boolean isBuffering();

    boolean isPlaying();

    void removeLivePlayerErrorListener(IHostLivePlayerErrorListener iHostLivePlayerErrorListener);

    void removeLiveUrlSwitchListener(IHostLiveUrlSwitchListener iHostLiveUrlSwitchListener);

    void removeOnCompletionListener(IHostLivePlayerCompleteListener iHostLivePlayerCompleteListener);

    void removeStateChangeListener(IHostLivePlayerStateChangeListener iHostLivePlayerStateChangeListener);

    void restartPlay(int i);

    void setMuted(boolean z);

    void setPlayerReleaseReason(int i);

    void setVolume(float f, float f2);

    void startPlay();

    void stopPlay();
}
