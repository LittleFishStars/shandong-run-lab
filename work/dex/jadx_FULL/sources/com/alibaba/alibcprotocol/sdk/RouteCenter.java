package com.alibaba.alibcprotocol.sdk;

import android.net.Uri;
import com.alibaba.alibcprotocol.base.AlibcTradeContext;
import com.alibaba.alibcprotocol.callback.AppLinkOpenCallback;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.proxy.IAlibcApplinkProxy;
import com.alibaba.alibcprotocol.route.proxy.IAlibcGameProxy;
import com.alibaba.alibcprotocol.route.proxy.impl.AlibcProxy;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import com.alibaba.baichuan.trade.common.AlibcBaseTradeCommon;
import com.alibaba.baichuan.trade.common.utils.AlibcLogger;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RouteCenter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f23633a = "RouteCenter";

    public static Object route(RouteRequest routeRequest, Map<String, Object> map, final RouteInnerCallback routeInnerCallback) {
        try {
            Uri uri = Uri.parse(routeRequest.getRawUrl());
            String authority = uri.getAuthority();
            String path = uri.getPath();
            String queryParameter = uri.getQueryParameter("url");
            if ("third_sdk".equals(authority)) {
                ((IAlibcGameProxy) AlibcProxy.get(IAlibcGameProxy.class)).route(routeRequest.getRawUrl(), map, new a() { // from class: com.alibaba.alibcprotocol.sdk.RouteCenter.1
                });
            } else if ("applink".equals(authority)) {
                AlibcTradeContext alibcTradeContext = AlibcTradeContext.getInstance();
                Map<String, Object> mapObj2Map = AlibcProtocolUtils.obj2Map(alibcTradeContext.showParams, alibcTradeContext.taokeParams, routeRequest.getBizType(), false, null);
                if ("/openUrl".equals(path)) {
                    ((IAlibcApplinkProxy) AlibcProxy.get(IAlibcApplinkProxy.class)).openUrl(AlibcBaseTradeCommon.context, queryParameter, mapObj2Map, new AppLinkOpenCallback() { // from class: com.alibaba.alibcprotocol.sdk.RouteCenter.2
                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public final void getLinkUrl(boolean z, String str, String str2, int i) {
                            AlibcLogger.i(RouteCenter.f23633a, "execute applink result: " + z);
                        }

                        @Override // com.alibaba.alibcprotocol.callback.AppLinkOpenCallback
                        public final void supportFail(String str, String str2) {
                        }
                    });
                }
            }
        } catch (Throwable th) {
            AlibcLogger.e(f23633a, "parse url exception: " + th.getMessage());
        }
        return null;
    }
}
