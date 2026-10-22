package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.DataType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private DataType f39641a;
    private Queue<e> b;

    static {
        OSETSDKProtected.interface11(3846);
    }

    public c(DataType dataType, Queue<e> queue) {
        this.f39641a = dataType;
        this.b = queue;
    }

    public native DataType a();

    public native Queue<e> b();

    public native String toString();
}
