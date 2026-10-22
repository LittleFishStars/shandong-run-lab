package com.zj.adlib;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class e8c extends k7c {
    public e8c() {
        super(4);
    }

    @CanIgnoreReturnValue
    public final e8c c(Object obj) {
        super.a(obj);
        return this;
    }

    @CanIgnoreReturnValue
    public final e8c d(Iterator it) {
        while (it.hasNext()) {
            super.a(it.next());
        }
        return this;
    }

    public e8c(int i) {
        super(4);
    }
}
