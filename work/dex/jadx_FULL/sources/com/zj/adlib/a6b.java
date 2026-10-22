package com.zj.adlib;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import cn.hzjizhun.admin.base.ad.RcSdk;
import cn.hzjizhun.admin.base.d;
import cn.hzjizhun.admin.base.g;
import com.igexin.push.core.b;
import java.util.HashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class a6b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ qxb f40461a;

    public a6b(qxb qxbVar) {
        this.f40461a = qxbVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jha.a().getClass();
            jSONObject.put(b.aC, jha.c());
            jha jhaVarA = jha.a();
            if (TextUtils.isEmpty(jhaVarA.f17399b)) {
                try {
                    Context contextE = RcSdk.e();
                    PackageManager packageManager = contextE.getPackageManager();
                    String str2 = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(contextE.getPackageName(), 0));
                    jhaVarA.f17399b = str2;
                    alb.c("appName", str2);
                    str = jhaVarA.f17399b;
                } catch (Throwable unused) {
                    str = "";
                }
            } else {
                str = jhaVarA.f17399b;
            }
            jSONObject.put("appName", str);
            jSONObject.put("os", 1);
            jSONObject.put("version", 38);
            jSONObject.put("sdkv", "2.1.0");
            jSONObject.put("osversion", Build.VERSION.RELEASE);
            jSONObject.put("apiLevel", Build.VERSION.SDK_INT);
            jSONObject.put("userControl", RcSdk.k() ? 1 : 0);
            jSONObject.put("deviceId", m3b.c().a());
            m3b m3bVarC = m3b.c();
            jSONObject.put("webviewH", (m3bVarC.f18126c - m3bVarC.f18127d) - 20);
            jSONObject.put("webviewW", m3b.c().f18124b);
            String strC = g.c(jSONObject.toString());
            String str3 = d.f22698a;
            qxb qxbVar = this.f40461a;
            HashMap map = new HashMap();
            m3b.c().getClass();
            map.put("User-Agent", m3b.g());
            mib.a().g("POST", str3, map, strC, qxbVar);
        } catch (Throwable unused2) {
        }
    }
}
