package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.common.dialog.VersionUpgradeDialog;
import com.huachenjie.common.dialog.auth.AuthDialogActivity;
import com.huachenjie.common.webview.WebViewActivity;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$common implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> atlas) {
        RouteType routeType = RouteType.ACTIVITY;
        atlas.put(RoutePathConstants.Common.b, RouteMeta.build(routeType, AuthDialogActivity.class, RoutePathConstants.Common.b, "common", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Common.d, RouteMeta.build(routeType, VersionUpgradeDialog.class, RoutePathConstants.Common.d, "common", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Common.c, RouteMeta.build(routeType, WebViewActivity.class, RoutePathConstants.Common.c, "common", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$common.1
            {
                put("title", 8);
                put("url", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
