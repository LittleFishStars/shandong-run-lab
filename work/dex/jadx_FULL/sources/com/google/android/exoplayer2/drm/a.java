package com.google.android.exoplayer2.drm;

import android.net.Uri;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Ints;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements DrmSessionManagerProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("lock")
    public DrmSessionManager f30605a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("lock")
    public com.google.android.exoplayer2.g.f f2674a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DataSource.Factory f2675a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f2676a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public String f2677a;

    @Override // com.google.android.exoplayer2.drm.DrmSessionManagerProvider
    public DrmSessionManager a(com.google.android.exoplayer2.g gVar) {
        DrmSessionManager drmSessionManager;
        sb0.g(gVar.f3327a);
        com.google.android.exoplayer2.g.f fVar = gVar.f3327a.f3368a;
        if (fVar == null || gj9.f41922a < 18) {
            return DrmSessionManager.f30597a;
        }
        synchronized (this.f2676a) {
            if (!gj9.c(fVar, this.f2674a)) {
                this.f2674a = fVar;
                this.f30605a = b(fVar);
            }
            drmSessionManager = (DrmSessionManager) sb0.g(this.f30605a);
        }
        return drmSessionManager;
    }

    @RequiresApi(18)
    public final DrmSessionManager b(com.google.android.exoplayer2.g.f fVar) {
        DataSource.Factory factoryL = this.f2675a;
        if (factoryL == null) {
            factoryL = new com.google.android.exoplayer2.upstream.e.b().l(this.f2677a);
        }
        Uri uri = fVar.f30747a;
        e eVar = new e(uri == null ? null : uri.toString(), fVar.c, factoryL);
        UnmodifiableIterator<Map.Entry<String, String>> it = fVar.f3353b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, String> next = it.next();
            eVar.g(next.getKey(), next.getValue());
        }
        DefaultDrmSessionManager defaultDrmSessionManagerA = new DefaultDrmSessionManager.b().h(fVar.f3350a, d.f30607a).d(fVar.f3351a).e(fVar.f3355b).g(Ints.B(fVar.b)).a(eVar);
        defaultDrmSessionManagerA.F(0, fVar.c());
        return defaultDrmSessionManagerA;
    }

    public void c(@Nullable DataSource.Factory factory) {
        this.f2675a = factory;
    }

    @Deprecated
    public void d(@Nullable String str) {
        this.f2677a = str;
    }
}
