package com.kc.openset.oaid.impl;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class g implements IOAID {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39788a;

    static {
        OSETSDKProtected.interface11(4510);
    }

    public g(Context context) {
        this.f39788a = context;
    }

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
