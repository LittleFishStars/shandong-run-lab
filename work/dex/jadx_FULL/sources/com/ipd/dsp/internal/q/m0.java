package com.ipd.dsp.internal.q;

import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class m0<T> implements com.ipd.dsp.internal.f.k<T, Bitmap> {
    public static final String d = "VideoDecoder";
    public static final long e = -1;

    @VisibleForTesting
    public static final int f = 2;
    public static final com.ipd.dsp.internal.f.h<Long> g = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final com.ipd.dsp.internal.f.h<Integer> h = com.ipd.dsp.internal.f.h.a("com.ipd.dsp.internal.components.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    public static final f i = new f();
    public static final List<String> j = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));
    public static final String k = "video/webm";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<T> f38506a;
    public final com.ipd.dsp.internal.j.e b;
    public final f c;

    public class a implements com.ipd.dsp.internal.f.h.b<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f38507a = ByteBuffer.allocate(8);

        @Override // com.ipd.dsp.internal.f.h.b
        public void a(@NonNull byte[] bArr, @NonNull Long l, @NonNull MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.f38507a) {
                this.f38507a.position(0);
                messageDigest.update(this.f38507a.putLong(l.longValue()).array());
            }
        }
    }

    public class b implements com.ipd.dsp.internal.f.h.b<Integer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f38508a = ByteBuffer.allocate(4);

        @Override // com.ipd.dsp.internal.f.h.b
        public void a(@NonNull byte[] bArr, @NonNull Integer num, @NonNull MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.f38508a) {
                this.f38508a.position(0);
                messageDigest.update(this.f38508a.putInt(num.intValue()).array());
            }
        }
    }

    @RequiresApi(16)
    public static final class c implements e<AssetFileDescriptor> {
        public c() {
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @Override // com.ipd.dsp.internal.q.m0.e
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // com.ipd.dsp.internal.q.m0.e
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
    }

    @VisibleForTesting
    public interface e<T> {
        @RequiresApi(16)
        void a(MediaExtractor mediaExtractor, T t) throws IOException;

        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    @VisibleForTesting
    public static class f {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    public static final class h extends RuntimeException {
        public static final long f = -2556382523004027815L;

        public h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public m0(com.ipd.dsp.internal.j.e eVar, e<T> eVar2) {
        this(eVar, eVar2, i);
    }

    public static com.ipd.dsp.internal.f.k<AssetFileDescriptor, Bitmap> a(com.ipd.dsp.internal.j.e eVar) {
        return new m0(eVar, new c(null));
    }

    @RequiresApi(api = 23)
    public static com.ipd.dsp.internal.f.k<ByteBuffer, Bitmap> b(com.ipd.dsp.internal.j.e eVar) {
        return new m0(eVar, new d());
    }

    public static com.ipd.dsp.internal.f.k<ParcelFileDescriptor, Bitmap> c(com.ipd.dsp.internal.j.e eVar) {
        return new m0(eVar, new g());
    }

    @Override // com.ipd.dsp.internal.f.k
    public boolean a(@NonNull T t, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return true;
    }

    @RequiresApi(23)
    public static final class d implements e<ByteBuffer> {

        public class a extends MediaDataSource {
            public final /* synthetic */ ByteBuffer f;

            public a(ByteBuffer byteBuffer) {
                this.f = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.f.limit()) {
                    return -1;
                }
                this.f.position((int) j);
                int iMin = Math.min(i2, this.f.remaining());
                this.f.get(bArr, i, iMin);
                return iMin;
            }
        }

        @Override // com.ipd.dsp.internal.q.m0.e
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(a(byteBuffer));
        }

        @Override // com.ipd.dsp.internal.q.m0.e
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(a(byteBuffer));
        }

        public final MediaDataSource a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }
    }

    public static final class g implements e<ParcelFileDescriptor> {
        @Override // com.ipd.dsp.internal.q.m0.e
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // com.ipd.dsp.internal.q.m0.e
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    @VisibleForTesting
    public m0(com.ipd.dsp.internal.j.e eVar, e<T> eVar2, f fVar) {
        this.b = eVar;
        this.f38506a = eVar2;
        this.c = fVar;
    }

    public static boolean b() {
        Iterator<String> it = j.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.ipd.dsp.internal.f.k
    public com.ipd.dsp.internal.i.v<Bitmap> a(@NonNull T t, int i2, int i3, @NonNull com.ipd.dsp.internal.f.i iVar) throws IOException {
        long jLongValue = ((Long) iVar.a(g)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + jLongValue);
        }
        Integer num = (Integer) iVar.a(h);
        if (num == null) {
            num = 2;
        }
        q qVar = (q) iVar.a(q.h);
        if (qVar == null) {
            qVar = q.g;
        }
        q qVar2 = qVar;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.c.a();
        try {
            this.f38506a.a(mediaMetadataRetrieverA, t);
            return com.ipd.dsp.internal.q.g.a(a(t, mediaMetadataRetrieverA, jLongValue, num.intValue(), i2, i3, qVar2), this.b);
        } finally {
            if (Build.VERSION.SDK_INT >= 29) {
                mediaMetadataRetrieverA.close();
            } else {
                mediaMetadataRetrieverA.release();
            }
        }
    }

    @Nullable
    public final Bitmap a(@NonNull T t, MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, q qVar) {
        if (!a(t, mediaMetadataRetriever)) {
            Bitmap bitmapA = (Build.VERSION.SDK_INT < 27 || i3 == Integer.MIN_VALUE || i4 == Integer.MIN_VALUE || qVar == q.f) ? null : a(mediaMetadataRetriever, j2, i2, i3, i4, qVar);
            if (bitmapA == null) {
                bitmapA = a(mediaMetadataRetriever, j2, i2);
            }
            Bitmap bitmapA2 = a(mediaMetadataRetriever, bitmapA);
            if (bitmapA2 != null) {
                return bitmapA2;
            }
            throw new h();
        }
        throw new IllegalStateException("Cannot decode VP8 video on CrOS.");
    }

    @TargetApi(30)
    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (a()) {
            try {
                if (!a(mediaMetadataRetriever) || Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                    return bitmap;
                }
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(d, "Applying HDR 180 deg thumbnail correction");
                }
                Matrix matrix = new Matrix();
                matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (NumberFormatException unused) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(d, "Exception trying to extract HDR transfer function or rotation");
                }
            }
        }
        return bitmap;
    }

    @RequiresApi(30)
    public static boolean a(MediaMetadataRetriever mediaMetadataRetriever) throws NumberFormatException {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i2 = Integer.parseInt(strExtractMetadata);
        return (i2 == 7 || i2 == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    @VisibleForTesting
    public static boolean a() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return b();
        }
        int i2 = Build.VERSION.SDK_INT;
        return i2 >= 30 && i2 < 33;
    }

    @Nullable
    @TargetApi(27)
    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2, int i3, int i4, q qVar) {
        try {
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i7 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i7 == 90 || i7 == 270) {
                i6 = i5;
                i5 = i6;
            }
            float fB = qVar.b(i5, i6, i3, i4);
            return mediaMetadataRetriever.getScaledFrameAtTime(j2, i2, Math.round(i5 * fB), Math.round(fB * i6));
        } catch (Throwable th) {
            if (!Dsp.isDebugLogEnable()) {
                return null;
            }
            com.ipd.dsp.internal.c2.k.a(d, "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j2, int i2) {
        return mediaMetadataRetriever.getFrameAtTime(j2, i2);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0057 A[Catch: all -> 0x0064, TRY_LEAVE, TryCatch #0 {all -> 0x0064, blocks: (B:23:0x0051, B:25:0x0057), top: B:34:0x0051 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0060 A[DONT_GENERATE] */
    public final boolean a(@NonNull T t, MediaMetadataRetriever mediaMetadataRetriever) {
        MediaExtractor mediaExtractor;
        String str = Build.DEVICE;
        if (str == null || !str.matches(".+_cheets|cheets_.+")) {
            return false;
        }
        try {
            try {
                if (!"video/webm".equals(mediaMetadataRetriever.extractMetadata(12))) {
                    return false;
                }
                mediaExtractor = new MediaExtractor();
                try {
                    this.f38506a.a(mediaExtractor, t);
                    int trackCount = mediaExtractor.getTrackCount();
                    for (int i2 = 0; i2 < trackCount; i2++) {
                        if ("video/x-vnd.on2.vp8".equals(mediaExtractor.getTrackFormat(i2).getString("mime"))) {
                            mediaExtractor.release();
                            return true;
                        }
                    }
                    mediaExtractor.release();
                } catch (Throwable th) {
                    th = th;
                    if (Dsp.isDebugLogEnable()) {
                        com.ipd.dsp.internal.c2.k.a(d, "Exception trying to extract track info for a webm video on CrOS.", th);
                    }
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                mediaExtractor = null;
            }
            if (Dsp.isDebugLogEnable()) {
                com.ipd.dsp.internal.c2.k.a(d, "Exception trying to extract track info for a webm video on CrOS.", th);
            }
            return false;
        } finally {
            if (mediaExtractor != null) {
                mediaExtractor.release();
            }
        }
    }
}
