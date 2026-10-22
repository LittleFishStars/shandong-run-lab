package com.ipd.dsp.internal.p1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.c2.s;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@SuppressLint({"ViewConstructor"})
public class e extends com.ipd.dsp.internal.x1.c {
    public final com.ipd.dsp.internal.e1.d g;
    public final boolean h;
    public com.ipd.dsp.internal.w1.a i;
    public com.ipd.dsp.internal.w1.e j;
    public b k;
    public Handler l;
    public boolean m;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }
    }

    public interface b {
        void a(int i, int i2);

        void a(int i, String str);

        void a(int i, JSONObject jSONObject);

        void a(com.ipd.dsp.internal.h1.a.c cVar, JSONObject jSONObject);

        void a(String str);

        void a(@Nullable JSONObject jSONObject);

        void b();

        void b(String str);

        void d();
    }

    public e(@NonNull Context context, com.ipd.dsp.internal.e1.d dVar, boolean z, b bVar) {
        super(context);
        this.l = new a(Looper.getMainLooper());
        int iA = (int) s.a(context, 60.0f);
        this.g = dVar;
        this.h = z;
        this.k = bVar;
        this.i = new com.ipd.dsp.internal.w1.a(context, iA, new View.OnClickListener() { // from class: com.zj.adlib.pya
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f44088a.a(view);
            }
        });
        this.j = new com.ipd.dsp.internal.w1.e(context, this);
        setBackgroundColor(-1);
        addView(this.i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.setMargins(0, iA, 0, 0);
        try {
            View viewD = this.j.d();
            if (viewD != null) {
                viewD.setVisibility(4);
            }
            addView(viewD, layoutParams);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        p();
    }

    public final /* synthetic */ void b(int i, String str) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(i, str);
        }
    }

    public void c(final int i, final String str) {
        a(new Runnable() { // from class: com.zj.adlib.iza
            @Override // java.lang.Runnable
            public final void run() {
                this.f42474a.b(i, str);
            }
        });
    }

    public final /* synthetic */ void d(String str) {
        com.ipd.dsp.internal.w1.a aVar = this.i;
        if (aVar != null) {
            aVar.setTitle(str);
        }
    }

    public boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setFlags(268435456);
            intent.setData(Uri.parse(str));
            intent.addCategory("android.intent.category.BROWSABLE");
            intent.setComponent(null);
            intent.setSelector(null);
            if (com.ipd.dsp.internal.w1.d.a(getContext(), intent)) {
                getContext().startActivity(intent);
                return true;
            }
        } catch (Throwable th) {
            r.a(th);
        }
        return false;
    }

    public void f(final String str) {
        a(new Runnable() { // from class: com.zj.adlib.vxa
            @Override // java.lang.Runnable
            public final void run() {
                this.f45483a.b(str);
            }
        });
    }

    public void g(final String str) {
        a(new Runnable() { // from class: com.zj.adlib.mza
            @Override // java.lang.Runnable
            public final void run() {
                this.f43417a.c(str);
            }
        });
    }

    public JSONObject getAdData() {
        if (this.g != null) {
            try {
                return new JSONObject(this.g.C);
            } catch (JSONException e) {
                r.a(e);
            }
        }
        return null;
    }

    public String getCurrUrl() {
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar == null) {
            return null;
        }
        try {
            return eVar.c();
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject getCustomData() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("is_volume_on", this.h ? 1 : 0);
            com.ipd.dsp.internal.e1.d dVar = this.g;
            if (dVar != null) {
                jSONObject.put("download_confirm", dVar.w.f ? 1 : 0);
                jSONObject.put("is_enable_slide_anim", this.g.w.i ? 1 : 0);
                jSONObject.put("is_disable_falling_anim", this.g.w.j);
                jSONObject.put("falling_rate", this.g.w.k);
            }
            return jSONObject;
        } catch (JSONException e) {
            r.a(e);
            return jSONObject;
        }
    }

    public void h(final String str) {
        a(new Runnable() { // from class: com.zj.adlib.pza
            @Override // java.lang.Runnable
            public final void run() {
                this.f44091a.d(str);
            }
        });
    }

    public void i() {
        this.k = null;
        com.ipd.dsp.internal.w1.a aVar = this.i;
        if (aVar != null) {
            aVar.a();
            this.i = null;
        }
        Handler handler = this.l;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.l = null;
        }
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.b();
            this.j = null;
        }
    }

    public void j() {
        a(new Runnable() { // from class: com.zj.adlib.sza
            @Override // java.lang.Runnable
            public final void run() {
                this.f44818a.k();
            }
        });
    }

    public final /* synthetic */ void k() {
        b bVar = this.k;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final /* synthetic */ void l() {
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.g();
        }
    }

    public final /* synthetic */ void m() {
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            try {
                View viewD = eVar.d();
                if (viewD != null) {
                    viewD.setVisibility(0);
                }
            } catch (Throwable unused) {
            }
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void n() {
        com.ipd.dsp.internal.w1.a aVar = this.i;
        if (aVar != null) {
            aVar.a(this.g);
        }
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.a(this.g.q.f);
        }
    }

    public boolean o() {
        com.ipd.dsp.internal.e1.d dVar;
        com.ipd.dsp.internal.w1.a aVar;
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if ((eVar == null || !eVar.f()) && (dVar = this.g) != null && dVar.E && (aVar = this.i) != null) {
            aVar.c();
        }
        return true;
    }

    public void p() {
        if (this.m) {
            j();
        } else {
            a(new Runnable() { // from class: com.zj.adlib.vya
                @Override // java.lang.Runnable
                public final void run() {
                    this.f45490a.l();
                }
            });
        }
    }

    public void q() {
        a(new Runnable() { // from class: com.zj.adlib.xza
            @Override // java.lang.Runnable
            public final void run() {
                this.f45927a.m();
            }
        });
    }

    public void r() {
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.h();
        }
    }

    public void s() {
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.i();
        }
    }

    public void t() {
        com.ipd.dsp.internal.w1.a aVar = this.i;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void a(int i, boolean z, int i2, String str) {
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.a(i, z, i2, str);
        }
    }

    public final /* synthetic */ void c(String str) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.b(str);
        }
        t();
    }

    public void b(@Nullable final JSONObject jSONObject) {
        a(new Runnable() { // from class: com.zj.adlib.dza
            @Override // java.lang.Runnable
            public final void run() {
                this.f41312a.a(jSONObject);
            }
        });
    }

    public void d(final int i) {
        a(new Runnable() { // from class: com.zj.adlib.vza
            @Override // java.lang.Runnable
            public final void run() {
                this.f45494a.c(i);
            }
        });
    }

    public final void a(Runnable runnable) {
        Handler handler = this.l;
        if (handler != null) {
            handler.post(runnable);
        }
    }

    public final /* synthetic */ void b(String str) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(str);
        }
        t();
    }

    public final /* synthetic */ void c(int i) {
        com.ipd.dsp.internal.w1.a aVar = this.i;
        if (aVar != null) {
            aVar.setTitle(i);
        }
    }

    public final /* synthetic */ void a(JSONObject jSONObject) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }

    public void b(boolean z) {
        this.m = z;
        com.ipd.dsp.internal.w1.a aVar = this.i;
        if (aVar != null) {
            aVar.setTitle("页面错误，请退出重试");
        }
        com.ipd.dsp.internal.w1.e eVar = this.j;
        if (eVar != null) {
            eVar.b();
        }
    }

    public void a(com.ipd.dsp.internal.h1.a.c cVar, JSONObject jSONObject) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(cVar, jSONObject);
        }
    }

    public void a(int i, int i2) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(i, i2);
        }
    }

    public void a(int i, JSONObject jSONObject) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.a(i, jSONObject);
        }
    }
}
