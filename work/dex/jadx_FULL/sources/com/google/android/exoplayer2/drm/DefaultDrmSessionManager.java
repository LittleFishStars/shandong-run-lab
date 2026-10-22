package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.at6;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.gm3;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(18)
public class DefaultDrmSessionManager implements DrmSessionManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30587a = "PRCustomData";
    public static final long b = 300000;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final String f2632b = "DefaultDrmSessionMgr";
    public static final int c = 0;
    public static final int d = 1;
    public static final int e = 2;
    public static final int f = 3;
    public static final int g = 3;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f2633a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2634a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Handler f2635a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Looper f2636a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DefaultDrmSession f2637a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public volatile d f2638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final f f2639a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g f2640a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoMediaDrm.Provider f2641a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ExoMediaDrm f2642a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaDrmCallback f2643a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f2644a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public at6 f2645a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, String> f2646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<DefaultDrmSession> f2647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<e> f2648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final UUID f2649a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2650a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public byte[] f2651a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f2652a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f2653b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public DefaultDrmSession f2654b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final Set<DefaultDrmSession> f2655b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f2656b;

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2661a;
        public boolean b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final HashMap<String, String> f2659a = new HashMap<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public UUID f2660a = C.f2005d;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ExoMediaDrm.Provider f2657a = com.google.android.exoplayer2.drm.d.f30607a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public LoadErrorHandlingPolicy f2658a = new com.google.android.exoplayer2.upstream.f();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public int[] f2662a = new int[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f30588a = 300000;

        public DefaultDrmSessionManager a(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.f2660a, this.f2657a, mediaDrmCallback, this.f2659a, this.f2661a, this.f2662a, this.b, this.f2658a, this.f30588a);
        }

        public b b(@Nullable Map<String, String> map) {
            this.f2659a.clear();
            if (map != null) {
                this.f2659a.putAll(map);
            }
            return this;
        }

        public b c(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.f2658a = (LoadErrorHandlingPolicy) sb0.g(loadErrorHandlingPolicy);
            return this;
        }

        public b d(boolean z) {
            this.f2661a = z;
            return this;
        }

        public b e(boolean z) {
            this.b = z;
            return this;
        }

        public b f(long j) {
            sb0.a(j > 0 || j == -9223372036854775807L);
            this.f30588a = j;
            return this;
        }

        public b g(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                sb0.a(z);
            }
            this.f2662a = (int[]) iArr.clone();
            return this;
        }

        public b h(UUID uuid, ExoMediaDrm.Provider provider) {
            this.f2660a = (UUID) sb0.g(uuid);
            this.f2657a = (ExoMediaDrm.Provider) sb0.g(provider);
            return this;
        }
    }

    public class c implements ExoMediaDrm.OnEventListener {
        public c() {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void a(ExoMediaDrm exoMediaDrm, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2) {
            ((d) sb0.g(DefaultDrmSessionManager.this.f2638a)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.f2647a) {
                if (defaultDrmSession.n(bArr)) {
                    defaultDrmSession.v(message.what);
                    return;
                }
            }
        }
    }

    public class e implements DrmSessionManager.DrmSessionReference {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public DrmSession f2663a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final DrmSessionEventListener.a f2664a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2665a;

        public e(DrmSessionEventListener.a aVar) {
            this.f2664a = aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e(com.google.android.exoplayer2.d dVar) {
            if (DefaultDrmSessionManager.this.f2633a == 0 || this.f2665a) {
                return;
            }
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            this.f2663a = defaultDrmSessionManager.t((Looper) sb0.g(defaultDrmSessionManager.f2636a), this.f2664a, dVar, false);
            DefaultDrmSessionManager.this.f2648a.add(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (this.f2665a) {
                return;
            }
            DrmSession drmSession = this.f2663a;
            if (drmSession != null) {
                drmSession.d(this.f2664a);
            }
            DefaultDrmSessionManager.this.f2648a.remove(this);
            this.f2665a = true;
        }

        public void d(final com.google.android.exoplayer2.d dVar) {
            ((Handler) sb0.g(DefaultDrmSessionManager.this.f2635a)).post(new Runnable() { // from class: com.zj.adlib.rf2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f19283a.e(dVar);
                }
            });
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager.DrmSessionReference
        public void release() {
            gj9.j1((Handler) sb0.g(DefaultDrmSessionManager.this.f2635a), new Runnable() { // from class: com.zj.adlib.qf2
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44198a.f();
                }
            });
        }
    }

    public class f implements DefaultDrmSession.ProvisioningManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public DefaultDrmSession f30592a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Set<DefaultDrmSession> f2666a = new HashSet();

        public f(DefaultDrmSessionManager defaultDrmSessionManager) {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void a(DefaultDrmSession defaultDrmSession) {
            this.f2666a.add(defaultDrmSession);
            if (this.f30592a != null) {
                return;
            }
            this.f30592a = defaultDrmSession;
            defaultDrmSession.B();
        }

        public void b(DefaultDrmSession defaultDrmSession) {
            this.f2666a.remove(defaultDrmSession);
            if (this.f30592a == defaultDrmSession) {
                this.f30592a = null;
                if (this.f2666a.isEmpty()) {
                    return;
                }
                DefaultDrmSession next = this.f2666a.iterator().next();
                this.f30592a = next;
                next.B();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionCompleted() {
            this.f30592a = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f2666a);
            this.f2666a.clear();
            UnmodifiableIterator it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).w();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionError(Exception exc, boolean z) {
            this.f30592a = null;
            ImmutableList immutableListCopyOf = ImmutableList.copyOf((Collection) this.f2666a);
            this.f2666a.clear();
            UnmodifiableIterator it = immutableListCopyOf.iterator();
            while (it.hasNext()) {
                ((DefaultDrmSession) it.next()).x(exc, z);
            }
        }
    }

    public class g implements DefaultDrmSession.ReferenceCountListener {
        public g() {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener
        public void a(DefaultDrmSession defaultDrmSession, int i) {
            if (DefaultDrmSessionManager.this.f2634a != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f2655b.remove(defaultDrmSession);
                ((Handler) sb0.g(DefaultDrmSessionManager.this.f2635a)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener
        public void b(final DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1 && DefaultDrmSessionManager.this.f2633a > 0 && DefaultDrmSessionManager.this.f2634a != -9223372036854775807L) {
                DefaultDrmSessionManager.this.f2655b.add(defaultDrmSession);
                ((Handler) sb0.g(DefaultDrmSessionManager.this.f2635a)).postAtTime(new Runnable() { // from class: com.zj.adlib.sf2
                    @Override // java.lang.Runnable
                    public final void run() {
                        defaultDrmSession.d(null);
                    }
                }, defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.f2634a);
            } else if (i == 0) {
                DefaultDrmSessionManager.this.f2647a.remove(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f2637a == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f2637a = null;
                }
                if (DefaultDrmSessionManager.this.f2654b == defaultDrmSession) {
                    DefaultDrmSessionManager.this.f2654b = null;
                }
                DefaultDrmSessionManager.this.f2639a.b(defaultDrmSession);
                if (DefaultDrmSessionManager.this.f2634a != -9223372036854775807L) {
                    ((Handler) sb0.g(DefaultDrmSessionManager.this.f2635a)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.f2655b.remove(defaultDrmSession);
                }
            }
            DefaultDrmSessionManager.this.C();
        }
    }

    public static boolean u(DrmSession drmSession) {
        return drmSession.getState() == 1 && (gj9.f41922a < 19 || (((DrmSession.DrmSessionException) sb0.g(drmSession.c())).getCause() instanceof ResourceBusyException));
    }

    public static List<DrmInitData.SchemeData> y(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i = 0; i < drmInitData.schemeDataCount; i++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i);
            if ((schemeData.matches(uuid) || (C.f2002c.equals(uuid) && schemeData.matches(C.f1999b))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    @Nullable
    public final DrmSession A(int i, boolean z) {
        ExoMediaDrm exoMediaDrm = (ExoMediaDrm) sb0.g(this.f2642a);
        if ((exoMediaDrm.getCryptoType() == 2 && gm3.b) || gj9.Q0(this.f2652a, i) == -1 || exoMediaDrm.getCryptoType() == 1) {
            return null;
        }
        DefaultDrmSession defaultDrmSession = this.f2637a;
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSessionX = x(ImmutableList.of(), true, null, z);
            this.f2647a.add(defaultDrmSessionX);
            this.f2637a = defaultDrmSessionX;
        } else {
            defaultDrmSession.a(null);
        }
        return this.f2637a;
    }

    public final void B(Looper looper) {
        if (this.f2638a == null) {
            this.f2638a = new d(looper);
        }
    }

    public final void C() {
        if (this.f2642a != null && this.f2633a == 0 && this.f2647a.isEmpty() && this.f2648a.isEmpty()) {
            ((ExoMediaDrm) sb0.g(this.f2642a)).release();
            this.f2642a = null;
        }
    }

    public final void D() {
        UnmodifiableIterator it = ImmutableSet.copyOf((Collection) this.f2655b).iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).d(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void E() {
        UnmodifiableIterator it = ImmutableSet.copyOf((Collection) this.f2648a).iterator();
        while (it.hasNext()) {
            ((e) it.next()).release();
        }
    }

    public void F(int i, @Nullable byte[] bArr) {
        sb0.i(this.f2647a.isEmpty());
        if (i == 1 || i == 3) {
            sb0.g(bArr);
        }
        this.f2653b = i;
        this.f2651a = bArr;
    }

    public final void G(DrmSession drmSession, @Nullable DrmSessionEventListener.a aVar) {
        drmSession.d(aVar);
        if (this.f2634a != -9223372036854775807L) {
            drmSession.d(null);
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public int a(com.google.android.exoplayer2.d dVar) {
        int cryptoType = ((ExoMediaDrm) sb0.g(this.f2642a)).getCryptoType();
        DrmInitData drmInitData = dVar.f2566a;
        if (drmInitData != null) {
            if (v(drmInitData)) {
                return cryptoType;
            }
            return 1;
        }
        if (gj9.Q0(this.f2652a, bp5.l(dVar.k)) != -1) {
            return cryptoType;
        }
        return 0;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    @Nullable
    public DrmSession b(@Nullable DrmSessionEventListener.a aVar, com.google.android.exoplayer2.d dVar) {
        sb0.i(this.f2633a > 0);
        sb0.k(this.f2636a);
        return t(this.f2636a, aVar, dVar, true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public void c(Looper looper, at6 at6Var) {
        z(looper);
        this.f2645a = at6Var;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public DrmSessionManager.DrmSessionReference d(@Nullable DrmSessionEventListener.a aVar, com.google.android.exoplayer2.d dVar) {
        sb0.i(this.f2633a > 0);
        sb0.k(this.f2636a);
        e eVar = new e(aVar);
        eVar.d(dVar);
        return eVar;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void prepare() {
        int i = this.f2633a;
        this.f2633a = i + 1;
        if (i != 0) {
            return;
        }
        if (this.f2642a == null) {
            ExoMediaDrm exoMediaDrmA = this.f2641a.a(this.f2649a);
            this.f2642a = exoMediaDrmA;
            exoMediaDrmA.setOnEventListener(new c());
        } else if (this.f2634a != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.f2647a.size(); i2++) {
                this.f2647a.get(i2).a(null);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void release() {
        int i = this.f2633a - 1;
        this.f2633a = i;
        if (i != 0) {
            return;
        }
        if (this.f2634a != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.f2647a);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((DefaultDrmSession) arrayList.get(i2)).d(null);
            }
        }
        E();
        C();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Nullable
    public final DrmSession t(Looper looper, @Nullable DrmSessionEventListener.a aVar, com.google.android.exoplayer2.d dVar, boolean z) {
        List<DrmInitData.SchemeData> listY;
        B(looper);
        DrmInitData drmInitData = dVar.f2566a;
        if (drmInitData == null) {
            return A(bp5.l(dVar.k), z);
        }
        DefaultDrmSession defaultDrmSessionX = null;
        Object[] objArr = 0;
        if (this.f2651a == null) {
            listY = y((DrmInitData) sb0.g(drmInitData), this.f2649a, false);
            if (listY.isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.f2649a);
                Log.e(f2632b, "DRM error", missingSchemeDataException);
                if (aVar != null) {
                    aVar.l(missingSchemeDataException);
                }
                return new com.google.android.exoplayer2.drm.c(new DrmSession.DrmSessionException(missingSchemeDataException, 6003));
            }
        } else {
            listY = null;
        }
        if (this.f2650a) {
            for (DefaultDrmSession defaultDrmSession : this.f2647a) {
                if (gj9.c(defaultDrmSession.f2623a, listY)) {
                    defaultDrmSessionX = defaultDrmSession;
                    break;
                }
            }
        } else {
            defaultDrmSessionX = this.f2654b;
        }
        if (defaultDrmSessionX == null) {
            defaultDrmSessionX = x(listY, false, aVar, z);
            if (!this.f2650a) {
                this.f2654b = defaultDrmSessionX;
            }
            this.f2647a.add(defaultDrmSessionX);
        } else {
            defaultDrmSessionX.a(aVar);
        }
        return defaultDrmSessionX;
    }

    public final boolean v(DrmInitData drmInitData) {
        if (this.f2651a != null) {
            return true;
        }
        if (y(drmInitData, this.f2649a, true).isEmpty()) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.f1999b)) {
                return false;
            }
            Log.n(f2632b, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.f2649a);
        }
        String str = drmInitData.schemeType;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        if ("cbcs".equals(str)) {
            return gj9.f41922a >= 25;
        }
        return ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    public final DefaultDrmSession w(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable DrmSessionEventListener.a aVar) {
        sb0.g(this.f2642a);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.f2649a, this.f2642a, this.f2639a, this.f2640a, list, this.f2653b, this.f2656b | z, z, this.f2651a, this.f2646a, this.f2643a, (Looper) sb0.g(this.f2636a), this.f2644a, (at6) sb0.g(this.f2645a));
        defaultDrmSession.a(aVar);
        if (this.f2634a != -9223372036854775807L) {
            defaultDrmSession.a(null);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession x(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable DrmSessionEventListener.a aVar, boolean z2) {
        DefaultDrmSession defaultDrmSessionW = w(list, z, aVar);
        if (u(defaultDrmSessionW) && !this.f2655b.isEmpty()) {
            D();
            G(defaultDrmSessionW, aVar);
            defaultDrmSessionW = w(list, z, aVar);
        }
        if (!u(defaultDrmSessionW) || !z2 || this.f2648a.isEmpty()) {
            return defaultDrmSessionW;
        }
        E();
        if (!this.f2655b.isEmpty()) {
            D();
        }
        G(defaultDrmSessionW, aVar);
        return w(list, z, aVar);
    }

    @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
    public final synchronized void z(Looper looper) {
        Looper looper2 = this.f2636a;
        if (looper2 == null) {
            this.f2636a = looper;
            this.f2635a = new Handler(looper);
        } else {
            sb0.i(looper2 == looper);
            sb0.g(this.f2635a);
        }
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> map) {
        this(uuid, exoMediaDrm, mediaDrmCallback, map == null ? new HashMap<>() : map, false, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> map, boolean z) {
        this(uuid, exoMediaDrm, mediaDrmCallback, map == null ? new HashMap<>() : map, z, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> map, boolean z, int i) {
        this(uuid, new ExoMediaDrm.a(exoMediaDrm), mediaDrmCallback, map == null ? new HashMap<>() : map, z, new int[0], false, new com.google.android.exoplayer2.upstream.f(i), 300000L);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> map, boolean z, int[] iArr, boolean z2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j) {
        sb0.g(uuid);
        sb0.b(!C.f1999b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.f2649a = uuid;
        this.f2641a = provider;
        this.f2643a = mediaDrmCallback;
        this.f2646a = map;
        this.f2650a = z;
        this.f2652a = iArr;
        this.f2656b = z2;
        this.f2644a = loadErrorHandlingPolicy;
        this.f2639a = new f(this);
        this.f2640a = new g();
        this.f2653b = 0;
        this.f2647a = new ArrayList();
        this.f2648a = Sets.z();
        this.f2655b = Sets.z();
        this.f2634a = j;
    }
}
