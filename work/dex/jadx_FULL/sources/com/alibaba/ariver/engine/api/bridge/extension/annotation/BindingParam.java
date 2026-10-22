package com.alibaba.ariver.engine.api.bridge.extension.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface BindingParam {
    boolean booleanDefault() default false;

    double doubleDefault() default 0.0d;

    float floatDefault() default 0.0f;

    int intDefault() default 0;

    long longDefault() default 0;

    String[] name() default {};

    boolean required() default false;

    String stringDefault() default "";

    String[] value() default {};
}
