package com.zj.adlib;

import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import com.baichuan.nb_trade.callback.AlibcRouteCallback;
import com.baichuan.nb_trade.distribute.b;
import com.baichuan.nb_trade.distribute.d;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lra extends b {
    public static final String b = "lra";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public p3b<b> f43138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Iterator<b> f18034a;

    public lra() {
        p3b<b> p3bVar = new p3b<>();
        this.f43138a = p3bVar;
        p3bVar.a(new zza());
        this.f43138a.a(new rga());
    }

    @Override // com.baichuan.nb_trade.distribute.b
    public final boolean a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext) {
        return !this.f43138a.isEmpty();
    }

    public final void d(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, AlibcRouteCallback alibcRouteCallback, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        this.f18034a = this.f43138a.iterator();
        b(routeRequest, alibcTradeContext, new a(alibcRouteCallback), alibcComponentReRenderCallback);
    }

    public class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AlibcRouteCallback f43139a;

        public a(AlibcRouteCallback alibcRouteCallback) {
            this.f43139a = alibcRouteCallback;
        }

        @Override // com.baichuan.nb_trade.distribute.d
        public final void a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
            AlibcLogger.i(lra.b, "HandlerCallbackImpl: onNext execute");
            lra.this.a(routeRequest, alibcTradeContext, dVar, alibcComponentReRenderCallback);
        }

        @Override // com.baichuan.nb_trade.distribute.d
        public final void a(int i, String str) {
            AlibcLogger.i(lra.b, "HandlerCallbackImpl: onComplete execute");
            this.f43139a.onRouteComplete(i, str);
        }
    }

    @Override // com.baichuan.nb_trade.distribute.b
    public final void a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        Iterator<b> it = this.f18034a;
        if (it.hasNext()) {
            it.next().b(routeRequest, alibcTradeContext, dVar, alibcComponentReRenderCallback);
        } else {
            dVar.a(3000, "");
        }
    }
}
