package com.kc.openset.util;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public final /* synthetic */ class OAIDUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final Method f$0;
    public final Context f$1;

    static {
        OSETSDKProtected.interface11(4947);
    }

    public /* synthetic */ OAIDUtils$$ExternalSyntheticLambda0(Method method, Context context) {
        this.f$0 = method;
        this.f$1 = context;
    }

    @Override // java.lang.Runnable
    public final native void run();
}
