package com.ipd.dsp.internal.n1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.e1.m;
import com.ipd.dsp.internal.g1.c;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public m f38465a;
    public c.b<List<DspRewardVideoAd>> b;

    public a(m mVar, c.b<List<DspRewardVideoAd>> bVar) {
        this.f38465a = mVar;
        this.b = bVar;
    }

    public abstract void a();

    public void a(DspRewardVideoAd dspRewardVideoAd, int i) {
        if (this.b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(dspRewardVideoAd);
            this.b.a(arrayList, i);
        }
    }

    public void b() {
        c.b<List<DspRewardVideoAd>> bVar = this.b;
        if (bVar != null) {
            bVar.a(null, 0);
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.n1.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC0906a implements DspRewardVideoAd {
        public m f;
        public com.ipd.dsp.internal.j1.b g;
        public final int h;
        public DspRewardVideoAd.InteractionListener i;
        public boolean j = true;

        public AbstractC0906a(m mVar, int i) {
            this.f = mVar;
            this.g = new com.ipd.dsp.internal.j1.b(mVar);
            this.h = i;
        }

        public void a(int i, String str) {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.c, com.ipd.dsp.internal.f1.a.a(i, str));
            }
            DspRewardVideoAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onRewardVideoError(i, str);
            }
        }

        public void b() {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.D, "t");
            }
            DspRewardVideoAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onRewardVideoClose();
            }
            f();
        }

        public void c() {
        }

        public void d() {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, com.ipd.dsp.internal.h1.a.e.C);
            }
            DspRewardVideoAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onRewardVideoVerify();
            }
        }

        public void e() {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, this.h);
            }
            DspRewardVideoAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onRewardVideoShow();
            }
        }

        public void f() {
            this.i = null;
            this.f = null;
            this.g = null;
        }

        @Override // com.ipd.dsp.api.IBid
        public final int getEcpm() {
            m mVar = this.f;
            if (mVar != null) {
                return mVar.v;
            }
            return 0;
        }

        @Override // com.ipd.dsp.ad.DspRewardVideoAd
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

        @Override // com.ipd.dsp.ad.DspRewardVideoAd
        public final void setInteractionListener(DspRewardVideoAd.InteractionListener interactionListener) {
            this.i = interactionListener;
        }

        @Override // com.ipd.dsp.ad.DspRewardVideoAd
        public final void setVolumeOn(boolean z) {
            this.j = z;
        }

        public void a() {
            com.ipd.dsp.internal.j1.b bVar = this.g;
            if (bVar != null) {
                com.ipd.dsp.internal.h1.a.a(bVar, this.h, 1, null, null, null);
            }
            DspRewardVideoAd.InteractionListener interactionListener = this.i;
            if (interactionListener != null) {
                interactionListener.onRewardVideoClick();
            }
        }
    }
}
