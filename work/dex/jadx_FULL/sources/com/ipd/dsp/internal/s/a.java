package com.ipd.dsp.internal.s;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.ipd.dsp.internal.components.glide.load.ImageHeaderParser;
import com.ipd.dsp.internal.d0.o;
import com.ipd.dsp.internal.f.i;
import com.ipd.dsp.internal.f.k;
import com.ipd.dsp.internal.i.v;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@RequiresApi(28)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ImageHeaderParser> f38527a;
    public final com.ipd.dsp.internal.j.b b;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.s.a$a, reason: collision with other inner class name */
    public static final class C0917a implements v<Drawable> {
        public static final int g = 2;
        public final AnimatedImageDrawable f;

        public C0917a(AnimatedImageDrawable animatedImageDrawable) {
            this.f = animatedImageDrawable;
        }

        @Override // com.ipd.dsp.internal.i.v
        @NonNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public AnimatedImageDrawable get() {
            return this.f;
        }

        @Override // com.ipd.dsp.internal.i.v
        public int c() {
            return this.f.getIntrinsicWidth() * this.f.getIntrinsicHeight() * o.a(Bitmap.Config.ARGB_8888) * 2;
        }

        @Override // com.ipd.dsp.internal.i.v
        @NonNull
        public Class<Drawable> d() {
            return Drawable.class;
        }

        @Override // com.ipd.dsp.internal.i.v
        public void e() {
            this.f.stop();
            this.f.clearAnimationCallbacks();
        }
    }

    public a(List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
        this.f38527a = list;
        this.b = bVar;
    }

    public static k<ByteBuffer, Drawable> a(List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
        return new b(new a(list, bVar));
    }

    public static k<InputStream, Drawable> b(List<ImageHeaderParser> list, com.ipd.dsp.internal.j.b bVar) {
        return new c(new a(list, bVar));
    }

    public static final class b implements k<ByteBuffer, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f38528a;

        public b(a aVar) {
            this.f38528a = aVar;
        }

        @Override // com.ipd.dsp.internal.f.k
        public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull i iVar) throws IOException {
            return this.f38528a.a(byteBuffer);
        }

        @Override // com.ipd.dsp.internal.f.k
        public v<Drawable> a(@NonNull ByteBuffer byteBuffer, int i, int i2, @NonNull i iVar) throws IOException {
            return this.f38528a.a(ImageDecoder.createSource(byteBuffer), i, i2, iVar);
        }
    }

    public static final class c implements k<InputStream, Drawable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f38529a;

        public c(a aVar) {
            this.f38529a = aVar;
        }

        @Override // com.ipd.dsp.internal.f.k
        public boolean a(@NonNull InputStream inputStream, @NonNull i iVar) throws IOException {
            return this.f38529a.a(inputStream);
        }

        @Override // com.ipd.dsp.internal.f.k
        public v<Drawable> a(@NonNull InputStream inputStream, int i, int i2, @NonNull i iVar) throws IOException {
            return this.f38529a.a(ImageDecoder.createSource(com.ipd.dsp.internal.d0.a.a(inputStream)), i, i2, iVar);
        }
    }

    public boolean a(ByteBuffer byteBuffer) throws IOException {
        return a(com.ipd.dsp.internal.components.glide.load.a.a(this.f38527a, byteBuffer));
    }

    public boolean a(InputStream inputStream) throws IOException {
        return a(com.ipd.dsp.internal.components.glide.load.a.b(this.f38527a, inputStream, this.b));
    }

    public final boolean a(ImageHeaderParser.ImageType imageType) {
        if (imageType != ImageHeaderParser.ImageType.ANIMATED_WEBP) {
            return Build.VERSION.SDK_INT >= 31 && imageType == ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        return true;
    }

    public v<Drawable> a(@NonNull ImageDecoder.Source source, int i, int i2, @NonNull i iVar) throws IOException {
        Drawable drawableDecodeDrawable = ImageDecoder.decodeDrawable(source, new com.ipd.dsp.internal.p.a(i, i2, iVar));
        if (drawableDecodeDrawable instanceof AnimatedImageDrawable) {
            return new C0917a((AnimatedImageDrawable) drawableDecodeDrawable);
        }
        throw new IOException("Received unexpected drawable type for animated image, failing: " + drawableDecodeDrawable);
    }
}
