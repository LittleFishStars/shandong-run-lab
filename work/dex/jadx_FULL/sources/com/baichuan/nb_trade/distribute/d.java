package com.baichuan.nb_trade.distribute;

import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface d {
    void a(int i, String str);

    void a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback);
}
