package com.ipd.dsp.internal.n;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class e<Model, Data> implements o<Model, Data> {
    public static final String b = "data:image";
    public static final String c = ";base64";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a<Data> f38420a;

    public interface a<Data> {
        Class<Data> a();

        Data a(String str) throws IllegalArgumentException;

        void a(Data data) throws IOException;
    }

    public static final class c<Model> implements p<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a<InputStream> f38421a = new a();

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<Model, InputStream> a(@NonNull s sVar) {
            return new e(this.f38421a);
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }

        public class a implements a<InputStream> {
            public a() {
            }

            @Override // com.ipd.dsp.internal.n.e.a
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(String str) {
                if (!str.startsWith(e.b)) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(e.c)) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }

            @Override // com.ipd.dsp.internal.n.e.a
            public void a(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // com.ipd.dsp.internal.n.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }
    }

    public e(a<Data> aVar) {
        this.f38420a = aVar;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<Data> a(@NonNull Model model, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(model), new b(model.toString(), this.f38420a));
    }

    public static final class b<Data> implements com.ipd.dsp.internal.g.d<Data> {
        public final String f;
        public final a<Data> g;
        public Data h;

        public b(String str, a<Data> aVar) {
            this.f = str;
            this.g = aVar;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super Data> aVar) {
            try {
                Data dataA = this.g.a(this.f);
                this.h = dataA;
                aVar.a(dataA);
            } catch (IllegalArgumentException e) {
                aVar.onLoadFailed(e);
            }
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
            try {
                this.g.a(this.h);
            } catch (IOException unused) {
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

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith(b);
    }
}
