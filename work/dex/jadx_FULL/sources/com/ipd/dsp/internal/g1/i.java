package com.ipd.dsp.internal.g1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.e1.m;
import com.ipd.dsp.request.DspSplashAdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i extends c<DspSplashAd> {
    public boolean h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;
    public DspLoadManager.SplashAdListener m;

    public void a(@NonNull DspSplashAdRequest dspSplashAdRequest, @NonNull DspLoadManager.SplashAdListener splashAdListener) {
        a(dspSplashAdRequest, "Splash");
        this.h = dspSplashAdRequest.isShakeable();
        this.i = dspSplashAdRequest.getShakeRequireForce();
        this.j = dspSplashAdRequest.isDisableFallingView();
        this.k = dspSplashAdRequest.getFallingRate();
        this.l = dspSplashAdRequest.isEnableSlideView();
        this.m = splashAdListener;
        a(dspSplashAdRequest.getFetchTimeOut());
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspSplashAd> list) {
        if (this.m != null) {
            DspSplashAd dspSplashAd = list.get(0);
            if (dspSplashAd instanceof com.ipd.dsp.internal.a1.g) {
                try {
                    ((com.ipd.dsp.internal.a1.g) dspSplashAd).a();
                } catch (Throwable unused) {
                }
            }
            this.m.onSplashAdLoad(dspSplashAd);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void d(@NonNull List<? extends com.ipd.dsp.internal.e1.d> list) {
        for (com.ipd.dsp.internal.e1.d dVar : list) {
            com.ipd.dsp.internal.e1.c cVar = dVar.w;
            cVar.f = this.f;
            cVar.g = this.h && (com.ipd.dsp.internal.c2.g.a().i() == null || com.ipd.dsp.internal.c2.g.a().i().canUseSensor());
            com.ipd.dsp.internal.e1.c cVar2 = dVar.w;
            cVar2.h = this.i;
            cVar2.j = this.j;
            cVar2.k = this.k;
            cVar2.i = this.l;
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void a(int i, @NonNull String str) {
        DspLoadManager.SplashAdListener splashAdListener = this.m;
        if (splashAdListener != null) {
            splashAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspSplashAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new com.ipd.dsp.internal.a1.f(it.next()));
                break;
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return arrayList;
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void a(m mVar, c.b<List<DspSplashAd>> bVar) {
        com.ipd.dsp.internal.o1.a bVar2;
        int i = mVar.F;
        if (i != 7) {
            bVar2 = i != 9 ? null : new com.ipd.dsp.internal.o1.c(mVar, bVar);
        } else {
            bVar2 = new com.ipd.dsp.internal.o1.b(mVar, bVar);
        }
        if (bVar2 != null) {
            bVar2.a();
        } else {
            bVar.a(null, 0);
        }
    }
}
