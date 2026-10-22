package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class PoiCitySearchOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26533a;
    private LatLng b;
    private int c;
    private LatLngBounds d;
    public String mCity = null;
    public String mKeyword = null;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public boolean mIsReturnAddr = true;
    public String mTag = "";
    public int mScope = 1;
    public boolean mIsCityLimit = true;
    public PoiFilter mPoiFilter = null;
    public boolean mIsExtendAdcode = true;
    public InputLanguageType mInputLanguageType = null;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public PoiCitySearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public PoiCitySearchOption cityLimit(boolean z) {
        this.mIsCityLimit = z;
        return this;
    }

    public PoiCitySearchOption extendAdcode(boolean z) {
        this.mIsExtendAdcode = z;
        return this;
    }

    public LatLng getCenter() {
        return this.b;
    }

    public int getFilterDistance() {
        return this.c;
    }

    public LatLngBounds getViewBound() {
        return this.d;
    }

    public PoiCitySearchOption inputLanguage(InputLanguageType inputLanguageType) {
        this.mInputLanguageType = inputLanguageType;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.mIsExtendAdcode;
    }

    public PoiCitySearchOption isReturnAddr(boolean z) {
        this.mIsReturnAddr = z;
        return this;
    }

    public boolean isShowPhoto() {
        return this.f26533a;
    }

    public PoiCitySearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiCitySearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiCitySearchOption pageCapacity(int i) {
        this.mPageCapacity = i;
        return this;
    }

    public PoiCitySearchOption pageNum(int i) {
        this.mPageNum = i;
        return this;
    }

    public PoiCitySearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiCitySearchOption scope(int i) {
        this.mScope = i;
        return this;
    }

    public PoiCitySearchOption setCenter(LatLng latLng) {
        this.b = latLng;
        return this;
    }

    public PoiCitySearchOption setFilterDistance(int i) {
        this.c = i;
        return this;
    }

    public PoiCitySearchOption setShowPhoto(boolean z) {
        this.f26533a = z;
        return this;
    }

    public PoiCitySearchOption setViewBound(LatLngBounds latLngBounds) {
        this.d = latLngBounds;
        return this;
    }

    public PoiCitySearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
