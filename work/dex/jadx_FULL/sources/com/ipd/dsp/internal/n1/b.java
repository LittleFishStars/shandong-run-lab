package com.ipd.dsp.internal.n1;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.internal.c2.f;
import com.ipd.dsp.internal.e1.m;
import com.octopus.ad.Octopus;
import com.octopus.ad.RewardItem;
import com.octopus.ad.RewardVideoAd;
import com.octopus.ad.RewardVideoAdListener;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends com.ipd.dsp.internal.n1.a {
    public RewardVideoAd c;
    public C0907b d;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.n1.b$b, reason: collision with other inner class name */
    public static class C0907b implements RewardVideoAdListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public b f38466a;
        public c b;

        public void onRewardVideoAdClicked() {
            c cVar = this.b;
            if (cVar != null) {
                cVar.a();
            }
        }

        public void onRewardVideoAdClosed() {
            c cVar = this.b;
            if (cVar != null) {
                cVar.b();
            }
            a();
        }

        public void onRewardVideoAdComplete() {
        }

        public void onRewardVideoAdFailedToLoad(int i) {
            b bVar = this.f38466a;
            if (bVar != null) {
                bVar.b();
                this.f38466a.d = null;
            }
            this.f38466a = null;
        }

        public void onRewardVideoAdLoaded() {
            b bVar = this.f38466a;
            if (bVar == null) {
                return;
            }
            try {
                m mVar = bVar.f38465a;
                int price = mVar.I ? bVar.c.getPrice() : mVar.J;
                this.f38466a.a(new c(price), price);
            } catch (Throwable unused) {
                this.f38466a.b();
            }
            this.f38466a.d = null;
            this.f38466a = null;
        }

        public void onRewardVideoAdShown() {
            c cVar = this.b;
            if (cVar != null) {
                cVar.e();
            }
        }

        public void onRewardVideoCached(boolean z) {
        }

        public void onRewarded(RewardItem rewardItem) {
            c cVar = this.b;
            if (cVar != null) {
                cVar.d();
            }
        }

        public C0907b(b bVar) {
            this.f38466a = bVar;
        }

        public final void a(c cVar) {
            this.b = cVar;
        }

        public final void a() {
            this.b.f();
            this.b = null;
        }
    }

    public static class c extends com.ipd.dsp.internal.n1.a.AbstractC0906a {
        public RewardVideoAd k;

        @Override // com.ipd.dsp.internal.n1.a.AbstractC0906a
        public void f() {
            this.k = null;
            super.f();
        }

        @Override // com.ipd.dsp.ad.DspRewardVideoAd
        public boolean isValid() {
            RewardVideoAd rewardVideoAd = this.k;
            return rewardVideoAd != null && rewardVideoAd.isLoaded();
        }

        /* JADX WARN: Code duplicated, block: B:10:0x001c A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:15:0x0029, B:8:0x0012, B:10:0x001c, B:12:0x0022, B:17:0x002f), top: B:22:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:12:0x0022 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:15:0x0029, B:8:0x0012, B:10:0x001c, B:12:0x0022, B:17:0x002f), top: B:22:0x0000 }] */
        /* JADX WARN: Code duplicated, block: B:14:0x0028  */
        /* JADX WARN: Code duplicated, block: B:8:0x0012 A[Catch: all -> 0x003b, TryCatch #0 {all -> 0x003b, blocks: (B:2:0x0000, B:4:0x0004, B:6:0x000c, B:15:0x0029, B:8:0x0012, B:10:0x001c, B:12:0x0022, B:17:0x002f), top: B:22:0x0000 }] */
        @Override // com.ipd.dsp.ad.DspRewardVideoAd
        public void showRewardVideo(Context context) {
            Activity activityB;
            try {
                if (!(context instanceof Activity)) {
                    activityB = f.a().b();
                    if (activityB != null) {
                        if (!activityB.isFinishing()) {
                            if (activityB.isDestroyed()) {
                            }
                        }
                    }
                    com.ipd.dsp.internal.f1.a aVarA = com.ipd.dsp.internal.f1.a.a();
                    a(aVarA.f38306a, aVarA.b);
                    return;
                }
                activityB = (Activity) context;
                if (activityB.isFinishing() || activityB.isDestroyed()) {
                    activityB = f.a().b();
                    if (activityB != null) {
                        if (!activityB.isFinishing()) {
                            if (activityB.isDestroyed()) {
                            }
                        }
                    }
                    com.ipd.dsp.internal.f1.a aVarA2 = com.ipd.dsp.internal.f1.a.a();
                    a(aVarA2.f38306a, aVarA2.b);
                    return;
                }
                this.k.show(activityB);
            } catch (Throwable th) {
                com.ipd.dsp.internal.f1.a aVarE = com.ipd.dsp.internal.f1.a.e(th.getClass().getSimpleName());
                a(aVarE.f38306a, aVarE.b);
                f();
            }
        }

        public c(b bVar, int i) {
            super(bVar.f38465a, i);
            this.k = bVar.c;
            bVar.c = null;
            bVar.d.a(this);
        }
    }

    public b(m mVar, com.ipd.dsp.internal.g1.c.b<List<DspRewardVideoAd>> bVar) {
        super(mVar, bVar);
    }

    public final /* synthetic */ void c() {
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
            String str = this.f38465a.H;
            C0907b c0907b = new C0907b();
            this.d = c0907b;
            RewardVideoAd rewardVideoAd = new RewardVideoAd(activityB, str, c0907b);
            this.c = rewardVideoAd;
            rewardVideoAd.loadAd();
        } catch (Throwable unused2) {
            b();
        }
    }

    @Override // com.ipd.dsp.internal.n1.a
    public void a() {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.zj.adlib.tka
            @Override // java.lang.Runnable
            public final void run() {
                this.f44943a.c();
            }
        });
    }
}
