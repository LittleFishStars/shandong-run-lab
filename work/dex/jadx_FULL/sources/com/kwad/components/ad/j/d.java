package com.kwad.components.ad.j;

import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.h;
import com.kwad.sdk.internal.api.SceneImpl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class d implements h.a {
    private static volatile d Nw;

    private d() {
    }

    public static d om() {
        if (Nw == null) {
            synchronized (d.class) {
                if (Nw == null) {
                    Nw = new d();
                }
            }
        }
        return Nw;
    }

    @Override // com.kwad.sdk.core.network.h.a
    public final void a(f fVar, int i) {
        SceneImpl scene;
        int i2;
        if (!(fVar instanceof com.kwad.components.core.request.a) || i == e.aTe.errorCode || (scene = fVar.getScene()) == null) {
            return;
        }
        long posId = scene.getPosId();
        if (i == e.aSZ.errorCode) {
            i2 = 21001;
        } else if (i == e.aTd.errorCode) {
            i2 = 21003;
        } else {
            i2 = (i <= 0 || i >= 1000) ? 21004 : 21002;
        }
        com.kwad.components.core.p.a.vL().c(posId, i2);
    }

    public final void init() {
        h.Mg().a(this);
    }
}
