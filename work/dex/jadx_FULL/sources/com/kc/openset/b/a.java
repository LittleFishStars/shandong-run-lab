package com.kc.openset.b;

import android.content.Context;
import com.aliyun.sls.android.producer.LogProducerCallback;
import com.aliyun.sls.android.producer.LogProducerClient;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static LogProducerClient f39697a;

    /* JADX INFO: renamed from: com.kc.openset.b.a$a, reason: collision with other inner class name */
    @Keep
    public class C1108a implements LogProducerCallback {
        static {
            OSETSDKProtected.interface11(4286);
        }

        @Override // com.aliyun.sls.android.producer.LogProducerCallback
        public native void onCall(int i, String str, String str2, int i2, int i3);
    }

    static {
        OSETSDKProtected.interface11(4287);
    }

    private static native String a(Context context, String str);

    private static native void a();

    public static native void a(String str, String str2);

    public static native void b();

    public static native void c();
}
