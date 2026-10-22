package com.baidu.mapapi.search.route;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class IndoorRoutePlanOption {
    public IndoorPlanNode mFrom = null;
    public IndoorPlanNode mTo = null;

    public IndoorRoutePlanOption from(IndoorPlanNode indoorPlanNode) {
        this.mFrom = indoorPlanNode;
        return this;
    }

    public IndoorRoutePlanOption to(IndoorPlanNode indoorPlanNode) {
        this.mTo = indoorPlanNode;
        return this;
    }
}
