package com.byazt.kz;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.byazt.bv.BaseConstants;
import com.byazt.bwm.sp;
import com.byazt.bzd.x;
import com.byazt.ddx.uj;
import com.byazt.dna.u;
import com.byazt.el.SSWebView;
import com.byazt.ete.ic;
import com.byazt.fiq.a;
import com.byazt.fiq.n;
import com.byazt.nr.m;
import com.byazt.nr.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 144, 20})
public class c {
    public ic c;
    public SSWebView tt;
    public int uj;
    public Context ve;
    public int n = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28763a = -3;
    public int sp = -1;

    /* JADX INFO: renamed from: com.byazt.kz.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 144, 44})
    public static class C0460c implements com.byazt.fiq.ve {
        public final WeakReference<SSWebView> c;
        public final int n;
        public final ic tt;
        public final int uj;
        public final long ve;

        public C0460c(WeakReference<SSWebView> weakReference, ic icVar, long j, int i, int i2) {
            this.c = weakReference;
            this.tt = icVar;
            this.ve = j;
            this.uj = i;
            this.n = i2;
        }

        @Override // com.byazt.fiq.ve
        public void c(boolean z, int i, int i2, String str, Map<String, List<String>> map, String str2) {
            m.c("transmit_TTWifiObject", "TransmitBusiness_onResponse s : " + z + " code:" + i2 + " msg:" + str + "  body:" + str2);
            if (z) {
                str = "取号成功";
            } else if (TextUtils.isEmpty(str)) {
                str = "取号失败";
            }
            uj.c(this.tt, "wifi_auth", "click_other", new ve(System.currentTimeMillis() - this.ve, i, z, str, this.uj, this.n));
            JSONObject jSONObject = new JSONObject();
            if (str2 == null) {
                str2 = "";
            }
            try {
                jSONObject.put("data", str2);
                jSONObject.put("networkType", i);
            } catch (JSONException unused) {
            }
            SSWebView sSWebView = this.c.get();
            if (sSWebView != null) {
                yp.c(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 144, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED})
    public static class tt extends sp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28764a;
        public final WeakReference<SSWebView> c;
        public final long n;
        public final int sp;
        public final Context tt;
        public final String uj;
        public final ic ve;

        public tt(SSWebView sSWebView, Context context, ic icVar, String str, long j, int i, int i2) {
            super("send_network_switch");
            this.c = new WeakReference<>(sSWebView);
            this.tt = context != null ? context.getApplicationContext() : null;
            this.ve = icVar;
            this.uj = str;
            this.n = j;
            this.f28764a = i;
            this.sp = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Context context = this.tt;
            if (context != null) {
                new a(context, new com.byazt.fiq.c()).c(this.uj, new C0460c(this.c, this.ve, this.n, this.f28764a, this.sp));
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("data", "取号失败，context is null");
                jSONObject.put("networkType", 0);
            } catch (JSONException unused) {
            }
            SSWebView sSWebView = this.c.get();
            if (sSWebView != null) {
                yp.c(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
            }
            uj.c(this.ve, "wifi_auth", "click_other", new ve(System.currentTimeMillis() - this.n, 0, false, "context is null", this.f28764a, this.sp));
        }
    }

    @com.byazt.zqa.c(c = {0, 1, 144, 132})
    public static class ve implements com.byazt.ya.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f28765a;
        public final long c;
        public final int n;
        public final int tt;
        public final String uj;
        public final boolean ve;

        public ve(long j, int i, boolean z, String str, int i2, int i3) {
            this.c = j;
            this.tt = i;
            this.ve = z;
            this.uj = str;
            this.n = i2;
            this.f28765a = i3;
        }

        @Override // com.byazt.ya.c
        public void onSend(JSONObject jSONObject) throws JSONException {
            jSONObject.put("duration", this.c);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.putOpt("wifi_auth_referer", "huoshan_JSSDK");
            jSONObject2.putOpt("wifi_auth_network_type", Integer.valueOf(this.tt));
            jSONObject2.putOpt("wifi_auth_duration", Long.valueOf(this.c));
            jSONObject2.putOpt("wifi_auth_status", this.ve ? "success" : "failure");
            String str = this.uj;
            if (str == null) {
                str = "";
            }
            jSONObject2.putOpt("wifi_auth_detail_info", str);
            jSONObject2.putOpt("wifi_auth_carrier", Integer.valueOf(this.n));
            jSONObject2.putOpt("wifi_auth_redirect_time", Integer.valueOf(this.f28765a));
            jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2.toString());
        }
    }

    public c(SSWebView sSWebView, Context context, int i, ic icVar) {
        this.tt = sSWebView;
        this.ve = context;
        this.uj = i;
        this.c = icVar;
    }

    @JavascriptInterface
    public int getNetOperatorType() {
        m.c("transmit_TTWifiObject", "getNetOperatorType PhoneNumStatus:" + this.uj);
        final int iC = c();
        if (iC == -1 || iC == -2) {
            final long jCurrentTimeMillis = System.currentTimeMillis();
            x.c(new sp("getNetOperatorType") { // from class: com.byazt.kz.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.c(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "获取运行商类型为-1或-2,直接标记取号失败", iC, c.this.n);
                }
            });
        }
        m.c("transmit_TTWifiObject", "getNetOperatorType type:".concat(String.valueOf(iC)));
        return iC;
    }

    @JavascriptInterface
    public String sendNetworkSwitch(String str) {
        int iC;
        Context context;
        m.c("transmit_TTWifiObject", "send_switch PhoneNumStatus:" + this.uj + "  params:" + str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (this.uj > 0) {
            try {
                iC = new JSONObject(str).optInt("operType");
            } catch (JSONException unused) {
                iC = -3;
            }
            if (iC != 1 && iC != 2 && iC != 3) {
                iC = c();
            }
            if (iC == 3 && this.f28763a == 3) {
                this.n++;
            } else {
                this.n = 1;
            }
            this.f28763a = iC;
            x.c((sp) new tt(this.tt, this.ve, this.c, str, jCurrentTimeMillis, iC, this.n));
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        if (this.sp == -1 && (context = this.ve) != null) {
            this.sp = n.c(context, n.c(context));
        }
        try {
            jSONObject.put("data", "没有wifi网络下获取手机号权限");
            jSONObject.put("networkType", this.sp);
        } catch (JSONException unused2) {
        }
        SSWebView sSWebView = this.tt;
        if (sSWebView != null) {
            yp.c(sSWebView, "javascript:receiveNetworkSwitch(" + jSONObject + ")");
        }
        c(-1, System.currentTimeMillis() - jCurrentTimeMillis, false, "没有wifi网络下获取手机号权限", -1, this.n);
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, long j, boolean z, String str, int i2, int i3) {
        m.c("transmit_TTWifiObject", "TTWifiObject sendWifiEvent duration:" + j + "  networkType:" + i + "   s:" + z + "  detailInfo:" + str + " simType:" + i2 + "  redirectTime:" + i3);
        uj.c(this.c, "wifi_auth", "click_other", new ve(j, i, z, str, i2, i3));
    }

    public int c() {
        int i = this.uj;
        if (i <= 0) {
            return -1;
        }
        Context context = this.ve;
        if (context == null || i == 1) {
            return -3;
        }
        int iC = n.c(context, n.c(context));
        this.sp = iC;
        if (iC == 0 || iC == 2) {
            return -2;
        }
        String activeSimOperatorStr = ((u) com.byazt.ut.uj.getService("device_info_new")).getActiveSimOperatorStr();
        activeSimOperatorStr.hashCode();
        switch (activeSimOperatorStr) {
            case "1":
                return 1;
            case "2":
                return 3;
            case "3":
                return 2;
            default:
                return -3;
        }
    }
}
