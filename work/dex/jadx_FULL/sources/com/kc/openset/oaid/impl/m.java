package com.kc.openset.oaid.impl;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.kc.openset.util.LogUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class m implements IOAID {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39796a;
    private Class<?> b;
    private Object c;

    static {
        OSETSDKProtected.interface11(4519);
    }

    public m(Context context) {
        this.f39796a = context;
        try {
            Class<?> cls = Class.forName(OSETSDKProtected.getString2("1985"));
            this.b = cls;
            this.c = cls.newInstance();
        } catch (Exception e) {
            LogUtils.writeE(OSETSDKProtected.getString2(1986), e.toString());
        }
    }

    private native String a();

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
