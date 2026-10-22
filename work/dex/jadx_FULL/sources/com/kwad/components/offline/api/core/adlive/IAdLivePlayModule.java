package com.kwad.components.offline.api.core.adlive;

import com.kwad.components.offline.api.core.adlive.listener.AdLiveCallerContextListener;
import com.kwad.components.offline.api.core.adlive.listener.AdLivePlayStateListener;
import com.kwad.components.offline.api.core.adlive.listener.OnAdLiveResumeInterceptor;
import com.kwad.components.offline.api.core.adlive.model.LiveShopItemInfo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public interface IAdLivePlayModule {
    void addInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor);

    LiveShopItemInfo getCurrentShowShopItemInfo();

    long getPlayDuration();

    void onDestroy();

    void onPause();

    void onResume();

    void pause();

    void registerAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener);

    void registerAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener);

    void release();

    void removeInterceptor(OnAdLiveResumeInterceptor onAdLiveResumeInterceptor);

    void resume();

    void setAudioEnabled(boolean z, boolean z2);

    void setForceGetAudioFocus(boolean z);

    void skipToEnd();

    void unRegisterAdLiveCallerContextListener(AdLiveCallerContextListener adLiveCallerContextListener);

    void unRegisterAdLivePlayStateListener(AdLivePlayStateListener adLivePlayStateListener);
}
