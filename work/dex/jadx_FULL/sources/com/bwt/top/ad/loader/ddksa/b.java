package com.bwt.top.ad.loader.ddksa;

import com.bwt.top.ad.adapter.AdapterAdLoader;
import com.bwt.top.ad.adapter.AdapterAdLoaderImp;
import com.bwt.top.api.bean.PosInfoBean;
import com.bwt.top.exception.AdError;
import com.bwt.top.util.ALog;
import com.zj.adlib.ygb;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b<T extends ygb, Y extends AdapterAdLoader> extends ddksa<T, Y> {
    public b(String str, T t) {
        super(str, t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l() {
        if (c()) {
            return;
        }
        n();
    }

    @Override // com.bwt.top.ad.loader.ddksa.ddksa
    public void a() {
        for (PosInfoBean posInfoBean : f()) {
            ALog.i(((ddksa) this).f1470a, "loadAdByStrategy posInfo: " + posInfoBean);
            AdapterAdLoaderImp adapterAdLoaderImpB = ((ddksa) this).f28243a.b(((ddksa) this).b, posInfoBean);
            if (adapterAdLoaderImpB != null) {
                ALog.i(((ddksa) this).f1470a, " createAdapterLoader succeed " + adapterAdLoaderImpB.getClass().getSimpleName());
                akdsd akdsdVar = new akdsd(adapterAdLoaderImpB, new akdsd.kdsksdda() { // from class: com.bwt.top.ad.loader.ddksa.a
                    @Override // com.bwt.top.ad.loader.ddksa.akdsd.kdsksdda
                    public final void a() {
                        this.f28241a.l();
                    }
                });
                adapterAdLoaderImpB.loadAdObject(posInfoBean, akdsdVar);
                ((ddksa) this).f1472a.put(posInfoBean, akdsdVar);
            } else {
                ALog.e(((ddksa) this).f1470a, " createAdapterLoader failed");
            }
        }
    }

    @Override // com.bwt.top.ad.loader.ddksa.ddksa
    public void d() {
        try {
            if (c() || dkkd()) {
                return;
            }
            n();
        } catch (Throwable unused) {
            m();
        }
    }

    public final void k() {
        for (PosInfoBean posInfoBean : f()) {
            akdsd akdsdVar = ((ddksa) this).f1472a.get(posInfoBean);
            if (akdsdVar != null && akdsdVar.b()) {
                ALog.i(((ddksa) this).f1470a, "showAdObjectByStrategy posInfo: " + posInfoBean);
                akdsdVar.c().showAdObject();
                return;
            }
        }
        m();
    }

    public final void m() {
        AdError adError = new AdError(10, "all third ad no data");
        adError.log();
        ((ddksa) this).f28243a.getAd().getAdListener().onAdFailed(adError);
    }

    public final void n() {
        boolean z;
        Iterator<PosInfoBean> it = ((ddksa) this).f1472a.keySet().iterator();
        loop0: while (true) {
            z = true;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                PosInfoBean next = it.next();
                if (!z || !((ddksa) this).f1472a.get(next).a()) {
                    z = false;
                }
            }
        }
        if (z) {
            k();
        }
    }
}
