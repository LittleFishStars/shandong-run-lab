package com.alipay.apmobilesecuritysdk.face;

import android.content.Context;
import com.alibaba.ariver.resource.api.prepare.PrepareException;
import com.alipay.apmobilesecuritysdk.a.a;
import com.alipay.apmobilesecuritysdk.e.d;
import com.alipay.apmobilesecuritysdk.e.g;
import com.alipay.apmobilesecuritysdk.e.h;
import com.alipay.apmobilesecuritysdk.e.i;
import com.alipay.apmobilesecuritysdk.f.b;
import com.alipay.apmobilesecuritysdk.otherid.UmidSdkWrapper;
import com.alipay.apmobilesecuritysdk.otherid.UtdidWrapper;
import com.alipay.sdk.m.f0.f;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class APSecuritySdk implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static APSecuritySdk f25348a;
    public static APSecBgCheckerInterface bgChecker;
    private static IDeviceInfo c;
    private static Object d = new Object();
    private Context b;

    public interface InitResultListener {
        void onResult(TokenResult tokenResult);
    }

    public class TokenResult {
        public String apdid;
        public String apdidToken;
        public String clientKey;
        public String umidToken;

        public TokenResult() {
        }
    }

    private APSecuritySdk(Context context) {
        this.b = context;
    }

    public static IDeviceInfo getDeviceInfo() {
        return c;
    }

    public static APSecuritySdk getInstance(Context context) {
        if (f25348a == null) {
            synchronized (d) {
                if (f25348a == null) {
                    f25348a = new APSecuritySdk(context);
                }
            }
        }
        return f25348a;
    }

    public static String getUtdid(Context context) {
        return UtdidWrapper.getUtdid(context);
    }

    public static void registerBgChecker(APSecBgCheckerInterface aPSecBgCheckerInterface) {
        bgChecker = aPSecBgCheckerInterface;
    }

    public static void registerDeviceInfo(IDeviceInfo iDeviceInfo) {
        c = iDeviceInfo;
    }

    @Override // com.alipay.sdk.m.f0.f
    public String getAndroidId() {
        IDeviceInfo iDeviceInfo = c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getAndroidId();
        }
        return null;
    }

    public String getApdidToken() {
        String strA = a.a(this.b, "");
        if (com.alipay.sdk.m.d0.a.a(strA)) {
            initToken(0, new HashMap(), null);
        }
        return strA;
    }

    public String getSdkName() {
        return "APPSecuritySDK-ALIPAYSDK";
    }

    public String getSdkVersion() {
        return "3.4.0.202507280853";
    }

    @Override // com.alipay.sdk.m.f0.f
    public String getSubscriberId() {
        IDeviceInfo iDeviceInfo = c;
        if (iDeviceInfo != null) {
            return iDeviceInfo.getSubscriberId();
        }
        return null;
    }

    public synchronized TokenResult getTokenResult() {
        TokenResult tokenResult;
        tokenResult = new TokenResult();
        try {
            tokenResult.apdidToken = a.a(this.b, "");
            tokenResult.clientKey = h.f(this.b);
            tokenResult.apdid = a.b(this.b);
            tokenResult.umidToken = UmidSdkWrapper.getSecurityToken(this.b);
            if (com.alipay.sdk.m.d0.a.a(tokenResult.apdid) || com.alipay.sdk.m.d0.a.a(tokenResult.apdidToken) || com.alipay.sdk.m.d0.a.a(tokenResult.clientKey)) {
                initToken(0, new HashMap(), null);
            }
        } catch (Throwable unused) {
        }
        return tokenResult;
    }

    public void initToken(int i, Map<String, String> map, final InitResultListener initResultListener) {
        com.alipay.apmobilesecuritysdk.b.a.a().a(i);
        String strB = h.b(this.b);
        String strC = com.alipay.apmobilesecuritysdk.b.a.a().c();
        if (com.alipay.sdk.m.d0.a.b(strB) && !com.alipay.sdk.m.d0.a.a(strB, strC)) {
            com.alipay.apmobilesecuritysdk.e.a.b(this.b);
            d.a(this.b);
            g.a(this.b);
            i.h();
        }
        if (!com.alipay.sdk.m.d0.a.a(strB, strC)) {
            h.c(this.b, strC);
        }
        String strA = com.alipay.sdk.m.d0.a.a(map, "utdid", "");
        String strA2 = com.alipay.sdk.m.d0.a.a(map, "tid", "");
        String strA3 = com.alipay.sdk.m.d0.a.a(map, "userId", "");
        if (com.alipay.sdk.m.d0.a.a(strA)) {
            strA = UtdidWrapper.getUtdid(this.b);
        }
        final HashMap map2 = new HashMap();
        map2.put("utdid", strA);
        map2.put("tid", strA2);
        map2.put("userId", strA3);
        map2.put("appName", "");
        map2.put("appKeyClient", "");
        map2.put("appchannel", "");
        map2.put("rpcVersion", PrepareException.ERROR_AUTH_FAIL);
        b.a().a(new Runnable(this) { // from class: com.alipay.apmobilesecuritysdk.face.APSecuritySdk.1
            public final /* synthetic */ APSecuritySdk c;

            {
                this.c = this;
            }

            @Override // java.lang.Runnable
            public void run() {
                new a(this.c.b).a(map2);
                InitResultListener initResultListener2 = initResultListener;
                if (initResultListener2 != null) {
                    initResultListener2.onResult(this.c.getTokenResult());
                }
            }
        });
    }

    @Override // com.alipay.sdk.m.f0.f
    public boolean isBackgroundRunning() {
        APSecBgCheckerInterface aPSecBgCheckerInterface = bgChecker;
        if (aPSecBgCheckerInterface != null) {
            return aPSecBgCheckerInterface.isBackgroundRunning();
        }
        return false;
    }
}
