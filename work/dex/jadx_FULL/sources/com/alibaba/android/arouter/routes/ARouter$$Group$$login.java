package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.login.page.school_certification.SchoolCertificationWebActivity;
import com.huachenjie.login.page.welcome.WelcomeLoginActivity;
import com.zj.adlib.zj7;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$login implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(zj7.f.LOGIN, RouteMeta.build(routeType, WelcomeLoginActivity.class, zj7.f.LOGIN, "login", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.Login.b, RouteMeta.build(routeType, SchoolCertificationWebActivity.class, "/login/schoolweb", "login", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$login.1
            {
                put("type", 8);
                put("url", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
