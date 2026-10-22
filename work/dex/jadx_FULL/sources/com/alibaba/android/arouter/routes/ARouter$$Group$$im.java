package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.common.constants.RoutePathConstants;
import com.huachenjie.im.page.ChatRoomActivity;
import com.huachenjie.im.page.SignalTowerActivity;
import com.huachenjie.im.page.SingleChatActivity;
import com.huachenjie.im.page.TeamChatActivity;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$im implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(RoutePathConstants.IM.d, RouteMeta.build(routeType, ChatRoomActivity.class, "/im/chatroom", "im", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.IM.e, RouteMeta.build(routeType, TeamChatActivity.class, "/im/chatteam", "im", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.IM.c, RouteMeta.build(routeType, SignalTowerActivity.class, "/im/signaltower", "im", null, -1, Integer.MIN_VALUE));
        map.put(RoutePathConstants.IM.b, RouteMeta.build(routeType, SingleChatActivity.class, "/im/singlechat", "im", null, -1, Integer.MIN_VALUE));
    }
}
