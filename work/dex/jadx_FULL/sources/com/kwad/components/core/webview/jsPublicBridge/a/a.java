package com.kwad.components.core.webview.jsPublicBridge.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.telephony.TelephonyManager;
import androidx.annotation.NonNull;
import com.aliyun.vod.log.core.AliyunLogCommon;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.config.e;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.SystemUtil;
import com.kwad.sdk.utils.aq;
import com.kwad.sdk.utils.n;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class a implements com.kwad.sdk.core.webview.c.a {

    /* JADX INFO: renamed from: com.kwad.components.core.webview.jsPublicBridge.a.a$a, reason: collision with other inner class name */
    @KsJson
    public static final class C1234a extends com.kwad.sdk.core.response.a.a {
        public int apb;
        public int apc;
        public int apd;
        public String ape;
        public String apf;
        public String apg;
        public String appVersion;
        public int netType;

        private static int ym() {
            if (!SystemUtil.b(ServiceProvider.getContext(), "android.permission.ACCESS_NETWORK_STATE")) {
                return -1;
            }
            try {
                Context context = ServiceProvider.getContext();
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(AliyunLogCommon.TERMINAL_TYPE);
                if (connectivityManager == null) {
                    return -1;
                }
                boolean zIsDataEnabled = telephonyManager.isDataEnabled();
                boolean zIsWifiConnected = aq.isWifiConnected(context);
                if (zIsDataEnabled && zIsWifiConnected) {
                    return 3;
                }
                if (zIsDataEnabled) {
                    return 1;
                }
                return zIsWifiConnected ? 2 : -1;
            } catch (Exception e) {
                c.printStackTraceOnly(e);
                return -1;
            }
        }

        public static C1234a yq() {
            C1234a c1234a = new C1234a();
            c1234a.apb = 6;
            c1234a.apc = 2;
            c1234a.apd = 2;
            c1234a.appVersion = n.cZ(((f) ServiceProvider.get(f.class)).getContext());
            c1234a.netType = ym();
            c1234a.ape = e.KZ();
            c1234a.apf = "KSAdChinaMobile.ksadGetPhoneNumber";
            c1234a.apg = "KSAdChinaMobile.ksadGetOperJudge";
            return c1234a;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        cVar.b(C1234a.yq());
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "ksadUnionGetPlatformInfo";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
    }
}
