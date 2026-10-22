package com.baidu.xclient.gdid;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mshield.b.a.g;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile h f26833a;
    public AtomicBoolean b = new AtomicBoolean(false);

    public static h a() {
        if (f26833a == null) {
            synchronized (h.class) {
                if (f26833a == null) {
                    f26833a = new h();
                }
            }
        }
        return f26833a;
    }

    public final JSONObject a(Context context, StringBuilder sb) {
        try {
            JSONObject jSONObject = new JSONObject();
            String str = d.a().d()[0];
            String str2 = "";
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            jSONObject.put("15028", str);
            String strA = com.baidu.xclient.gdid.j.c.a("02018", d.a().c("arid"), sb);
            if (!TextUtils.isEmpty(strA)) {
                str2 = strA;
            }
            jSONObject.put("02018", str2);
            jSONObject.put("15003", com.baidu.mshield.b.b.a.a(context));
            jSONObject.put("02003", d.a().c("mod"));
            jSONObject.put("02002", com.baidu.xclient.gdid.jni.c.a(context).f());
            String strB = g.b(context);
            String strC = g.c(context);
            jSONObject.put("15029", strB);
            jSONObject.put("15030", strC);
            jSONObject.put("p", com.baidu.mshield.b.a.e.c() ? "1" : "0");
            jSONObject.put("02020", com.baidu.xclient.gdid.j.d.b());
            jSONObject.put("02015", d.a().c("arv"));
            jSONObject.put("s", com.baidu.xclient.gdid.jni.c.a(context).a());
            return jSONObject;
        } catch (Throwable th) {
            com.baidu.xclient.gdid.j.d.a(th);
            return null;
        }
    }

    public void a(Context context) {
        if (this.b.get()) {
            return;
        }
        try {
            this.b.set(true);
            if (!e.e().x() && com.baidu.xclient.gdid.j.d.a(context) && com.baidu.mshield.b.e.a.d(context)) {
                long jN = e.e().n();
                long jO = e.e().o();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - jN >= jO) {
                    StringBuilder sb = new StringBuilder();
                    JSONObject jSONObjectA = a(context, sb);
                    jSONObjectA.put("15057", sb);
                    JSONObject jSONObjectA2 = com.baidu.xclient.gdid.j.d.a(context, jSONObjectA, "1072102");
                    if (jSONObjectA2 != null && new com.baidu.xclient.gdid.g.a(context, null).a(jSONObjectA2) != null) {
                        e.e().d();
                        e.e().g(jCurrentTimeMillis);
                    }
                }
            }
        } catch (Throwable th) {
            try {
                com.baidu.xclient.gdid.j.d.a(th);
            } finally {
                this.b.set(false);
            }
        }
    }
}
