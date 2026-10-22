package com.baidu.platform.core.route;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.route.BikingRoutePlanOption;
import com.baidu.mapapi.search.route.PlanNode;
import com.baidu.mapsdkplatform.comapi.util.CoordTrans;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b extends com.baidu.platform.base.c {
    public b(BikingRoutePlanOption bikingRoutePlanOption) {
        a(bikingRoutePlanOption);
    }

    private void a(BikingRoutePlanOption bikingRoutePlanOption) {
        this.c.a("mode", "riding");
        PlanNode planNode = bikingRoutePlanOption.mFrom;
        PlanNode planNode2 = bikingRoutePlanOption.mTo;
        if (planNode == null || planNode2 == null) {
            return;
        }
        LatLng location = planNode.getLocation();
        if (location != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location = CoordTrans.gcjToBaidu(location);
            }
            if (location != null) {
                this.c.a("origin", location.latitude + "," + location.longitude);
            }
        } else {
            this.c.a("origin", planNode.getName());
            this.c.a("origin_region", planNode.getCity());
        }
        if (planNode.getPoiId() != null && planNode.getPoiId().length() > 0) {
            this.c.a("origin_uid", planNode.getPoiId());
        }
        LatLng location2 = planNode2.getLocation();
        if (location2 != null) {
            if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                location2 = CoordTrans.gcjToBaidu(location2);
            }
            if (location2 != null) {
                this.c.a("destination", location2.latitude + "," + location2.longitude);
            }
        } else {
            this.c.a("destination", planNode2.getName());
            this.c.a("destination_region", planNode2.getCity());
        }
        if (planNode2.getPoiId() != null && planNode2.getPoiId().length() > 0) {
            this.c.a("destination_uid", planNode2.getPoiId());
        }
        int i = bikingRoutePlanOption.mRidingType;
        if (i == 1) {
            this.c.a("riding_type", String.valueOf(i));
        }
        List<PlanNode> wayPoints = bikingRoutePlanOption.getWayPoints();
        if (wayPoints != null) {
            StringBuilder sb = new StringBuilder();
            for (int i2 = 0; i2 < wayPoints.size(); i2++) {
                PlanNode planNode3 = wayPoints.get(i2);
                if (i2 == 0) {
                    sb.append(a(planNode3, this.c));
                } else {
                    sb.append("|");
                    sb.append(a(planNode3, this.c));
                }
            }
            this.c.a("waypoints", sb.toString());
        }
        this.c.a(com.alibaba.ariver.remotedebug.b.c.g, "json");
        this.c.a("from", "android_map_sdk");
        this.c.a("road_prefer", bikingRoutePlanOption.mRoadPrefer);
    }

    private String a(PlanNode planNode, com.baidu.platform.util.a aVar) {
        if (planNode != null && aVar != null) {
            LatLng location = planNode.getLocation();
            String poiId = planNode.getPoiId() != null ? planNode.getPoiId() : "";
            if (location != null) {
                if (SDKInitializer.getCoordType() == CoordType.GCJ02) {
                    location = CoordTrans.gcjToBaidu(location);
                }
                if (location != null) {
                    return location.latitude + "," + location.longitude + com.alipay.sdk.m.y.l.b + poiId;
                }
            } else {
                String cityCode = planNode.getCityCode() != null ? planNode.getCityCode() : "";
                String cityName = planNode.getCityName() != null ? planNode.getCityName() : "";
                if (planNode.getName() != null && planNode.getName().length() > 0) {
                    return planNode.getName() + com.alipay.sdk.m.y.l.b + poiId + com.alipay.sdk.m.y.l.b + cityName + com.alipay.sdk.m.y.l.b + cityCode;
                }
            }
        }
        return "";
    }

    @Override // com.baidu.platform.base.c
    public String a(com.baidu.platform.domain.b bVar) {
        return bVar.b();
    }
}
