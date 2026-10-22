package com.baidu.mapapi.search.sug;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.LanguageType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SuggestionSearchOption {
    public boolean mHotWord;
    public String mCity = null;
    public String mKeyword = null;
    public LatLng mLocation = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26578a = true;
    public Boolean mCityLimit = Boolean.FALSE;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public SuggestionSearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public SuggestionSearchOption citylimit(Boolean bool) {
        this.mCityLimit = bool;
        return this;
    }

    public SuggestionSearchOption extendAdcode(boolean z) {
        this.f26578a = z;
        return this;
    }

    public SuggestionSearchOption hotWord(boolean z) {
        this.mHotWord = z;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.f26578a;
    }

    public SuggestionSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public SuggestionSearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public SuggestionSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }
}
