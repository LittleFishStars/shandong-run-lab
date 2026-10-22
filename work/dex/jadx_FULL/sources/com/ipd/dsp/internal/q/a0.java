package com.ipd.dsp.internal.q;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.components.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface a0 {

    public static final class a implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f38488a;
        public final List<ImageHeaderParser> b;
        public final com.ipd.dsp.internal.j.b c;

        public a(byte[] bArr, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
            this.f38488a = bArr;
            this.b = list;
            this.c = bVar;
        }

        @Override // com.ipd.dsp.internal.q.a0
        @Nullable
        public Bitmap a(BitmapFactory.Options options) {
            byte[] bArr = this.f38488a;
            return BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public void a() {
        }

        @Override // com.ipd.dsp.internal.q.a0
        public int b() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.a(this.b, ByteBuffer.wrap(this.f38488a), this.c);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.a(this.b, ByteBuffer.wrap(this.f38488a));
        }
    }

    public static final class b implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f38489a;
        public final List<ImageHeaderParser> b;
        public final com.ipd.dsp.internal.j.b c;

        public b(ByteBuffer byteBuffer, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
            this.f38489a = byteBuffer;
            this.b = list;
            this.c = bVar;
        }

        @Override // com.ipd.dsp.internal.q.a0
        @Nullable
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(d(), null, options);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public void a() {
        }

        @Override // com.ipd.dsp.internal.q.a0
        public int b() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.a(this.b, com.ipd.dsp.internal.d0.a.b(this.f38489a), this.c);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.a(this.b, com.ipd.dsp.internal.d0.a.b(this.f38489a));
        }

        public final InputStream d() {
            return com.ipd.dsp.internal.d0.a.d(com.ipd.dsp.internal.d0.a.b(this.f38489a));
        }
    }

    public static final class c implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final File f38490a;
        public final List<ImageHeaderParser> b;
        public final com.ipd.dsp.internal.j.b c;

        public c(File file, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
            this.f38490a = file;
            this.b = list;
            this.c = bVar;
        }

        @Override // com.ipd.dsp.internal.q.a0
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            e0 e0Var = new e0(new FileInputStream(this.f38490a), this.c);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(e0Var, null, options);
                e0Var.close();
                return bitmapDecodeStream;
            } catch (Throwable th) {
                try {
                    e0Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        @Override // com.ipd.dsp.internal.q.a0
        public void a() {
        }

        @Override // com.ipd.dsp.internal.q.a0
        public int b() throws IOException {
            e0 e0Var = new e0(new FileInputStream(this.f38490a), this.c);
            try {
                int iA = com.ipd.dsp.internal.components.glide.load.a.a(this.b, e0Var, this.c);
                e0Var.close();
                return iA;
            } catch (Throwable th) {
                try {
                    e0Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        @Override // com.ipd.dsp.internal.q.a0
        public ImageHeaderParser.ImageType c() throws IOException {
            e0 e0Var = new e0(new FileInputStream(this.f38490a), this.c);
            try {
                ImageHeaderParser.ImageType imageTypeB = com.ipd.dsp.internal.components.glide.load.a.b(this.b, e0Var, this.c);
                e0Var.close();
                return imageTypeB;
            } catch (Throwable th) {
                try {
                    e0Var.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
    }

    public static final class d implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.components.glide.load.data.c f38491a;
        public final com.ipd.dsp.internal.j.b b;
        public final List<ImageHeaderParser> c;

        public d(InputStream inputStream, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
            this.b = (com.ipd.dsp.internal.j.b) com.ipd.dsp.internal.d0.m.a(bVar);
            this.c = (List) com.ipd.dsp.internal.d0.m.a(list);
            this.f38491a = new com.ipd.dsp.internal.components.glide.load.data.c(inputStream, bVar);
        }

        @Override // com.ipd.dsp.internal.q.a0
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.f38491a.c(), null, options);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public int b() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.a(this.c, this.f38491a.c(), this.b);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.b(this.c, this.f38491a.c(), this.b);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public void a() {
            this.f38491a.a();
        }
    }

    public static final class e implements a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.ipd.dsp.internal.j.b f38492a;
        public final List<ImageHeaderParser> b;
        public final ParcelFileDescriptorRewinder c;

        public e(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
            this.f38492a = (com.ipd.dsp.internal.j.b) com.ipd.dsp.internal.d0.m.a(bVar);
            this.b = (List) com.ipd.dsp.internal.d0.m.a(list);
            this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // com.ipd.dsp.internal.q.a0
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.c.c().getFileDescriptor(), null, options);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public void a() {
        }

        @Override // com.ipd.dsp.internal.q.a0
        public int b() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.a(this.b, this.c, this.f38492a);
        }

        @Override // com.ipd.dsp.internal.q.a0
        public ImageHeaderParser.ImageType c() throws IOException {
            return com.ipd.dsp.internal.components.glide.load.a.b(this.b, this.c, this.f38492a);
        }
    }

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void a();

    int b() throws IOException;

    ImageHeaderParser.ImageType c() throws IOException;
}
