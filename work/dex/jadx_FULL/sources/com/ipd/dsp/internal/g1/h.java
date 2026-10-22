package com.ipd.dsp.internal.g1;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.internal.e1.j;
import com.ipd.dsp.internal.e1.m;
import com.ipd.dsp.request.DspRewardVideoAdRequest;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class h extends c<DspRewardVideoAd> {
    public boolean h;
    public int i;
    public boolean j;
    public int k;
    public boolean l;
    public boolean m;
    public String n;
    public DspLoadManager.RewardVideoAdListener o;

    public void a(@NonNull DspRewardVideoAdRequest dspRewardVideoAdRequest, @NonNull DspLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        a(dspRewardVideoAdRequest, com.ipd.dsp.internal.e1.i.b);
        this.h = dspRewardVideoAdRequest.isShakeable();
        this.i = dspRewardVideoAdRequest.getShakeRequireForce();
        this.j = dspRewardVideoAdRequest.isDisableFallingView();
        this.k = dspRewardVideoAdRequest.getFallingRate();
        this.l = dspRewardVideoAdRequest.isEnableSlideView();
        this.m = dspRewardVideoAdRequest.isOneClickShutdown();
        this.o = rewardVideoAdListener;
        HashMap<String, Object> map = new HashMap<>();
        if (!TextUtils.isEmpty(dspRewardVideoAdRequest.getName())) {
            try {
                map.put("reward_name", URLEncoder.encode(dspRewardVideoAdRequest.getName(), "utf-8"));
            } catch (Throwable unused) {
            }
        }
        if (!TextUtils.isEmpty(dspRewardVideoAdRequest.getExtra())) {
            this.n = dspRewardVideoAdRequest.getExtra();
            try {
                map.put("reward_extra_o", o.d(URLEncoder.encode(dspRewardVideoAdRequest.getExtra(), "utf-8")));
            } catch (Throwable unused2) {
            }
        }
        if (dspRewardVideoAdRequest.getAmount() > 0) {
            map.put("reward_amount", Integer.valueOf(dspRewardVideoAdRequest.getAmount()));
        }
        a(map);
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspRewardVideoAd> list) {
        if (this.o != null) {
            DspRewardVideoAd dspRewardVideoAd = list.get(0);
            if (dspRewardVideoAd instanceof com.ipd.dsp.internal.a1.g) {
                try {
                    ((com.ipd.dsp.internal.a1.g) dspRewardVideoAd).a();
                } catch (Throwable unused) {
                }
            }
            this.o.onRewardVideoAdLoad(dspRewardVideoAd);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void d(@NonNull List<? extends com.ipd.dsp.internal.e1.d> list) {
        for (com.ipd.dsp.internal.e1.d dVar : list) {
            if (dVar != null) {
                com.ipd.dsp.internal.e1.c cVar = dVar.w;
                cVar.f = this.f;
                cVar.g = this.h && (com.ipd.dsp.internal.c2.g.a().i() == null || com.ipd.dsp.internal.c2.g.a().i().canUseSensor());
                com.ipd.dsp.internal.e1.c cVar2 = dVar.w;
                cVar2.h = this.i;
                cVar2.j = this.j;
                cVar2.k = this.k;
                cVar2.i = this.l;
                cVar2.l = this.m;
                dVar.D.g = this.n;
            }
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void a(int i, @NonNull String str) {
        DspLoadManager.RewardVideoAdListener rewardVideoAdListener = this.o;
        if (rewardVideoAdListener != null) {
            rewardVideoAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspRewardVideoAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        j jVar;
        ArrayList arrayList = new ArrayList();
        for (com.ipd.dsp.internal.e1.d dVar : list) {
            if (dVar != null && (jVar = dVar.q) != null) {
                if (jVar.i == 1) {
                    String host = Uri.parse(jVar.f).getHost();
                    if (host == null || (!host.endsWith(com.ipd.dsp.internal.c2.b.b("Ljh6aWJlbi5jb20=")) && !host.endsWith(com.ipd.dsp.internal.c2.b.b("LmZsaWR1by5jbg==")) && !host.endsWith(com.ipd.dsp.internal.c2.b.b("anJvbmdqaWUuY29t")))) {
                        throw new IllegalArgumentException("invalid hostname");
                    }
                }
                try {
                    arrayList.add(new com.ipd.dsp.internal.a1.e(dVar));
                    break;
                } catch (Throwable th) {
                    r.a(th);
                }
            }
        }
        return arrayList;
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void a(m mVar, c.b<List<DspRewardVideoAd>> bVar) {
        com.ipd.dsp.internal.n1.b bVar2 = mVar.F != 9 ? null : new com.ipd.dsp.internal.n1.b(mVar, bVar);
        if (bVar2 != null) {
            bVar2.a();
        } else {
            bVar.a(null, 0);
        }
    }
}
