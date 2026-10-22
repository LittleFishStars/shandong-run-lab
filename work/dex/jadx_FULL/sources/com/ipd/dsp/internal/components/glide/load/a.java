package com.ipd.dsp.internal.components.glide.load;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.internal.components.glide.load.data.ParcelFileDescriptorRewinder;
import com.ipd.dsp.internal.q.e0;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f38250a = 5242880;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.components.glide.load.a$a, reason: collision with other inner class name */
    public class C0869a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f38251a;

        public C0869a(InputStream inputStream) {
            this.f38251a = inputStream;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f38251a);
            } finally {
                this.f38251a.reset();
            }
        }
    }

    public class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f38252a;

        public b(ByteBuffer byteBuffer) {
            this.f38252a = byteBuffer;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f38252a);
            } finally {
                com.ipd.dsp.internal.d0.a.b(this.f38252a);
            }
        }
    }

    public class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f38253a;
        public final /* synthetic */ com.ipd.dsp.internal.j.b b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.ipd.dsp.internal.j.b bVar) {
            this.f38253a = parcelFileDescriptorRewinder;
            this.b = bVar;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.a.h
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            e0 e0Var;
            try {
                e0Var = new e0(new FileInputStream(this.f38253a.c().getFileDescriptor()), this.b);
                try {
                    ImageHeaderParser.ImageType imageTypeA = imageHeaderParser.a(e0Var);
                    e0Var.b();
                    this.f38253a.c();
                    return imageTypeA;
                } catch (Throwable th) {
                    th = th;
                    if (e0Var != null) {
                        e0Var.b();
                    }
                    this.f38253a.c();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                e0Var = null;
            }
        }
    }

    public class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ByteBuffer f38254a;
        public final /* synthetic */ com.ipd.dsp.internal.j.b b;

        public d(ByteBuffer byteBuffer, com.ipd.dsp.internal.j.b bVar) {
            this.f38254a = byteBuffer;
            this.b = bVar;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f38254a, this.b);
            } finally {
                com.ipd.dsp.internal.d0.a.b(this.f38254a);
            }
        }
    }

    public class e implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InputStream f38255a;
        public final /* synthetic */ com.ipd.dsp.internal.j.b b;

        public e(InputStream inputStream, com.ipd.dsp.internal.j.b bVar) {
            this.f38255a = inputStream;
            this.b = bVar;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.a(this.f38255a, this.b);
            } finally {
                this.f38255a.reset();
            }
        }
    }

    public class f implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ParcelFileDescriptorRewinder f38256a;
        public final /* synthetic */ com.ipd.dsp.internal.j.b b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, com.ipd.dsp.internal.j.b bVar) {
            this.f38256a = parcelFileDescriptorRewinder;
            this.b = bVar;
        }

        @Override // com.ipd.dsp.internal.components.glide.load.a.g
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            e0 e0Var;
            try {
                e0Var = new e0(new FileInputStream(this.f38256a.c().getFileDescriptor()), this.b);
                try {
                    int iA = imageHeaderParser.a(e0Var, this.b);
                    e0Var.b();
                    this.f38256a.c();
                    return iA;
                } catch (Throwable th) {
                    th = th;
                    if (e0Var != null) {
                        e0Var.b();
                    }
                    this.f38256a.c();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                e0Var = null;
            }
        }
    }

    public interface g {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    public interface h {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    @NonNull
    public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : a(list, new b(byteBuffer));
    }

    @NonNull
    public static ImageHeaderParser.ImageType b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new C0869a(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType a(@NonNull List<ImageHeaderParser> list, h hVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            ImageHeaderParser.ImageType imageTypeA = hVar.a(list.get(i));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType b(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        return a(list, new c(parcelFileDescriptorRewinder, bVar));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        if (byteBuffer == null) {
            return -1;
        }
        return a(list, new d(byteBuffer, bVar));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new e0(inputStream, bVar);
        }
        inputStream.mark(5242880);
        return a(list, new e(inputStream, bVar));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull com.ipd.dsp.internal.j.b bVar) throws IOException {
        return a(list, new f(parcelFileDescriptorRewinder, bVar));
    }

    public static int a(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int iA = gVar.a(list.get(i));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }
}
