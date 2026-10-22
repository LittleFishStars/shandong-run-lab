package com.ipd.dsp.internal.g1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspNativeExpressAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.request.DspNativeExpressAdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g extends c<DspNativeExpressAd> {
    public DspLoadManager.NativeExpressAdListener h;

    public void a(@NonNull DspNativeExpressAdRequest dspNativeExpressAdRequest, @NonNull DspLoadManager.NativeExpressAdListener nativeExpressAdListener) {
        a(dspNativeExpressAdRequest, "Feed");
        b(dspNativeExpressAdRequest.getAdNum());
        this.h = nativeExpressAdListener;
        a();
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspNativeExpressAd> list) {
        if (this.h != null) {
            for (DspNativeExpressAd dspNativeExpressAd : list) {
                if (dspNativeExpressAd instanceof com.ipd.dsp.internal.a1.g) {
                    try {
                        ((com.ipd.dsp.internal.a1.g) dspNativeExpressAd).a();
                    } catch (Throwable unused) {
                    }
                }
            }
            this.h.onNativeExpressAdLoad(list);
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
        DspLoadManager.NativeExpressAdListener nativeExpressAdListener = this.h;
        if (nativeExpressAdListener != null) {
            nativeExpressAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspNativeExpressAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new com.ipd.dsp.internal.a1.d(it.next()));
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return arrayList;
    }
}
