package com.kwad.components.ad.feed.monitor;

import com.ksad.json.annotation.KsJson;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
@KsJson
public class FeedPageInfo extends com.kwad.sdk.commercial.c.a implements Serializable {
    private static final long serialVersionUID = -1423277713849754339L;
    public String abParams;
    public int adNum;
    public int callbackType;
    public long convertDuration;
    public int expectedRenderType;
    public String extMsg;
    public long loadDataDuration;
    public int loadStatus;
    public long loadType;
    public List<a> materialInfoList = new ArrayList();
    public int materialType;
    public String materialUrl;
    public long renderDuration;
    public int renderType;
    public long resourceLoadDuration;
    public int status;
    public int type;

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public long creativeId;
        public int materialType;
        public String materialUrl;

        public final a O(int i) {
            this.materialType = i;
            return this;
        }

        public final a l(long j) {
            this.creativeId = j;
            return this;
        }

        public final a v(String str) {
            this.materialUrl = str;
            return this;
        }
    }

    public FeedPageInfo setAbParams(String str) {
        this.abParams = str;
        return this;
    }

    public FeedPageInfo setAdNum(int i) {
        this.adNum = i;
        return this;
    }

    public FeedPageInfo setCallbackType(int i) {
        this.callbackType = i;
        return this;
    }

    public FeedPageInfo setConvertDuration(long j) {
        this.convertDuration = j;
        return this;
    }

    public FeedPageInfo setExpectedRenderType(int i) {
        this.expectedRenderType = i;
        return this;
    }

    public FeedPageInfo setExtMsg(String str) {
        this.extMsg = str;
        return this;
    }

    public FeedPageInfo setLoadDataDuration(long j) {
        this.loadDataDuration = j;
        return this;
    }

    public FeedPageInfo setLoadStatus(int i) {
        this.loadStatus = i;
        return this;
    }

    public FeedPageInfo setLoadType(long j) {
        this.loadType = j;
        return this;
    }

    public FeedPageInfo setMaterialInfoList(List<a> list) {
        this.materialInfoList = list;
        return this;
    }

    public FeedPageInfo setMaterialType(int i) {
        this.materialType = i;
        return this;
    }

    public FeedPageInfo setMaterialUrl(String str) {
        this.materialUrl = str;
        return this;
    }

    public FeedPageInfo setRenderDuration(long j) {
        this.renderDuration = j;
        return this;
    }

    public FeedPageInfo setRenderType(int i) {
        this.renderType = i;
        return this;
    }

    public FeedPageInfo setResourceLoadDuration(long j) {
        this.resourceLoadDuration = j;
        return this;
    }

    public FeedPageInfo setStatus(int i) {
        this.status = i;
        return this;
    }

    public FeedPageInfo setType(int i) {
        this.type = i;
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorCode(int i) {
        super.setErrorCode(i);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setErrorMsg(String str) {
        super.setErrorMsg(str);
        return this;
    }

    @Override // com.kwad.sdk.commercial.c.a
    public FeedPageInfo setPosId(long j) {
        return (FeedPageInfo) super.setPosId(j);
    }
}
