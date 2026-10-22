package com.kwad.components.ad.interstitial.f;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b extends Presenter {
    public c mN;

    @Override // com.kwad.sdk.mvp.Presenter
    public void ay() {
        super.ay();
        this.mN = (c) SB();
    }

    public void dY() {
        List<Presenter> listSA = SA();
        if (listSA == null) {
            return;
        }
        for (Presenter presenter : listSA) {
            if (presenter instanceof b) {
                ((b) presenter).dY();
            }
        }
    }

    public void dZ() {
        List<Presenter> listSA = SA();
        if (listSA == null) {
            return;
        }
        for (Presenter presenter : listSA) {
            if (presenter instanceof b) {
                ((b) presenter).dZ();
            }
        }
    }
}
