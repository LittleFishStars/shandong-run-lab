package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.huachenjie.shandong_school.home.HomeActivity;
import com.huachenjie.shandong_school.splash.SplashAdNewDialog;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$app implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        map.put(zj7.a.HOME, RouteMeta.build(RouteType.ACTIVITY, HomeActivity.class, "/app/homeactivity", NativeCallContext.DOMAIN_APP, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$app.1
            {
                put(yj7.a.SHOULD_REFRESH_USER_INFO, 0);
                put(yj7.a.ALERT_TIP, 10);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(zj7.a.SPLASH_AD_NEW, RouteMeta.build(RouteType.FRAGMENT, SplashAdNewDialog.class, "/app/splashadnewdialog", NativeCallContext.DOMAIN_APP, null, -1, Integer.MIN_VALUE));
    }
}
