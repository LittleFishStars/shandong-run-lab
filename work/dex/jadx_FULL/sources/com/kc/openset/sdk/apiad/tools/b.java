package com.kc.openset.sdk.apiad.tools;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static long f39917a;
    public static String b;

    @Keep
    public class a implements DeeplinkCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final APIAdClickCallback f39918a;
        final Context b;
        final c c;

        static {
            OSETSDKProtected.interface11(4883);
        }

        public a(APIAdClickCallback aPIAdClickCallback, Context context, c cVar) {
            this.f39918a = aPIAdClickCallback;
            this.b = context;
            this.c = cVar;
        }

        @Override // com.kc.openset.sdk.apiad.tools.DeeplinkCallback
        public native void onDeeplinkResult(boolean z, String str);

        @Override // com.kc.openset.sdk.apiad.tools.DeeplinkCallback
        public native void onViewFinish(long j);
    }

    /* JADX INFO: renamed from: com.kc.openset.sdk.apiad.tools.b$b, reason: collision with other inner class name */
    @Keep
    public class C1122b implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Context f39919a;
        final c b;
        final APIAdClickCallback c;

        static {
            OSETSDKProtected.interface11(4884);
        }

        public C1122b(Context context, c cVar, APIAdClickCallback aPIAdClickCallback) {
            this.f39919a = context;
            this.b = cVar;
            this.c = aPIAdClickCallback;
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    public static native /* synthetic */ void $r8$lambda$ey61ONUOOqL86KPG95mkM1icBQM(Context context, String str, View view);

    static {
        OSETSDKProtected.interface11(4885);
    }

    public static native String a(String str);

    public static native void a(Context context, TextView textView, String str);

    public static native void a(Context context, c cVar, APIAdClickCallback aPIAdClickCallback);

    private static native /* synthetic */ void a(Context context, String str, View view);

    public static native /* synthetic */ boolean a(Context context, String str, APIAdClickCallback aPIAdClickCallback);

    public static native boolean a(c cVar);

    private static native boolean b(Context context, c cVar, APIAdClickCallback aPIAdClickCallback);

    private static native boolean b(Context context, String str, APIAdClickCallback aPIAdClickCallback);

    private static native void c(Context context, c cVar, APIAdClickCallback aPIAdClickCallback);

    private static native boolean d(Context context, c cVar, APIAdClickCallback aPIAdClickCallback);

    private static native void e(Context context, c cVar, APIAdClickCallback aPIAdClickCallback);
}
