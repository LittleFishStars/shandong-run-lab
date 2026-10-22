package com.baichuan.nb_trade.distribute;

import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.baichuan.nb_trade.callback.AlibcRouteCallback;
import com.zj.adlib.lra;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class HandlerCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public lra f26229a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static HandlerCenter f26230a = new HandlerCenter(0);
    }

    public /* synthetic */ HandlerCenter(byte b) {
        this();
    }

    public static HandlerCenter getInstance() {
        return a.f26230a;
    }

    public void route(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, AlibcRouteCallback alibcRouteCallback, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        getInstance().f26229a.d(routeRequest, alibcTradeContext, alibcRouteCallback, alibcComponentReRenderCallback);
    }

    public HandlerCenter() {
        if (this.f26229a == null) {
            this.f26229a = new lra();
        }
    }
}
