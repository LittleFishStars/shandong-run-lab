package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public final class k {
    @ParametricNullness
    public static <T> T a(@CheckForNull T t) {
        return t;
    }

    @ParametricNullness
    public static <T> T b() {
        return null;
    }
}
