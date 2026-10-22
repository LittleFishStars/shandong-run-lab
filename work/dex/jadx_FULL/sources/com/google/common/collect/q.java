package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class q {
    @ParametricNullness
    public static <T> T a(@CheckForNull T t) {
        return t;
    }

    @ParametricNullness
    public static <T> T b() {
        return null;
    }
}
