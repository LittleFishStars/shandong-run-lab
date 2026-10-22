package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedExecutionException() {
    }

    public UncheckedExecutionException(@CheckForNull String str) {
        super(str);
    }

    public UncheckedExecutionException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(@CheckForNull Throwable th) {
        super(th);
    }
}
