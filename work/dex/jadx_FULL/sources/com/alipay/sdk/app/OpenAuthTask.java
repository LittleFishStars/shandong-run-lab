package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alibaba.ariver.permission.AppPermissionUtils;
import com.alipay.sdk.m.y.g;
import com.alipay.sdk.m.y.q;
import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.igexin.assist.sdk.AssistPushConsts;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class OpenAuthTask {
    public static final int Duplex = 5000;
    public static final int NOT_INSTALLED = 4001;
    public static final int OK = 9000;
    public static final int SYS_ERR = 4000;
    public static final Map<String, Callback> e = new ConcurrentHashMap();
    public static long f = -1;
    public static final int g = 122;
    public final Activity b;
    public Callback c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f25369a = false;
    public final Handler d = new Handler(Looper.getMainLooper());

    public enum BizType {
        Invoice("20000920"),
        AccountAuth(AppPermissionUtils.ALIPAY_WEB_COMMON_APPID),
        Deduct("60000157");

        private String appId;

        BizType(String str) {
            this.appId = str;
        }
    }

    public interface Callback {
        void onResult(int i, String str, Bundle bundle);
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f25370a;

        static {
            int[] iArr = new int[BizType.values().length];
            f25370a = iArr;
            try {
                iArr[BizType.Deduct.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25370a[BizType.AccountAuth.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25370a[BizType.Invoice.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f25371a;
        public final String b;
        public final Bundle c;

        public /* synthetic */ b(OpenAuthTask openAuthTask, int i, String str, Bundle bundle, a aVar) {
            this(i, str, bundle);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (OpenAuthTask.this.c != null) {
                OpenAuthTask.this.c.onResult(this.f25371a, this.b, this.c);
            }
        }

        public b(int i, String str, Bundle bundle) {
            this.f25371a = i;
            this.b = str;
            this.c = bundle;
        }
    }

    public OpenAuthTask(Activity activity) {
        this.b = activity;
        com.alipay.sdk.m.w.b.c().a(activity);
    }

    public void execute(String str, BizType bizType, Map<String, String> map, Callback callback, boolean z) {
        com.alipay.sdk.m.w.a aVar = new com.alipay.sdk.m.w.a(this.b, String.valueOf(map), "oa-" + bizType);
        this.c = callback;
        if (a(aVar, str, bizType, map, z)) {
            com.alipay.sdk.m.m.a.b(this.b, aVar, "", aVar.d);
        }
    }

    public final boolean a(com.alipay.sdk.m.w.a aVar, String str, BizType bizType, Map<String, String> map, boolean z) {
        PackageInfo packageInfo;
        String strA;
        if (this.f25369a) {
            this.d.post(new b(this, 4000, "该 OpenAuthTask 已在执行", null, null));
            return true;
        }
        this.f25369a = true;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime - f <= 3000) {
            this.d.post(new b(this, 5000, "3s 内重复支付", null, null));
            return true;
        }
        f = jElapsedRealtime;
        com.alipay.sdk.m.l.a.a("");
        String strA2 = q.a(32);
        HashMap map2 = new HashMap(map);
        map2.put("mqpPkgName", this.b.getPackageName());
        map2.put("mqpScene", "sdk");
        List<com.alipay.sdk.m.o.b.C0199b> listM = com.alipay.sdk.m.o.b.i().m();
        if (!com.alipay.sdk.m.o.b.i().g || listM == null) {
            listM = com.alipay.sdk.m.l.a.d;
        }
        q.c cVarA = q.a(aVar, this.b, listM);
        if (cVarA != null && !cVarA.a(aVar) && !cVarA.a() && (packageInfo = cVarA.f25547a) != null) {
            try {
                if (packageInfo.versionCode >= 122) {
                    try {
                        HashMap<String, String> mapA = com.alipay.sdk.m.w.a.a(aVar);
                        mapA.put("ts_scheme", String.valueOf(SystemClock.elapsedRealtime()));
                        map2.put("mqpLoc", new JSONObject(mapA).toString());
                    } catch (Throwable th) {
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "OpenAuthLocEx", th);
                    }
                    String strA3 = a(bizType, map2);
                    e.put(strA2, this.c);
                    try {
                        strA = a(jElapsedRealtime, strA2, bizType, strA3);
                    } catch (JSONException e2) {
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.q0, e2);
                        strA = null;
                    }
                    if (TextUtils.isEmpty(strA)) {
                        this.d.post(new b(this, 4000, "参数错误", null, null));
                        return true;
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", new Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.q).appendQueryParameter("appId", "20001129").appendQueryParameter(AssistPushConsts.MSG_TYPE_PAYLOAD, strA).build());
                    intent.addFlags(268435456);
                    intent.setPackage(cVarA.f25547a.packageName);
                    try {
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, com.alipay.sdk.m.m.b.Y, "" + jElapsedRealtime);
                        com.alipay.sdk.m.w.a.C0210a.a(aVar, strA2);
                        this.b.startActivity(intent);
                    } catch (Throwable th2) {
                        com.alipay.sdk.m.m.a.a(aVar, com.alipay.sdk.m.m.b.l, "StartWalletEx", th2);
                    }
                    return false;
                }
            } catch (Throwable unused) {
                this.d.post(new b(this, 4000, "业务参数错误", null, null));
                return true;
            }
        }
        if (!z) {
            this.d.post(new b(this, 4001, "支付宝未安装或签名错误", null, null));
            return true;
        }
        map2.put("mqpScheme", String.valueOf(str));
        map2.put("mqpNotifyName", strA2);
        map2.put("mqpScene", "landing");
        String strA4 = a(bizType, map2);
        Intent intent2 = new Intent(this.b, (Class<?>) H5OpenAuthActivity.class);
        intent2.putExtra("url", String.format("https://render.alipay.com/p/s/i?scheme=%s", Uri.encode(strA4)));
        com.alipay.sdk.m.w.a.C0210a.a(aVar, intent2);
        this.b.startActivity(intent2);
        return false;
    }

    public final String a(BizType bizType, Map<String, String> map) {
        if (bizType != null) {
            Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme("alipays").authority("platformapi").path(com.igexin.push.core.b.q).appendQueryParameter("appId", bizType.appId);
            if (a.f25370a[bizType.ordinal()] == 1) {
                builderAppendQueryParameter.appendQueryParameter("appClearTop", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE).appendQueryParameter("startMultApp", "YES");
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                builderAppendQueryParameter.appendQueryParameter(entry.getKey(), entry.getValue());
            }
            return builderAppendQueryParameter.build().toString();
        }
        throw new RuntimeException("missing bizType");
    }

    public final String a(long j, String str, BizType bizType, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("startTime", String.valueOf(j));
        jSONObject.put("session", str);
        jSONObject.put("package", this.b.getPackageName());
        if (bizType != null) {
            jSONObject.put("appId", bizType.appId);
        }
        jSONObject.put("sdkVersion", "h.a.3.8.42");
        jSONObject.put("mqpURL", str2);
        return Base64.encodeToString(jSONObject.toString().getBytes(Charset.forName("UTF-8")), 2);
    }

    public static void a(String str, int i, String str2, Bundle bundle) {
        Callback callbackRemove = e.remove(str);
        if (callbackRemove != null) {
            try {
                callbackRemove.onResult(i, str2, bundle);
            } catch (Throwable th) {
                g.a(th);
            }
        }
    }
}
