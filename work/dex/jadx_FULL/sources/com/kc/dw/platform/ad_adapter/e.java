package com.kc.dw.platform.ad_adapter;

import android.content.Context;
import com.kc.dw.ad.a0;
import com.kc.dw.ad.nativ.NormalMediaView;
import com.kc.dw.ad.nativ.i;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f39471a;
    public com.kc.dw.core.loader.b b;

    public e(Context context, com.kc.dw.core.loader.b bVar) {
        this.f39471a = context;
        this.b = bVar;
    }

    public final void a(i iVar, com.kc.dw.ad.nativ.a aVar, boolean z, boolean z2, boolean z3, float f, float f2) {
        ArrayList arrayList = new ArrayList();
        NormalMediaView normalMediaView = new NormalMediaView(this.f39471a);
        if (iVar.getAdPatternType() == 2) {
            System.currentTimeMillis();
            normalMediaView.setAdListener(aVar);
            normalMediaView.B = aVar;
            normalMediaView.C = z;
            normalMediaView.setRecycler(z);
            if (z) {
                normalMediaView.setConfigWidth(iVar.f39132a);
                normalMediaView.setConfigHeight(iVar.b);
                normalMediaView.setVideoEndCover(iVar.h);
                normalMediaView.setInitMute(true);
                normalMediaView.setVideoCover(iVar.getVideo_cover());
                normalMediaView.setVideoEndCover(iVar.h);
                normalMediaView.setFromLogoVisibility(8);
                normalMediaView.setUseTransform(false);
                normalMediaView.setAutoStart(z3);
                normalMediaView.setContainerWidth(f);
                normalMediaView.setContainerHeight(f2);
            } else {
                normalMediaView.setVideoCover(iVar.getVideo_cover());
                normalMediaView.setVideoEndCover(iVar.h);
                normalMediaView.setPlayOnce(true);
                normalMediaView.setUseTransform(false);
                normalMediaView.setContainerWidth(f);
                normalMediaView.setContainerHeight(f2);
                if (com.kc.dw.base.a.adConfig().showLogo()) {
                    normalMediaView.setFromLogo(iVar.getFromLogo());
                } else {
                    normalMediaView.setFromLogo(null);
                    normalMediaView.setFromLogoVisibility(8);
                }
            }
        }
        normalMediaView.setOnVideoLoadedListener(new d(this, iVar, z2, arrayList, aVar));
        a0.c cVar = normalMediaView.x;
        if (cVar != null) {
            d dVar = (d) cVar;
            com.kc.dw.ad.nativ.g gVar = new com.kc.dw.ad.nativ.g(dVar.f39456a);
            i iVar2 = dVar.f39456a;
            gVar.d = iVar2.title;
            iVar2.getCid();
            i iVar3 = dVar.f39456a;
            gVar.e = iVar3.desc;
            gVar.f39131a = iVar3.getAdPatternType();
            i iVar4 = dVar.f39456a;
            gVar.b = iVar4.iconUrl;
            gVar.c = iVar4.getImageUrls();
            gVar.g = normalMediaView;
            gVar.f = dVar.b;
            dVar.c.add(gVar);
            normalMediaView.setMsAd(gVar);
            com.kc.dw.ad.nativ.a aVar2 = dVar.d;
            if (aVar2 != null) {
                aVar2.a(dVar.c);
            }
        }
    }
}
