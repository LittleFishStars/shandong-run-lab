package com.alibaba.triver.open.prefetch.expr;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public enum PrefetchParamsExpression {
    APP_DEVICEID("@app.deviceId", 100),
    APP_UTDID("@app.utdid", 101),
    APP_TTID("@app.ttid", 102),
    LOGIN_USERID("@login.userId", 200),
    LOGIN_OLD_USERID("@login.oldUserId", 201),
    LOGIN_USERNAME("@login.userName", 202),
    LOGIN_NICK("@login.nick", 203),
    LOGIN_OLD_NICK("@login.oldNick", 204),
    LOCATION_PROVINCE_CODE("@location.provinceCode", 300),
    LOCATION_PROVINCE_NAME("@location.provinceName", 301),
    LOCATION_CITY_CODE("@location.cityCode", 302),
    LOCATION_CITY_NAME("@location.cityName", 303),
    LOCATION_AREA_CODE("@location.areaCode", 304),
    LOCATION_AREA_NAME("@location.areaName", 305),
    LOCATION_LONGITUDE("@location.longitude", 306),
    LOCATION_LATITUDE("@location.latitude", 307),
    LOCATION_ALTITUDE("@location.altitude", 308),
    LOCATION_ADDRESS("@location.address", 309),
    LOCATION_TIMESTAMP("@location.timeStamp", 310),
    LOCATION_ACCURACY("@location.accuracy", 311),
    LOCATION_COUNTRY_CODE("@location.countryCode", 312),
    LOCATION_COUNTRY_NAME("@location.countryName", 313),
    EDITION_COUNTRY_CODE("@edition.countryCode", 400),
    EDITION_COUNTRY_NAME("@edition.countryName", 401),
    EDITION_COUNTRY_NUM_CODE("@edition.countryNumCode", 402),
    EDITION_LANGUAGE_CODE("@edition.languageCode", 403),
    EDITION_ACTUAL_LANGUAGE_CODE("@edition.actualLanguageCode", 404),
    EDITION_CURRENCY_CODE("@edition.currencyCode", 405),
    EDITION_HNG_COOKIE("@edition.hngCookie", 406),
    EDITION_CITY_NAME("@edition.cityName", 407),
    EDITION_CITY_ID("@edition.cityId", 408),
    EDITION_AREA("@edition.area", TTAdConstant.IMAGE_LIST_CODE),
    EDITION_EDITION_CODE("@edition.editionCode", 410),
    EDITION_IS_VILLAGE_USER("@edition.isVillageUser", 411),
    FILE("@file", 500, 6),
    URL("@url", 600, 5),
    FOREACH_QUERY("@foreachQuery", 700),
    STR("@str", 800, 5),
    FOREACH_INTENT("@foreachIntent", 900),
    UTABTEST("@utabtest", 1000, 10),
    OS_VERSION("@os.version", 1100),
    OS_MODEL("@os.model", 1101),
    OS_CPU_NUMS("@os.cpuNums", 1102),
    OS_CPU_MAX_HZ("@os.cpuMaxHz", SecExceptionCode.SEC_ERROE_OPENSDK_INVALID_LENGTH),
    PAGE_URL("@pageurl", 1200, 9),
    INTENT("@intent", 1300, 8),
    EXT("@ext", 1400, 5),
    KV_EXT("@kvExt", 1500, 7);

    public String expression;
    public int subIndex;
    public int type;

    PrefetchParamsExpression(String str, int i) {
        this.subIndex = 0;
        this.expression = str;
        this.type = i;
    }

    public static PrefetchParamsExpression getByExpression(String str) {
        if (str != null && !str.equals("")) {
            PrefetchParamsExpression prefetchParamsExpression = FILE;
            if (str.startsWith(prefetchParamsExpression.expression)) {
                return prefetchParamsExpression;
            }
            PrefetchParamsExpression prefetchParamsExpression2 = URL;
            if (str.startsWith(prefetchParamsExpression2.expression)) {
                return prefetchParamsExpression2;
            }
            PrefetchParamsExpression prefetchParamsExpression3 = STR;
            if (str.startsWith(prefetchParamsExpression3.expression)) {
                return prefetchParamsExpression3;
            }
            PrefetchParamsExpression prefetchParamsExpression4 = UTABTEST;
            if (str.startsWith(prefetchParamsExpression4.expression)) {
                return prefetchParamsExpression4;
            }
            PrefetchParamsExpression prefetchParamsExpression5 = PAGE_URL;
            if (str.startsWith(prefetchParamsExpression5.expression)) {
                return prefetchParamsExpression5;
            }
            PrefetchParamsExpression prefetchParamsExpression6 = INTENT;
            if (str.startsWith(prefetchParamsExpression6.expression)) {
                return prefetchParamsExpression6;
            }
            PrefetchParamsExpression prefetchParamsExpression7 = EXT;
            if (str.startsWith(prefetchParamsExpression7.expression)) {
                return prefetchParamsExpression7;
            }
            PrefetchParamsExpression prefetchParamsExpression8 = KV_EXT;
            if (str.startsWith(prefetchParamsExpression8.expression)) {
                return prefetchParamsExpression8;
            }
            for (PrefetchParamsExpression prefetchParamsExpression9 : values()) {
                if (prefetchParamsExpression9.expression.equals(str)) {
                    return prefetchParamsExpression9;
                }
            }
        }
        return null;
    }

    PrefetchParamsExpression(String str, int i, int i2) {
        this.expression = str;
        this.type = i;
        this.subIndex = i2;
    }
}
