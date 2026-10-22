package com.kwad.sdk.commercial.convert;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@KsJson
public class AdLinkMonitorMsg extends com.kwad.sdk.commercial.c.a implements Serializable {
    public static final int CACHE_LOAD = 2;
    public static final int GET_VIEW_COST = 3;
    public static final int NATIVE = 1;
    public static final int ONLINE_LOAD = 1;
    public static final int PRE_RENDER_COST = 2;
    public static final int REQUEST_COST = 1;
    public static final int TK = 2;
    public static final int VIEW_RENDER_COST = 4;
    private static final long serialVersionUID = -6924282068763767612L;
    public int adStyle;
    public long durationTime;
    public int materialLoadType;
    public int renderType;
    public int status;

    public static AdLinkMonitorMsg obtain() {
        return new AdLinkMonitorMsg();
    }

    public AdLinkMonitorMsg setAdStyle(int i) {
        this.adStyle = i;
        return this;
    }

    public AdLinkMonitorMsg setDurationTime(long j) {
        this.durationTime = j;
        return this;
    }

    public AdLinkMonitorMsg setMaterialLoadType(int i) {
        this.materialLoadType = i;
        return this;
    }

    public AdLinkMonitorMsg setRenderType(int i) {
        this.renderType = i;
        return this;
    }

    public AdLinkMonitorMsg setStatus(int i) {
        this.status = i;
        return this;
    }
}
