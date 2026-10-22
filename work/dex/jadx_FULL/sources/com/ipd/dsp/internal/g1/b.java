package com.ipd.dsp.internal.g1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspBannerAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.request.DspBannerAdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b extends c<DspBannerAd> {
    public DspLoadManager.BannerAdListener h;

    public void a(@NonNull DspBannerAdRequest dspBannerAdRequest, @NonNull DspLoadManager.BannerAdListener bannerAdListener) {
        a(dspBannerAdRequest, com.ipd.dsp.internal.e1.i.d);
        this.h = bannerAdListener;
        a();
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspBannerAd> list) {
        if (this.h != null) {
            for (DspBannerAd dspBannerAd : list) {
                if (dspBannerAd instanceof com.ipd.dsp.internal.a1.g) {
                    try {
                        ((com.ipd.dsp.internal.a1.g) dspBannerAd).a();
                    } catch (Throwable unused) {
                    }
                }
            }
            this.h.onBannerAdLoad(list);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void d(@NonNull List<? extends com.ipd.dsp.internal.e1.d> list) {
        Iterator<? extends com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            it.next().w.f = this.f;
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void a(int i, @NonNull String str) {
        DspLoadManager.BannerAdListener bannerAdListener = this.h;
        if (bannerAdListener != null) {
            bannerAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspBannerAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new com.ipd.dsp.internal.a1.a(it.next()));
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return arrayList;
    }
}
