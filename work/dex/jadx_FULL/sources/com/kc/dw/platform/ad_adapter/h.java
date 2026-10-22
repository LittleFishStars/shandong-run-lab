package com.kc.dw.platform.ad_adapter;

import com.alibaba.android.arouter.utils.Consts;
import com.kc.dw.ad.z;
import com.kc.dw.core.ad.AdSlot;
import com.kc.dw.core.ad.IAdEventListener;
import com.kc.dw.core.loader.a;
import com.kc.dw.core.utils.p0;
import com.kc.dw.core.utils.s1;
import com.kc.dw.platform.BasePlatformLoader;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class h<T extends AdSlot, Loader extends com.kc.dw.core.loader.a, LoaderListener extends IAdEventListener> extends BasePlatformLoader<Loader, LoaderListener> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public T f39477a;
    public long b;
    public long c;
    public long d;
    public String[] e;

    public h(Loader loader, T t) {
        this.adLoader = loader;
        this.f39477a = t;
    }

    public T a() {
        return this.f39477a;
    }

    public void a(z zVar, String str, Integer num) {
        if (this.c == 0) {
            this.c = System.currentTimeMillis();
        }
        if (zVar != null) {
            ((com.kc.dw.platform.ad_adapter.reward.a) zVar).onAdRenderFail(str, num.intValue());
        }
        if (p0.k > 0) {
            s1.a(this.e, 12, num.intValue(), str);
        }
    }

    public String b() {
        return this.b + Consts.DOT + this.c + Consts.DOT + this.d;
    }

    @Override // com.kc.dw.platform.BasePlatformLoader, com.kc.dw.core.loader.b
    public void destroy() {
    }
}
