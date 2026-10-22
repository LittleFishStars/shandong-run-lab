package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b<Data> implements o<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0903b<Data> f38415a;

    public static class a implements p<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: com.ipd.dsp.internal.n.b$a$a, reason: collision with other inner class name */
        public class C0902a implements InterfaceC0903b<ByteBuffer> {
            public C0902a() {
            }

            @Override // com.ipd.dsp.internal.n.b.InterfaceC0903b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // com.ipd.dsp.internal.n.b.InterfaceC0903b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<byte[], ByteBuffer> a(@NonNull s sVar) {
            return new b(new C0902a());
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    /* JADX INFO: renamed from: com.ipd.dsp.internal.n.b$b, reason: collision with other inner class name */
    public interface InterfaceC0903b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    public static class d implements p<byte[], InputStream> {

        public class a implements InterfaceC0903b<InputStream> {
            public a() {
            }

            @Override // com.ipd.dsp.internal.n.b.InterfaceC0903b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // com.ipd.dsp.internal.n.b.InterfaceC0903b
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<byte[], InputStream> a(@NonNull s sVar) {
            return new b(new a());
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    public b(InterfaceC0903b<Data> interfaceC0903b) {
        this.f38415a = interfaceC0903b;
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }

    public static class c<Data> implements com.ipd.dsp.internal.g.d<Data> {
        public final byte[] f;
        public final InterfaceC0903b<Data> g;

        public c(byte[] bArr, InterfaceC0903b<Data> interfaceC0903b) {
            this.f = bArr;
            this.g = interfaceC0903b;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super Data> aVar) {
            aVar.a(this.g.a(this.f));
        }

        @Override // com.ipd.dsp.internal.g.d
        public void b() {
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
    public o.a<Data> a(@NonNull byte[] bArr, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(bArr), new c(bArr, this.f38415a));
    }
}
