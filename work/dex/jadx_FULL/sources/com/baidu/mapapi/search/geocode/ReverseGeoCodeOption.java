package com.baidu.mapapi.search.geocode;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ReverseGeoCodeOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f26530a = 10;
    private int b = 0;
    private LatLng c = null;
    private int d = 1;
    private int e = 1000;
    private String f = null;
    private boolean g = false;
    private LanguageType h = LanguageType.LanguageTypeChinese;

    public ReverseGeoCodeOption extensionsRoad(boolean z) {
        this.g = z;
        return this;
    }

    public boolean getExtensionsRoad() {
        return this.g;
    }

    public LanguageType getLanguage() {
        return this.h;
    }

    public int getLatestAdmin() {
        return this.d;
    }

    public LatLng getLocation() {
        return this.c;
    }

    public int getPageNum() {
        return this.b;
    }

    public int getPageSize() {
        return this.f26530a;
    }

    public String getPoiType() {
        return this.f;
    }

    public int getRadius() {
        return this.e;
    }

    public ReverseGeoCodeOption language(LanguageType languageType) {
        this.h = languageType;
        return this;
    }

    public ReverseGeoCodeOption location(LatLng latLng) {
        this.c = latLng;
        return this;
    }

    public ReverseGeoCodeOption newVersion(int i) {
        this.d = i;
        return this;
    }

    public ReverseGeoCodeOption pageNum(int i) {
        if (i < 0) {
            i = 0;
        }
        this.b = i;
        return this;
    }

    public ReverseGeoCodeOption pageSize(int i) {
        if (i <= 0) {
            this.f26530a = 10;
        } else if (i > 100) {
            this.f26530a = 100;
        } else {
            this.f26530a = i;
        }
        return this;
    }

    public ReverseGeoCodeOption poiType(String str) {
        this.f = str;
        return this;
    }

    public ReverseGeoCodeOption radius(int i) {
        if (i < 0) {
            this.e = 0;
        } else if (i > 1000) {
            this.e = 1000;
        } else {
            this.e = i;
        }
        return this;
    }
}
