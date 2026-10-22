package cj.mobile.wm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface dex08 {
    String[] alternateNames() default {};

    boolean deserialize() default true;

    String format() default "";

    String name() default "";

    int ordinal() default 0;

    boolean serialize() default true;

    com.wangmai.insightvision.openadsdk.d.j.a0[] serialzeFeatures() default {};
}
