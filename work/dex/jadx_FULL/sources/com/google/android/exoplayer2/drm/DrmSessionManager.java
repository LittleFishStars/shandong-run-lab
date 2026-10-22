package com.google.android.exoplayer2.drm;

import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.zj.adlib.at6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DrmSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final DrmSessionManager f30597a;

    @Deprecated
    public static final DrmSessionManager b;

    public interface DrmSessionReference {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final DrmSessionReference f30598a = new DrmSessionReference() { // from class: com.zj.adlib.fs2
            @Override // com.google.android.exoplayer2.drm.DrmSessionManager.DrmSessionReference
            public final void release() {
                DrmSessionManager.DrmSessionReference.lambda$static$0();
            }
        };

        static /* synthetic */ void lambda$static$0() {
        }

        void release();
    }

    public class a implements DrmSessionManager {
        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public int a(com.google.android.exoplayer2.d dVar) {
            return dVar.f2566a != null ? 1 : 0;
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        @Nullable
        public DrmSession b(@Nullable DrmSessionEventListener.a aVar, com.google.android.exoplayer2.d dVar) {
            if (dVar.f2566a == null) {
                return null;
            }
            return new c(new DrmSession.DrmSessionException(new UnsupportedDrmException(1), 6001));
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public void c(Looper looper, at6 at6Var) {
        }
    }

    static {
        a aVar = new a();
        f30597a = aVar;
        b = aVar;
    }

    @Deprecated
    static DrmSessionManager e() {
        return f30597a;
    }

    int a(com.google.android.exoplayer2.d dVar);

    @Nullable
    DrmSession b(@Nullable DrmSessionEventListener.a aVar, com.google.android.exoplayer2.d dVar);

    void c(Looper looper, at6 at6Var);

    default DrmSessionReference d(@Nullable DrmSessionEventListener.a aVar, com.google.android.exoplayer2.d dVar) {
        return DrmSessionReference.f30598a;
    }

    default void prepare() {
    }

    default void release() {
    }
}
