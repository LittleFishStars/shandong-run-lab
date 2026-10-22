package com.alibaba.android.arouter.facade.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.CLASS)
@Deprecated
public @interface Param {
    String desc() default "No desc.";

    String name() default "";
}
