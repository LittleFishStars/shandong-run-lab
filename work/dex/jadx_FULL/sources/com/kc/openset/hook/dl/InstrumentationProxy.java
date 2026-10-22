package com.kc.openset.hook.dl;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.utils.LogUtilsBridge;
import com.kc.openset.bean.a;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class InstrumentationProxy extends Instrumentation {
    private static final String RESULT_FAIL = OSETSDKProtected.getString2(434);
    private static final String RESULT_SUCCESS = OSETSDKProtected.getString2(1794);
    private static final String TAG = OSETSDKProtected.getString2(1793);
    Instrumentation mInstrumentation;

    /* JADX INFO: renamed from: com.kc.openset.hook.dl.InstrumentationProxy$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements OSETHttpCallback {
        final InstrumentationProxy this$0;
        final String val$dataString;
        final a.C1109a val$deepLink;
        final String val$dl;
        final String val$url;

        static {
            OSETSDKProtected.interface11(4456);
        }

        public AnonymousClass1(InstrumentationProxy instrumentationProxy, String str, String str2, String str3, a.C1109a c1109a) {
            this.this$0 = instrumentationProxy;
            this.val$dl = str;
            this.val$url = str2;
            this.val$dataString = str3;
            this.val$deepLink = c1109a;
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    static {
        OSETSDKProtected.interface11(4457);
    }

    public InstrumentationProxy(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
        String string2 = OSETSDKProtected.getString2(1793);
        LogUtilsBridge.writeD(string2, string2);
    }

    public static native /* synthetic */ void access$000(InstrumentationProxy instrumentationProxy, String str, String str2, String str3, int i, String str4, String str5, String str6);

    public static native boolean matches(String str, String str2);

    private native Instrumentation.ActivityResult next(Method method, Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle);

    private native void upLoadLog(String str, String str2, String str3, int i, String str4, String str5, String str6);

    public native Instrumentation.ActivityResult execStartActivity(Context context, IBinder iBinder, IBinder iBinder2, Activity activity, Intent intent, int i, Bundle bundle);

    @Override // android.app.Instrumentation
    public native Activity newActivity(ClassLoader classLoader, String str, Intent intent);
}
