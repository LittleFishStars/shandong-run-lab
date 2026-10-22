package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Target({})
@Retention(RetentionPolicy.CLASS)
public @interface Index {
    String name() default "";

    boolean unique() default false;

    String[] value();
}
