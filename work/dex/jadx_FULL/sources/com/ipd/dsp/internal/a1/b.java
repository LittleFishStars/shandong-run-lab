package com.ipd.dsp.internal.a1;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspDrawAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements DspDrawAd {
    public final com.ipd.dsp.internal.e1.d f;
    public final com.ipd.dsp.internal.j1.b g;
    public DspDrawAd.InteractionListener h;
    public com.ipd.dsp.internal.k1.c i;
    public int j;
    public boolean k = true;
    public boolean l = true;

    public b(com.ipd.dsp.internal.e1.d dVar) {
        this.f = dVar;
        this.g = new com.ipd.dsp.internal.j1.b(dVar);
    }

    @Override // com.ipd.dsp.api.IBid
    public int getEcpm() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        if (dVar != null) {
            return dVar.v;
        }
        return 0;
    }

    @Override // com.ipd.dsp.ad.DspDrawAd
    public String getRequestId() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return o.b(dVar != null ? dVar.i : null);
    }

    @Override // com.ipd.dsp.ad.DspDrawAd
    public void isDimBehind(boolean z) {
        this.k = z;
    }

    @Override // com.ipd.dsp.ad.DspDrawAd
    public void isVolumeOn(boolean z) {
        this.l = z;
    }

    @Override // com.ipd.dsp.api.IBid
    public void onBiddingFailed(@NonNull BidFailedReason bidFailedReason) {
        com.ipd.dsp.internal.h1.a.a(this.g, bidFailedReason, (String) null);
    }

    @Override // com.ipd.dsp.api.IBid
    public void onBiddingSuccess(int i, int i2) {
        this.j = i;
        com.ipd.dsp.internal.h1.a.a(this.g, i, i2, (String) null);
    }

    @Override // com.ipd.dsp.ad.DspDrawAd
    public void render(Activity activity) {
        View viewE;
        if (activity == null) {
            try {
                Activity activityB = com.ipd.dsp.internal.c2.f.a().b();
                if (activityB != null) {
                    activity = activityB;
                }
            } catch (Throwable unused) {
            }
        }
        if (activity == null || activity.isFinishing()) {
            com.ipd.dsp.internal.f1.a aVarC = com.ipd.dsp.internal.f1.a.c();
            com.ipd.dsp.internal.h1.a.a(this.g, com.ipd.dsp.internal.h1.a.e.c, aVarC.toString());
            DspDrawAd.InteractionListener interactionListener = this.h;
            if (interactionListener != null) {
                interactionListener.onDrawAdRenderFail(aVarC.f38306a, aVarC.b);
                return;
            }
            return;
        }
        if (this.i == null) {
            try {
                com.ipd.dsp.internal.k1.c cVar = new com.ipd.dsp.internal.k1.c(this.f, this.g, this.k, this.l);
                this.i = cVar;
                cVar.a(this.j);
                this.i.a(this.h);
                this.i.b(activity);
            } catch (Throwable th) {
                r.a(th);
            }
        }
        if (this.h != null) {
            com.ipd.dsp.internal.k1.c cVar2 = this.i;
            if (cVar2 == null || (viewE = cVar2.e()) == null) {
                com.ipd.dsp.internal.f1.a aVarG = com.ipd.dsp.internal.f1.a.g();
                com.ipd.dsp.internal.h1.a.a(this.g, com.ipd.dsp.internal.h1.a.e.c, aVarG.toString());
                this.h.onDrawAdRenderFail(aVarG.f38306a, aVarG.b);
            } else {
                if (viewE.getParent() != null) {
                    try {
                        ((ViewGroup) viewE.getParent()).removeView(viewE);
                    } catch (Throwable th2) {
                        r.a(th2);
                    }
                }
                this.h.onDrawAdRenderSuccess(viewE);
            }
        }
    }

    @Override // com.ipd.dsp.ad.DspDrawAd
    public void setInteractionListener(DspDrawAd.InteractionListener interactionListener) {
        this.h = interactionListener;
    }
}
