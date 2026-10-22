package com.ipd.dsp.internal.n;

import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class g<Data> implements o<File, Data> {
    public static final String b = "FileLoader";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d<Data> f38427a;

    public static class a<Data> implements p<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<Data> f38428a;

        public a(d<Data> dVar) {
            this.f38428a = dVar;
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public final o<File, Data> a(@NonNull s sVar) {
            return new g(this.f38428a);
        }

        @Override // com.ipd.dsp.internal.n.p
        public final void b() {
        }
    }

    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new a());
        }

        public class a implements d<ParcelFileDescriptor> {
            @Override // com.ipd.dsp.internal.n.g.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // com.ipd.dsp.internal.n.g.d
            public void a(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // com.ipd.dsp.internal.n.g.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }
        }
    }

    public interface d<Data> {
        Class<Data> a();

        Data a(File file) throws FileNotFoundException;

        void a(Data data) throws IOException;
    }

    public static class e extends a<InputStream> {
        public e() {
            super(new a());
        }

        public class a implements d<InputStream> {
            @Override // com.ipd.dsp.internal.n.g.d
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // com.ipd.dsp.internal.n.g.d
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.ipd.dsp.internal.n.g.d
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }
    }

    public g(d<Data> dVar) {
        this.f38427a = dVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull File file, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(file), new c(file, this.f38427a));
    }

    public static final class c<Data> implements com.ipd.dsp.internal.g.d<Data> {
        public final File f;
        public final d<Data> g;
        public Data h;

        public c(File file, d<Data> dVar) {
            this.f = file;
            this.g = dVar;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super Data> aVar) {
            try {
                Data dataA = this.g.a(this.f);
                this.h = dataA;
                aVar.a(dataA);
            } catch (FileNotFoundException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(g.b, "Failed to open file", e);
                }
                aVar.onLoadFailed(e);
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
            Data data = this.h;
            if (data != null) {
                try {
                    this.g.a(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public com.ipd.dsp.internal.f.a c() {
            return com.ipd.dsp.internal.f.a.LOCAL;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void cancel() {
        }

        @Override // com.ipd.dsp.internal.g.d
        @NonNull
        public Class<Data> a() {
            return this.g.a();
        }
    }
}
