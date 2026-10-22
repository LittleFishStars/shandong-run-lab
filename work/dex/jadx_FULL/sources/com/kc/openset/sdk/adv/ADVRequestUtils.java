package com.kc.openset.sdk.adv;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.kc.openset.config.OSETSDK;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class ADVRequestUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f39811a;

    @Keep
    public interface AdvCallback {
        void onFail(int i, String str);

        void onSuccess(com.kc.openset.sdk.adv.a aVar);
    }

    @Keep
    public @interface ResponseCode {
        public static final int ERROR_INVALID = 1;
        public static final int ERROR_IP = 1001;
        public static final int ERROR_NOT_CONFIG = 1004;
        public static final int ERROR_OS_TYPE = 1002;
        public static final int ERROR_PARAMS = 1000;
        public static final int ERROR_TAG_ID = 1003;
        public static final int SUCCESS = 0;
    }

    @Keep
    public class a implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final AdvCallback f39812a;
        final ADVRequestUtils b;

        static {
            OSETSDKProtected.interface11(4690);
        }

        public a(ADVRequestUtils aDVRequestUtils, AdvCallback advCallback) {
            this.b = aDVRequestUtils;
            this.f39812a = advCallback;
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    static {
        OSETSDKProtected.interface11(4691);
        f39811a = OSETSDK.getInstance().getVersionCode();
    }

    public static native com.kc.openset.sdk.adv.a.C1115a a(JSONObject jSONObject);

    public static native /* synthetic */ com.kc.openset.sdk.adv.a a(ADVRequestUtils aDVRequestUtils, String str);

    private native com.kc.openset.sdk.adv.a a(String str);

    private static native b.C1116b a(Context context);

    private static native b.i a(Context context, String str, int i);

    private native String a(Object obj, String str);

    private native List<com.kc.openset.sdk.adv.a.k> a(String str, JSONObject jSONObject);

    public static native /* synthetic */ boolean a(int i);

    private native com.kc.openset.sdk.adv.a.b b(JSONObject jSONObject);

    private static native b.d b(Context context);

    private static native boolean b(int i);

    public static native com.kc.openset.sdk.adv.a.d c(JSONObject jSONObject);

    private native List<com.kc.openset.sdk.adv.a.e> d(JSONObject jSONObject);

    public static native com.kc.openset.sdk.adv.a.f e(JSONObject jSONObject);

    public static native com.kc.openset.sdk.adv.a.g f(JSONObject jSONObject);

    private native com.kc.openset.sdk.adv.a.h g(JSONObject jSONObject);

    private native List<com.kc.openset.sdk.adv.a.j> h(JSONObject jSONObject);

    private native com.kc.openset.sdk.adv.a.l i(JSONObject jSONObject);

    public native String a(Context context, String str, String str2, int i);

    public native String a(Context context, String str, String str2, int i, String str3);

    public native void a(String str, AdvCallback advCallback);

    public native void a(String str, String str2, AdvCallback advCallback);

    public native void b(String str, AdvCallback advCallback);
}
