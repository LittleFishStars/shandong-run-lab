package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.college.page.hw_health.HWHealthActivity;
import com.huachenjie.college.page.recreation.RecreationActivity;
import com.huachenjie.college.page.sport.CollegeActivity;
import com.zj.adlib.zj7;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$college implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(zj7.c.HOME, RouteMeta.build(routeType, CollegeActivity.class, "/college/collegehome", "college", null, -1, Integer.MIN_VALUE));
        map.put(zj7.c.HW_HEALTH, RouteMeta.build(routeType, HWHealthActivity.class, "/college/hwhealth", "college", null, -1, Integer.MIN_VALUE));
        map.put(zj7.c.RECREATION, RouteMeta.build(routeType, RecreationActivity.class, zj7.c.RECREATION, "college", null, -1, Integer.MIN_VALUE));
    }
}
