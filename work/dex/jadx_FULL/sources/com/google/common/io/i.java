package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.io.Flushable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@Beta
@GwtIncompatible
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f32192a = Logger.getLogger(i.class.getName());

    public static void a(Flushable flushable, boolean z) throws IOException {
        try {
            flushable.flush();
        } catch (IOException e) {
            if (!z) {
                throw e;
            }
            f32192a.log(Level.WARNING, "IOException thrown while flushing Flushable.", (Throwable) e);
        }
    }

    public static void b(Flushable flushable) {
        try {
            a(flushable, true);
        } catch (IOException e) {
            f32192a.log(Level.SEVERE, "IOException should not have been thrown.", (Throwable) e);
        }
    }
}
