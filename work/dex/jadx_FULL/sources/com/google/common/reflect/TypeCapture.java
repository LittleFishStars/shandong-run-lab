package com.google.common.reflect;

import com.google.common.base.i;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
abstract class TypeCapture<T> {
    public final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        i.u(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
