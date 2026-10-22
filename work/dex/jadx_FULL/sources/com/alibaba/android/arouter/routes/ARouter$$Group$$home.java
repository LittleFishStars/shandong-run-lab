package com.alibaba.android.arouter.routes;

import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.huachenjie.home.dialog.reward.RewardInfoDialog;
import com.huachenjie.home.page.change_reward.ChangeRewardActivity;
import com.huachenjie.home.page.reward_record.RewardRecordActivity;
import com.zj.adlib.zj7;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ARouter$$Group$$home implements IRouteGroup {
    @Override // com.alibaba.android.arouter.facade.template.IRouteGroup
    public void loadInto(Map<String, RouteMeta> map) {
        RouteType routeType = RouteType.ACTIVITY;
        map.put(zj7.e.CHANGE_REWARD, RouteMeta.build(routeType, ChangeRewardActivity.class, "/home/changereward", "home", null, -1, Integer.MIN_VALUE));
        map.put(zj7.e.REWARD_INFO_DIALOG, RouteMeta.build(RouteType.FRAGMENT, RewardInfoDialog.class, "/home/rewardinfodialog", "home", null, -1, Integer.MIN_VALUE));
        map.put(zj7.e.REWARD_RECORD, RouteMeta.build(routeType, RewardRecordActivity.class, "/home/rewardrecord", "home", null, -1, Integer.MIN_VALUE));
    }
}
