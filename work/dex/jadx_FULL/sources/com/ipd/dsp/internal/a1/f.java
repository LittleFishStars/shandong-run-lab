package com.ipd.dsp.internal.a1;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.open.IPDGlideHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f implements DspSplashAd, com.ipd.dsp.internal.g1.a, g {
    public final com.ipd.dsp.internal.e1.d f;
    public final com.ipd.dsp.internal.j1.b g;
    public DspSplashAd.InteractionListener h;
    public com.ipd.dsp.internal.k1.e i;
    public int j;

    public f(com.ipd.dsp.internal.e1.d dVar) {
        this.f = dVar;
        this.g = new com.ipd.dsp.internal.j1.b(dVar);
    }

    @Override // com.ipd.dsp.internal.a1.g
    public void a() {
        if (this.f != null) {
            IPDGlideHelper.preload(com.ipd.dsp.internal.l1.a.a().getContext(), this.f.o);
        }
    }

    @Override // com.ipd.dsp.internal.g1.a
    public int b() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        if (dVar != null) {
            return dVar.v;
        }
        return 0;
    }

    @Override // com.ipd.dsp.api.IBid
    public int getEcpm() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        if (dVar != null) {
            return dVar.v;
        }
        return 0;
    }

    @Override // com.ipd.dsp.ad.DspSplashAd
    public String getRequestId() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return o.b(dVar != null ? dVar.i : null);
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

    @Override // com.ipd.dsp.ad.DspSplashAd
    public void setInteractionListener(DspSplashAd.InteractionListener interactionListener) {
        this.h = interactionListener;
    }

    @Override // com.ipd.dsp.ad.DspSplashAd
    public void show(Context context, ViewGroup viewGroup) {
        if (this.h != null) {
            if (context == null) {
                try {
                    Activity activityB = com.ipd.dsp.internal.c2.f.a().b();
                    if (activityB != null) {
                        context = activityB.getApplicationContext();
                    }
                } catch (Throwable unused) {
                }
            }
            if (context == null) {
                com.ipd.dsp.internal.f1.a aVarC = com.ipd.dsp.internal.f1.a.c();
                com.ipd.dsp.internal.h1.a.a(this.g, com.ipd.dsp.internal.h1.a.e.c, aVarC.toString());
                this.h.onSplashAdShowError(aVarC.f38306a, aVarC.b);
            } else {
                if (viewGroup == null) {
                    com.ipd.dsp.internal.f1.a aVarB = com.ipd.dsp.internal.f1.a.b();
                    com.ipd.dsp.internal.h1.a.a(this.g, com.ipd.dsp.internal.h1.a.e.c, aVarB.toString());
                    this.h.onSplashAdShowError(aVarB.f38306a, aVarB.b);
                    return;
                }
                if (this.i == null) {
                    com.ipd.dsp.internal.k1.e eVar = new com.ipd.dsp.internal.k1.e(this.f, this.g);
                    this.i = eVar;
                    eVar.a(this.j);
                    this.i.a(this.h);
                    this.i.b(context);
                }
                viewGroup.addView(this.i.e());
            }
        }
    }
}
