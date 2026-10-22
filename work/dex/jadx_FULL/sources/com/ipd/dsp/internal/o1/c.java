package com.ipd.dsp.internal.o1;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.e1.m;
import com.octopus.ad.Octopus;
import com.octopus.ad.SplashAd;
import com.octopus.ad.SplashAdListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class c extends com.ipd.dsp.internal.o1.a {
    public SplashAd c;
    public b d;

    public static class b implements SplashAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f38481a;
        public C0910c b;

        public void onAdCacheLoaded(boolean z) {
        }

        public void onAdClicked() {
            C0910c c0910c = this.b;
            if (c0910c != null) {
                c0910c.a();
            }
        }

        public void onAdClosed() {
            C0910c c0910c = this.b;
            if (c0910c != null) {
                c0910c.b();
                a();
            }
        }

        public void onAdFailedToLoad(int i) {
            c cVar = this.f38481a;
            if (cVar != null) {
                cVar.b();
                this.f38481a.d = null;
            }
            this.f38481a = null;
        }

        public void onAdLoaded() {
            c cVar = this.f38481a;
            if (cVar == null) {
                return;
            }
            try {
                m mVar = cVar.f38479a;
                int price = mVar.I ? cVar.c.getPrice() : mVar.J;
                this.f38481a.a(new C0910c(price), price);
            } catch (Throwable unused) {
                this.f38481a.b();
            }
            this.f38481a.d = null;
            this.f38481a = null;
        }

        public void onAdShown() {
            C0910c c0910c = this.b;
            if (c0910c != null) {
                c0910c.c();
            }
        }

        public void onAdTick(long j) {
        }

        public b(c cVar) {
            this.f38481a = cVar;
        }

        public final void a(C0910c c0910c) {
            this.b = c0910c;
        }

        public final void a() {
            this.b.d();
            this.b = null;
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.o1.c$c, reason: collision with other inner class name */
    public static class C0910c extends com.ipd.dsp.internal.o1.a.AbstractC0908a {
        public SplashAd j;

        @Override // com.ipd.dsp.internal.o1.a.AbstractC0908a
        public void d() {
            this.j = null;
            super.d();
        }

        @Override // com.ipd.dsp.ad.DspSplashAd
        public void show(Context context, ViewGroup viewGroup) {
            if (viewGroup == null) {
                com.ipd.dsp.internal.f1.a aVarB = com.ipd.dsp.internal.f1.a.b();
                a(aVarB.f38306a, aVarB.b);
                d();
                return;
            }
            try {
                this.j.showAd(viewGroup);
            } catch (Throwable th) {
                k.b("OSA", "show error", th);
                com.ipd.dsp.internal.f1.a aVarE = com.ipd.dsp.internal.f1.a.e(th.getClass().getSimpleName());
                a(aVarE.f38306a, aVarE.b);
                d();
            }
        }

        public C0910c(c cVar, int i) {
            super(cVar.f38479a, i);
            this.j = cVar.c;
            cVar.c = null;
            cVar.d.a(this);
        }
    }

    public c(m mVar, com.ipd.dsp.internal.g1.c.b<List<DspSplashAd>> bVar) {
        super(mVar, bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        Activity activityB = f.a().b();
        if (activityB == null) {
            b();
            return;
        }
        try {
            Octopus.setTimeout(3500);
        } catch (Throwable unused) {
        }
        try {
            String str = this.f38479a.H;
            b bVar = new b();
            this.d = bVar;
            SplashAd splashAd = new SplashAd(activityB, str, bVar);
            this.c = splashAd;
            splashAd.openAdInNativeBrowser(true);
        } catch (Throwable unused2) {
            b();
        }
    }

    @Override // com.ipd.dsp.internal.o1.a
    public void a() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.zoa
            @Override // java.lang.Runnable
            public final void run() {
                this.f46311a.c();
            }
        });
    }
}
