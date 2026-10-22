package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class tm1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final Logger f44950a = Logger.getLogger(tm1.class.getName());

    public static void a(@Nullable Closeable closeable, boolean z) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (!z) {
                throw e;
            }
            f44950a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
        }
    }

    public static void b(@Nullable InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    public static void c(@Nullable Reader reader) {
        try {
            a(reader, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
