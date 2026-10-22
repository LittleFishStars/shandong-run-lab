package com.ipd.dsp.internal.n;

import androidx.annotation.NonNull;
import com.ipd.dsp.Dsp;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class d implements o<File, ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38419a = "ByteBufferFileLoader";

    public static class b implements p<File, ByteBuffer> {
        @Override // com.ipd.dsp.internal.n.p
        @NonNull
        public o<File, ByteBuffer> a(@NonNull s sVar) {
            return new d();
        }

        @Override // com.ipd.dsp.internal.n.p
        public void b() {
        }
    }

    @Override // com.ipd.dsp.internal.n.o
    public boolean a(@NonNull File file) {
        return true;
    }

    @Override // com.ipd.dsp.internal.n.o
    public o.a<ByteBuffer> a(@NonNull File file, int i, int i2, @NonNull com.ipd.dsp.internal.f.i iVar) {
        return new o.a<>(new com.ipd.dsp.internal.c0.e(file), new a(file));
    }

    public static final class a implements com.ipd.dsp.internal.g.d<ByteBuffer> {
        public final File f;

        public a(File file) {
            this.f = file;
        }

        @Override // com.ipd.dsp.internal.g.d
        public void a(@NonNull com.ipd.dsp.internal.b.e eVar, @NonNull com.ipd.dsp.internal.g.d.a<? super ByteBuffer> aVar) {
            try {
                aVar.a(com.ipd.dsp.internal.d0.a.a(this.f));
            } catch (IOException e) {
                if (Dsp.isDebugLogEnable()) {
                    com.ipd.dsp.internal.c2.k.a(d.f38419a, "Failed to obtain ByteBuffer for file", e);
                }
                aVar.onLoadFailed(e);
            }
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
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }
}
