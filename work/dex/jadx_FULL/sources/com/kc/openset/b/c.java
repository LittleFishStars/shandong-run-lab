package com.kc.openset.b;

import android.content.Context;
import com.aliyun.sls.android.producer.Log;
import com.aliyun.sls.android.producer.LogProducerCallback;
import com.aliyun.sls.android.producer.LogProducerClient;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.OSETLogUploadBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LogProducerClient f39699a;
    private static LogProducerClient b;
    private static LogProducerClient c;
    private static LogProducerClient d;
    private static LogProducerClient e;
    private static LogProducerClient f;
    private static LogProducerClient g;
    private static LogProducerClient h;
    private static LogProducerClient i;
    private static LogProducerClient j;
    private static LogProducerClient k;
    private static LogProducerClient l;
    private static LogProducerClient m;
    private static LogProducerClient n;
    private static LogProducerClient o;
    private static LogProducerClient p;
    private static LogProducerClient q;
    private static LogProducerClient r;
    private static LogProducerClient s;
    private static LogProducerClient t;
    private static LogProducerClient u;
    private static LogProducerClient v;
    private static LogProducerClient w;
    private static LogProducerClient x;
    private static LogProducerClient y;
    private static LogProducerClient z;

    @Keep
    public class a implements LogProducerCallback {
        static {
            OSETSDKProtected.interface11(4290);
        }

        @Override // com.aliyun.sls.android.producer.LogProducerCallback
        public native void onCall(int i, String str, String str2, int i2, int i3);
    }

    static {
        OSETSDKProtected.interface11(4291);
    }

    private static native void A();

    private static native LogProducerClient a(String str, String str2);

    private static native String a(Context context, String str);

    private static native void a();

    private static native void a(Log log, OSETLogUploadBean oSETLogUploadBean);

    public static native void a(Log log, String str, String str2);

    public static native void a(LogProducerClient logProducerClient, Log log);

    public static native void a(OSETLogUploadBean oSETLogUploadBean);

    public static native void a(OSETLogUploadBean oSETLogUploadBean, LogProducerClient logProducerClient);

    private static native void b();

    private static native void b(Log log, OSETLogUploadBean oSETLogUploadBean);

    public static native void b(Log log, String str, String str2);

    public static native void b(OSETLogUploadBean oSETLogUploadBean);

    private static native void c();

    private static native void c(Log log, OSETLogUploadBean oSETLogUploadBean);

    public static native void c(OSETLogUploadBean oSETLogUploadBean);

    private static native void d();

    private static native void d(Log log, OSETLogUploadBean oSETLogUploadBean);

    public static native void d(OSETLogUploadBean oSETLogUploadBean);

    private static native void e();

    private static native void e(Log log, OSETLogUploadBean oSETLogUploadBean);

    public static native void e(OSETLogUploadBean oSETLogUploadBean);

    private static native void f();

    private static native void f(Log log, OSETLogUploadBean oSETLogUploadBean);

    public static native void f(OSETLogUploadBean oSETLogUploadBean);

    private static native void g();

    public static native void g(OSETLogUploadBean oSETLogUploadBean);

    private static native void h();

    public static native void h(OSETLogUploadBean oSETLogUploadBean);

    private static native void i();

    public static native void i(OSETLogUploadBean oSETLogUploadBean);

    private static native void j();

    public static native void j(OSETLogUploadBean oSETLogUploadBean);

    private static native void k();

    public static native void k(OSETLogUploadBean oSETLogUploadBean);

    private static native void l();

    public static native void l(OSETLogUploadBean oSETLogUploadBean);

    private static native void m();

    public static native void m(OSETLogUploadBean oSETLogUploadBean);

    private static native void n();

    public static native void n(OSETLogUploadBean oSETLogUploadBean);

    private static native void o();

    public static native void o(OSETLogUploadBean oSETLogUploadBean);

    private static native void p();

    public static native void p(OSETLogUploadBean oSETLogUploadBean);

    private static native void q();

    public static native void q(OSETLogUploadBean oSETLogUploadBean);

    public static native void r();

    public static native void r(OSETLogUploadBean oSETLogUploadBean);

    private static native void s();

    public static native void s(OSETLogUploadBean oSETLogUploadBean);

    private static native void t();

    public static native void t(OSETLogUploadBean oSETLogUploadBean);

    private static native void u();

    public static native void u(OSETLogUploadBean oSETLogUploadBean);

    private static native void v();

    public static native void v(OSETLogUploadBean oSETLogUploadBean);

    private static native void w();

    public static native void w(OSETLogUploadBean oSETLogUploadBean);

    private static native void x();

    public static native void x(OSETLogUploadBean oSETLogUploadBean);

    private static native void y();

    public static native void y(OSETLogUploadBean oSETLogUploadBean);

    private static native void z();

    public static native void z(OSETLogUploadBean oSETLogUploadBean);
}
