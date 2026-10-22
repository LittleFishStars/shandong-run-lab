package com.byazt.jb;

import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 63, 133})
public final class z extends IOException {
    public final tt c;

    public z(tt ttVar) {
        super("stream was reset: ".concat(String.valueOf(ttVar)));
        this.c = ttVar;
    }
}
