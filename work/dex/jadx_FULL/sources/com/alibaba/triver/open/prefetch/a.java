package com.alibaba.triver.open.prefetch;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.ariver.kernel.common.network.http.RVHttpRequest;
import com.alibaba.ariver.kernel.common.network.http.RVHttpResponse;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f25070a = "HttpRequestCache";
    private static Map<String, RVHttpResponse> b = new LinkedHashMap(32);

    public static void a(RVHttpRequest rVHttpRequest, RVHttpResponse rVHttpResponse) {
        if (rVHttpRequest == null || TextUtils.isEmpty(rVHttpRequest.getUrl()) || rVHttpResponse == null) {
            return;
        }
        try {
            a();
            b.put(a(rVHttpRequest.getUrl()), rVHttpResponse);
            RVLogger.d(f25070a, "cacheRequest: " + rVHttpRequest.getUrl());
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
        }
    }

    public static RVHttpResponse a(RVHttpRequest rVHttpRequest) {
        if (rVHttpRequest != null && !TextUtils.isEmpty(rVHttpRequest.getUrl())) {
            try {
                RVHttpResponse rVHttpResponseRemove = b.remove(a(rVHttpRequest.getUrl()));
                if (rVHttpResponseRemove != null) {
                    RVLogger.d(f25070a, "hit cache: " + rVHttpRequest.getUrl());
                    return rVHttpResponseRemove;
                }
            } catch (Throwable th) {
                RVLogger.w(Log.getStackTraceString(th));
            }
        }
        return null;
    }

    private static void a() {
        if (b.size() > 32) {
            Iterator<String> it = b.keySet().iterator();
            for (int size = b.size() - 32; size >= 0 && it.hasNext(); size--) {
                b.remove(it.next());
            }
        }
    }

    private static String a(String str) {
        int iIndexOf = str.indexOf("?");
        return iIndexOf > 0 ? str.substring(0, iIndexOf) : str;
    }
}
