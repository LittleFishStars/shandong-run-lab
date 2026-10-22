package com.ipd.dsp.internal.g1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspNativeAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.request.DspNativeAdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class f extends c<DspNativeAd> {
    public DspLoadManager.NativeAdListener h;

    public void a(DspNativeAdRequest dspNativeAdRequest, DspLoadManager.NativeAdListener nativeAdListener) {
        a(dspNativeAdRequest, com.ipd.dsp.internal.e1.i.g);
        this.h = nativeAdListener;
        b(dspNativeAdRequest.getAdNum());
        a();
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspNativeAd> list) {
        DspLoadManager.NativeAdListener nativeAdListener = this.h;
        if (nativeAdListener != null) {
            nativeAdListener.onNativeAdLoad(list);
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
        DspLoadManager.NativeAdListener nativeAdListener = this.h;
        if (nativeAdListener != null) {
            nativeAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspNativeAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new com.ipd.dsp.internal.a1.c(it.next()));
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return arrayList;
    }
}
