package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alibaba.ariver.kernel.RVParams;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.d0.a;
import java.util.HashMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TMNTokenClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static TMNTokenClient f25351a;
    private Context b;

    public interface InitResultListener {
        void onResult(String str, int i);
    }

    private TMNTokenClient(Context context) {
        this.b = null;
        if (context == null) {
            throw new IllegalArgumentException("TMNTokenClient initialization error: context is null.");
        }
        this.b = context;
    }

    public static TMNTokenClient getInstance(Context context) {
        if (f25351a == null) {
            synchronized (TMNTokenClient.class) {
                if (f25351a == null) {
                    f25351a = new TMNTokenClient(context);
                }
            }
        }
        return f25351a;
    }

    public void intiToken(final String str, String str2, String str3, final InitResultListener initResultListener) {
        if (a.a(str) && initResultListener != null) {
            initResultListener.onResult("", 2);
        }
        if (a.a(str2) && initResultListener != null) {
            initResultListener.onResult("", 3);
        }
        final HashMap map = new HashMap();
        map.put("utdid", UtdidWrapper.getUtdid(this.b));
        map.put("tid", "");
        map.put("userId", "");
        map.put("appName", str);
        map.put("appKeyClient", str2);
        map.put("appchannel", "openapi");
        map.put(RVParams.SESSION_ID, str3);
        map.put("rpcVersion", PrepareException.ERROR_AUTH_FAIL);
        b.a().a(new Runnable(this) { // from class: com.alipay.apmobilesecuritysdk.face.TMNTokenClient.1
            public final /* synthetic */ TMNTokenClient d;

            {
                this.d = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                int iA = new com.alipay.apmobilesecuritysdk.a.a(this.d.b).a(map);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 == null) {
                    return;
                }
                if (iA != 0) {
                    initResultListener2.onResult("", iA);
                } else {
                    initResultListener.onResult(com.alipay.apmobilesecuritysdk.a.a.a(this.d.b, str), 0);
                }
            }
        });
    }
}
