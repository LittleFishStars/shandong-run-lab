package com.alibaba.analytics.core.d;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e implements com.alibaba.analytics.core.a.d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static e f23775a;
    private Map<String, String> v = Collections.synchronizedMap(new HashMap());

    public e() {
        com.alibaba.analytics.core.a.d.a().a("loglevel", this);
        c("loglevel", com.alibaba.analytics.core.a.d.a().get("loglevel"));
    }

    public static synchronized e a() {
        if (f23775a == null) {
            f23775a = new e();
        }
        return f23775a;
    }

    @Override // com.alibaba.analytics.core.a.d.a
    public void c(String str, String str2) {
        this.v.clear();
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            Iterator<String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                String strOptString = jSONObject.optString(next);
                if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString)) {
                    this.v.put(next, strOptString);
                }
            }
        } catch (Throwable unused) {
        }
    }

    public String e(String str) {
        String strF = f(str);
        return !TextUtils.isEmpty(strF) ? strF : "3";
    }

    public String f(String str) {
        return this.v.get(str);
    }
}
