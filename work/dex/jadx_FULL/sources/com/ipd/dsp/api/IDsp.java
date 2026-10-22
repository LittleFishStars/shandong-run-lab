package com.ipd.dsp.api;

import android.content.Context;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.ipd.dsp.DspConfig;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IDsp {
    @Keep
    DspLoadManager getAdManager();

    @Keep
    String getAppId();

    @Nullable
    @Keep
    Context getContext();

    @Keep
    boolean getPersonalRecommend();

    @Keep
    boolean getProgrammaticRecommend();

    @Keep
    String getWxOpenId();

    @Keep
    void init(Context context, DspConfig dspConfig);

    @Keep
    boolean isDebug();

    @Keep
    boolean isHttpsOnly();

    @Keep
    void setPersonalRecommend(boolean z);

    @Keep
    void setProgrammaticRecommend(boolean z);
}
