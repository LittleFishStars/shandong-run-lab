package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.channel.page.channel_main.ChannelMainActivity;
import com.huachenjie.channel.page.message_detail.MessageDetailActivity;
import com.huachenjie.channel.page.notify.buddy.BuddyChatRoomActivity;
import com.huachenjie.channel.page.topic_main.TopicMainActivity;
import com.zj.adlib.xh9;
import com.zj.adlib.yj7;
import com.zj.adlib.zj7;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$channel implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(zj7.b.BUDDY_CHAT, RouteMeta.build(routeType, BuddyChatRoomActivity.class, "/channel/buddychat", xh9.WEBSITE_PARAMS_CHANNEL, null, -1, Integer.MIN_VALUE));
        map.put(zj7.b.CHANNEL_MAIN, RouteMeta.build(routeType, ChannelMainActivity.class, "/channel/channelmainactivity", xh9.WEBSITE_PARAMS_CHANNEL, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$channel.1
            {
                put("channelNo", 8);
            }
        }, -1, Integer.MIN_VALUE));
        map.put(zj7.b.ORGANIZE_ACTIVITY_DETAIL, RouteMeta.build(routeType, MessageDetailActivity.class, "/channel/organizeactivitydetail", xh9.WEBSITE_PARAMS_CHANNEL, null, -1, Integer.MIN_VALUE));
        map.put(zj7.b.TOPIC_MAIN, RouteMeta.build(routeType, TopicMainActivity.class, "/channel/topicmainactivity", xh9.WEBSITE_PARAMS_CHANNEL, new HashMap<String, Integer>() { // from class: com.alibaba.android.arouter.routes.ARouter$$Group$$channel.2
            {
                put(yj7.b.SUBJECT_NO, 8);
            }
        }, -1, Integer.MIN_VALUE));
    }
}
