package com.kc.openset.oaid.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.oaid.IGetter;
import com.kc.openset.oaid.IOAID;
import com.kc.openset.oaid.IOAIDCallBack;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
class d implements IOAID {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39777a;
    private ServiceConnectionC1114d b;
    private IGetter c;
    private String d = OSETSDKProtected.getString2(1930);
    private final Handler e = new Handler(Looper.getMainLooper());
    private String f = OSETSDKProtected.getString2(1931);
    private String g = OSETSDKProtected.getString2(1932);
    private long h = System.currentTimeMillis();

    @Keep
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39778a;

        static {
            OSETSDKProtected.interface11(4499);
        }

        public a(d dVar) {
            this.f39778a = dVar;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final String f39779a;
        final d b;

        static {
            OSETSDKProtected.interface11(4500);
        }

        public b(d dVar, String str) {
            this.b = dVar;
            this.f39779a = str;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    @Keep
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Exception f39780a;
        final d b;

        static {
            OSETSDKProtected.interface11(4501);
        }

        public c(d dVar, Exception exc) {
            this.b = dVar;
            this.f39780a = exc;
        }

        @Override // java.lang.Runnable
        public native void run();
    }

    /* JADX INFO: renamed from: com.kc.openset.oaid.impl.d$d, reason: collision with other inner class name */
    @Keep
    public class ServiceConnectionC1114d implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        String f39781a = OSETSDKProtected.getString2(1919);
        final d b;

        static {
            OSETSDKProtected.interface11(4502);
        }

        public ServiceConnectionC1114d(d dVar) {
            this.b = dVar;
        }

        @Override // android.content.ServiceConnection
        public native void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(ComponentName componentName);
    }

    @Keep
    public class e extends IOAIDCallBack.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39782a;

        static {
            OSETSDKProtected.interface11(4503);
        }

        public e(d dVar) {
            this.f39782a = dVar;
        }

        @Override // com.kc.openset.oaid.IOAIDCallBack
        public native void basicTypes(int i, long j, boolean z, float f, double d, String str);

        @Override // com.kc.openset.oaid.IOAIDCallBack
        public native void handleResult(int i, Bundle bundle);
    }

    @Keep
    public class f extends IOAIDCallBack.Stub {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39783a;

        static {
            OSETSDKProtected.interface11(4504);
        }

        public f(d dVar) {
            this.f39783a = dVar;
        }

        @Override // com.kc.openset.oaid.IOAIDCallBack
        public native void basicTypes(int i, long j, boolean z, float f, double d, String str);

        @Override // com.kc.openset.oaid.IOAIDCallBack
        public native void handleResult(int i, Bundle bundle);
    }

    static {
        OSETSDKProtected.interface11(4505);
    }

    public d(Context context) {
        this.f39777a = context;
    }

    public static native /* synthetic */ IGetter a(d dVar);

    public static native /* synthetic */ ServiceConnectionC1114d a(d dVar, ServiceConnectionC1114d serviceConnectionC1114d);

    private native void a(Context context);

    public static native /* synthetic */ String b(d dVar);

    private native boolean b(Context context);

    public static native /* synthetic */ long c(d dVar);

    public static native /* synthetic */ ServiceConnectionC1114d d(d dVar);

    public native void a();

    public native void a(ServiceConnection serviceConnection);

    public native void a(Exception exc);

    public native void a(String str);

    @Override // com.kc.openset.oaid.IOAID
    public native void doGet(IGetter iGetter);

    @Override // com.kc.openset.oaid.IOAID
    public native boolean supported();
}
