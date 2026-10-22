package com.google.android.exoplayer2.drm;

import com.zj.adlib.sb0;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class f implements MediaDrmCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f30609a;

    public f(byte[] bArr) {
        this.f30609a = (byte[]) sb0.g(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] a(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        return this.f30609a;
    }

    @Override // com.google.android.exoplayer2.drm.MediaDrmCallback
    public byte[] b(UUID uuid, ExoMediaDrm.c cVar) {
        throw new UnsupportedOperationException();
    }
}
