package com.baidu.platform.core.route;

import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapapi.search.route.WalkingRoutePlanOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class h extends com.baidu.platform.base.c {
    public h(WalkingRoutePlanOption walkingRoutePlanOption) {
        a(walkingRoutePlanOption);
    }

    private void a(WalkingRoutePlanOption walkingRoutePlanOption) {
        this.c.a("qt", "walkplan");
        this.c.a("sn", a(walkingRoutePlanOption.mFrom));
        this.c.a(AMap.ENGLISH, a(walkingRoutePlanOption.mTo));
        PlanNode planNode = walkingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.c.a("sc", planNode.getCity());
        }
        PlanNode planNode2 = walkingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.c.a(AliyunLogKey.KEY_ERROR_CODE, planNode2.getCity());
        }
        this.c.a("ie", "utf-8");
        this.c.a("lrn", "20");
        this.c.a("version", "6");
        this.c.a("rp_format", "json");
        this.c.a("rp_filter", "mobile");
        this.c.a("spath_type", "1");
        this.c.a("with_indoor_navi", "1");
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.i();
    }
}
