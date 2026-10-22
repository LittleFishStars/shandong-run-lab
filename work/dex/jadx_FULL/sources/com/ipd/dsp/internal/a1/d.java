package com.ipd.dsp.internal.a1;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspNativeExpressAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.open.IPDGlideHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements DspNativeExpressAd, g {
    public final com.ipd.dsp.internal.e1.d f;
    public final com.ipd.dsp.internal.j1.b g;
    public DspNativeExpressAd.InteractionListener h;
    public com.ipd.dsp.internal.k1.d i;
    public int j;
    public boolean k;

    public d(com.ipd.dsp.internal.e1.d dVar) {
        this.f = dVar;
        this.g = new com.ipd.dsp.internal.j1.b(dVar);
    }

    @Override // com.ipd.dsp.internal.a1.g
    public void a() {
        IPDGlideHelper.preload(com.ipd.dsp.internal.l1.a.a().getContext(), this.f.o);
        IPDGlideHelper.preload(com.ipd.dsp.internal.l1.a.a().getContext(), this.f.n);
    }

    @Override // com.ipd.dsp.api.IBid
    public int getEcpm() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        if (dVar != null) {
            return dVar.v;
        }
        return 0;
    }

    @Override // com.ipd.dsp.ad.DspNativeExpressAd
    public View getNativeExpressView(Context context) {
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
            DspNativeExpressAd.InteractionListener interactionListener = this.h;
            if (interactionListener == null) {
                return null;
            }
            interactionListener.onNativeExpressAdRenderFail(aVarC.f38306a, aVarC.b);
            return null;
        }
        if (this.i == null) {
            com.ipd.dsp.internal.k1.d dVar = new com.ipd.dsp.internal.k1.d(this.f, this.g);
            this.i = dVar;
            dVar.a(this.j);
        }
        this.i.a(this.k);
        this.i.a(this.h);
        this.i.b(context);
        View viewE = this.i.e();
        if (viewE.getParent() instanceof ViewGroup) {
            try {
                ((ViewGroup) viewE.getParent()).removeView(viewE);
            } catch (Throwable unused2) {
            }
        }
        return viewE;
    }

    @Override // com.ipd.dsp.ad.DspNativeExpressAd
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

    @Override // com.ipd.dsp.ad.DspNativeExpressAd
    public void setInteractionListener(DspNativeExpressAd.InteractionListener interactionListener) {
        this.h = interactionListener;
    }

    @Override // com.ipd.dsp.ad.DspNativeExpressAd
    public void setVolumeOn(boolean z) {
        this.k = z;
    }
}
