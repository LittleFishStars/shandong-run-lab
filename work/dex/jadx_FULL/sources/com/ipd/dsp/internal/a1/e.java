package com.ipd.dsp.internal.a1;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspInterstitialAd;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.api.BidFailedReason;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.open.IPDGlideHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class e implements DspInterstitialAd, DspRewardVideoAd, DspRewardVideoAd.InteractionListener, com.ipd.dsp.internal.g1.a, g {
    public final com.ipd.dsp.internal.e1.d f;
    public final com.ipd.dsp.internal.j1.b g;
    public DspInterstitialAd.InteractionListener h;
    public DspInterstitialAd.RewardListener i;
    public DspRewardVideoAd.InteractionListener j;
    public int l;
    public boolean k = true;
    public boolean m = true;

    public e(com.ipd.dsp.internal.e1.d dVar) {
        this.f = dVar;
        this.g = new com.ipd.dsp.internal.j1.b(dVar);
    }

    @Override // com.ipd.dsp.internal.a1.g
    public void a() {
        IPDGlideHelper.preload(com.ipd.dsp.internal.l1.a.a().getContext(), this.f.o);
        IPDGlideHelper.preload(com.ipd.dsp.internal.l1.a.a().getContext(), this.f.n);
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

    @Override // com.ipd.dsp.ad.DspInterstitialAd, com.ipd.dsp.ad.DspRewardVideoAd
    public String getRequestId() {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        return o.b(dVar != null ? dVar.i : null);
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd
    public boolean isValid() {
        return this.m;
    }

    @Override // com.ipd.dsp.api.IBid
    public void onBiddingFailed(@NonNull BidFailedReason bidFailedReason) {
        com.ipd.dsp.internal.h1.a.a(this.g, bidFailedReason, (String) null);
    }

    @Override // com.ipd.dsp.api.IBid
    public void onBiddingSuccess(int i, int i2) {
        this.l = i;
        com.ipd.dsp.internal.h1.a.a(this.g, i, i2, (String) null);
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd.InteractionListener
    public void onRewardVideoClick() {
        DspInterstitialAd.InteractionListener interactionListener = this.h;
        if (interactionListener != null) {
            interactionListener.onInterstitialAdClick();
            return;
        }
        DspRewardVideoAd.InteractionListener interactionListener2 = this.j;
        if (interactionListener2 != null) {
            interactionListener2.onRewardVideoClick();
        }
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd.InteractionListener
    public void onRewardVideoClose() {
        this.m = false;
        DspInterstitialAd.InteractionListener interactionListener = this.h;
        if (interactionListener != null) {
            interactionListener.onInterstitialAdClose();
            this.h = null;
            this.i = null;
        } else {
            DspRewardVideoAd.InteractionListener interactionListener2 = this.j;
            if (interactionListener2 != null) {
                interactionListener2.onRewardVideoClose();
                this.j = null;
            }
        }
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd.InteractionListener
    public void onRewardVideoError(int i, String str) {
        this.m = false;
        com.ipd.dsp.internal.h1.a.a(this.g, com.ipd.dsp.internal.h1.a.e.c, com.ipd.dsp.internal.f1.a.a(i, str));
        DspInterstitialAd.InteractionListener interactionListener = this.h;
        if (interactionListener != null) {
            interactionListener.onInterstitialAdError(i, str);
            return;
        }
        DspRewardVideoAd.InteractionListener interactionListener2 = this.j;
        if (interactionListener2 != null) {
            interactionListener2.onRewardVideoError(i, str);
        }
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd.InteractionListener
    public void onRewardVideoShow() {
        this.m = false;
        DspInterstitialAd.InteractionListener interactionListener = this.h;
        if (interactionListener != null) {
            interactionListener.onInterstitialAdShow();
            return;
        }
        DspRewardVideoAd.InteractionListener interactionListener2 = this.j;
        if (interactionListener2 != null) {
            interactionListener2.onRewardVideoShow();
        }
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd.InteractionListener
    public void onRewardVideoVerify() {
        DspInterstitialAd.RewardListener rewardListener = this.i;
        if (rewardListener != null) {
            try {
                rewardListener.onReward();
            } catch (Throwable unused) {
            }
            this.i = null;
        } else {
            DspRewardVideoAd.InteractionListener interactionListener = this.j;
            if (interactionListener != null) {
                interactionListener.onRewardVideoVerify();
            }
        }
    }

    @Override // com.ipd.dsp.ad.DspInterstitialAd
    public void setInteractionListener(DspInterstitialAd.InteractionListener interactionListener) {
        this.h = interactionListener;
    }

    @Override // com.ipd.dsp.ad.DspInterstitialAd
    public void setRewardListener(DspInterstitialAd.RewardListener rewardListener) {
        this.i = rewardListener;
    }

    @Override // com.ipd.dsp.ad.DspInterstitialAd, com.ipd.dsp.ad.DspRewardVideoAd
    public void setVolumeOn(boolean z) {
        this.k = z;
    }

    @Override // com.ipd.dsp.ad.DspInterstitialAd
    public void showInterstitialAd(Activity activity) {
        a(activity);
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd
    public void showRewardVideo(Context context) {
        a(context);
    }

    @Override // com.ipd.dsp.ad.DspRewardVideoAd
    public void setInteractionListener(DspRewardVideoAd.InteractionListener interactionListener) {
        this.j = interactionListener;
    }

    public final void a(Context context) {
        com.ipd.dsp.internal.e1.d dVar = this.f;
        int i = dVar != null ? dVar.q.i : -1;
        if (i == 0) {
            if (context == null) {
                context = com.ipd.dsp.internal.l1.a.a().getContext();
            }
            com.ipd.dsp.internal.z0.e.a(context, this.l, this.f, this.k, com.ipd.dsp.internal.z0.c.a((DspRewardVideoAd.InteractionListener) this));
        } else if (i != 1) {
            com.ipd.dsp.internal.f1.a aVarJ = com.ipd.dsp.internal.f1.a.j();
            onRewardVideoError(aVarJ.f38306a, aVarJ.b);
        } else {
            com.ipd.dsp.internal.z0.e.b(context, this.l, dVar, this.k, com.ipd.dsp.internal.z0.d.a((DspRewardVideoAd.InteractionListener) this));
        }
    }
}
