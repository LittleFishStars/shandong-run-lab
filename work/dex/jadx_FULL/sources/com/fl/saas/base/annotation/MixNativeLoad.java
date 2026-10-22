package com.fl.saas.base.annotation;

import com.fl.saas.base.innterNative.NativeStyle;
import com.fl.saas.base.innterNative.NativeType;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MixNativeLoad {
    NativeStyle style() default NativeStyle.NONE;

    NativeType type() default NativeType.None;
}
