package com.kc.openset.ad.listener;

import com.kc.openset.ad.d;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public interface AdLoadCacheListener {
    void onFail(String str, String str2);

    void onFail(String str, String str2, d dVar);

    void onSuccess(d dVar);

    void onTimeOut(d dVar);
}
