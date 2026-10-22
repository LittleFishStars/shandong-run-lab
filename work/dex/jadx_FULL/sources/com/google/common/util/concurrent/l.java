package com.google.common.util.concurrent;

import java.util.concurrent.locks.LockSupport;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final long f32437a = 2147483647999999999L;

    public static void a(@CheckForNull Object obj, long j) {
        LockSupport.parkNanos(obj, Math.min(j, f32437a));
    }
}
