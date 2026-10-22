package androidx.coroutines;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Target({ElementType.ANNOTATION_TYPE})
public @interface BindingMethod {
    String attribute();

    String method();

    Class type();
}
