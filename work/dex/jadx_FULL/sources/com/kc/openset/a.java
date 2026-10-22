package com.kc.openset;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.i;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.kc.openset.verify.ServiceVerifyResultListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: com.kc.openset.a$a, reason: collision with other inner class name */
    @Keep
    public class C1101a implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ServiceVerifyResultListener f39591a;
        final OnServiceRewardListener b;

        static {
            OSETSDKProtected.interface11(3681);
        }

        public C1101a(ServiceVerifyResultListener serviceVerifyResultListener, OnServiceRewardListener onServiceRewardListener) {
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    @Keep
    public class b implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ServiceVerifyResultListener f39592a;
        final String b;

        static {
            OSETSDKProtected.interface11(3682);
        }

        public b(ServiceVerifyResultListener serviceVerifyResultListener, String str) {
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    static {
        OSETSDKProtected.interface11(3685);
    }

    public static native void a(Context context, String str, String str2, String str3, String str4, String str5, ServiceVerifyResultListener serviceVerifyResultListener);

    public static native void a(i iVar, OnServiceRewardListener onServiceRewardListener, ServiceVerifyResultListener serviceVerifyResultListener);
}
