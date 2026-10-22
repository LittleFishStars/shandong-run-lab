package com.ipd.dsp.internal.g1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspInterstitialAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.request.DspInterstitialAdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e extends c<DspInterstitialAd> {
    public boolean h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;
    public boolean m;
    public boolean n;
    public DspLoadManager.InterstitialAdListener o;

    public void a(@NonNull DspInterstitialAdRequest dspInterstitialAdRequest, @NonNull DspLoadManager.InterstitialAdListener interstitialAdListener) {
        a(dspInterstitialAdRequest, "Interstitial");
        this.h = dspInterstitialAdRequest.isShakeable();
        this.i = dspInterstitialAdRequest.getShakeRequireForce();
        this.j = dspInterstitialAdRequest.isDisableFallingView();
        this.k = dspInterstitialAdRequest.getFallingRate();
        this.l = dspInterstitialAdRequest.isEnableSlideView();
        this.m = dspInterstitialAdRequest.isOneClickShutdown();
        this.n = dspInterstitialAdRequest.isClickToClose();
        this.o = interstitialAdListener;
        a();
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspInterstitialAd> list) {
        if (this.o != null) {
            DspInterstitialAd dspInterstitialAd = list.get(0);
            if (dspInterstitialAd instanceof com.ipd.dsp.internal.a1.g) {
                try {
                    ((com.ipd.dsp.internal.a1.g) dspInterstitialAd).a();
                } catch (Throwable unused) {
                }
            }
            this.o.onInterstitialAdLoad(dspInterstitialAd);
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
            cVar2.l = this.m;
            cVar2.m = this.n;
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void a(int i, @NonNull String str) {
        DspLoadManager.InterstitialAdListener interstitialAdListener = this.o;
        if (interstitialAdListener != null) {
            interstitialAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspInterstitialAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new com.ipd.dsp.internal.a1.e(it.next()));
                break;
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return arrayList;
    }
}
