package com.facebook.imagepipeline.nativecode;

import com.facebook.common.internal.DoNotStrip;
import com.zj.adlib.ax6;
import com.zj.adlib.v74;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@DoNotStrip
public class JpegTranscoder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30001a = 0;
    public static final int b = 100;
    public static final int c = 1;
    public static final int d = 16;
    public static final int e = 8;

    static {
        v74.a();
    }

    public static boolean a(int i) {
        return i >= 0 && i <= 270 && i % 90 == 0;
    }

    public static void b(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException {
        ax6.d(i2 >= 1);
        ax6.d(i2 <= 16);
        ax6.d(i3 >= 0);
        ax6.d(i3 <= 100);
        ax6.d(a(i));
        ax6.e((i2 == 8 && i == 0) ? false : true, "no transformation requested");
        nativeTranscodeJpeg((InputStream) ax6.i(inputStream), (OutputStream) ax6.i(outputStream), i, i2, i3);
    }

    @DoNotStrip
    private static native void nativeTranscodeJpeg(InputStream inputStream, OutputStream outputStream, int i, int i2, int i3) throws IOException;
}
