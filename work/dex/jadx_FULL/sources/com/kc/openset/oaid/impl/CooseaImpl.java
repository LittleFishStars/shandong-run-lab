package com.kc.openset.oaid.impl;

import android.app.KeyguardManager;
import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class CooseaImpl implements IOAID {
    private static final String TAG = OSETSDKProtected.getString2(1875);
    private final Context context;
    private final KeyguardManager keyguardManager;

    static {
        OSETSDKProtected.interface11(4484);
    }

    public CooseaImpl(Context context) {
        this.context = context;
        this.keyguardManager = (KeyguardManager) context.getSystemService(OSETSDKProtected.getString2(1874));
    }

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
