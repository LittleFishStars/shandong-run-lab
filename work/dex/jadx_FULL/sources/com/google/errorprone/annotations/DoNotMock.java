package com.google.errorprone.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface DoNotMock {
    String value() default "Create a real instance instead";
}
