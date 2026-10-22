package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public UncheckedTimeoutException() {
    }

    public UncheckedTimeoutException(@CheckForNull String str) {
        super(str);
    }

    public UncheckedTimeoutException(@CheckForNull Throwable th) {
        super(th);
    }

    public UncheckedTimeoutException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }
}
