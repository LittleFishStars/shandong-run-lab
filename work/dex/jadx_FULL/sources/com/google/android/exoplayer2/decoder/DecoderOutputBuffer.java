package com.google.android.exoplayer2.decoder;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DecoderOutputBuffer extends Buffer {
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f30577a;

    public interface Owner<S extends DecoderOutputBuffer> {
        void a(S s);
    }

    public abstract void j();
}
