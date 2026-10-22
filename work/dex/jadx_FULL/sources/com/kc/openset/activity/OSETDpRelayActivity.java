package com.kc.openset.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.SSActivityLifecycleCallbacks;
import com.kc.openset.plugin.DpOptResultListener;
import com.kc.openset.sdk.apiad.tools.DeeplinkCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETDpRelayActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static DeeplinkCallback f39595a;
    private static final List<Pair<String, String>> b;
    private String h;
    private String i;
    private JSONArray c = new JSONArray();
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private boolean j = false;
    private boolean k = false;
    private long l = 0;
    private final Handler m = new a(this, Looper.getMainLooper());
    private final SSActivityLifecycleCallbacks n = new c(this);

    @Keep
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETDpRelayActivity f39596a;

        static {
            OSETSDKProtected.interface11(3689);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OSETDpRelayActivity oSETDpRelayActivity, Looper looper) {
            super(looper);
            this.f39596a = oSETDpRelayActivity;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    @Keep
    public class b implements DpOptResultListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Intent f39597a;
        final OSETDpRelayActivity b;

        static {
            OSETSDKProtected.interface11(3690);
        }

        public b(OSETDpRelayActivity oSETDpRelayActivity, Intent intent) {
            this.b = oSETDpRelayActivity;
            this.f39597a = intent;
        }

        @Override // com.kc.openset.plugin.DpOptResultListener
        public native void onDpOptFail(String str);

        @Override // com.kc.openset.plugin.DpOptResultListener
        public native void onDpOptSuccess();
    }

    @Keep
    public class c extends SSActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETDpRelayActivity f39598a;

        static {
            OSETSDKProtected.interface11(3691);
        }

        public c(OSETDpRelayActivity oSETDpRelayActivity) {
            this.f39598a = oSETDpRelayActivity;
        }

        private native boolean a();

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks
        public native void onBackToBackground();

        @Override // com.kc.openset.ad.base.SSActivityLifecycleCallbacks
        public native void onBackToForeground();
    }

    /* JADX INFO: renamed from: $r8$lambda$SRy-hZOoNLC6PdXOgxto_usFJ-w, reason: not valid java name */
    public static native /* synthetic */ void m1006$r8$lambda$SRyhZOoNLC6PdXOgxto_usFJw(OSETDpRelayActivity oSETDpRelayActivity);

    public static native /* synthetic */ void $r8$lambda$vlFlfFrICqERBIYa0gK5vzJcQgQ(OSETDpRelayActivity oSETDpRelayActivity);

    static {
        OSETSDKProtected.interface11(3692);
        b = new ArrayList();
    }

    public static native /* synthetic */ long a(OSETDpRelayActivity oSETDpRelayActivity, long j);

    public static native /* synthetic */ DeeplinkCallback a();

    public static native void a(Context context, String str, String str2, DeeplinkCallback deeplinkCallback);

    private native void a(Intent intent, String str);

    public static native /* synthetic */ void a(OSETDpRelayActivity oSETDpRelayActivity, Intent intent);

    private native boolean a(Intent intent);

    public static native /* synthetic */ boolean a(OSETDpRelayActivity oSETDpRelayActivity);

    public static native /* synthetic */ boolean a(OSETDpRelayActivity oSETDpRelayActivity, boolean z);

    public static native boolean a(String str);

    public static native /* synthetic */ Handler b(OSETDpRelayActivity oSETDpRelayActivity);

    private native void b(Intent intent);

    private native boolean b();

    public static native /* synthetic */ boolean b(OSETDpRelayActivity oSETDpRelayActivity, boolean z);

    private native void c();

    private native void c(Intent intent);

    public static native /* synthetic */ boolean c(OSETDpRelayActivity oSETDpRelayActivity);

    public static native /* synthetic */ JSONArray d(OSETDpRelayActivity oSETDpRelayActivity);

    private native void d();

    public static native /* synthetic */ void e(OSETDpRelayActivity oSETDpRelayActivity);

    public static native boolean e();

    private native /* synthetic */ void f();

    public static native /* synthetic */ void f(OSETDpRelayActivity oSETDpRelayActivity);

    public static native /* synthetic */ long g(OSETDpRelayActivity oSETDpRelayActivity);

    private native void g();

    private native void h();

    public static native /* synthetic */ boolean h(OSETDpRelayActivity oSETDpRelayActivity);

    public native String b(String str);

    @Override // android.app.Activity
    public native void finish();

    @Override // android.app.Activity
    public native void onActivityResult(int i, int i2, Intent intent);

    @Override // android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public native void onPause();

    @Override // android.app.Activity
    public native void onResume();
}
