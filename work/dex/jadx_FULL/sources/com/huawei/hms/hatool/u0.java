package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class u0 {
    public static f0 a(String str, String str2, String str3, String str4) {
        f0 f0Var = new f0();
        f0Var.a(str);
        f0Var.b(q0.f());
        f0Var.e(str2);
        f0Var.c(str4);
        StringBuffer stringBuffer = new StringBuffer("hmshi");
        stringBuffer.append(str3);
        stringBuffer.append("qrt");
        f0Var.d(stringBuffer.toString());
        return f0Var;
    }

    public static l a(String str, String str2) {
        l lVar = new l();
        lVar.a(j.a().a(str, str2));
        return lVar;
    }

    public static y0 a(String str, String str2, String str3) {
        y0 y0Var = new y0();
        y0Var.c(q0.j());
        y0Var.e(q0.l());
        y0Var.a(str3);
        y0Var.b(j.a().b(str2, str));
        return y0Var;
    }

    public static h1 b(String str, String str2) {
        v.c("hmsSdk", "generate UploadData EventModelHandlerBase");
        m1.d().a(str, str2);
        if (!TextUtils.isEmpty(m1.d().a())) {
            return new h1(m1.d().c());
        }
        v.f("hmsSdk", "event chifer is empty");
        return null;
    }

    public static Map<String, String> c(String str, String str2) {
        HashMap map = new HashMap();
        map.put("App-Id", q0.f());
        map.put("App-Ver", q0.g());
        map.put("Sdk-Name", "hianalytics");
        map.put("Sdk-Ver", "2.2.0.314");
        map.put("Device-Type", Build.MODEL);
        map.put("servicetag", str);
        v.a("hmsSdk", "sendData RequestId : %s", str2);
        map.put("Request-Id", str2);
        return map;
    }
}
