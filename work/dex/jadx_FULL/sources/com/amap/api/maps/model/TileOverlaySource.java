package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class TileOverlaySource {

    @JBindingExclude
    public static int TILESOURCE_TYPE_FBO_TEXTURE = 4;

    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE = 1;

    @JBindingExclude
    public static int TILESOURCE_TYPE_IMAGE_DEM = 3;

    @JBindingExclude
    public static int TILESOURCE_TYPE_VECTOR = 2;
    private String attribute;
    private final int id;
    private final int type;
    private final String url;
    private int minZoom = 3;
    private int maxZoom = 20;
    private boolean cacheEnabled = true;

    public TileOverlaySource(int i, int i2, String str) {
        this.url = str;
        this.type = i2;
        this.id = i;
    }

    public int getId() {
        return this.id;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public int getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheEnabled() {
        return this.cacheEnabled;
    }

    public void setCacheEnabled(boolean z) {
        this.cacheEnabled = z;
    }

    public void setMaxZoom(int i) {
        this.maxZoom = i;
    }

    public void setMinZoom(int i) {
        this.minZoom = i;
    }
}
