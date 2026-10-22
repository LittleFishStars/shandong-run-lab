package com.kc.openset.oaid.impl;

import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class j implements IOAID {
    private static final String TAG = OSETSDKProtected.getString2(1976);
    private final Context context;
    private String sign;

    @Keep
    public class a implements OAIDService.RemoteCaller {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final j f39792a;

        static {
            OSETSDKProtected.interface11(4514);
        }

        public a(j jVar) {
            this.f39792a = jVar;
        }

        @Override // com.kc.openset.oaid.impl.OAIDService.RemoteCaller
        public native String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4515);
    }

    public j(Context context) {
        this.context = context instanceof Application ? context : context.getApplicationContext();
    }

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    public native String getSerId(IBinder iBinder, String str, String str2);

    public native String realGetOUID(IBinder iBinder);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
