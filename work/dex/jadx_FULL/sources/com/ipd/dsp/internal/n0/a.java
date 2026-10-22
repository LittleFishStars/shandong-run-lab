package com.ipd.dsp.internal.n0;

import android.content.Context;
import android.net.Uri;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a {

    /* JADX INFO: renamed from: com.ipd.dsp.internal.n0.a$a, reason: collision with other inner class name */
    public interface InterfaceC0905a {
        a a(Context context, Uri uri, int i) throws FileNotFoundException;

        a a(Context context, File file, int i) throws FileNotFoundException;

        boolean a();
    }

    void a() throws IOException;

    void a(long j) throws IOException;

    void b(long j) throws IOException;

    void close() throws IOException;

    void write(byte[] bArr, int i, int i2) throws IOException;
}
