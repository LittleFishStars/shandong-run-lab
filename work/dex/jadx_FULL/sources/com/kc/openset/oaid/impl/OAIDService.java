package com.kc.openset.oaid.impl;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class OAIDService implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39771a;
    private final IGetter b;
    private final RemoteCaller c;

    @Keep
    @FunctionalInterface
    public interface RemoteCaller {
        String callRemoteInterface(IBinder iBinder);
    }

    static {
        OSETSDKProtected.interface11(4489);
    }

    private OAIDService(Context context, IGetter iGetter, RemoteCaller remoteCaller) {
        this.f39771a = context instanceof Application ? context : context.getApplicationContext();
        this.b = iGetter;
        this.c = remoteCaller;
    }

    public static native void a(Context context, Intent intent, IGetter iGetter, RemoteCaller remoteCaller);

    private native void a(Intent intent);

    @Override // android.content.ServiceConnection
    public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

    @Override // android.content.ServiceConnection
    public native void onServiceDisconnected(ComponentName componentName);
}
