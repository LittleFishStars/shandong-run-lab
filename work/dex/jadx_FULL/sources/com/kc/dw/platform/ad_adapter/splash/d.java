package com.kc.dw.platform.ad_adapter.splash;

import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class d extends com.kc.dw.core.safe.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ShakeUtil f39547a;

    @Keep
    public class a implements Comparator<com.kc.dw.platform.ad_adapter.splash.a> {
        public a(d dVar) {
        }

        @Override // java.util.Comparator
        public int compare(com.kc.dw.platform.ad_adapter.splash.a aVar, com.kc.dw.platform.ad_adapter.splash.a aVar2) {
            return aVar2.c - aVar.c;
        }
    }

    public d(ShakeUtil shakeUtil) {
        this.f39547a = shakeUtil;
    }

    @Override // com.kc.dw.core.safe.j
    public void safeRun() {
        List<com.kc.dw.platform.ad_adapter.splash.a> list = this.f39547a.g;
        if (list == null || list.size() <= 0) {
            this.f39547a.a();
            return;
        }
        Collections.sort(this.f39547a.g, new a(this));
        for (int i = 0; i < this.f39547a.g.size(); i++) {
            com.kc.dw.platform.ad_adapter.splash.a aVar = this.f39547a.g.get(i);
            if (aVar != null && aVar.g) {
                aVar.h = 1;
                this.f39547a.d = true;
            } else if (aVar != null) {
                aVar.h = 2;
            }
        }
    }
}
