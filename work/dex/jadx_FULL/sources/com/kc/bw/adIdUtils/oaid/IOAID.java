package com.kc.bw.adIdUtils.oaid;

import com.kc.bw.dexg;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface IOAID {
    public static final String TAG = dexg.dexa("je");

    void doGet(IGetter iGetter);

    boolean supported();
}
