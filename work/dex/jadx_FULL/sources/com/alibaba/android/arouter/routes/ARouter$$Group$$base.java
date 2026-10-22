package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.base.dsbridge_webview.PayWebViewActivity;
import com.huachenjie.base.qr_code_scan.ScanFriendQRCodeActivity;
import com.huachenjie.common.constants.RoutePathConstants;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$base implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> atlas) {
        RouteType routeType = RouteType.ACTIVITY;
        atlas.put(RoutePathConstants.Base.b, RouteMeta.build(routeType, PayWebViewActivity.class, RoutePathConstants.Base.b, "base", null, -1, Integer.MIN_VALUE));
        atlas.put(RoutePathConstants.Base.c, RouteMeta.build(routeType, ScanFriendQRCodeActivity.class, RoutePathConstants.Base.c, "base", null, -1, Integer.MIN_VALUE));
    }
}
