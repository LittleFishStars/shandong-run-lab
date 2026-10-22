package com.facebook.imagepipeline.nativecode;

import com.facebook.imageformat.ImageFormat;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface WebpTranscoder {
    void a(InputStream inputStream, OutputStream outputStream, int i) throws IOException;

    void b(InputStream inputStream, OutputStream outputStream) throws IOException;

    boolean c(ImageFormat imageFormat);
}
