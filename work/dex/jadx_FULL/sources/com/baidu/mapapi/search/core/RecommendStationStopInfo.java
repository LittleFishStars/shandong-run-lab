package com.baidu.mapapi.search.core;

import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RecommendStationStopInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f26516a;
    private List<RecommendStopInfo> b;

    public List<RecommendStopInfo> getRecommendStopInfoList() {
        return this.b;
    }

    public String getStationName() {
        return this.f26516a;
    }

    public void setRecommendStopInfoList(List<RecommendStopInfo> list) {
        this.b = list;
    }

    public void setStationName(String str) {
        this.f26516a = str;
    }
}
