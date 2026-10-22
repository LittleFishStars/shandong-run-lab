package com.google.android.exoplayer2.drm;

import android.os.ConditionVariable;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.zj.adlib.at6;
import com.zj.adlib.sb0;
import com.zj.adlib.wv9;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(18)
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.google.android.exoplayer2.d f30610a = new com.google.android.exoplayer2.d.b().M(new DrmInitData(new DrmInitData.SchemeData[0])).E();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ConditionVariable f2685a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HandlerThread f2686a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DefaultDrmSessionManager f2687a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final DrmSessionEventListener.a f2688a;

    public class a implements DrmSessionEventListener {
        public a() {
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void I(int i, @Nullable MediaSource.a aVar) {
            g.this.f2685a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void O(int i, @Nullable MediaSource.a aVar) {
            g.this.f2685a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void n(int i, @Nullable MediaSource.a aVar, Exception exc) {
            g.this.f2685a.open();
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionEventListener
        public void o(int i, @Nullable MediaSource.a aVar) {
            g.this.f2685a.open();
        }
    }

    @Deprecated
    public g(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, @Nullable Map<String, String> map, DrmSessionEventListener.a aVar) {
        this(new DefaultDrmSessionManager.b().h(uuid, provider).b(map).a(mediaDrmCallback), aVar);
    }

    public static g e(String str, DataSource.Factory factory, DrmSessionEventListener.a aVar) {
        return f(str, false, factory, aVar);
    }

    public static g f(String str, boolean z, DataSource.Factory factory, DrmSessionEventListener.a aVar) {
        return g(str, z, factory, null, aVar);
    }

    public static g g(String str, boolean z, DataSource.Factory factory, @Nullable Map<String, String> map, DrmSessionEventListener.a aVar) {
        return new g(new DefaultDrmSessionManager.b().b(map).a(new e(str, z, factory)), aVar);
    }

    public final byte[] b(int i, @Nullable byte[] bArr, com.google.android.exoplayer2.d dVar) throws DrmSession.DrmSessionException {
        this.f2687a.c(this.f2686a.getLooper(), at6.f40608a);
        this.f2687a.prepare();
        DrmSession drmSessionH = h(i, bArr, dVar);
        DrmSession.DrmSessionException drmSessionExceptionC = drmSessionH.c();
        byte[] offlineLicenseKeySetId = drmSessionH.getOfflineLicenseKeySetId();
        drmSessionH.d(this.f2688a);
        this.f2687a.release();
        if (drmSessionExceptionC == null) {
            return (byte[]) sb0.g(offlineLicenseKeySetId);
        }
        throw drmSessionExceptionC;
    }

    public synchronized byte[] c(com.google.android.exoplayer2.d dVar) throws DrmSession.DrmSessionException {
        sb0.a(dVar.f2566a != null);
        return b(2, null, dVar);
    }

    public synchronized Pair<Long, Long> d(byte[] bArr) throws DrmSession.DrmSessionException {
        sb0.g(bArr);
        this.f2687a.c(this.f2686a.getLooper(), at6.f40608a);
        this.f2687a.prepare();
        DrmSession drmSessionH = h(1, bArr, f30610a);
        DrmSession.DrmSessionException drmSessionExceptionC = drmSessionH.c();
        Pair<Long, Long> pairB = wv9.b(drmSessionH);
        drmSessionH.d(this.f2688a);
        this.f2687a.release();
        if (drmSessionExceptionC == null) {
            return (Pair) sb0.g(pairB);
        }
        if (!(drmSessionExceptionC.getCause() instanceof KeysExpiredException)) {
            throw drmSessionExceptionC;
        }
        return Pair.create(0L, 0L);
    }

    public final DrmSession h(int i, @Nullable byte[] bArr, com.google.android.exoplayer2.d dVar) {
        sb0.g(dVar.f2566a);
        this.f2687a.F(i, bArr);
        this.f2685a.close();
        DrmSession drmSessionB = this.f2687a.b(this.f2688a, dVar);
        this.f2685a.block();
        return (DrmSession) sb0.g(drmSessionB);
    }

    public void i() {
        this.f2686a.quit();
    }

    public synchronized void j(byte[] bArr) throws DrmSession.DrmSessionException {
        sb0.g(bArr);
        b(3, bArr, f30610a);
    }

    public synchronized byte[] k(byte[] bArr) throws DrmSession.DrmSessionException {
        sb0.g(bArr);
        return b(2, bArr, f30610a);
    }

    public g(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.a aVar) {
        this.f2687a = defaultDrmSessionManager;
        this.f2688a = aVar;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:OfflineLicenseHelper");
        this.f2686a = handlerThread;
        handlerThread.start();
        this.f2685a = new ConditionVariable();
        aVar.g(new Handler(handlerThread.getLooper()), new a());
    }
}
