package com.baichuan.nb_trade.distribute;

import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AlibcComponentReRenderCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f26231a = "b";

    public static String a(boolean z, String str, String str2, Map<String, String> map) {
        if (!z) {
            return AlibcProtocolUtils.handleShopUrl(str, str2);
        }
        HashMap map2 = new HashMap();
        map2.put("shop", str2);
        return AlibcProtocolUtils.reAssembleUrl(str, map, true, map2);
    }

    public abstract void a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback);

    public abstract boolean a(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext);

    public final void b(RouteRequest routeRequest, AlibcTradeContext alibcTradeContext, d dVar, AlibcComponentReRenderCallback alibcComponentReRenderCallback) {
        if (a(routeRequest, alibcTradeContext)) {
            a(routeRequest, alibcTradeContext, dVar, alibcComponentReRenderCallback);
        } else {
            dVar.a(routeRequest, alibcTradeContext, dVar, alibcComponentReRenderCallback);
        }
    }
}
