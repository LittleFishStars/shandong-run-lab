package com.byazt.zr;

import android.util.SparseArray;
import com.byazt.fy.ve;
import com.byazt.yxi.uj;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1673, 20})
public class c {
    public static ve c(final Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            return new ve() { // from class: com.byazt.zr.c.1
                @Override // com.byazt.me.n
                public void c(long j) {
                    function.apply(uj.c().c(8166).c(Void.class).c(8074, Long.valueOf(j)).tt());
                }

                @Override // com.byazt.me.n
                public void tt(long j) {
                    function.apply(uj.c().c(8167).c(Void.class).c(8074, Long.valueOf(j)).tt());
                }

                @Override // com.byazt.me.n
                public void ve(long j) {
                    function.apply(uj.c().c(8169).c(Void.class).c(8074, Long.valueOf(j)).tt());
                }

                @Override // com.byazt.me.n
                public void c() {
                    function.apply(uj.c().c(8168).c(Void.class).tt());
                }

                @Override // com.byazt.me.n
                public void tt() {
                    function.apply(uj.c().c(8170).c(Void.class).tt());
                }

                @Override // com.byazt.me.n
                public void c(int i, int i2) {
                    function.apply(uj.c().c(8171).c(Void.class).c(8014, Integer.valueOf(i)).c(8075, Integer.valueOf(i2)).tt());
                }

                @Override // com.byazt.me.n
                public void c(long j, int i, int i2) {
                    function.apply(uj.c().c(8172).c(Void.class).c(8014, Integer.valueOf(i)).c(8075, Integer.valueOf(i2)).c(8074, Long.valueOf(j)).tt());
                }
            };
        }
        return null;
    }
}
