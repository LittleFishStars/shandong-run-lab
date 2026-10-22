package com.kc.openset.common.okhttp;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class RedirectInterceptor implements Interceptor {
    private static final int MAX_REDIRECTS = 10;

    static {
        OSETSDKProtected.interface11(4389);
    }

    private native boolean isRedirect(Response response);

    public native Response intercept(Interceptor.Chain chain) throws IOException;
}
