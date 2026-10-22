package com.fl.saas.adx.base.interfaces;

import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface S2SVideoPlayListener {
    @Keep
    void onVideoPlayComplete();

    void onVideoPlayError(int i, int i2);

    @Keep
    void onVideoPlayStart();

    @Keep
    void onVideoPrepare();
}
