package com.huawei.hms.push;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class u {
    private static final String[] c = {"url", NativeCallContext.DOMAIN_APP, "cosa", AliyunLogKey.KEY_RESOURCE_PATH};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f37635a;
    private o b;

    public u(Context context, o oVar) {
        this.f37635a = context;
        this.b = oVar;
    }

    public static boolean a(String str) {
        for (String str2 : c) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x00ce A[PHI: r2 r3
      0x00ce: PHI (r2v22 android.content.Intent) = (r2v16 android.content.Intent), (r2v25 android.content.Intent) binds: [B:10:0x008c, B:17:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00ce: PHI (r3v5 boolean) = (r3v3 boolean), (r3v1 boolean) binds: [B:10:0x008c, B:17:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    private void b() {
        Intent uri;
        HMSLog.i("PushSelfShowLog", "run into launchCosaApp");
        try {
            HMSLog.i("PushSelfShowLog", "enter launchExistApp cosa, appPackageName =" + this.b.c() + ",and msg.intentUri is " + this.b.m());
            Intent intentB = e.b(this.f37635a, this.b.c());
            boolean zBooleanValue = false;
            if (this.b.m() != null) {
                try {
                    uri = Intent.parseUri(this.b.m(), 0);
                    uri.setSelector(null);
                    if (uri.getClipData() == null) {
                        uri.setClipData(ClipData.newPlainText("avoid intent add read permission flags", "avoid"));
                    }
                    HMSLog.i("PushSelfShowLog", "Intent.parseUri(msg.intentUri, 0), action:" + uri.getAction());
                    zBooleanValue = e.a(this.f37635a, this.b.c(), uri).booleanValue();
                    if (zBooleanValue) {
                        intentB = uri;
                    }
                } catch (Exception e) {
                    HMSLog.w("PushSelfShowLog", "intentUri error." + e.toString());
                }
            } else if (this.b.a() != null) {
                uri = new Intent(this.b.a());
                if (e.a(this.f37635a, this.b.c(), uri).booleanValue()) {
                    intentB = uri;
                }
            }
            if (intentB == null) {
                HMSLog.i("PushSelfShowLog", "launchCosaApp,intent == null");
                return;
            }
            intentB.setPackage(this.b.c());
            if (zBooleanValue) {
                intentB.addFlags(268435456);
            } else {
                intentB.setFlags(805437440);
            }
            this.f37635a.startActivity(intentB);
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "launch Cosa App exception." + e2.toString());
        }
    }

    public void c() {
        o oVar;
        HMSLog.d("PushSelfShowLog", "enter launchNotify()");
        if (this.f37635a == null || (oVar = this.b) == null) {
            HMSLog.d("PushSelfShowLog", "launchNotify  context or msg is null");
            return;
        }
        if (NativeCallContext.DOMAIN_APP.equals(oVar.h())) {
            a();
            return;
        }
        if ("cosa".equals(this.b.h())) {
            b();
            return;
        }
        if (AliyunLogKey.KEY_RESOURCE_PATH.equals(this.b.h())) {
            HMSLog.w("PushSelfShowLog", this.b.h() + " not support rich message.");
            return;
        }
        if ("url".equals(this.b.h())) {
            HMSLog.w("PushSelfShowLog", this.b.h() + " not support URL.");
            return;
        }
        HMSLog.d("PushSelfShowLog", this.b.h() + " is not exist in hShowType");
    }

    private void a() {
        try {
            HMSLog.i("PushSelfShowLog", "enter launchApp, appPackageName =" + this.b.c());
            if (e.c(this.f37635a, this.b.c())) {
                b();
            }
        } catch (Exception e) {
            HMSLog.e("PushSelfShowLog", "launchApp error:" + e.toString());
        }
    }
}
