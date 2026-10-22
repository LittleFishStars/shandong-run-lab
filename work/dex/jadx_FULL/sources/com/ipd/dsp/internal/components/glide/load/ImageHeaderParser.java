package com.ipd.dsp.internal.components.glide.load;

import androidx.annotation.NonNull;
import com.ipd.dsp.internal.j.b;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public interface ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38248a = -1;

    public enum ImageType {
        GIF(true),
        JPEG(false),
        RAW(false),
        PNG_A(true),
        PNG(false),
        WEBP_A(true),
        WEBP(false),
        ANIMATED_WEBP(true),
        AVIF(true),
        ANIMATED_AVIF(true),
        UNKNOWN(false);

        public final boolean f;

        ImageType(boolean z) {
            this.f = z;
        }

        public boolean hasAlpha() {
            return this.f;
        }

        public boolean isWebp() {
            int i = a.f38249a[ordinal()];
            return i == 1 || i == 2 || i == 3;
        }
    }

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f38249a;

        static {
            int[] iArr = new int[ImageType.values().length];
            f38249a = iArr;
            try {
                iArr[ImageType.WEBP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38249a[ImageType.WEBP_A.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38249a[ImageType.ANIMATED_WEBP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    int a(@NonNull InputStream inputStream, @NonNull b bVar) throws IOException;

    int a(@NonNull ByteBuffer byteBuffer, @NonNull b bVar) throws IOException;

    @NonNull
    ImageType a(@NonNull InputStream inputStream) throws IOException;

    @NonNull
    ImageType a(@NonNull ByteBuffer byteBuffer) throws IOException;
}
