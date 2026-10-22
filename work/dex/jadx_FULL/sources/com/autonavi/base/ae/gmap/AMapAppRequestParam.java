package com.autonavi.base.ae.gmap;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class AMapAppRequestParam {

    @JBindingExclude
    public static final int RESOURCE_TYPE_ABSPATH = 4;

    @JBindingExclude
    public static final int RESOURCE_TYPE_BINARY = 3;

    @JBindingExclude
    public static final int RESOURCE_TYPE_IMAGE = 1;

    @JBindingExclude
    public static final int RESOURCE_TYPE_NONE = 0;

    @JBindingExclude
    public static final int RESOURCE_TYPE_SVG = 2;

    @JBindingExclude
    private ResourceCallback callback;
    private String url;
    private int resourceType = 0;
    private long contextId = 0;
    private int expectWidth = 0;
    private int expectHeight = 0;

    @JBindingInclude
    public void generateCallback(long j) {
        this.callback = new ResourceCallback(j);
    }

    @JBindingExclude
    public ResourceCallback getCallback() {
        return this.callback;
    }

    @JBindingExclude
    public long getContextId() {
        return this.contextId;
    }

    @JBindingExclude
    public int getExpectHeight() {
        return this.expectHeight;
    }

    @JBindingExclude
    public int getExpectWidth() {
        return this.expectWidth;
    }

    @JBindingExclude
    public int getResourceType() {
        return this.resourceType;
    }

    @JBindingExclude
    public String getUrl() {
        return this.url;
    }

    @JBindingExclude
    public void setCallback(ResourceCallback resourceCallback) {
        this.callback = resourceCallback;
    }

    @JBindingExclude
    public void setContextId(long j) {
        this.contextId = j;
    }

    @JBindingExclude
    public void setExpectHeight(int i) {
        this.expectHeight = i;
    }

    @JBindingExclude
    public void setExpectWidth(int i) {
        this.expectWidth = i;
    }

    @JBindingExclude
    public void setResourceType(int i) {
        this.resourceType = i;
    }

    @JBindingExclude
    public void setUrl(String str) {
        this.url = str;
    }
}
