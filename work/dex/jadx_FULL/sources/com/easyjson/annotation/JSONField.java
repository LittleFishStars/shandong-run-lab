package com.easyjson.annotation;

import com.easyjson.parser.Feature;
import com.easyjson.serializer.SerializerFeature;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface JSONField {
    boolean deserialize() default true;

    String format() default "";

    String name() default "";

    int ordinal() default 0;

    Feature[] parseFeatures() default {};

    boolean serialize() default true;

    SerializerFeature[] serialzeFeatures() default {};
}
