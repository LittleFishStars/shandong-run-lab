package com.ipd.dsp.internal.z0;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.WindowManager;
import android.window.OnBackInvokedCallback;
import androidx.annotation.Nullable;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.zj.adlib.c49;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d extends com.ipd.dsp.internal.z0.b implements com.ipd.dsp.internal.p1.e.b {
    public static final HashMap<String, DspRewardVideoAd.InteractionListener> A = new HashMap<>();
    public int j;
    public String k;
    public com.ipd.dsp.internal.e1.d l;
    public com.ipd.dsp.internal.j1.b m;
    public com.ipd.dsp.internal.j1.c n;
    public com.ipd.dsp.internal.p1.e o;
    public com.ipd.dsp.internal.b1.a p;
    public com.ipd.dsp.internal.b1.a.b q;
    public Handler r;
    public boolean s;
    public boolean u;
    public OnBackInvokedCallback z;
    public boolean h = false;
    public boolean i = false;
    public boolean t = false;
    public final f.b v = new a();
    public final AtomicBoolean w = new AtomicBoolean(false);
    public final AtomicBoolean x = new AtomicBoolean(false);
    public final AtomicBoolean y = new AtomicBoolean(false);

    public class a implements f.b {
        public a() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onPause() {
        }

        @Override // com.ipd.dsp.internal.c2.f.b
        public void onResume() {
            f.a().b(d.this.v);
            d.this.b();
        }
    }

    public class b implements com.ipd.dsp.internal.c1.b.InterfaceC0865b {
        public b() {
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void a(long j, long j2) {
            d.this.a(10, true, 0, String.format(Locale.getDefault(), "{\\\"curr\\\":%d,\\\"total\\\":%d}", Long.valueOf(j), Long.valueOf(j2)));
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onFailure(String str) {
            d.this.a(14, true, 0, str);
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onStart() {
        }

        @Override // com.ipd.dsp.internal.c1.b.InterfaceC0865b
        public void onSuccess() {
            d.this.a(13, true, 0, null);
        }
    }

    public static void e(String str) {
        if (o.c(str)) {
            A.remove(str);
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(Bundle bundle) {
        Activity activityJ = j();
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                this.z = new OnBackInvokedCallback() { // from class: com.zj.adlib.sta
                    @Override // android.window.OnBackInvokedCallback
                    public final void onBackInvoked() {
                        this.f44775a.t();
                    }
                };
                activityJ.getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.z);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        try {
            activityJ.requestWindowFeature(1);
            activityJ.getWindow().setFlags(1024, 1024);
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = activityJ.getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                activityJ.getWindow().setAttributes(attributes);
                activityJ.getWindow().getDecorView().setSystemUiVisibility(1280);
            }
        } catch (Throwable th2) {
            r.a(th2);
        }
        Intent intent = activityJ.getIntent();
        this.j = intent.getIntExtra("be", 0);
        this.k = intent.getStringExtra("uuid");
        com.ipd.dsp.internal.e1.d dVar = (com.ipd.dsp.internal.e1.d) intent.getSerializableExtra("data");
        this.l = dVar;
        if (dVar == null) {
            u();
            return;
        }
        this.u = dVar.w.l;
        this.m = new com.ipd.dsp.internal.j1.b(dVar);
        com.ipd.dsp.internal.p1.e eVar = new com.ipd.dsp.internal.p1.e(activityJ, this.l, intent.getBooleanExtra("isVolumeOn", true), this);
        this.o = eVar;
        activityJ.setContentView(eVar);
        com.ipd.dsp.internal.p1.e eVar2 = this.o;
        if (eVar2 != null) {
            eVar2.n();
        }
        Handler handler = new Handler(Looper.getMainLooper());
        this.r = handler;
        handler.postDelayed(new Runnable() { // from class: com.zj.adlib.aua
            @Override // java.lang.Runnable
            public final void run() {
                this.f40616a.u();
            }
        }, 5000L);
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void d() {
        this.s = true;
        com.ipd.dsp.internal.j1.b bVar = this.m;
        if (bVar != null) {
            bVar.a(new com.ipd.dsp.internal.j1.a(this.o));
            com.ipd.dsp.internal.j1.b bVar2 = this.m;
            com.ipd.dsp.internal.j1.c cVar = new com.ipd.dsp.internal.j1.c();
            this.n = cVar;
            bVar2.a(cVar);
            com.ipd.dsp.internal.h1.a.a(this.m, this.j);
        }
        DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
        if (interactionListener != null) {
            interactionListener.onRewardVideoShow();
        }
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.r = null;
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void k() {
        Activity activityJ;
        if (Build.VERSION.SDK_INT >= 33) {
            try {
                if (this.z != null && (activityJ = j()) != null) {
                    activityJ.getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.z);
                }
            } catch (Throwable th) {
                r.a(th);
            }
        }
        super.k();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void l() {
        com.ipd.dsp.internal.p1.e eVar;
        this.i = false;
        if (this.s && (eVar = this.o) != null) {
            eVar.r();
        }
        super.l();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void n() {
        com.ipd.dsp.internal.p1.e eVar;
        this.i = true;
        if (this.s && (eVar = this.o) != null) {
            eVar.s();
        }
        super.n();
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void p() {
        super.p();
        this.h = true;
    }

    public final void r() {
        com.ipd.dsp.internal.b1.a aVar = new com.ipd.dsp.internal.b1.a(this.l, this.m);
        this.p = aVar;
        aVar.a(new b());
        this.q = new com.ipd.dsp.internal.b1.a.b() { // from class: com.zj.adlib.gua
            @Override // com.ipd.dsp.internal.b1.a.b
            public final void a(int i, boolean z, int i2, String str) {
                this.f41989a.a(i, z, i2, str);
            }
        };
    }

    public final /* synthetic */ void s() {
        com.ipd.dsp.internal.b1.a aVar;
        if (!this.i || this.h || (aVar = this.p) == null) {
            return;
        }
        aVar.g(null);
    }

    public final /* synthetic */ void t() {
        b(4);
    }

    public final void u() {
        Handler handler = this.r;
        String currUrl = null;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.r = null;
        }
        DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
        if (interactionListener != null) {
            com.ipd.dsp.internal.p1.e eVar = this.o;
            if (eVar != null) {
                try {
                    currUrl = eVar.getCurrUrl();
                } catch (Throwable unused) {
                }
            }
            if (TextUtils.isEmpty(currUrl)) {
                currUrl = "网络错误";
            }
            com.ipd.dsp.internal.f1.a aVarB = com.ipd.dsp.internal.f1.a.b(currUrl);
            com.ipd.dsp.internal.j1.b bVar = this.m;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, aVarB.toString());
            }
            interactionListener.onRewardVideoError(aVarB.f38306a, aVarB.b);
        }
        com.ipd.dsp.internal.p1.e eVar2 = this.o;
        if (eVar2 != null) {
            eVar2.b(true);
            this.o.t();
        }
    }

    public static String a(DspRewardVideoAd.InteractionListener interactionListener) {
        HashMap<String, DspRewardVideoAd.InteractionListener> map = A;
        if (map.containsValue(interactionListener)) {
            for (Map.Entry<String, DspRewardVideoAd.InteractionListener> entry : map.entrySet()) {
                if (entry.getValue() == interactionListener) {
                    return entry.getKey();
                }
            }
        }
        String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
        A.put(strReplace, interactionListener);
        return strReplace;
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void a(int i, String str) {
        DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
        com.ipd.dsp.internal.j1.b bVar = this.m;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, com.ipd.dsp.internal.f1.a.a(i, str));
        }
        if (interactionListener != null) {
            interactionListener.onRewardVideoError(i, str);
        }
        b();
    }

    public final /* synthetic */ void d(String str) {
        if (this.l == null) {
            return;
        }
        if (this.p == null) {
            r();
        }
        try {
            if (!TextUtils.isEmpty(str)) {
                this.l.r.k = str;
            }
        } catch (Throwable th) {
            r.a(th);
        }
        a(0, true, 0, null);
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void a(@Nullable JSONObject jSONObject) {
        if (this.m != null) {
            com.ipd.dsp.internal.h1.a.a(this.m, this.j, jSONObject != null ? jSONObject.optInt("click_action", 1) : 1, null, this.o.getTouchCoordsMap(), new com.ipd.dsp.internal.h1.a.d() { // from class: com.zj.adlib.iua
                @Override // com.ipd.dsp.internal.h1.a.d
                public final void a(Object obj) {
                    this.f42447a.d((String) obj);
                }
            });
        }
        DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
        if (interactionListener != null) {
            interactionListener.onRewardVideoClick();
        }
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void a(String str) {
        if (this.t) {
            return;
        }
        this.t = true;
        try {
            com.ipd.dsp.internal.j1.b bVar = this.m;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.C);
            }
            DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
            if (interactionListener != null) {
                interactionListener.onRewardVideoVerify();
            }
        } catch (Throwable th) {
            k.a("IAP", th);
        }
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void a(com.ipd.dsp.internal.h1.a.c cVar, JSONObject jSONObject) {
        com.ipd.dsp.internal.j1.b bVar = this.m;
        if (bVar != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, cVar);
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public boolean b(int i) {
        if (i == 4) {
            com.ipd.dsp.internal.p1.e eVar = this.o;
            if (eVar != null) {
                return eVar.o();
            }
            return true;
        }
        return super.b(i);
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void a(int i, int i2) {
        com.ipd.dsp.internal.j1.c cVar = this.n;
        if (cVar == null) {
            return;
        }
        switch (i) {
            case 0:
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.z);
                return;
            case 1:
                cVar.a(i2);
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.o);
                return;
            case 2:
                cVar.b(i2);
                com.ipd.dsp.internal.h1.a.a(this.m);
                if (this.n.b() > 0.25f && !this.w.getAndSet(true)) {
                    com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.p);
                }
                if (this.n.b() > 0.5f && !this.x.getAndSet(true)) {
                    com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.q);
                }
                if (this.n.b() <= 0.75f || this.y.getAndSet(true)) {
                    return;
                }
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.r);
                return;
            case 3:
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.v);
                return;
            case 4:
                cVar.f();
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.w);
                return;
            case 5:
                cVar.d();
                return;
            case 6:
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.A);
                return;
            case 7:
                cVar.c();
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.s);
                return;
            case 8:
                cVar.e();
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.t);
                break;
            case 9:
                break;
            case 10:
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.x);
                return;
            case 11:
                com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.y);
                return;
            default:
                return;
        }
        com.ipd.dsp.internal.h1.a.a(this.m, com.ipd.dsp.internal.h1.a.e.B);
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(int i, int i2, @Nullable Intent intent) {
        super.b(i, i2, intent);
        if (i == 9529 && i2 == 0) {
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.zj.adlib.mta
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43380a.s();
                }
            }, 100L);
        }
    }

    @Override // com.ipd.dsp.internal.z0.b
    public void b(Throwable th) {
        DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
        if (interactionListener != null) {
            com.ipd.dsp.internal.f1.a aVarA = com.ipd.dsp.internal.f1.a.a(th);
            com.ipd.dsp.internal.j1.b bVar = this.m;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, aVarA.toString());
            }
            interactionListener.onRewardVideoError(aVarA.f38306a, aVarA.b);
        }
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void b(String str) {
        com.ipd.dsp.internal.j1.b bVar;
        if (this.t || (bVar = this.m) == null) {
            return;
        }
        com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.A);
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void b() {
        com.ipd.dsp.internal.j1.b bVar;
        if (this.l != null && this.s && (bVar = this.m) != null) {
            com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.D);
        }
        DspRewardVideoAd.InteractionListener interactionListener = A.get(this.k);
        if (interactionListener != null) {
            interactionListener.onRewardVideoClose();
            e(this.k);
        }
        Handler handler = this.r;
        if (handler != null) {
            try {
                handler.removeCallbacksAndMessages(null);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        com.ipd.dsp.internal.p1.e eVar = this.o;
        if (eVar != null) {
            try {
                eVar.i();
                this.o.removeAllViews();
            } catch (Throwable unused) {
            }
            this.o = null;
        }
        com.ipd.dsp.internal.b1.a aVar = this.p;
        if (aVar != null) {
            try {
                aVar.f();
            } catch (Throwable unused2) {
            }
            this.p = null;
            this.q = null;
        }
        j().finish();
    }

    @Override // com.ipd.dsp.internal.p1.e.b
    public void a(int i, JSONObject jSONObject) {
        com.ipd.dsp.internal.b1.a aVar = this.p;
        if (aVar == null) {
            return;
        }
        switch (i) {
            case 1:
                if (this.t && this.u) {
                    f.a().a(this.v);
                }
                this.p.g(this.q);
                break;
            case 2:
                aVar.h(this.q);
                break;
            case 3:
                aVar.a(this.q, j());
                break;
            case 4:
                aVar.e(this.q);
                break;
            case 5:
                a(5, true, 0, String.valueOf(aVar.d()));
                break;
            case 6:
                a(6, true, 0, String.valueOf(aVar.a()));
                break;
            case 7:
                aVar.k(this.q);
                break;
            case 8:
                aVar.i(this.q);
                break;
            case 9:
                aVar.j(this.q);
                break;
            case 11:
                a(11, true, 0, String.valueOf(aVar.e()));
                break;
            case 12:
                a(12, true, 0, String.valueOf(aVar.c()));
                break;
            case 15:
                aVar.a(this.q);
                break;
        }
    }

    public final void a(int i, boolean z, int i2, String str) {
        com.ipd.dsp.internal.p1.e eVar;
        if (!this.s || (eVar = this.o) == null) {
            return;
        }
        eVar.a(i, z, i2, str);
    }
}
