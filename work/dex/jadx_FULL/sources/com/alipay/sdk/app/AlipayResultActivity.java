package com.alipay.sdk.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64;
import com.alipay.sdk.m.m.b;
import com.alipay.sdk.m.y.o;
import com.zj.adlib.c49;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class AlipayResultActivity extends Activity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f25365a = new ConcurrentHashMap<>();

    public interface a {
        void a(int i, String str, String str2);
    }

    public final void a(String str, Bundle bundle) {
        a aVarRemove = f25365a.remove(str);
        if (aVarRemove == null) {
            finish();
            return;
        }
        try {
            aVarRemove.a(bundle.getInt("endCode"), bundle.getString(o.b), bundle.getString("result"));
        } finally {
            finish();
        }
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        Throwable th;
        super.onCreate(bundle);
        try {
            Intent intent = getIntent();
            try {
                String stringExtra = intent.getStringExtra("session");
                Bundle bundleExtra = intent.getBundleExtra("result");
                String stringExtra2 = intent.getStringExtra("scene");
                com.alipay.sdk.m.w.a aVarA = com.alipay.sdk.m.w.a.C0210a.a(stringExtra);
                if (aVarA == null) {
                    finish();
                    return;
                }
                com.alipay.sdk.m.m.a.a(aVarA, b.l, "BSPSession", stringExtra + "|" + SystemClock.elapsedRealtime());
                if (TextUtils.equals("mqpSchemePay", stringExtra2)) {
                    a(stringExtra, bundleExtra);
                    return;
                }
                if ((TextUtils.isEmpty(stringExtra) || bundleExtra == null) && intent.getData() != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(Base64.decode(intent.getData().getQuery(), 2), "UTF-8"));
                        JSONObject jSONObject2 = jSONObject.getJSONObject("result");
                        stringExtra = jSONObject.getString("session");
                        com.alipay.sdk.m.m.a.a(aVarA, b.l, "BSPUriSession", stringExtra);
                        Bundle bundle2 = new Bundle();
                        try {
                            Iterator<String> itKeys = jSONObject2.keys();
                            while (itKeys.hasNext()) {
                                String next = itKeys.next();
                                bundle2.putString(next, jSONObject2.getString(next));
                            }
                            bundleExtra = bundle2;
                        } catch (Throwable th2) {
                            th = th2;
                            bundleExtra = bundle2;
                            com.alipay.sdk.m.m.a.a(aVarA, b.l, "BSPResEx", th);
                            com.alipay.sdk.m.m.a.a(aVarA, b.l, b.s0, th);
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                if (TextUtils.isEmpty(stringExtra) || bundleExtra == null) {
                    com.alipay.sdk.m.m.a.b(this, aVarA, "", aVarA.d);
                    finish();
                    return;
                }
                try {
                    com.alipay.sdk.m.m.a.a(aVarA, b.l, b.V, "" + SystemClock.elapsedRealtime());
                    com.alipay.sdk.m.m.a.a(aVarA, b.l, b.W, bundleExtra.getInt("endCode", -1) + "|" + bundleExtra.getString(o.b, c49.f40900a));
                    OpenAuthTask.a(stringExtra, 9000, "OK", bundleExtra);
                } finally {
                    com.alipay.sdk.m.m.a.b(this, aVarA, "", aVarA.d);
                    finish();
                }
            } catch (Throwable th4) {
                com.alipay.sdk.m.m.a.a((com.alipay.sdk.m.w.a) null, b.l, "BSPSerError", th4);
                com.alipay.sdk.m.m.a.a((com.alipay.sdk.m.w.a) null, b.l, b.r0, th4);
                finish();
            }
        } catch (Throwable unused) {
            finish();
        }
    }
}
