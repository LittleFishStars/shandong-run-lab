package com.baidu.mapapi.http.wrapper.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Retention(RetentionPolicy.RUNTIME)
public @interface BodyData {
    public static final String TYPE_FORM_DATA = "form-data";
    public static final String TYPE_JSON = "json";
    public static final String TYPE_URL_ENCODED = "urlencoded";

    String value() default "json";
}
