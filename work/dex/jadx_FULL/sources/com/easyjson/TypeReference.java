package com.easyjson;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class TypeReference<T> {
    protected final Type type = ((ParameterizedType) TypeReference.class.getGenericSuperclass()).getActualTypeArguments()[0];

    public Type getType() {
        return this.type;
    }
}
