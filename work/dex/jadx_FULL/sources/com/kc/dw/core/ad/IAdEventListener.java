package com.kc.dw.core.ad;

import com.kc.dw.core.utils.AdError;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IAdEventListener<T> {
    void onAdFail(T t, AdError adError, int i);

    void onLoadFail(AdError adError);

    void onLoadSuccess(T t);

    void onRenderSuccess(T t);
}
