package com.alibaba.triver.kit.api.common;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum TrackId {
    Prop_networkType("networktype"),
    Statistic_networkCount("networkCount"),
    Event_networkStart("networkStart"),
    Behavior_share("share"),
    Error_WebEngine("WebEngineError");

    private String trackId;

    TrackId(String str) {
        this.trackId = str;
    }

    public String value() {
        return this.trackId;
    }
}
