package com.alibaba.alibcprotocol.route;

import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.a.a;
import com.alibaba.alibcprotocol.route.a.c;
import com.alibaba.alibcprotocol.route.a.d;
import com.alibaba.alibcprotocol.route.a.e;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RequestFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23617a = "RequestFactory";

    public static RouteRequest buildRequest(RouteRequest routeRequest, AlibcBizParams alibcBizParams, RouteRequestCallback routeRequestCallback) {
        d dVar = new d();
        e eVar = new e();
        a aVar = new a();
        c cVar = new c();
        dVar.a(eVar);
        eVar.a(aVar);
        aVar.a(cVar);
        return dVar.a(routeRequest, alibcBizParams, routeRequestCallback);
    }
}
