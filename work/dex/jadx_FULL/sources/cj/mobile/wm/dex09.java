package cj.mobile.wm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface dex09 {
    String[] ignores() default {};

    Class<?> mappingTo() default Void.class;

    com.wangmai.insightvision.openadsdk.d.g naming() default com.wangmai.insightvision.openadsdk.d.g.CamelCase;

    String[] orders() default {};

    com.wangmai.insightvision.openadsdk.d.i.d[] parseFeatures() default {};

    Class<?>[] seeAlso() default {};

    com.wangmai.insightvision.openadsdk.d.j.a0[] serialzeFeatures() default {};

    String typeKey() default "";

    String typeName() default "";
}
