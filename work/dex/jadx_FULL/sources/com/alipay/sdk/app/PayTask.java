package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.ali.auth.third.login.LoginConstants;
import com.alipay.sdk.R;
import com.alipay.sdk.app.debug.AlipayDebugOptions;
import com.alipay.sdk.m.u.h;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.k;
import com.alipay.sdk.m.y.l;
import com.alipay.sdk.m.y.m;
import com.alipay.sdk.m.y.o;
import com.alipay.sdk.m.y.p;
import com.alipay.sdk.m.y.q;
import com.alipay.sdk.util.H5PayResultModel;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PayTask {
    public static final Object j = k.class;
    public static long k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Activity f25375a;
    public com.alipay.sdk.m.c0.a b;
    public final String c = "wappaygw.alipay.com/service/rest.htm";
    public final String d = "mclient.alipay.com/service/rest.htm";
    public final String e = "mclient.alipay.com/home/exterfaceAssign.htm";
    public final String f = "mclient.alipay.com/cashier/mobilepay.htm";
    public final String g = "mclient.alipay.hk";
    public final String h = "render.alipay.hk";
    public Map<String, e> i = new HashMap();

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f25376a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ H5PayCallback c;

        public b(String str, boolean z, H5PayCallback h5PayCallback) {
            this.f25376a = str;
            this.b = z;
            this.c = h5PayCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            H5PayResultModel h5PayResultModelH5Pay = PayTask.this.h5Pay(new com.alipay.sdk.m.w.a(PayTask.this.f25375a, this.f25376a, "payInterceptorWithUrl"), this.f25376a, this.b);
            g.d(com.alipay.sdk.m.n.a.B, "inc finished: " + h5PayResultModelH5Pay.getResultCode());
            this.c.onPayResult(h5PayResultModelH5Pay);
        }
    }

    public class c implements k.f {
        public c() {
        }

        @Override // com.alipay.sdk.m.y.k.f
        public void a() {
            PayTask.this.dismissLoading();
        }

        @Override // com.alipay.sdk.m.y.k.f
        public void b() {
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.alipay.sdk.m.w.a f25378a;
        public final /* synthetic */ String b;

        public d(com.alipay.sdk.m.w.a aVar, String str) {
            this.f25378a = aVar;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            PayTask.this.b(this.f25378a, this.b);
        }
    }

    public class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f25379a;
        public String b;
        public String c;
        public String d;

        public e() {
            this.f25379a = "";
            this.b = "";
            this.c = "";
            this.d = "";
        }

        public String a() {
            return this.c;
        }

        public String b() {
            return this.f25379a;
        }

        public String c() {
            return this.b;
        }

        public String d() {
            return this.d;
        }

        public void a(String str) {
            this.c = str;
        }

        public void b(String str) {
            this.f25379a = str;
        }

        public void c(String str) {
            this.b = str;
        }

        public void d(String str) {
            this.d = str;
        }
    }

    public PayTask(Activity activity) {
        this.f25375a = activity;
        com.alipay.sdk.m.w.b.c().a(this.f25375a);
        this.b = new com.alipay.sdk.m.c0.a(activity, this.f25375a.getString(R.string.alipay_standard_sdk_loading_go_pay));
    }

    public static synchronized boolean fetchSdkConfig(Context context) {
        try {
            com.alipay.sdk.m.w.b.c().a(context);
            long jElapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (jElapsedRealtime - k < com.alipay.sdk.m.o.b.i().e()) {
                return false;
            }
            k = jElapsedRealtime;
            com.alipay.sdk.m.o.b.i().a(com.alipay.sdk.m.w.a.f(), context.getApplicationContext(), false, 4);
            return true;
        } catch (Exception e2) {
            g.a(e2);
            return false;
        }
        throw th;
    }

    public final void b(com.alipay.sdk.m.w.a aVar, JSONObject jSONObject) {
        try {
            String strOptString = jSONObject.optString("tid");
            String strOptString2 = jSONObject.optString(com.alipay.sdk.m.x.a.j);
            if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
                return;
            }
            com.alipay.sdk.m.x.a.a(com.alipay.sdk.m.w.b.c().b()).a(strOptString, strOptString2);
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.P, th);
        }
    }

    public final void c(com.alipay.sdk.m.w.a aVar, String str) {
        if (aVar.a() && com.alipay.sdk.m.o.b.i().j(aVar)) {
            new Thread(new d(aVar, str)).start();
        }
    }

    public void dismissLoading() {
        com.alipay.sdk.m.c0.a aVar = this.b;
        if (aVar != null) {
            aVar.a();
            this.b = null;
        }
    }

    public synchronized String fetchOrderInfoFromH5PayUrl(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("https://wappaygw.alipay.com/service/rest.htm") || strTrim.startsWith("http://wappaygw.alipay.com/service/rest.htm")) {
                    String strTrim2 = strTrim.replaceFirst("(http|https)://wappaygw.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim2)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + q.a("<request_token>", "</request_token>", q.b(strTrim2).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.f25375a) + "\"";
                    }
                }
                if (strTrim.startsWith("https://mclient.alipay.com/service/rest.htm") || strTrim.startsWith("http://mclient.alipay.com/service/rest.htm")) {
                    String strTrim3 = strTrim.replaceFirst("(http|https)://mclient.alipay.com/service/rest.htm\\?", "").trim();
                    if (!TextUtils.isEmpty(strTrim3)) {
                        return "_input_charset=\"utf-8\"&ordertoken=\"" + q.a("<request_token>", "</request_token>", q.b(strTrim3).get("req_data")) + "\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"" + a(this.f25375a) + "\"";
                    }
                }
                if ((strTrim.startsWith("https://mclient.alipay.com/home/exterfaceAssign.htm") || strTrim.startsWith("http://mclient.alipay.com/home/exterfaceAssign.htm")) && ((strTrim.contains("alipay.wap.create.direct.pay.by.user") || strTrim.contains("create_forex_trade_wap")) && !TextUtils.isEmpty(strTrim.replaceFirst("(http|https)://mclient.alipay.com/home/exterfaceAssign.htm\\?", "").trim()))) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("url", str);
                    jSONObject.put("bizcontext", a(this.f25375a));
                    return com.alipay.sdk.m.w.a.I + jSONObject.toString();
                }
                if (Pattern.compile("^(http|https)://(maliprod\\.alipay\\.com/w/trade_pay\\.do.?|mali\\.alipay\\.com/w/trade_pay\\.do.?|mclient\\.alipay\\.com/w/trade_pay\\.do.?)").matcher(str).find()) {
                    String strA = q.a("?", "", str);
                    if (!TextUtils.isEmpty(strA)) {
                        Map<String, String> mapB = q.b(strA);
                        StringBuilder sb = new StringBuilder();
                        if (a(false, true, com.alipay.sdk.m.m.b.B0, sb, mapB, com.alipay.sdk.m.m.b.B0, "alipay_trade_no")) {
                            a(true, false, "pay_phase_id", sb, mapB, "payPhaseId", "pay_phase_id", "out_relation_id");
                            sb.append("&biz_sub_type=\"TRADE\"");
                            sb.append("&biz_type=\"trade\"");
                            String str2 = mapB.get("app_name");
                            if (TextUtils.isEmpty(str2) && !TextUtils.isEmpty(mapB.get("cid"))) {
                                str2 = "ali1688";
                            } else if (TextUtils.isEmpty(str2) && (!TextUtils.isEmpty(mapB.get(LoginConstants.SID)) || !TextUtils.isEmpty(mapB.get("s_id")))) {
                                str2 = "tb";
                            }
                            sb.append("&app_name=\"" + str2 + "\"");
                            if (!a(true, true, "extern_token", sb, mapB, "extern_token", "cid", LoginConstants.SID, "s_id")) {
                                return "";
                            }
                            a(true, false, "appenv", sb, mapB, "appenv");
                            sb.append("&pay_channel_id=\"alipay_sdk\"");
                            e eVar = new e();
                            eVar.b(mapB.get("return_url"));
                            eVar.c(mapB.get("show_url"));
                            eVar.a(mapB.get("pay_order_id"));
                            String str3 = sb.toString() + "&bizcontext=\"" + a(this.f25375a) + "\"";
                            this.i.put(str3, eVar);
                            return str3;
                        }
                    }
                }
                if (!strTrim.startsWith("https://mclient.alipay.com/cashier/mobilepay.htm") && !strTrim.startsWith("http://mclient.alipay.com/cashier/mobilepay.htm") && (!EnvUtils.isSandBox() || !strTrim.contains("mobileclientgw.alipaydev.com/cashier/mobilepay.htm"))) {
                    if ((strTrim.startsWith("https://mclient.alipay.hk") || strTrim.startsWith("http://mclient.alipay.hk") || strTrim.startsWith("https://render.alipay.hk") || strTrim.startsWith("http://render.alipay.hk")) && strTrim.contains("qrCode=")) {
                        if (com.alipay.sdk.m.o.b.i().d(null)) {
                            String strA2 = a(this.f25375a);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("url", strTrim);
                            jSONObject2.put("bizcontext", strA2);
                            return String.format("new_external_info==%s", jSONObject2.toString());
                        }
                        fetchSdkConfig(this.f25375a);
                    }
                    if (com.alipay.sdk.m.o.b.i().j() && Pattern.compile("^https?://(maliprod\\.alipay\\.com|mali\\.alipay\\.com)/batch_payment\\.do\\?").matcher(strTrim).find()) {
                        Uri uri = Uri.parse(strTrim);
                        String queryParameter = uri.getQueryParameter("return_url");
                        String queryParameter2 = uri.getQueryParameter("show_url");
                        String queryParameter3 = uri.getQueryParameter("pay_order_id");
                        String strA3 = a(uri.getQueryParameter("trade_nos"), uri.getQueryParameter("alipay_trade_no"));
                        String strA4 = a(uri.getQueryParameter("payPhaseId"), uri.getQueryParameter("pay_phase_id"), uri.getQueryParameter("out_relation_id"));
                        String[] strArr = new String[4];
                        strArr[0] = uri.getQueryParameter("app_name");
                        strArr[1] = !TextUtils.isEmpty(uri.getQueryParameter("cid")) ? "ali1688" : "";
                        strArr[2] = !TextUtils.isEmpty(uri.getQueryParameter(LoginConstants.SID)) ? "tb" : "";
                        strArr[3] = !TextUtils.isEmpty(uri.getQueryParameter("s_id")) ? "tb" : "";
                        String strA5 = a(strArr);
                        String strA6 = a(uri.getQueryParameter("extern_token"), uri.getQueryParameter("cid"), uri.getQueryParameter(LoginConstants.SID), uri.getQueryParameter("s_id"));
                        String strA7 = a(uri.getQueryParameter("appenv"));
                        if (!TextUtils.isEmpty(strA3) && !TextUtils.isEmpty(strA5) && !TextUtils.isEmpty(strA6)) {
                            String str4 = String.format("trade_no=\"%s\"&pay_phase_id=\"%s\"&biz_type=\"trade\"&biz_sub_type=\"TRADE\"&app_name=\"%s\"&extern_token=\"%s\"&appenv=\"%s\"&pay_channel_id=\"alipay_sdk\"&bizcontext=\"%s\"", strA3, strA4, strA5, strA6, strA7, a(this.f25375a));
                            e eVar2 = new e();
                            eVar2.b(queryParameter);
                            eVar2.c(queryParameter2);
                            eVar2.a(queryParameter3);
                            eVar2.d(strA3);
                            this.i.put(str4, eVar2);
                            return str4;
                        }
                    }
                }
                String strA8 = a(this.f25375a);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("url", strTrim);
                jSONObject3.put("bizcontext", strA8);
                return String.format("new_external_info==%s", jSONObject3.toString());
            }
        } catch (Throwable th) {
            g.a(th);
        }
        return "";
    }

    public synchronized String fetchTradeToken() {
        return l.a(new com.alipay.sdk.m.w.a(this.f25375a, "", "fetchTradeToken"), this.f25375a.getApplicationContext());
    }

    public String getVersion() {
        return "15.8.42";
    }

    public synchronized H5PayResultModel h5Pay(com.alipay.sdk.m.w.a aVar, String str, boolean z) {
        H5PayResultModel h5PayResultModel;
        h5PayResultModel = new H5PayResultModel();
        try {
            String[] strArrSplit = a(aVar, str, z).split(l.b);
            HashMap map = new HashMap();
            for (String str2 : strArrSplit) {
                int iIndexOf = str2.indexOf("={");
                if (iIndexOf >= 0) {
                    String strSubstring = str2.substring(0, iIndexOf);
                    map.put(strSubstring, a(str2, strSubstring));
                }
            }
            if (map.containsKey(o.f25542a)) {
                h5PayResultModel.setResultCode(map.get(o.f25542a));
            }
            h5PayResultModel.setReturnUrl(a(str, map));
            if (TextUtils.isEmpty(h5PayResultModel.getReturnUrl())) {
                com.alipay.sdk.m.m.a.b(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.n0, "");
            }
        } catch (Throwable th) {
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.o0, th);
            g.a(th);
        }
        return h5PayResultModel;
    }

    public synchronized String pay(String str, boolean z) {
        if (com.alipay.sdk.m.y.c.a()) {
            return com.alipay.sdk.m.l.b.b();
        }
        return a(new com.alipay.sdk.m.w.a(this.f25375a, str, "pay"), str, z);
    }

    public synchronized boolean payInterceptorWithUrl(String str, boolean z, H5PayCallback h5PayCallback) {
        String strFetchOrderInfoFromH5PayUrl;
        strFetchOrderInfoFromH5PayUrl = fetchOrderInfoFromH5PayUrl(str);
        if (!TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl)) {
            g.d(com.alipay.sdk.m.n.a.B, "intercepted: " + strFetchOrderInfoFromH5PayUrl);
            new Thread(new b(strFetchOrderInfoFromH5PayUrl, z, h5PayCallback)).start();
        }
        return !TextUtils.isEmpty(strFetchOrderInfoFromH5PayUrl);
    }

    public synchronized Map<String, String> payV2(String str, boolean z) {
        String strA;
        com.alipay.sdk.m.w.a aVar;
        if (com.alipay.sdk.m.y.c.a()) {
            strA = com.alipay.sdk.m.l.b.b();
            aVar = null;
        } else {
            com.alipay.sdk.m.w.a aVar2 = new com.alipay.sdk.m.w.a(this.f25375a, str, "payV2");
            strA = a(aVar2, str, z);
            aVar = aVar2;
        }
        return o.a(aVar, strA);
    }

    public void showLoading() {
        com.alipay.sdk.m.c0.a aVar = this.b;
        if (aVar != null) {
            aVar.d();
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0368 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x038a A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:132:? A[ADDED_TO_REGION, Catch: all -> 0x03a9, REMOVE, SYNTHETIC, TRY_LEAVE, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x0133 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x013d A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x0199 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x01bb A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x020f A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0219 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x0275 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:73:0x0297 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0302 A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    /* JADX WARN: Code duplicated, block: B:97:0x030c A[Catch: all -> 0x03a9, TryCatch #2 {, blocks: (B:3:0x0001, B:5:0x0005, B:6:0x0008, B:8:0x0052, B:10:0x0066, B:11:0x006a, B:13:0x008b, B:15:0x0093, B:16:0x0096, B:18:0x009a, B:20:0x00a2, B:21:0x00af, B:23:0x00b7, B:27:0x00ff, B:29:0x0109, B:36:0x0130, B:37:0x0133, B:39:0x013d, B:40:0x014b, B:42:0x0199, B:43:0x01a6, B:45:0x01bb, B:47:0x01c1, B:80:0x02ac, B:51:0x01ce, B:81:0x02b5, B:55:0x01db, B:57:0x01e5, B:64:0x020c, B:65:0x020f, B:67:0x0219, B:68:0x0227, B:70:0x0275, B:71:0x0282, B:73:0x0297, B:75:0x029d, B:79:0x02a9, B:85:0x02ce, B:87:0x02d8, B:94:0x02ff, B:95:0x0302, B:97:0x030c, B:98:0x031a, B:100:0x0368, B:101:0x0375, B:103:0x038a, B:105:0x0390, B:110:0x039f, B:109:0x039c, B:111:0x03a8, B:12:0x0086, B:26:0x00c6, B:76:0x02a2, B:106:0x0395, B:59:0x01f1, B:61:0x0202, B:54:0x01d4, B:48:0x01c6, B:89:0x02e4, B:91:0x02f5, B:31:0x0115, B:33:0x0126), top: B:119:0x0001, inners: #0, #1, #3, #4, #5, #6, #7, #8 }] */
    public final synchronized String a(com.alipay.sdk.m.w.a aVar, String str, boolean z) {
        String strA;
        AlipayDebugOptions alipayDebugOptions;
        AlipayDebugOptions alipayDebugOptions2;
        JSONObject jSONObject;
        AlipayDebugOptions alipayDebugOptions3;
        boolean z2 = AlipayApi.f;
        if (z) {
            showLoading();
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "isDebugApp", "false degradeRegisterApp=" + com.alipay.sdk.m.o.b.i().c(null) + " fetchConfigWhenRegisterApp=" + com.alipay.sdk.m.o.b.i().f(null) + " grayLogPrintPerformance=" + com.alipay.sdk.m.o.b.i().h(null));
        if (str.contains("payment_inst=")) {
            String strSubstring = str.substring(str.indexOf("payment_inst=") + 13);
            int iIndexOf = strSubstring.indexOf(38);
            if (iIndexOf > 0) {
                strSubstring = strSubstring.substring(0, iIndexOf);
            }
            com.alipay.sdk.m.l.a.a(strSubstring.replaceAll("\"", "").toLowerCase(Locale.getDefault()).replaceAll("alipay", ""));
        } else {
            com.alipay.sdk.m.l.a.a("");
        }
        if (str.contains(com.alipay.sdk.m.n.a.x)) {
            com.alipay.sdk.m.n.a.y = true;
        }
        if (com.alipay.sdk.m.n.a.y) {
            if (str.startsWith(com.alipay.sdk.m.n.a.z)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.n.a.z) + 53);
            } else if (str.startsWith(com.alipay.sdk.m.n.a.A)) {
                str = str.substring(str.indexOf(com.alipay.sdk.m.n.a.A) + 52);
            }
        }
        strA = "";
        try {
            g.d(com.alipay.sdk.m.n.a.B, "pay prepared: " + str);
            strA = a(str, aVar);
            g.d(com.alipay.sdk.m.n.a.B, "pay raw result: " + strA);
            l.a(aVar, this.f25375a.getApplicationContext(), strA);
            if (!com.alipay.sdk.m.o.b.i().a(aVar)) {
                String strB = o.b(strA, o.d);
                if (!TextUtils.isEmpty(strB)) {
                    try {
                        String strOptString = new JSONObject(strB).optString(com.alipay.sdk.m.w.a.E);
                        if (!TextUtils.isEmpty(strOptString)) {
                            m.b(aVar, this.f25375a, com.alipay.sdk.m.w.a.H, strOptString);
                            if (com.alipay.sdk.m.o.b.i().i(null)) {
                                com.alipay.sdk.m.r.b.e().a();
                                com.alipay.sdk.m.r.b.e().d();
                            }
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                            if (!com.alipay.sdk.m.o.b.i().u()) {
                                com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                            }
                            dismissLoading();
                            a(aVar);
                            com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                            alipayDebugOptions3 = AlipayApi.h;
                            if (alipayDebugOptions3 != null && alipayDebugOptions3.getAlipayPayLifeCycle() != null) {
                                jSONObject = new JSONObject();
                                try {
                                    jSONObject.put("isHitPreHeatApp", z2);
                                } catch (Throwable th) {
                                    g.a(th);
                                }
                                AlipayApi.h.getAlipayPayLifeCycle().onPayEnd(jSONObject);
                            }
                        } else {
                            if (com.alipay.sdk.m.o.b.i().i(null)) {
                                com.alipay.sdk.m.r.b.e().a();
                                com.alipay.sdk.m.r.b.e().d();
                            }
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                            if (!com.alipay.sdk.m.o.b.i().u()) {
                                com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                            }
                            dismissLoading();
                            a(aVar);
                            com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                            alipayDebugOptions3 = AlipayApi.h;
                            if (alipayDebugOptions3 != null) {
                                jSONObject = new JSONObject();
                                jSONObject.put("isHitPreHeatApp", z2);
                                AlipayApi.h.getAlipayPayLifeCycle().onPayEnd(jSONObject);
                            }
                        }
                    } catch (Throwable th2) {
                        g.a(th2);
                    }
                } else {
                    if (com.alipay.sdk.m.o.b.i().i(null)) {
                        com.alipay.sdk.m.r.b.e().a();
                        com.alipay.sdk.m.r.b.e().d();
                    }
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                    if (!com.alipay.sdk.m.o.b.i().u()) {
                        com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                    }
                    dismissLoading();
                    a(aVar);
                    com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                    alipayDebugOptions3 = AlipayApi.h;
                    if (alipayDebugOptions3 != null) {
                        jSONObject = new JSONObject();
                        jSONObject.put("isHitPreHeatApp", z2);
                        AlipayApi.h.getAlipayPayLifeCycle().onPayEnd(jSONObject);
                    }
                }
            } else {
                if (com.alipay.sdk.m.o.b.i().i(null)) {
                    com.alipay.sdk.m.r.b.e().a();
                    com.alipay.sdk.m.r.b.e().d();
                }
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                if (!com.alipay.sdk.m.o.b.i().u()) {
                    com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                }
                dismissLoading();
                a(aVar);
                com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                alipayDebugOptions3 = AlipayApi.h;
                if (alipayDebugOptions3 != null) {
                    jSONObject = new JSONObject();
                    jSONObject.put("isHitPreHeatApp", z2);
                    AlipayApi.h.getAlipayPayLifeCycle().onPayEnd(jSONObject);
                }
            }
        } catch (Throwable th3) {
            try {
                strA = com.alipay.sdk.m.l.b.a();
                g.a(th3);
                if (!com.alipay.sdk.m.o.b.i().a(aVar)) {
                    String strB2 = o.b(strA, o.d);
                    if (!TextUtils.isEmpty(strB2)) {
                        try {
                            String strOptString2 = new JSONObject(strB2).optString(com.alipay.sdk.m.w.a.E);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                m.b(aVar, this.f25375a, com.alipay.sdk.m.w.a.H, strOptString2);
                                if (com.alipay.sdk.m.o.b.i().i(null)) {
                                    com.alipay.sdk.m.r.b.e().a();
                                    com.alipay.sdk.m.r.b.e().d();
                                }
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                                if (!com.alipay.sdk.m.o.b.i().u()) {
                                    com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                                }
                                dismissLoading();
                                a(aVar);
                                com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                                alipayDebugOptions2 = AlipayApi.h;
                                if (alipayDebugOptions2 != null && alipayDebugOptions2.getAlipayPayLifeCycle() != null) {
                                    jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("isHitPreHeatApp", z2);
                                    } catch (Throwable th4) {
                                        g.a(th4);
                                    }
                                }
                            } else {
                                if (com.alipay.sdk.m.o.b.i().i(null)) {
                                    com.alipay.sdk.m.r.b.e().a();
                                    com.alipay.sdk.m.r.b.e().d();
                                }
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                                if (!com.alipay.sdk.m.o.b.i().u()) {
                                    com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                                }
                                dismissLoading();
                                a(aVar);
                                com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                                alipayDebugOptions2 = AlipayApi.h;
                                if (alipayDebugOptions2 != null) {
                                    jSONObject = new JSONObject();
                                    jSONObject.put("isHitPreHeatApp", z2);
                                }
                            }
                        } catch (Throwable th5) {
                            g.a(th5);
                        }
                    } else {
                        if (com.alipay.sdk.m.o.b.i().i(null)) {
                            com.alipay.sdk.m.r.b.e().a();
                            com.alipay.sdk.m.r.b.e().d();
                        }
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                        if (!com.alipay.sdk.m.o.b.i().u()) {
                            com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                        }
                        dismissLoading();
                        a(aVar);
                        com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                        alipayDebugOptions2 = AlipayApi.h;
                        if (alipayDebugOptions2 != null) {
                            jSONObject = new JSONObject();
                            jSONObject.put("isHitPreHeatApp", z2);
                        }
                    }
                } else {
                    if (com.alipay.sdk.m.o.b.i().i(null)) {
                        com.alipay.sdk.m.r.b.e().a();
                        com.alipay.sdk.m.r.b.e().d();
                    }
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                    if (!com.alipay.sdk.m.o.b.i().u()) {
                        com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                    }
                    dismissLoading();
                    a(aVar);
                    com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                    alipayDebugOptions2 = AlipayApi.h;
                    if (alipayDebugOptions2 != null) {
                        jSONObject = new JSONObject();
                        jSONObject.put("isHitPreHeatApp", z2);
                    }
                }
            } catch (Throwable th6) {
                if (!com.alipay.sdk.m.o.b.i().a(aVar)) {
                    String strB3 = o.b(strA, o.d);
                    if (!TextUtils.isEmpty(strB3)) {
                        try {
                            String strOptString3 = new JSONObject(strB3).optString(com.alipay.sdk.m.w.a.E);
                            if (!TextUtils.isEmpty(strOptString3)) {
                                m.b(aVar, this.f25375a, com.alipay.sdk.m.w.a.H, strOptString3);
                                if (com.alipay.sdk.m.o.b.i().i(null)) {
                                    com.alipay.sdk.m.r.b.e().a();
                                    com.alipay.sdk.m.r.b.e().d();
                                }
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                                if (!com.alipay.sdk.m.o.b.i().u()) {
                                    com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                                }
                                dismissLoading();
                                a(aVar);
                                com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                                alipayDebugOptions = AlipayApi.h;
                                if (alipayDebugOptions == null && alipayDebugOptions.getAlipayPayLifeCycle() != null) {
                                    JSONObject jSONObject2 = new JSONObject();
                                    try {
                                        jSONObject2.put("isHitPreHeatApp", z2);
                                    } catch (Throwable th7) {
                                        g.a(th7);
                                    }
                                    AlipayApi.h.getAlipayPayLifeCycle().onPayEnd(jSONObject2);
                                    throw th6;
                                }
                                throw th6;
                            }
                            if (com.alipay.sdk.m.o.b.i().i(null)) {
                                com.alipay.sdk.m.r.b.e().a();
                                com.alipay.sdk.m.r.b.e().d();
                            }
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                            if (!com.alipay.sdk.m.o.b.i().u()) {
                                com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                            }
                            dismissLoading();
                            a(aVar);
                            com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                            alipayDebugOptions = AlipayApi.h;
                            if (alipayDebugOptions == null) {
                                throw th6;
                            }
                            throw th6;
                        } catch (Throwable th8) {
                            g.a(th8);
                        }
                    } else {
                        if (com.alipay.sdk.m.o.b.i().i(null)) {
                            com.alipay.sdk.m.r.b.e().a();
                            com.alipay.sdk.m.r.b.e().d();
                        }
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                        if (!com.alipay.sdk.m.o.b.i().u()) {
                            com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                        }
                        dismissLoading();
                        a(aVar);
                        com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                        alipayDebugOptions = AlipayApi.h;
                        if (alipayDebugOptions == null) {
                            throw th6;
                        }
                        throw th6;
                    }
                } else {
                    if (com.alipay.sdk.m.o.b.i().i(null)) {
                        com.alipay.sdk.m.r.b.e().a();
                        com.alipay.sdk.m.r.b.e().d();
                    }
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.W, o.a(strA, o.f25542a) + "|" + o.a(strA, o.b));
                    if (!com.alipay.sdk.m.o.b.i().u()) {
                        com.alipay.sdk.m.o.b.i().a(aVar, this.f25375a.getApplicationContext(), false, 3);
                    }
                    dismissLoading();
                    a(aVar);
                    com.alipay.sdk.m.m.a.b(this.f25375a.getApplicationContext(), aVar, str, aVar.d);
                    alipayDebugOptions = AlipayApi.h;
                    if (alipayDebugOptions == null) {
                        throw th6;
                    }
                    throw th6;
                }
            }
        }
        g.d(com.alipay.sdk.m.n.a.B, "pay returning: " + strA);
        return strA;
    }

    @WorkerThread
    public final void b(com.alipay.sdk.m.w.a aVar, String str) {
        g.b(com.alipay.sdk.m.n.a.B, "requestPreheatPay");
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "requestPreheatStart", aVar.g());
        try {
            g.b(com.alipay.sdk.m.n.a.B, "requestPreheatPay respData:" + new h().a(aVar, this.f25375a.getApplicationContext(), str).c());
        } catch (Throwable th) {
            g.a(th);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "requestPreheatError", th);
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "requestPreheatEnd", aVar.g());
    }

    public final void a(com.alipay.sdk.m.w.a aVar) {
        WeakReference<Context> weakReference;
        if (com.alipay.sdk.m.o.b.i().c(null)) {
            return;
        }
        g.d(com.alipay.sdk.m.n.a.B, "unbindRegisterAppService registerAppServiceConnectSuccess=" + AlipayApi.f);
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "registerApp", "unbindServiceStart");
        if (AlipayApi.e != null && AlipayApi.f && (weakReference = AlipayApi.g) != null && weakReference.get() != null) {
            try {
                AlipayApi.g.get().unbindService(AlipayApi.e);
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "registerApp", "unbindServiceEnd");
            } catch (Throwable th) {
                g.a(th);
                com.alipay.sdk.m.m.a.a(aVar, "wr", "registerAppUnbindServiceError", th);
            }
        }
        AlipayApi.g = null;
        AlipayApi.f = false;
        AlipayApi.e = null;
    }

    public static String a(Context context) {
        String str;
        String str2;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            try {
                str2 = packageInfo.packageName;
            } catch (Exception e2) {
                e = e2;
                g.a(e);
                str2 = "";
            }
        } catch (Exception e3) {
            e = e3;
            str = "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("appkey", com.alipay.sdk.m.n.a.h);
            jSONObject.put(com.alipay.sdk.m.w.a.u, "and_lite");
            jSONObject.put(com.alipay.sdk.m.w.a.v, "h.a.3.8.42");
            jSONObject.put(com.alipay.sdk.m.w.a.w, str2);
            jSONObject.put("av", str);
            jSONObject.put(com.alipay.sdk.m.w.a.z, System.currentTimeMillis());
            if (!TextUtils.isEmpty("sc")) {
                jSONObject.put("sc", "h5tonative");
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            g.a(th);
            return "";
        }
    }

    public static final String a(String... strArr) {
        if (strArr == null) {
            return "";
        }
        for (String str : strArr) {
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return "";
    }

    public final boolean a(boolean z, boolean z2, String str, StringBuilder sb, Map<String, String> map, String... strArr) {
        String str2;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                str2 = "";
                break;
            }
            String str3 = strArr[i];
            if (!TextUtils.isEmpty(map.get(str3))) {
                str2 = map.get(str3);
                break;
            }
            i++;
        }
        if (TextUtils.isEmpty(str2)) {
            return !z2;
        }
        if (z) {
            sb.append("&");
            sb.append(str);
            sb.append("=\"");
            sb.append(str2);
            sb.append("\"");
            return true;
        }
        sb.append(str);
        sb.append("=\"");
        sb.append(str2);
        sb.append("\"");
        return true;
    }

    public final String a(String str, Map<String, String> map) throws UnsupportedEncodingException {
        boolean zEquals = "9000".equals(map.get(o.f25542a));
        String str2 = map.get("result");
        e eVarRemove = this.i.remove(str);
        if (map.containsKey("callBackUrl")) {
            return map.get("callBackUrl");
        }
        if (str2.length() > 15) {
            String strA = a(q.a("&callBackUrl=\"", "\"", str2), q.a("&call_back_url=\"", "\"", str2), q.a(com.alipay.sdk.m.n.a.v, "\"", str2), URLDecoder.decode(q.a(com.alipay.sdk.m.n.a.w, "&", str2), "utf-8"), URLDecoder.decode(q.a("&callBackUrl=", "&", str2), "utf-8"), q.a("call_back_url=\"", "\"", str2));
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        if (eVarRemove != null) {
            String strB = zEquals ? eVarRemove.b() : eVarRemove.c();
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        return eVarRemove != null ? com.alipay.sdk.m.o.b.i().s() : "";
    }

    public final String a(String str, String str2) {
        String str3 = str2 + "={";
        return str.substring(str.indexOf(str3) + str3.length(), str.lastIndexOf("}"));
    }

    public final k.f a() {
        return new c();
    }

    public final String a(String str, com.alipay.sdk.m.w.a aVar) {
        String strA = aVar.a(str);
        g.b(com.alipay.sdk.m.n.a.B, "payResult orderInfo=" + strA);
        if (strA.contains("paymethod=\"expressGateway\"")) {
            return a(aVar, strA);
        }
        List<com.alipay.sdk.m.o.b.C0199b> listM = com.alipay.sdk.m.o.b.i().m();
        if (!com.alipay.sdk.m.o.b.i().g || listM == null) {
            listM = com.alipay.sdk.m.l.a.d;
        }
        if (q.a(aVar, (Context) this.f25375a, listM, true)) {
            k kVar = new k(this.f25375a, aVar, a());
            g.d(com.alipay.sdk.m.n.a.B, "pay inner started: " + strA);
            c(aVar, strA);
            String strA2 = kVar.a(strA, false);
            if (!TextUtils.isEmpty(strA2)) {
                if (strA2.contains("resultStatus={" + com.alipay.sdk.m.l.c.ACTIVITY_NOT_START_EXIT.c() + "}")) {
                    q.a("alipaySdk", com.alipay.sdk.m.n.b.q, this.f25375a, aVar);
                    strA2 = kVar.a(strA, true);
                }
            }
            g.d(com.alipay.sdk.m.n.a.B, "pay inner raw result: " + strA2);
            kVar.a();
            boolean zA = com.alipay.sdk.m.o.b.i().A();
            if (!TextUtils.equals(strA2, k.j) && !TextUtils.equals(strA2, k.k) && (!zA || !aVar.i())) {
                if (TextUtils.isEmpty(strA2)) {
                    return com.alipay.sdk.m.l.b.a();
                }
                if (!strA2.contains(PayResultActivity.b)) {
                    return strA2;
                }
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.k0);
                return a(aVar, strA, listM, strA2, this.f25375a);
            }
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.i0);
            return a(aVar, strA);
        }
        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.j0);
        return a(aVar, strA);
    }

    public static String a(com.alipay.sdk.m.w.a aVar, String str, List<com.alipay.sdk.m.o.b.C0199b> list, String str2, Activity activity) {
        q.c cVarA = q.a(aVar, activity, list);
        if (cVarA == null || cVarA.a(aVar) || cVarA.a() || !TextUtils.equals(cVarA.f25547a.packageName, "hk.alipay.wallet")) {
            return str2;
        }
        g.b(com.alipay.sdk.m.n.a.B, "PayTask not_login");
        String strValueOf = String.valueOf(str.hashCode());
        Object obj = new Object();
        HashMap<String, Object> map = PayResultActivity.c;
        map.put(strValueOf, obj);
        Intent intent = new Intent(activity, (Class<?>) PayResultActivity.class);
        intent.putExtra(PayResultActivity.f, str);
        intent.putExtra(PayResultActivity.g, activity.getPackageName());
        intent.putExtra(PayResultActivity.e, strValueOf);
        com.alipay.sdk.m.w.a.C0210a.a(aVar, intent);
        activity.startActivity(intent);
        synchronized (map.get(strValueOf)) {
            try {
                g.b(com.alipay.sdk.m.n.a.B, "PayTask wait");
                map.get(strValueOf).wait();
            } catch (InterruptedException unused) {
                g.b(com.alipay.sdk.m.n.a.B, "PayTask interrupted");
                return com.alipay.sdk.m.l.b.a();
            }
        }
        String str3 = PayResultActivity.b.b;
        g.b(com.alipay.sdk.m.n.a.B, "PayTask ret: " + str3);
        return str3;
    }

    public final String a(com.alipay.sdk.m.w.a aVar, String str) {
        com.alipay.sdk.m.t.b bVarA;
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2;
        showLoading();
        com.alipay.sdk.m.l.c cVarA = null;
        try {
            try {
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "h5CashierRequest");
                if (com.alipay.sdk.m.o.b.i().i(aVar)) {
                    com.alipay.sdk.m.r.b.e().a(aVar);
                    bVarA = new com.alipay.sdk.m.u.d().a(aVar, this.f25375a.getApplicationContext(), str, p.a());
                } else {
                    bVarA = new com.alipay.sdk.m.u.g().a(aVar, this.f25375a.getApplicationContext(), str);
                }
                JSONObject jSONObjectC = bVarA.c();
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "h5CashierResponse");
                String strOptString = jSONObjectC.optString("end_code", null);
                JSONObject jSONObjectOptJSONObject3 = (!com.alipay.sdk.m.o.b.i().i(null) || (jSONObjectOptJSONObject = jSONObjectC.optJSONObject("data")) == null || (jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(com.alipay.sdk.m.n.c.c)) == null) ? null : jSONObjectOptJSONObject2.optJSONObject(com.alipay.sdk.m.n.c.d);
                if (jSONObjectOptJSONObject3 == null) {
                    jSONObjectOptJSONObject3 = jSONObjectC.optJSONObject(com.alipay.sdk.m.n.c.c).optJSONObject(com.alipay.sdk.m.n.c.d);
                }
                List<com.alipay.sdk.m.v.b> listA = com.alipay.sdk.m.v.b.a(jSONObjectOptJSONObject3);
                for (int i = 0; i < listA.size(); i++) {
                    if (listA.get(i).a() == com.alipay.sdk.m.v.a.Update) {
                        com.alipay.sdk.m.v.b.a(listA.get(i));
                    }
                }
                b(aVar, jSONObjectC);
                dismissLoading();
                com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
                for (int i2 = 0; i2 < listA.size(); i2++) {
                    com.alipay.sdk.m.v.b bVar = listA.get(i2);
                    if (bVar.a() == com.alipay.sdk.m.v.a.WapPay) {
                        String strA = a(aVar, bVar);
                        dismissLoading();
                        com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
                        return strA;
                    }
                    if (bVar.a() == com.alipay.sdk.m.v.a.OpenWeb) {
                        String strA2 = a(aVar, bVar, strOptString);
                        dismissLoading();
                        com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
                        return strA2;
                    }
                    if (com.alipay.sdk.m.o.b.i().i(null) && bVar.a() == com.alipay.sdk.m.v.a.LocalWebPay) {
                        String strA3 = a(aVar, jSONObjectC);
                        dismissLoading();
                        com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
                        return strA3;
                    }
                }
                dismissLoading();
                com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
            } catch (Throwable th) {
                dismissLoading();
                com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
                throw th;
            }
        } catch (IOException e2) {
            cVarA = com.alipay.sdk.m.l.c.a(com.alipay.sdk.m.l.c.NETWORK_ERROR.c());
            com.alipay.sdk.m.m.a.a(aVar, "net", e2);
            dismissLoading();
            com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
        } catch (Throwable th2) {
            g.a(th2);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.B, th2);
            dismissLoading();
            com.alipay.sdk.m.m.a.a(this.f25375a, aVar, str, aVar.d);
        }
        if (cVarA == null) {
            cVarA = com.alipay.sdk.m.l.c.a(com.alipay.sdk.m.l.c.FAILED.c());
        }
        return com.alipay.sdk.m.l.b.a(cVarA.c(), cVarA.b(), "");
    }

    public final String a(com.alipay.sdk.m.w.a aVar, JSONObject jSONObject) {
        g.b(com.alipay.sdk.m.n.a.B, "processLocalWebPay");
        com.alipay.sdk.m.l.b.a(false);
        com.alipay.sdk.m.l.b.a((String) null);
        Intent intent = new Intent(this.f25375a, (Class<?>) H5PayActivity.class);
        try {
            JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("data").optJSONObject("local_web_pay_data");
            String strOptString = jSONObjectOptJSONObject.optString("h5_cashier_url");
            JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("h5_local_data");
            String strOptString2 = jSONObjectOptJSONObject2.optString("sha256", "");
            String strOptString3 = jSONObjectOptJSONObject2.optString("source_url", "");
            String strOptString4 = jSONObjectOptJSONObject2.optString("update_strategy");
            com.alipay.sdk.m.r.b.e().a(new com.alipay.sdk.m.r.a(strOptString2, strOptString3, strOptString4));
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "h5LocalDataUpdateStrategy", strOptString4);
            intent.putExtra("url", strOptString);
            intent.putExtra("version", com.alipay.sdk.m.c0.c.c);
            intent.putExtra("cashierBizData", jSONObject.toString());
            Bundle bundle = new Bundle();
            bundle.putBoolean("backisexit", com.alipay.sdk.m.o.b.i().e(aVar));
            intent.putExtras(bundle);
            com.alipay.sdk.m.w.a.C0210a.a(aVar, intent);
            this.f25375a.startActivity(intent);
            Object obj = j;
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e2) {
                    g.a(e2);
                    return com.alipay.sdk.m.l.b.a();
                }
            }
            String strD = com.alipay.sdk.m.l.b.d();
            return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.l.b.a() : strD;
        } catch (Throwable th) {
            g.a(th);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "processLocalWebPay", th);
            return com.alipay.sdk.m.l.b.a();
        }
    }

    public final String a(com.alipay.sdk.m.w.a aVar, com.alipay.sdk.m.v.b bVar, String str) {
        boolean zC;
        String strD;
        String[] strArrC = bVar.c();
        Intent intent = new Intent(this.f25375a, (Class<?>) H5PayActivity.class);
        try {
            JSONObject jSONObjectH = q.h(new String(com.alipay.sdk.m.p.a.a(strArrC[2])));
            intent.putExtra("url", strArrC[0]);
            intent.putExtra("title", strArrC[1]);
            intent.putExtra("version", "v2");
            intent.putExtra("method", jSONObjectH.optString("method", "POST"));
            com.alipay.sdk.m.l.b.a(false);
            com.alipay.sdk.m.l.b.a((String) null);
            com.alipay.sdk.m.w.a.C0210a.a(aVar, intent);
            this.f25375a.startActivity(intent);
            Object obj = j;
            synchronized (obj) {
                try {
                    obj.wait();
                    zC = com.alipay.sdk.m.l.b.c();
                    strD = com.alipay.sdk.m.l.b.d();
                    com.alipay.sdk.m.l.b.a(false);
                    com.alipay.sdk.m.l.b.a((String) null);
                } catch (InterruptedException e2) {
                    g.a(e2);
                    return com.alipay.sdk.m.l.b.a();
                }
            }
            String strA = "";
            if (zC) {
                try {
                    List<com.alipay.sdk.m.v.b> listA = com.alipay.sdk.m.v.b.a(q.h(new String(com.alipay.sdk.m.p.a.a(strD))));
                    for (int i = 0; i < listA.size(); i++) {
                        com.alipay.sdk.m.v.b bVar2 = listA.get(i);
                        if (bVar2.a() == com.alipay.sdk.m.v.a.SetResult) {
                            String[] strArrC2 = bVar2.c();
                            strA = com.alipay.sdk.m.l.b.a(Integer.valueOf(strArrC2[1]).intValue(), strArrC2[0], q.e(aVar, strArrC2[2]));
                            break;
                        }
                    }
                } catch (Throwable th) {
                    g.a(th);
                    com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.B, th, strD);
                }
            }
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
            try {
                return com.alipay.sdk.m.l.b.a(Integer.valueOf(str).intValue(), "", "");
            } catch (Throwable th2) {
                com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.B, th2, "endCode: " + str);
                return com.alipay.sdk.m.l.b.a(8000, "", "");
            }
        } catch (Throwable th3) {
            g.a(th3);
            com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.B, th3, Arrays.toString(strArrC));
            return com.alipay.sdk.m.l.b.a();
        }
    }

    public final String a(com.alipay.sdk.m.w.a aVar, com.alipay.sdk.m.v.b bVar) {
        com.alipay.sdk.m.l.b.a(false);
        com.alipay.sdk.m.l.b.a((String) null);
        String[] strArrC = bVar.c();
        Intent intent = new Intent(this.f25375a, (Class<?>) H5PayActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("url", strArrC[0]);
        if (strArrC.length == 2) {
            bundle.putString("cookie", strArrC[1]);
        }
        intent.putExtras(bundle);
        com.alipay.sdk.m.w.a.C0210a.a(aVar, intent);
        this.f25375a.startActivity(intent);
        Object obj = j;
        synchronized (obj) {
            try {
                obj.wait();
            } catch (InterruptedException e2) {
                g.a(e2);
                return com.alipay.sdk.m.l.b.a();
            }
        }
        String strD = com.alipay.sdk.m.l.b.d();
        return TextUtils.isEmpty(strD) ? com.alipay.sdk.m.l.b.a() : strD;
    }
}
