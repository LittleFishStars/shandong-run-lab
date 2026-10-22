package com.byazt.vm;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 165, 13})
public abstract class tt<T> {
    public volatile T c;

    public abstract T c(Object... objArr);

    public final T tt(Object... objArr) {
        if (this.c == null) {
            synchronized (this) {
                if (this.c == null) {
                    this.c = c(objArr);
                }
            }
        }
        return this.c;
    }
}
