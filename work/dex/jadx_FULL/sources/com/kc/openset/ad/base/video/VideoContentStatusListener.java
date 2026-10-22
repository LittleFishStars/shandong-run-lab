package com.kc.openset.ad.base.video;

import androidx.fragment.app.Fragment;
import com.kc.openset.bean.k;
import com.kc.openset.video.VideoTubeDramaMode;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface VideoContentStatusListener {
    void doTask();

    void doVideoCompleted(k kVar);

    void doVideoError(k kVar, String str, String str2);

    void doVideoPaused(k kVar);

    void doVideoResume(k kVar);

    void doVideoStart(k kVar);

    int getFreeEpisodeCount();

    VideoTubeDramaMode getTubeDramaMode();

    int getUnlockEpisodeCount();

    void onLoadFail(String str, String str2);

    void onLoadSuccess(Fragment fragment);
}
