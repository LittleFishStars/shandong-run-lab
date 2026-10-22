package com.alibaba.alibcprotocol.route.a;

import android.text.TextUtils;
import com.alibaba.alibcprotocol.callback.RouteRequestCallback;
import com.alibaba.alibcprotocol.param.AlibcBizParams;
import com.alibaba.alibcprotocol.route.RouteRequest;
import com.alibaba.alibcprotocol.route.config.AlibcConfigService;
import com.alibaba.alibcprotocol.route.model.ActionDO;
import com.alibaba.alibcprotocol.route.model.ConfigDO;
import com.alibaba.alibcprotocol.route.model.ParamDO;
import com.alibaba.alibcprotocol.route.model.RouteConfigDO;
import com.zj.adlib.bv9;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private b f23620a;

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final void a(b bVar) {
        this.f23620a = bVar;
    }

    @Override // com.alibaba.alibcprotocol.route.a.b
    public final RouteRequest a(RouteRequest routeRequest, AlibcBizParams alibcBizParams, RouteRequestCallback routeRequestCallback) {
        List<RouteConfigDO> routeConfig;
        String rawUrl = routeRequest.getRawUrl();
        if (!TextUtils.isEmpty(rawUrl)) {
            ArrayList arrayList = new ArrayList();
            ConfigDO config = AlibcConfigService.getInstance().getConfig();
            if (config != null && (routeConfig = config.getRouteConfig()) != null && routeConfig.size() > 0) {
                for (RouteConfigDO routeConfigDO : routeConfig) {
                    int[] index = routeConfigDO.getIndex();
                    Matcher matcher = Pattern.compile(routeConfigDO.getMatch()).matcher(rawUrl);
                    if (matcher.find()) {
                        for (int i : index) {
                            if (i <= matcher.groupCount()) {
                                arrayList.add(matcher.group(i));
                            }
                        }
                        List<ActionDO> action = routeConfigDO.getAction();
                        for (ActionDO actionDO : action) {
                            ParamDO param = actionDO.getParam();
                            String targetPath = param.getTargetPath();
                            if (!TextUtils.isEmpty(targetPath)) {
                                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                                    targetPath = targetPath.replace(bv9.b + i2 + "}", (CharSequence) arrayList.get(i2));
                                }
                            }
                            param.setTargetPath(targetPath);
                            actionDO.setParam(param);
                        }
                        routeRequest.setActionList(action);
                        break;
                    }
                }
            }
        }
        b bVar = this.f23620a;
        if (bVar != null) {
            bVar.a(routeRequest, alibcBizParams, routeRequestCallback);
        } else {
            routeRequestCallback.onBuildComplete("RouteNode");
        }
        return routeRequest;
    }
}
