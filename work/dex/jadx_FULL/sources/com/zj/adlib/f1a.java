package com.zj.adlib;

import com.facebook.cache.common.WriterCallback;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f1a {

    public static class a implements WriterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f41570a;

        public a(InputStream inputStream) {
            this.f41570a = inputStream;
        }

        @Override // com.facebook.cache.common.WriterCallback
        public void b(OutputStream outputStream) throws IOException {
            s51.a(this.f41570a, outputStream);
        }
    }

    public static class b implements WriterCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f41571a;

        public b(byte[] bArr) {
            this.f41571a = bArr;
        }

        @Override // com.facebook.cache.common.WriterCallback
        public void b(OutputStream outputStream) throws IOException {
            outputStream.write(this.f41571a);
        }
    }

    public static WriterCallback a(InputStream inputStream) {
        return new a(inputStream);
    }

    public static WriterCallback b(byte[] bArr) {
        return new b(bArr);
    }
}
