package com.igexin.push.core.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class a<T> {
    public final a<T> a(final a<? super T> aVar) {
        return new a<T>() { // from class: com.igexin.push.core.g.a.1
            @Override // com.igexin.push.core.g.a
            public final void a(T t) {
                a.this.a(t);
                a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(t);
                }
            }
        };
    }

    public abstract void a(T t);
}
