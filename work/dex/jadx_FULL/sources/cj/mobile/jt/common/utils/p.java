package cj.mobile.jt.common.utils;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class p {
    public static final int b;
    public static final int c;
    public static final LinkedBlockingQueue d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f22399a;

    static {
        int iMax = Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4));
        b = iMax;
        c = iMax * 2;
        d = new LinkedBlockingQueue(128);
    }
}
