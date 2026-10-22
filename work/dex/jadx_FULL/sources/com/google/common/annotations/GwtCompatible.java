package com.google.common.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Target({ElementType.TYPE, ElementType.METHOD})
@GwtCompatible
@Documented
@Retention(RetentionPolicy.CLASS)
public @interface GwtCompatible {
    boolean emulated() default false;

    boolean serializable() default false;
}
