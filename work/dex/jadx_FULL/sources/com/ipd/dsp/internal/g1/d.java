package com.ipd.dsp.internal.g1;

import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspDrawAd;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.c2.r;
import com.ipd.dsp.request.DspDrawAdRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d extends c<DspDrawAd> {
    public DspLoadManager.DrawAdListener h;

    public void a(@NonNull DspDrawAdRequest dspDrawAdRequest, @NonNull DspLoadManager.DrawAdListener drawAdListener) {
        a(dspDrawAdRequest, com.ipd.dsp.internal.e1.i.f);
        b(dspDrawAdRequest.getAdNum());
        this.h = drawAdListener;
        a();
    }

    @Override // com.ipd.dsp.internal.g1.c
    public void c(@NonNull List<DspDrawAd> list) {
        DspLoadManager.DrawAdListener drawAdListener = this.h;
        if (drawAdListener != null) {
            drawAdListener.onDrawAdLoad(list);
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
        DspLoadManager.DrawAdListener drawAdListener = this.h;
        if (drawAdListener != null) {
            drawAdListener.onLoadError(i, str);
        }
    }

    @Override // com.ipd.dsp.internal.g1.c
    public List<DspDrawAd> a(@NonNull List<com.ipd.dsp.internal.e1.d> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<com.ipd.dsp.internal.e1.d> it = list.iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(new com.ipd.dsp.internal.a1.b(it.next()));
            } catch (Throwable th) {
                r.a(th);
            }
        }
        return arrayList;
    }
}
