package com.baidu.mshield.x6.e;

import android.content.Context;
import com.baidu.mshield.x6.f.l;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f26761a;
    public g b;
    public com.baidu.mshield.x6.b.b c;
    public int d;

    public c(Context context, int i) {
        this.f26761a = context;
        this.d = i;
        this.b = new g(context, i);
        this.c = new com.baidu.mshield.x6.b.b(this.f26761a);
    }

    public final long a() {
        long j = 300000;
        try {
            int i = h.d;
            if (i == 0 || i == 1 || i == 2) {
                j = 5000;
            } else if ((i < 3 || i >= 10) && i >= 10) {
                j = -1;
            }
            h.d = i + 1;
        } catch (Throwable th) {
            com.baidu.mshield.x6.f.f.b(th);
        }
        return j;
    }

    public void b() {
        JSONObject jSONObjectA;
        try {
            com.baidu.mshield.b.c.a.a("report static alive for start");
            JSONObject jSONObjectA2 = this.b.a();
            if (jSONObjectA2 != null) {
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f26761a, jSONObjectA2, com.baidu.mshield.x6.f.g.c, true);
            } else {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("11111", "-1");
                jSONObjectA = com.baidu.mshield.x6.f.f.a(this.f26761a, jSONObject, com.baidu.mshield.x6.f.g.c, true);
            }
            com.baidu.mshield.b.c.a.a("sendJson:" + jSONObjectA);
            if (!com.baidu.mshield.b.a.d.b(this.f26761a)) {
                h.c = false;
                h.c = false;
                return;
            }
            int iA = l.a(this.f26761a, jSONObjectA.toString());
            com.baidu.mshield.b.c.a.c("result: " + iA);
            if (iA == 0) {
                this.c.s(com.baidu.mshield.x6.f.f.c());
                this.c.b(true);
                this.c.e(false);
            } else {
                long jA = a();
                if (com.baidu.mshield.b.a.d.b(this.f26761a) && jA > 0) {
                    f.b(this.f26761a).a(jA);
                }
            }
        } catch (Throwable th) {
            try {
                com.baidu.mshield.x6.f.f.b(th);
            } finally {
                h.c = false;
            }
        }
    }
}
