package com.ipd.dsp.internal.o1;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.ViewGroup;
import com.beizi.fusion.AdListener;
import com.beizi.fusion.SplashAd;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.s;
import com.ipd.dsp.internal.e1.m;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends com.ipd.dsp.internal.o1.a {
    public SplashAd c;
    public C0909b d;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.o1.b$b, reason: collision with other inner class name */
    public static class C0909b implements AdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f38480a;
        public c b;

        @Override // com.beizi.fusion.AdListener
        public void onAdClicked() {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a();
            }
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdClosed() {
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
                a();
            }
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdFailedToLoad(int i) {
            b bVar = this.f38480a;
            if (bVar != null) {
                bVar.b();
                this.f38480a.d = null;
            }
            this.f38480a = null;
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdLoaded() {
            b bVar = this.f38480a;
            if (bVar == null) {
                return;
            }
            try {
                m mVar = bVar.f38479a;
                int ecpm = mVar.I ? bVar.c.getECPM() : mVar.J;
                this.f38480a.a(new c(ecpm), ecpm);
            } catch (Throwable unused) {
                this.f38480a.b();
            }
            this.f38480a.d = null;
            this.f38480a = null;
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdShown() {
            c cVar = this.b;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.beizi.fusion.AdListener
        public void onAdTick(long j) {
        }

        public C0909b(b bVar) {
            this.f38480a = bVar;
        }

        public final void a(c cVar) {
            this.b = cVar;
        }

        public final void a() {
            this.b.d();
            this.b = null;
        }
    }

    public static class c extends com.ipd.dsp.internal.o1.a.AbstractC0908a {
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
                this.j.show(viewGroup);
            } catch (Throwable th) {
                k.b("BZSA", "show error", th);
                com.ipd.dsp.internal.f1.a aVarE = com.ipd.dsp.internal.f1.a.e(th.getClass().getSimpleName());
                a(aVarE.f38306a, aVarE.b);
                d();
            }
        }

        public c(b bVar, int i) {
            super(bVar.f38479a, i);
            this.j = bVar.c;
            bVar.c = null;
            bVar.d.a(this);
        }
    }

    public b(m mVar, com.ipd.dsp.internal.g1.c.b<List<DspSplashAd>> bVar) {
        super(mVar, bVar);
    }

    public final /* synthetic */ void c() {
        Activity activityB = f.a().b();
        if (activityB == null) {
            b();
            return;
        }
        try {
            String str = this.f38479a.H;
            C0909b c0909b = new C0909b();
            this.d = c0909b;
            this.c = new SplashAd(activityB, null, str, c0909b, 3500L);
            Pair<Float, Float> pairC = s.c(activityB);
            this.c.loadAd(((Float) pairC.first).intValue(), ((Float) pairC.second).intValue());
        } catch (Throwable unused) {
            b();
        }
    }

    @Override // com.ipd.dsp.internal.o1.a
    public void a() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.uka
            @Override // java.lang.Runnable
            public final void run() {
                this.f45166a.c();
            }
        });
    }
}
