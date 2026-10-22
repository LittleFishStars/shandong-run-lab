package com.ipd.dsp.internal.o1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.e1.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f38479a;
    public com.ipd.dsp.internal.g1.c.b<List<DspSplashAd>> b;

    public a(m mVar, com.ipd.dsp.internal.g1.c.b<List<DspSplashAd>> bVar) {
        this.f38479a = mVar;
        this.b = bVar;
    }

    public abstract void a();

    public void a(DspSplashAd dspSplashAd, int i) {
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(dspSplashAd);
            this.b.a(arrayList, i);
        }
    }

    public void b() {
        com.ipd.dsp.internal.g1.c.b<List<DspSplashAd>> bVar = this.b;
        if (bVar != null) {
            bVar.a(null, 0);
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.o1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0908a implements DspSplashAd {
        public m f;
        public com.ipd.dsp.internal.j1.b g;
        public final int h;
        public DspSplashAd.InteractionListener i;

        public AbstractC0908a(m mVar, int i) {
            this.f = mVar;
            this.g = new com.ipd.dsp.internal.j1.b(mVar);
            this.h = i;
        }

        public void a(int i, String str) {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, com.ipd.dsp.internal.f1.a.a(i, str));
            }
            DspSplashAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onSplashAdShowError(i, str);
            }
        }

        public void b() {
            DspSplashAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onSplashAdDismiss();
            }
            d();
        }

        public void c() {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, this.h);
            }
            DspSplashAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onSplashAdShow();
            }
        }

        public void d() {
            this.f = null;
            this.g = null;
            this.i = null;
        }

        @Override // com.ipd.dsp.api.IBid
        public final int getEcpm() {
            m mVar = this.f;
            if (mVar != null) {
                return mVar.v;
            }
            return 0;
        }

        @Override // com.ipd.dsp.ad.DspSplashAd
        public String getRequestId() {
            m mVar = this.f;
            return o.b(mVar != null ? mVar.i : null);
        }

        @Override // com.ipd.dsp.api.IBid
        public void onBiddingFailed(@NonNull BidFailedReason bidFailedReason) {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, bidFailedReason, "t");
            }
        }

        @Override // com.ipd.dsp.api.IBid
        public void onBiddingSuccess(int i, int i2) {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, i, i2, "t");
            }
        }

        @Override // com.ipd.dsp.ad.DspSplashAd
        public final void setInteractionListener(DspSplashAd.InteractionListener interactionListener) {
            this.i = interactionListener;
        }

        public void a() {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, this.h, 1, null, null, null);
            }
        }
    }
}
