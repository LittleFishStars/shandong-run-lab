package com.google.android.exoplayer2.drm;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.zj.adlib.sb0;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class c implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DrmSession.DrmSessionException f30606a;

    public c(DrmSession.DrmSessionException drmSessionException) {
        this.f30606a = (DrmSession.DrmSessionException) sb0.g(drmSessionException);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable DrmSessionEventListener.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public CryptoConfig b() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public DrmSession.DrmSessionException c() {
        return this.f30606a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void d(@Nullable DrmSessionEventListener.a aVar) {
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID getSchemeUuid() {
        return C.f1996a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public int getState() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return false;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean requiresSecureDecoder(String str) {
        return false;
    }
}
