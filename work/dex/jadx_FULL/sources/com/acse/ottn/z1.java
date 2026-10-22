package com.acse.ottn;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class z1<T> extends k3<T, Integer> {
    public z1(String str) {
        super(Integer.class, str);
    }

    public abstract void a(T t, int i);

    @Override // com.acse.ottn.k3
    public final void a(T t, Integer num) {
        a((Object) t, Integer.valueOf(num.intValue()));
    }
}
