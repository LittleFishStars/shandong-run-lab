package com.byazt.iu;

import com.byazt.bzd.x;
import com.byazt.ete.ic;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 127, 34})
public class a<T> implements n<T> {
    public final n<T> c;

    public a(n<T> nVar) {
        this.c = nVar;
    }

    @Override // com.byazt.iu.n
    public void c(final T t, final boolean z, final ic icVar) {
        x.c(new Runnable() { // from class: com.byazt.iu.a.1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c != null) {
                    a.this.c.c(t, z, icVar);
                }
            }
        });
    }

    @Override // com.byazt.iu.n
    public void c(final T t) {
        x.c(new Runnable() { // from class: com.byazt.iu.a.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c != null) {
                    a.this.c.c(t);
                }
            }
        });
    }

    @Override // com.byazt.iu.n
    public void c(final int i, final String str) {
        x.c(new Runnable() { // from class: com.byazt.iu.a.3
            @Override // java.lang.Runnable
            public void run() {
                if (a.this.c != null) {
                    a.this.c.c(i, str);
                }
            }
        });
    }
}
