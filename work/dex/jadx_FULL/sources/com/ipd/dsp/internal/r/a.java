package com.ipd.dsp.internal.r;

import androidx.annotation.NonNull;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a implements com.ipd.dsp.internal.components.glide.load.data.a<ByteBuffer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f38524a;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.r.a$a, reason: collision with other inner class name */
    public static class C0913a implements com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a<ByteBuffer> {
        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public com.ipd.dsp.internal.components.glide.load.data.a<ByteBuffer> a(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // com.ipd.dsp.internal.components.glide.load.data.a.InterfaceC0870a
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }
    }

    public a(ByteBuffer byteBuffer) {
        this.f38524a = byteBuffer;
    }

    @Override // com.ipd.dsp.internal.components.glide.load.data.a
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ByteBuffer c() {
        this.f38524a.position(0);
        return this.f38524a;
    }

    @Override // com.ipd.dsp.internal.components.glide.load.data.a
    public void b() {
    }
}
