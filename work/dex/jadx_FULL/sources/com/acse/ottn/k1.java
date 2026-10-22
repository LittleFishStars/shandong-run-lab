package com.acse.ottn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class k1<T> extends k3<T, Float> {
    public k1(String str) {
        super(Float.class, str);
    }

    public abstract void a(T t, float f);

    @Override // com.acse.ottn.k3
    public final void a(T t, Float f) {
        a(t, f.floatValue());
    }
}
