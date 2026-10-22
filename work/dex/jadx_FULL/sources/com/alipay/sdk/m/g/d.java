package com.alipay.sdk.m.g;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d implements i, j {
    @Override // com.alipay.sdk.m.g.j
    public Object a(Object obj) {
        return ((Enum) obj).name();
    }

    @Override // com.alipay.sdk.m.g.i
    public Object a(Object obj, Type type) {
        return Enum.valueOf((Class) type, obj.toString());
    }

    @Override // com.alipay.sdk.m.g.i, com.alipay.sdk.m.g.j
    public boolean a(Class<?> cls) {
        return Enum.class.isAssignableFrom(cls);
    }
}
