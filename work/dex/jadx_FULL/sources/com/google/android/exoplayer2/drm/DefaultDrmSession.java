package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.alibaba.ariver.kernel.RVParams;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.at6;
import com.zj.adlib.az4;
import com.zj.adlib.gj9;
import com.zj.adlib.oh5;
import com.zj.adlib.sb0;
import com.zj.adlib.wv9;
import com.zj.adlib.xv1;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@RequiresApi(18)
public class DefaultDrmSession implements DrmSession {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30583a = "DefaultDrmSession";
    public static final int i = 0;
    public static final int j = 1;
    public static final int k = 60;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public HandlerThread f2608a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public CryptoConfig f2609a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProvisioningManager f2610a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ReferenceCountListener f2611a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public a f2612a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final c f2613a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DrmSession.DrmSessionException f2614a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ExoMediaDrm.KeyRequest f2615a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ExoMediaDrm.c f2616a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExoMediaDrm f2617a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaDrmCallback f2618a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final LoadErrorHandlingPolicy f2619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final at6 f2620a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xv1<DrmSessionEventListener.a> f2621a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, String> f2622a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final List<DrmInitData.SchemeData> f2623a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final UUID f2624a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2625a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public byte[] f2626a;
    public final boolean b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public byte[] f2627b;
    public final int f;
    public int g;
    public int h;

    public interface ProvisioningManager {
        void a(DefaultDrmSession defaultDrmSession);

        void onProvisionCompleted();

        void onProvisionError(Exception exc, boolean z);
    }

    public interface ReferenceCountListener {
        void a(DefaultDrmSession defaultDrmSession, int i);

        void b(DefaultDrmSession defaultDrmSession, int i);
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("this")
        public boolean f2628a;

        public a(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, MediaDrmCallbackException mediaDrmCallbackException) {
            b bVar = (b) message.obj;
            if (!bVar.f2631a) {
                return false;
            }
            int i = bVar.f30585a + 1;
            bVar.f30585a = i;
            if (i > DefaultDrmSession.this.f2619a.getMinimumLoadableRetryCount(3)) {
                return false;
            }
            long jB = DefaultDrmSession.this.f2619a.b(new LoadErrorHandlingPolicy.c(new az4(bVar.f2629a, mediaDrmCallbackException.dataSpec, mediaDrmCallbackException.uriAfterRedirects, mediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - bVar.b, mediaDrmCallbackException.bytesLoaded), new oh5(3), mediaDrmCallbackException.getCause() instanceof IOException ? (IOException) mediaDrmCallbackException.getCause() : new UnexpectedDrmSessionException(mediaDrmCallbackException.getCause()), bVar.f30585a));
            if (jB == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                if (this.f2628a) {
                    return false;
                }
                sendMessageDelayed(Message.obtain(message), jB);
                return true;
            }
        }

        public void b(int i, Object obj, boolean z) {
            obtainMessage(i, new b(az4.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages(null);
            this.f2628a = true;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object objB;
            b bVar = (b) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    objB = defaultDrmSession.f2618a.b(defaultDrmSession.f2624a, (ExoMediaDrm.c) bVar.f2630a);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    objB = defaultDrmSession2.f2618a.a(defaultDrmSession2.f2624a, (ExoMediaDrm.KeyRequest) bVar.f2630a);
                }
            } catch (MediaDrmCallbackException e) {
                boolean zA = a(message, e);
                objB = e;
                if (zA) {
                    return;
                }
            } catch (Exception e2) {
                Log.o(DefaultDrmSession.f30583a, "Key/provisioning request produced an unexpected exception. Not retrying.", e2);
                objB = e2;
            }
            DefaultDrmSession.this.f2619a.onLoadTaskConcluded(bVar.f2629a);
            synchronized (this) {
                if (!this.f2628a) {
                    DefaultDrmSession.this.f2613a.obtainMessage(message.what, Pair.create(bVar.f2630a, objB)).sendToTarget();
                }
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30585a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f2629a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Object f2630a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2631a;
        public final long b;

        public b(long j, boolean z, long j2, Object obj) {
            this.f2629a = j;
            this.f2631a = z;
            this.b = j2;
            this.f2630a = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession.this.y(obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                DefaultDrmSession.this.s(obj, obj2);
            }
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, @Nullable List<DrmInitData.SchemeData> list, int i2, boolean z, boolean z2, @Nullable byte[] bArr, HashMap<String, String> map, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy, at6 at6Var) {
        if (i2 == 1 || i2 == 3) {
            sb0.g(bArr);
        }
        this.f2624a = uuid;
        this.f2610a = provisioningManager;
        this.f2611a = referenceCountListener;
        this.f2617a = exoMediaDrm;
        this.f = i2;
        this.f2625a = z;
        this.b = z2;
        if (bArr != null) {
            this.f2627b = bArr;
            this.f2623a = null;
        } else {
            this.f2623a = Collections.unmodifiableList((List) sb0.g(list));
        }
        this.f2622a = map;
        this.f2618a = mediaDrmCallback;
        this.f2621a = new xv1<>();
        this.f2619a = loadErrorHandlingPolicy;
        this.f2620a = at6Var;
        this.g = 2;
        this.f2613a = new c(looper);
    }

    public final void A(byte[] bArr, int i2, boolean z) {
        try {
            this.f2615a = this.f2617a.c(bArr, this.f2623a, i2, this.f2622a);
            ((a) gj9.k(this.f2612a)).b(1, sb0.g(this.f2615a), z);
        } catch (Exception e) {
            t(e, true);
        }
    }

    public void B() {
        this.f2616a = this.f2617a.b();
        ((a) gj9.k(this.f2612a)).b(0, sb0.g(this.f2616a), true);
    }

    @RequiresNonNull({RVParams.SESSION_ID, "offlineLicenseKeySetId"})
    public final boolean C() {
        try {
            this.f2617a.restoreKeys(this.f2626a, this.f2627b);
            return true;
        } catch (Exception e) {
            r(e, 1);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void a(@Nullable DrmSessionEventListener.a aVar) {
        if (this.h < 0) {
            Log.d(f30583a, "Session reference count less than zero: " + this.h);
            this.h = 0;
        }
        if (aVar != null) {
            this.f2621a.a(aVar);
        }
        int i2 = this.h + 1;
        this.h = i2;
        if (i2 == 1) {
            sb0.i(this.g == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.f2608a = handlerThread;
            handlerThread.start();
            this.f2612a = new a(this.f2608a.getLooper());
            if (z()) {
                l(true);
            }
        } else if (aVar != null && o() && this.f2621a.count(aVar) == 1) {
            aVar.k(this.g);
        }
        this.f2611a.a(this, this.h);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final CryptoConfig b() {
        return this.f2609a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException c() {
        if (this.g == 1) {
            return this.f2614a;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void d(@Nullable DrmSessionEventListener.a aVar) {
        int i2 = this.h;
        if (i2 <= 0) {
            Log.d(f30583a, "release() called on a session that's already fully released.");
            return;
        }
        int i3 = i2 - 1;
        this.h = i3;
        if (i3 == 0) {
            this.g = 0;
            ((c) gj9.k(this.f2613a)).removeCallbacksAndMessages(null);
            ((a) gj9.k(this.f2612a)).c();
            this.f2612a = null;
            ((HandlerThread) gj9.k(this.f2608a)).quit();
            this.f2608a = null;
            this.f2609a = null;
            this.f2614a = null;
            this.f2615a = null;
            this.f2616a = null;
            byte[] bArr = this.f2626a;
            if (bArr != null) {
                this.f2617a.closeSession(bArr);
                this.f2626a = null;
            }
        }
        if (aVar != null) {
            this.f2621a.b(aVar);
            if (this.f2621a.count(aVar) == 0) {
                aVar.m();
            }
        }
        this.f2611a.b(this, this.h);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return this.f2627b;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final UUID getSchemeUuid() {
        return this.f2624a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.g;
    }

    public final void k(Consumer<DrmSessionEventListener.a> consumer) {
        Iterator<DrmSessionEventListener.a> it = this.f2621a.elementSet().iterator();
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    @RequiresNonNull({RVParams.SESSION_ID})
    public final void l(boolean z) {
        if (this.b) {
            return;
        }
        byte[] bArr = (byte[]) gj9.k(this.f2626a);
        int i2 = this.f;
        if (i2 != 0 && i2 != 1) {
            if (i2 == 2) {
                if (this.f2627b == null || C()) {
                    A(bArr, 2, z);
                    return;
                }
                return;
            }
            if (i2 != 3) {
                return;
            }
            sb0.g(this.f2627b);
            sb0.g(this.f2626a);
            A(this.f2627b, 3, z);
            return;
        }
        if (this.f2627b == null) {
            A(bArr, 1, z);
            return;
        }
        if (this.g == 4 || C()) {
            long jM = m();
            if (this.f != 0 || jM > 60) {
                if (jM <= 0) {
                    r(new KeysExpiredException(), 2);
                    return;
                } else {
                    this.g = 4;
                    k(new Consumer() { // from class: com.zj.adlib.pf2
                        @Override // com.google.android.exoplayer2.util.Consumer
                        public final void accept(Object obj) {
                            ((DrmSessionEventListener.a) obj).j();
                        }
                    });
                    return;
                }
            }
            Log.b(f30583a, "Offline license has expired or will expire soon. Remaining seconds: " + jM);
            A(bArr, 2, z);
        }
    }

    public final long m() {
        if (!C.f2005d.equals(this.f2624a)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) sb0.g(wv9.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public boolean n(byte[] bArr) {
        return Arrays.equals(this.f2626a, bArr);
    }

    @EnsuresNonNullIf(expression = {RVParams.SESSION_ID}, result = true)
    public final boolean o() {
        int i2 = this.g;
        return i2 == 3 || i2 == 4;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.f2625a;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.f2626a;
        if (bArr == null) {
            return null;
        }
        return this.f2617a.queryKeyStatus(bArr);
    }

    public final void r(final Exception exc, int i2) {
        this.f2614a = new DrmSession.DrmSessionException(exc, DrmUtil.a(exc, i2));
        Log.e(f30583a, "DRM session error", exc);
        k(new Consumer() { // from class: com.zj.adlib.of2
            @Override // com.google.android.exoplayer2.util.Consumer
            public final void accept(Object obj) {
                ((DrmSessionEventListener.a) obj).l(exc);
            }
        });
        if (this.g != 4) {
            this.g = 1;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean requiresSecureDecoder(String str) {
        return this.f2617a.requiresSecureDecoder((byte[]) sb0.k(this.f2626a), str);
    }

    public final void s(Object obj, Object obj2) {
        if (obj == this.f2615a && o()) {
            this.f2615a = null;
            if (obj2 instanceof Exception) {
                t((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.f == 3) {
                    this.f2617a.provideKeyResponse((byte[]) gj9.k(this.f2627b), bArr);
                    k(new Consumer() { // from class: com.zj.adlib.jf2
                        @Override // com.google.android.exoplayer2.util.Consumer
                        public final void accept(Object obj3) {
                            ((DrmSessionEventListener.a) obj3).i();
                        }
                    });
                    return;
                }
                byte[] bArrProvideKeyResponse = this.f2617a.provideKeyResponse(this.f2626a, bArr);
                int i2 = this.f;
                if ((i2 == 2 || (i2 == 0 && this.f2627b != null)) && bArrProvideKeyResponse != null && bArrProvideKeyResponse.length != 0) {
                    this.f2627b = bArrProvideKeyResponse;
                }
                this.g = 4;
                k(new Consumer() { // from class: com.zj.adlib.lf2
                    @Override // com.google.android.exoplayer2.util.Consumer
                    public final void accept(Object obj3) {
                        ((DrmSessionEventListener.a) obj3).h();
                    }
                });
            } catch (Exception e) {
                t(e, true);
            }
        }
    }

    public final void t(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.f2610a.a(this);
        } else {
            r(exc, z ? 1 : 2);
        }
    }

    public final void u() {
        if (this.f == 0 && this.g == 4) {
            gj9.k(this.f2626a);
            l(false);
        }
    }

    public void v(int i2) {
        if (i2 != 2) {
            return;
        }
        u();
    }

    public void w() {
        if (z()) {
            l(true);
        }
    }

    public void x(Exception exc, boolean z) {
        r(exc, z ? 1 : 3);
    }

    public final void y(Object obj, Object obj2) {
        if (obj == this.f2616a) {
            if (this.g == 2 || o()) {
                this.f2616a = null;
                if (obj2 instanceof Exception) {
                    this.f2610a.onProvisionError((Exception) obj2, false);
                    return;
                }
                try {
                    this.f2617a.provideProvisionResponse((byte[]) obj2);
                    this.f2610a.onProvisionCompleted();
                } catch (Exception e) {
                    this.f2610a.onProvisionError(e, true);
                }
            }
        }
    }

    @EnsuresNonNullIf(expression = {RVParams.SESSION_ID}, result = true)
    public final boolean z() {
        if (o()) {
            return true;
        }
        try {
            byte[] bArrOpenSession = this.f2617a.openSession();
            this.f2626a = bArrOpenSession;
            this.f2617a.d(bArrOpenSession, this.f2620a);
            this.f2609a = this.f2617a.a(this.f2626a);
            final int i2 = 3;
            this.g = 3;
            k(new Consumer() { // from class: com.zj.adlib.nf2
                @Override // com.google.android.exoplayer2.util.Consumer
                public final void accept(Object obj) {
                    ((DrmSessionEventListener.a) obj).k(i2);
                }
            });
            sb0.g(this.f2626a);
            return true;
        } catch (NotProvisionedException unused) {
            this.f2610a.a(this);
            return false;
        } catch (Exception e) {
            r(e, 1);
            return false;
        }
    }
}
