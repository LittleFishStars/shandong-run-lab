package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.mine.page.dressing_table.DressingTableActivity;
import com.huachenjie.mine.page.home.FriendInfoActivity;
import com.zj.adlib.zj7;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$mine implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(zj7.h.DRESS_TABLE, RouteMeta.build(routeType, DressingTableActivity.class, "/mine/dressingtable", "mine", null, -1, Integer.MIN_VALUE));
        map.put(zj7.h.OTHER_HOME, RouteMeta.build(routeType, FriendInfoActivity.class, "/mine/otherhome", "mine", new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$mine.1
            {
                put("appUserCode", 8);
                put("target", 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
