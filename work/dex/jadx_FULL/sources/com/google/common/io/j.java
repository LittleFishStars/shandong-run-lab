package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.nio.Buffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class j {
    public static void a(Buffer buffer) {
        buffer.clear();
    }

    public static void b(Buffer buffer) {
        buffer.flip();
    }

    public static void c(Buffer buffer, int i) {
        buffer.limit(i);
    }

    public static void d(Buffer buffer) {
        buffer.mark();
    }

    public static void e(Buffer buffer, int i) {
        buffer.position(i);
    }

    public static void f(Buffer buffer) {
        buffer.reset();
    }
}
