package com.baidu.mapapi.search.base;

import com.alibaba.ariver.kernel.RVParams;
import com.amap.api.maps.AMap;
import com.igexin.push.g.o;
import com.kuaishou.weapon.p0.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public enum InputLanguageType {
    AUTO("auto"),
    ENGLISH(AMap.ENGLISH),
    CANTONESE("yue"),
    CLASSICAL_CHINESE("wyw"),
    JAPANESE("jp"),
    KOREAN("kor"),
    FRENCH("fra"),
    SPANISH("spa"),
    THAI("th"),
    ARABIC("ara"),
    RUSSIAN("ru"),
    PORTUGUESE("pt"),
    GERMAN("de"),
    ITALIAN(o.f),
    Greek(t.n),
    DUTCH("nl"),
    Polish(RVParams.PREFETCH_LOCATION),
    BULGARIAN("bul"),
    ESTONIAN("est"),
    DANISH("dan"),
    FINNISH("fin"),
    CZECH("cs"),
    ROMANIAN("rom"),
    SLOVENIAN("slo"),
    SWEDISH("swe"),
    HUNGARIAN("hu"),
    TRADITIONAL_CHINESE("cht"),
    VIETNAMESE("vie");

    private final String value;

    InputLanguageType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
