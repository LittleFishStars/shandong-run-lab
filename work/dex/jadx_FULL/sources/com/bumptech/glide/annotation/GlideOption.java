package com.bumptech.glide.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.CLASS)
public @interface GlideOption {
    public static final int OVERRIDE_EXTEND = 1;
    public static final int OVERRIDE_NONE = 0;
    public static final int OVERRIDE_REPLACE = 2;

    boolean memoizeStaticMethod() default false;

    int override() default 0;

    boolean skipStaticMethod() default false;

    String staticMethodName() default "";
}
