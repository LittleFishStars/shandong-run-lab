package com.alibaba.alibcprotocol.route.a;

import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.UrlTypeDO;
import com.alibaba.alibcprotocol.utils.AlibcProtocolUtils;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class e implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f23622a;

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final void a(b bVar) {
        this.f23622a = bVar;
    }

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final RouteRequest a(RouteRequest routeRequest, AlibcBizParams alibcBizParams, RouteRequestCallback routeRequestCallback) {
        List<UrlTypeDO> urlTypeConfig;
        ConfigDO config = AlibcConfigService.getInstance().getConfig();
        if (config != null && (urlTypeConfig = config.getUrlTypeConfig()) != null && urlTypeConfig.size() > 0) {
            Iterator<UrlTypeDO> it = urlTypeConfig.iterator();
            while (true) {
                if (!it.hasNext()) {
                    routeRequest.setPageType("h5");
                    break;
                }
                UrlTypeDO next = it.next();
                String[] pattern = next.getPattern();
                String type = next.getType();
                String rawUrl = routeRequest.getRawUrl();
                if (AlibcProtocolUtils.urlCheck(pattern, rawUrl)) {
                    routeRequest.setPageType(type);
                    if (!"miniapp".equals(type)) {
                        break;
                    }
                    routeRequest.setRawUrl(rawUrl);
                    break;
                }
            }
        } else {
            routeRequest.setPageType("h5");
            break;
        }
        b bVar = this.f23622a;
        if (bVar != null) {
            bVar.a(routeRequest, alibcBizParams, routeRequestCallback);
        } else {
            routeRequestCallback.onBuildComplete("UrlTypeNode");
        }
        return routeRequest;
    }
}
