package com.zj.adlib;

import android.content.Context;
import com.amap.api.col.p0003l.bg;
import com.amap.api.col.p0003l.c;
import com.amap.api.col.p0003l.ff;
import com.amap.api.col.p0003l.it;
import com.amap.api.col.p0003l.z;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class qna {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static qna f44251a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public z f19151a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LinkedHashMap<String, it> f19152a = new LinkedHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19153a = true;

    public qna() {
        try {
            if (this.f19151a == null) {
                this.f19151a = z.j();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static qna a() {
        return f();
    }

    public static synchronized qna f() {
        try {
            qna qnaVar = f44251a;
            if (qnaVar == null) {
                f44251a = new qna();
            } else if (qnaVar.f19151a == null) {
                qnaVar.f19151a = z.i();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return f44251a;
    }

    public static void h() {
        f44251a = null;
    }

    public final void b(bg bgVar) {
        synchronized (this.f19152a) {
            c cVar = (c) this.f19152a.get(bgVar.b());
            if (cVar == null) {
                return;
            }
            cVar.a();
            this.f19152a.remove(bgVar.b());
        }
    }

    public final void c(bg bgVar, Context context) throws ff {
        if (!this.f19152a.containsKey(bgVar.b())) {
            c cVar = new c((com.amap.api.col.p0003l.bx) bgVar, context.getApplicationContext(), (byte) 0);
            synchronized (this.f19152a) {
                this.f19152a.put(bgVar.b(), cVar);
            }
        }
        this.f19151a.b(this.f19152a.get(bgVar.b()));
    }

    public final void d() {
        g();
        this.f19151a.f();
        this.f19151a = null;
        h();
    }

    public final void e(bg bgVar) {
        c cVar = (c) this.f19152a.get(bgVar.b());
        if (cVar != null) {
            synchronized (this.f19152a) {
                cVar.b();
                this.f19152a.remove(bgVar.b());
            }
        }
    }

    public final void g() {
        synchronized (this.f19152a) {
            if (this.f19152a.size() <= 0) {
                return;
            }
            for (Map.Entry<String, it> entry : this.f19152a.entrySet()) {
                entry.getKey();
                ((c) entry.getValue()).a();
            }
            this.f19152a.clear();
        }
    }
}
