package com.baidu.platform.core.route;

import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.maps.AMap;
import com.baidu.mapapi.search.route.DrivingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.kuaishou.weapon.p0.bg;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class d extends com.baidu.platform.base.c {
    public d(DrivingRoutePlanOption drivingRoutePlanOption) {
        a(drivingRoutePlanOption);
    }

    private void a(DrivingRoutePlanOption drivingRoutePlanOption) {
        this.c.a("qt", "cars");
        this.c.a("sy", drivingRoutePlanOption.mPolicy.getInt() + "");
        this.c.a("ie", "utf-8");
        this.c.a("lrn", "20");
        this.c.a("version", "6");
        this.c.a("extinfo", "32");
        this.c.a("mrs", "1");
        this.c.a("rp_format", "json");
        this.c.a("rp_filter", "mobile");
        this.c.a("route_traffic", drivingRoutePlanOption.mtrafficPolicy.getInt() + "");
        this.c.a("sn", a(drivingRoutePlanOption.mFrom));
        this.c.a(AMap.ENGLISH, a(drivingRoutePlanOption.mTo));
        String str = drivingRoutePlanOption.mCityName;
        if (str != null) {
            this.c.a("c", str);
        }
        PlanNode planNode = drivingRoutePlanOption.mFrom;
        if (planNode != null) {
            this.c.a("sc", planNode.getCity());
        }
        PlanNode planNode2 = drivingRoutePlanOption.mTo;
        if (planNode2 != null) {
            this.c.a(AliyunLogKey.KEY_ERROR_CODE, planNode2.getCity());
        }
        List<PlanNode> list = drivingRoutePlanOption.mWayPoints;
        String str2 = new String();
        String str3 = new String();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                PlanNode planNode3 = list.get(i);
                if (planNode3 != null) {
                    str2 = str2 + a(planNode3);
                    str3 = str3 + planNode3.getCity();
                    if (i != list.size() - 1) {
                        str3 = str3 + "|";
                        str2 = str2 + "|";
                    }
                }
            }
            this.c.a(bg.q, str2);
            this.c.a("wpc", str3);
        }
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.a();
    }
}
