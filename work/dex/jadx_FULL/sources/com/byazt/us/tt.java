package com.byazt.us;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 251, 13})
public class tt {
    public void c(@NonNull final com.byazt.dd.tt ttVar, @NonNull final sp spVar, int i) {
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.us.tt.1
            @Override // java.lang.Runnable
            public void run() {
                if (i.c(ttVar)) {
                    spVar.c(false);
                } else if (a.c(ttVar)) {
                    a.c(ttVar, new x() { // from class: com.byazt.us.tt.1.1
                        @Override // com.byazt.us.x
                        public void c(boolean z) {
                            spVar.c(z);
                        }
                    });
                } else {
                    spVar.c(false);
                }
            }
        }, i);
    }
}
