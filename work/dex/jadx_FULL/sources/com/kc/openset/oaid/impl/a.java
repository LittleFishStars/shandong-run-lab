package com.kc.openset.oaid.impl;

import android.content.Context;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class a implements IOAID {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39774a;

    /* JADX INFO: renamed from: $r8$lambda$BUOa7Wif2_QNwdXOQ-G5X1EuZmo, reason: not valid java name */
    public static native /* synthetic */ String m1035$r8$lambda$BUOa7Wif2_QNwdXOQG5X1EuZmo(IBinder iBinder);

    static {
        OSETSDKProtected.interface11(4495);
    }

    public a(Context context) {
        this.f39774a = context;
    }

    private static native /* synthetic */ String a(IBinder iBinder);

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
