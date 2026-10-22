package com.google.android.exoplayer2.audio;

import android.annotation.SuppressLint;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.InlineMeValidationDisabled;
import com.zj.adlib.at6;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.hs5;
import com.zj.adlib.js2;
import com.zj.adlib.ls1;
import com.zj.adlib.mr;
import com.zj.adlib.pi0;
import com.zj.adlib.ps1;
import com.zj.adlib.qe0;
import com.zj.adlib.sb0;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class DefaultAudioSink implements AudioSink {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30544a = "DefaultAudioSink";
    public static final float b = 1.0f;
    public static final float c = 0.1f;
    public static final float d = 8.0f;
    public static final float e = 0.1f;
    public static final float f = 8.0f;
    public static final int k = 1000000;
    public static final int l = 0;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public static final boolean f2398l = false;
    public static final int m = 1;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public static boolean f2399m = false;
    public static final int n = 2;
    public static final int o = 3;
    public static final int p = 0;
    public static final int q = 1;
    public static final int r = 2;
    public static final int s = -32;
    public static final int t = 100;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public float f2400a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AudioTrack f2401a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public AudioSink.Listener f2402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioTrackPositionTracker f2403a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioProcessorChain f2404a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioTrackBufferSizeProvider f2405a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public d f2406a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public f f2407a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final g<AudioSink.InitializationException> f2408a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f2409a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.audio.a f2410a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final com.google.android.exoplayer2.audio.b f2411a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final j f2412a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public com.google.android.exoplayer2.j f2413a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public at6 f2414a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public pi0 f2415a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ps1 f2416a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qe0 f2417a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public ByteBuffer f2418a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ArrayDeque<f> f2419a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2420a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public byte[] f2421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AudioProcessor[] f2422a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ByteBuffer[] f2423a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f2424b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public d f2425b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public f f2426b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final g<AudioSink.WriteException> f2427b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public ByteBuffer f2428b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f2429b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final AudioProcessor[] f2430b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public long f2431c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public ByteBuffer f2432c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f2433c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public AudioProcessor[] f2434c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final int f2435d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2436d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f2437d;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public int f2438e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f2439e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f2440e;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public int f2441f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f2442f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f2443f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public long f2444g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f2445g;
    public int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public boolean f2446h;
    public int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public boolean f2447i;
    public int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public boolean f2448j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public boolean f2449k;

    public interface AudioProcessorChain {
        AudioProcessor[] a();

        boolean applySkipSilenceEnabled(boolean z);

        com.google.android.exoplayer2.j b(com.google.android.exoplayer2.j jVar);

        long getMediaDuration(long j);

        long getSkippedOutputFrameCount();
    }

    public interface AudioTrackBufferSizeProvider {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AudioTrackBufferSizeProvider f30545a = new com.google.android.exoplayer2.audio.c.a().g();

        int a(int i, int i2, int i3, int i4, int i5, double d);
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        public /* synthetic */ InvalidAudioTrackTimestampException(String str, a aVar) {
            this(str);
        }

        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    @Target({ElementType.TYPE_USE})
    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputMode {
    }

    public class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AudioTrack f30546a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, AudioTrack audioTrack) {
            super(str);
            this.f30546a = audioTrack;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                this.f30546a.flush();
                this.f30546a.release();
            } finally {
                DefaultAudioSink.this.f2416a.f();
            }
        }
    }

    @RequiresApi(31)
    public static final class b {
        @DoNotInline
        public static void a(AudioTrack audioTrack, at6 at6Var) {
            LogSessionId logSessionIdA = at6Var.a();
            if (logSessionIdA.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                return;
            }
            audioTrack.setLogSessionId(logSessionIdA);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public AudioProcessorChain f2451a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f2454a;
        public boolean b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public qe0 f2453a = qe0.f19069a;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30547a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AudioTrackBufferSizeProvider f2452a = AudioTrackBufferSizeProvider.f30545a;

        public DefaultAudioSink f() {
            if (this.f2451a == null) {
                this.f2451a = new e(new AudioProcessor[0]);
            }
            return new DefaultAudioSink(this, (a) null);
        }

        public c g(qe0 qe0Var) {
            sb0.g(qe0Var);
            this.f2453a = qe0Var;
            return this;
        }

        public c h(AudioProcessorChain audioProcessorChain) {
            sb0.g(audioProcessorChain);
            this.f2451a = audioProcessorChain;
            return this;
        }

        public c i(AudioProcessor[] audioProcessorArr) {
            sb0.g(audioProcessorArr);
            return h(new e(audioProcessorArr));
        }

        public c j(AudioTrackBufferSizeProvider audioTrackBufferSizeProvider) {
            this.f2452a = audioTrackBufferSizeProvider;
            return this;
        }

        public c k(boolean z) {
            this.b = z;
            return this;
        }

        public c l(boolean z) {
            this.f2454a = z;
            return this;
        }

        public c m(int i) {
            this.f30547a = i;
            return this;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30548a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.d f2455a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AudioProcessor[] f2456a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public d(com.google.android.exoplayer2.d dVar, int i, int i2, int i3, int i4, int i5, int i6, int i7, AudioProcessor[] audioProcessorArr) {
            this.f2455a = dVar;
            this.f30548a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.f2456a = audioProcessorArr;
        }

        @RequiresApi(21)
        public static AudioAttributes i(com.google.android.exoplayer2.audio.a aVar, boolean z) {
            return z ? j() : aVar.b().f30558a;
        }

        @RequiresApi(21)
        public static AudioAttributes j() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) throws AudioSink.InitializationException {
            try {
                AudioTrack audioTrackD = d(z, aVar, i);
                int state = audioTrackD.getState();
                if (state == 1) {
                    return audioTrackD;
                }
                try {
                    audioTrackD.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.d, this.e, this.g, this.f2455a, l(), null);
            } catch (IllegalArgumentException | UnsupportedOperationException e) {
                throw new AudioSink.InitializationException(0, this.d, this.e, this.g, this.f2455a, l(), e);
            }
        }

        public boolean b(d dVar) {
            return dVar.b == this.b && dVar.f == this.f && dVar.d == this.d && dVar.e == this.e && dVar.c == this.c;
        }

        public d c(int i) {
            return new d(this.f2455a, this.f30548a, this.b, this.c, this.d, this.e, this.f, i, this.f2456a);
        }

        public final AudioTrack d(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            int i2 = gj9.f41922a;
            if (i2 >= 29) {
                return f(z, aVar, i);
            }
            return i2 >= 21 ? e(z, aVar, i) : g(aVar, i);
        }

        @RequiresApi(21)
        public final AudioTrack e(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            return new AudioTrack(i(aVar, z), DefaultAudioSink.z(this.d, this.e, this.f), this.g, 1, i);
        }

        @RequiresApi(29)
        public final AudioTrack f(boolean z, com.google.android.exoplayer2.audio.a aVar, int i) {
            return new AudioTrack.Builder().setAudioAttributes(i(aVar, z)).setAudioFormat(DefaultAudioSink.z(this.d, this.e, this.f)).setTransferMode(1).setBufferSizeInBytes(this.g).setSessionId(i).setOffloadedPlayback(this.b == 1).build();
        }

        public final AudioTrack g(com.google.android.exoplayer2.audio.a aVar, int i) {
            int iR0 = gj9.r0(aVar.M);
            return i == 0 ? new AudioTrack(iR0, this.d, this.e, this.f, this.g, 1) : new AudioTrack(iR0, this.d, this.e, this.f, this.g, 1, i);
        }

        public long h(long j) {
            return (j * 1000000) / ((long) this.d);
        }

        public long k(long j) {
            return (j * 1000000) / ((long) this.f2455a.V);
        }

        public boolean l() {
            return this.b == 1;
        }
    }

    public static class e implements AudioProcessorChain {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.audio.h f30549a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.audio.i f2457a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AudioProcessor[] f2458a;

        public e(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new com.google.android.exoplayer2.audio.h(), new com.google.android.exoplayer2.audio.i());
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public AudioProcessor[] a() {
            return this.f2458a;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public boolean applySkipSilenceEnabled(boolean z) {
            this.f30549a.k(z);
            return z;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public com.google.android.exoplayer2.j b(com.google.android.exoplayer2.j jVar) {
            this.f2457a.e(jVar.f3399a);
            this.f2457a.d(jVar.b);
            return jVar;
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getMediaDuration(long j) {
            return this.f2457a.b(j);
        }

        @Override // com.google.android.exoplayer2.audio.DefaultAudioSink.AudioProcessorChain
        public long getSkippedOutputFrameCount() {
            return this.f30549a.e();
        }

        public e(AudioProcessor[] audioProcessorArr, com.google.android.exoplayer2.audio.h hVar, com.google.android.exoplayer2.audio.i iVar) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[audioProcessorArr.length + 2];
            this.f2458a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f30549a = hVar;
            this.f2457a = iVar;
            audioProcessorArr2[audioProcessorArr.length] = hVar;
            audioProcessorArr2[audioProcessorArr.length + 1] = iVar;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30550a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final com.google.android.exoplayer2.j f2459a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f2460a;
        public final long b;

        public /* synthetic */ f(com.google.android.exoplayer2.j jVar, boolean z, long j, long j2, a aVar) {
            this(jVar, z, j, j2);
        }

        public f(com.google.android.exoplayer2.j jVar, boolean z, long j, long j2) {
            this.f2459a = jVar;
            this.f2460a = z;
            this.f30550a = j;
            this.b = j2;
        }
    }

    public static final class g<T extends Exception> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30551a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public T f2461a;
        public long b;

        public g(long j) {
            this.f30551a = j;
        }

        public void a() {
            this.f2461a = null;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: T extends java.lang.Exception */
        public void b(T t) throws Exception {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f2461a == null) {
                this.f2461a = t;
                this.b = this.f30551a + jElapsedRealtime;
            }
            if (jElapsedRealtime >= this.b) {
                T t2 = this.f2461a;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.f2461a;
                a();
                throw t3;
            }
        }
    }

    public final class h implements AudioTrackPositionTracker.Listener {
        public h() {
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onInvalidLatency(long j) {
            Log.n(DefaultAudioSink.f30544a, "Ignoring impossibly large audio latency: " + j);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionAdvancing(long j) {
            if (DefaultAudioSink.this.f2402a != null) {
                DefaultAudioSink.this.f2402a.onPositionAdvancing(j);
            }
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onPositionFramesMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.F() + ", " + DefaultAudioSink.this.G();
            if (DefaultAudioSink.f2399m) {
                throw new InvalidAudioTrackTimestampException(str, null);
            }
            Log.n(DefaultAudioSink.f30544a, str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onSystemTimeUsMismatch(long j, long j2, long j3, long j4) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j + ", " + j2 + ", " + j3 + ", " + j4 + ", " + DefaultAudioSink.this.F() + ", " + DefaultAudioSink.this.G();
            if (DefaultAudioSink.f2399m) {
                throw new InvalidAudioTrackTimestampException(str, null);
            }
            Log.n(DefaultAudioSink.f30544a, str);
        }

        @Override // com.google.android.exoplayer2.audio.AudioTrackPositionTracker.Listener
        public void onUnderrun(int i, long j) {
            if (DefaultAudioSink.this.f2402a != null) {
                DefaultAudioSink.this.f2402a.onUnderrun(i, j, SystemClock.elapsedRealtime() - DefaultAudioSink.this.f2444g);
            }
        }

        public /* synthetic */ h(DefaultAudioSink defaultAudioSink, a aVar) {
            this();
        }
    }

    @RequiresApi(29)
    public final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AudioTrack.StreamEventCallback f30553a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Handler f2462a = new Handler();

        public class a extends AudioTrack.StreamEventCallback {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ DefaultAudioSink f2464a;

            public a(DefaultAudioSink defaultAudioSink) {
                this.f2464a = defaultAudioSink;
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onDataRequest(AudioTrack audioTrack, int i) {
                sb0.i(audioTrack == DefaultAudioSink.this.f2401a);
                if (DefaultAudioSink.this.f2402a == null || !DefaultAudioSink.this.f2445g) {
                    return;
                }
                DefaultAudioSink.this.f2402a.onOffloadBufferEmptying();
            }

            @Override // android.media.AudioTrack.StreamEventCallback
            public void onTearDown(AudioTrack audioTrack) {
                sb0.i(audioTrack == DefaultAudioSink.this.f2401a);
                if (DefaultAudioSink.this.f2402a == null || !DefaultAudioSink.this.f2445g) {
                    return;
                }
                DefaultAudioSink.this.f2402a.onOffloadBufferEmptying();
            }
        }

        public i() {
            this.f30553a = new a(DefaultAudioSink.this);
        }

        public void a(AudioTrack audioTrack) {
            Handler handler = this.f2462a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new ls1(handler), this.f30553a);
        }

        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f30553a);
            this.f2462a.removeCallbacksAndMessages(null);
        }
    }

    public /* synthetic */ DefaultAudioSink(c cVar, a aVar) {
        this(cVar);
    }

    public static int B(int i2, int i3, int i4) {
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i4);
        sb0.i(minBufferSize != -2);
        return minBufferSize;
    }

    public static int C(int i2, ByteBuffer byteBuffer) {
        switch (i2) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.d(byteBuffer);
            case 7:
            case 8:
                return js2.e(byteBuffer);
            case 9:
                int iM = hs5.m(gj9.Q(byteBuffer, byteBuffer.position()));
                if (iM != -1) {
                    return iM;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 13:
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i2);
            case 14:
                int iA = Ac3Util.a(byteBuffer);
                if (iA == -1) {
                    return 0;
                }
                return Ac3Util.h(byteBuffer, iA) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return mr.c(byteBuffer);
        }
    }

    public static boolean I(int i2) {
        return (gj9.f41922a >= 24 && i2 == -6) || i2 == -32;
    }

    public static boolean K(AudioTrack audioTrack) {
        return gj9.f41922a >= 29 && audioTrack.isOffloadedPlayback();
    }

    @RequiresApi(21)
    public static void T(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    public static void U(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    @RequiresApi(21)
    public static int a0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @RequiresApi(21)
    public static AudioFormat z(int i2, int i3, int i4) {
        return new AudioFormat.Builder().setSampleRate(i2).setChannelMask(i3).setEncoding(i4).build();
    }

    public final com.google.android.exoplayer2.j A() {
        return D().f2459a;
    }

    public final f D() {
        f fVar = this.f2407a;
        if (fVar != null) {
            return fVar;
        }
        return !this.f2419a.isEmpty() ? this.f2419a.getLast() : this.f2426b;
    }

    @RequiresApi(29)
    @SuppressLint({"InlinedApi"})
    public final int E(AudioFormat audioFormat, AudioAttributes audioAttributes) {
        int i2 = gj9.f41922a;
        if (i2 >= 31) {
            return AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        }
        if (AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes)) {
            return (i2 == 30 && gj9.c.startsWith("Pixel")) ? 2 : 1;
        }
        return 0;
    }

    public final long F() {
        d dVar = this.f2425b;
        return dVar.b == 0 ? this.f2424b / ((long) dVar.f30548a) : this.f2431c;
    }

    public final long G() {
        d dVar = this.f2425b;
        return dVar.b == 0 ? this.f2436d / ((long) dVar.c) : this.f2439e;
    }

    public final boolean H() throws AudioSink.InitializationException {
        at6 at6Var;
        if (!this.f2416a.e()) {
            return false;
        }
        AudioTrack audioTrackW = w();
        this.f2401a = audioTrackW;
        if (K(audioTrackW)) {
            O(this.f2401a);
            if (this.f2435d != 3) {
                AudioTrack audioTrack = this.f2401a;
                com.google.android.exoplayer2.d dVar = this.f2425b.f2455a;
                audioTrack.setOffloadDelayPadding(dVar.X, dVar.Y);
            }
        }
        if (gj9.f41922a >= 31 && (at6Var = this.f2414a) != null) {
            b.a(this.f2401a, at6Var);
        }
        this.j = this.f2401a.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker = this.f2403a;
        AudioTrack audioTrack2 = this.f2401a;
        d dVar2 = this.f2425b;
        audioTrackPositionTracker.s(audioTrack2, dVar2.b == 2, dVar2.f, dVar2.c, dVar2.g);
        S();
        int i2 = this.f2415a.f18849a;
        if (i2 != 0) {
            this.f2401a.attachAuxEffect(i2);
            this.f2401a.setAuxEffectSendLevel(this.f2415a.f43985a);
        }
        this.f2437d = true;
        return true;
    }

    public final boolean J() {
        return this.f2401a != null;
    }

    public final void L() {
        if (this.f2425b.l()) {
            this.f2448j = true;
        }
    }

    public final void M() {
        if (this.f2443f) {
            return;
        }
        this.f2443f = true;
        this.f2403a.g(G());
        this.f2401a.stop();
        this.f2438e = 0;
    }

    public final void N(long j) throws Exception {
        ByteBuffer byteBuffer;
        int length = this.f2434c.length;
        int i2 = length;
        while (i2 >= 0) {
            if (i2 > 0) {
                byteBuffer = this.f2423a[i2 - 1];
            } else {
                byteBuffer = this.f2428b;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.f30536a;
                }
            }
            if (i2 == length) {
                Z(byteBuffer, j);
            } else {
                AudioProcessor audioProcessor = this.f2434c[i2];
                if (i2 > this.i) {
                    audioProcessor.queueInput(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.f2423a[i2] = output;
                if (output.hasRemaining()) {
                    i2++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i2--;
            }
        }
    }

    @RequiresApi(29)
    public final void O(AudioTrack audioTrack) {
        if (this.f2409a == null) {
            this.f2409a = new i();
        }
        this.f2409a.a(audioTrack);
    }

    public final void P() {
        this.f2424b = 0L;
        this.f2431c = 0L;
        this.f2436d = 0L;
        this.f2439e = 0L;
        this.f2449k = false;
        this.f2441f = 0;
        this.f2426b = new f(A(), getSkipSilenceEnabled(), 0L, 0L, null);
        this.f2442f = 0L;
        this.f2407a = null;
        this.f2419a.clear();
        this.f2428b = null;
        this.g = 0;
        this.f2432c = null;
        this.f2443f = false;
        this.f2440e = false;
        this.i = -1;
        this.f2418a = null;
        this.f2438e = 0;
        this.f2412a.c();
        y();
    }

    public final void Q(com.google.android.exoplayer2.j jVar, boolean z) {
        f fVarD = D();
        if (jVar.equals(fVarD.f2459a) && z == fVarD.f2460a) {
            return;
        }
        f fVar = new f(jVar, z, -9223372036854775807L, -9223372036854775807L, null);
        if (J()) {
            this.f2407a = fVar;
        } else {
            this.f2426b = fVar;
        }
    }

    @RequiresApi(23)
    public final void R(com.google.android.exoplayer2.j jVar) {
        if (J()) {
            try {
                this.f2401a.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(jVar.f3399a).setPitch(jVar.b).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log.o(f30544a, "Failed to set playback params", e2);
            }
            jVar = new com.google.android.exoplayer2.j(this.f2401a.getPlaybackParams().getSpeed(), this.f2401a.getPlaybackParams().getPitch());
            this.f2403a.t(jVar.f3399a);
        }
        this.f2413a = jVar;
    }

    public final void S() {
        if (J()) {
            if (gj9.f41922a >= 21) {
                T(this.f2401a, this.f2400a);
            } else {
                U(this.f2401a, this.f2400a);
            }
        }
    }

    public final void V() {
        AudioProcessor[] audioProcessorArr = this.f2425b.f2456a;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.f2434c = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.f2423a = new ByteBuffer[size];
        y();
    }

    public final boolean W() {
        return (this.f2447i || !"audio/raw".equals(this.f2425b.f2455a.k) || X(this.f2425b.f2455a.W)) ? false : true;
    }

    public final boolean X(int i2) {
        return this.f2420a && gj9.I0(i2);
    }

    public final boolean Y(com.google.android.exoplayer2.d dVar, com.google.android.exoplayer2.audio.a aVar) {
        int iF;
        int iN;
        int iE;
        if (gj9.f41922a < 29 || this.f2435d == 0 || (iF = bp5.f((String) sb0.g(dVar.k), dVar.i)) == 0 || (iN = gj9.N(dVar.U)) == 0 || (iE = E(z(dVar.V, iN, iF), aVar.b().f30558a)) == 0) {
            return false;
        }
        if (iE == 1) {
            return ((dVar.X != 0 || dVar.Y != 0) && (this.f2435d == 1)) ? false : true;
        }
        if (iE == 2) {
            return true;
        }
        throw new IllegalStateException();
    }

    public final void Z(ByteBuffer byteBuffer, long j) throws Exception {
        int iA0;
        AudioSink.Listener listener;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.f2432c;
            if (byteBuffer2 != null) {
                sb0.a(byteBuffer2 == byteBuffer);
            } else {
                this.f2432c = byteBuffer;
                if (gj9.f41922a < 21) {
                    int iRemaining = byteBuffer.remaining();
                    byte[] bArr = this.f2421a;
                    if (bArr == null || bArr.length < iRemaining) {
                        this.f2421a = new byte[iRemaining];
                    }
                    int iPosition = byteBuffer.position();
                    byteBuffer.get(this.f2421a, 0, iRemaining);
                    byteBuffer.position(iPosition);
                    this.h = 0;
                }
            }
            int iRemaining2 = byteBuffer.remaining();
            if (gj9.f41922a < 21) {
                int iC = this.f2403a.c(this.f2436d);
                if (iC > 0) {
                    iA0 = this.f2401a.write(this.f2421a, this.h, Math.min(iRemaining2, iC));
                    if (iA0 > 0) {
                        this.h += iA0;
                        byteBuffer.position(byteBuffer.position() + iA0);
                    }
                } else {
                    iA0 = 0;
                }
            } else if (this.f2447i) {
                sb0.i(j != -9223372036854775807L);
                iA0 = b0(this.f2401a, byteBuffer, iRemaining2, j);
            } else {
                iA0 = a0(this.f2401a, byteBuffer, iRemaining2);
            }
            this.f2444g = SystemClock.elapsedRealtime();
            if (iA0 < 0) {
                boolean zI = I(iA0);
                if (zI) {
                    L();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(iA0, this.f2425b.f2455a, zI);
                AudioSink.Listener listener2 = this.f2402a;
                if (listener2 != null) {
                    listener2.onAudioSinkError(writeException);
                }
                if (writeException.isRecoverable) {
                    throw writeException;
                }
                this.f2427b.b(writeException);
                return;
            }
            this.f2427b.a();
            if (K(this.f2401a)) {
                if (this.f2439e > 0) {
                    this.f2449k = false;
                }
                if (this.f2445g && (listener = this.f2402a) != null && iA0 < iRemaining2 && !this.f2449k) {
                    listener.onOffloadBufferFull();
                }
            }
            int i2 = this.f2425b.b;
            if (i2 == 0) {
                this.f2436d += (long) iA0;
            }
            if (iA0 == iRemaining2) {
                if (i2 != 0) {
                    sb0.i(byteBuffer == this.f2428b);
                    this.f2439e += ((long) this.f2441f) * ((long) this.g);
                }
                this.f2432c = null;
            }
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean a(com.google.android.exoplayer2.d dVar) {
        return f(dVar) != 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public com.google.android.exoplayer2.j b() {
        return this.f2429b ? this.f2413a : A();
    }

    @RequiresApi(21)
    public final int b0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j) {
        if (gj9.f41922a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j * 1000);
        }
        if (this.f2418a == null) {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            this.f2418a = byteBufferAllocate;
            byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
            this.f2418a.putInt(1431633921);
        }
        if (this.f2438e == 0) {
            this.f2418a.putInt(4, i2);
            this.f2418a.putLong(8, j * 1000);
            this.f2418a.position(0);
            this.f2438e = i2;
        }
        int iRemaining = this.f2418a.remaining();
        if (iRemaining > 0) {
            int iWrite = audioTrack.write(this.f2418a, iRemaining, 1);
            if (iWrite < 0) {
                this.f2438e = 0;
                return iWrite;
            }
            if (iWrite < iRemaining) {
                return 0;
            }
        }
        int iA0 = a0(audioTrack, byteBuffer, i2);
        if (iA0 < 0) {
            this.f2438e = 0;
            return iA0;
        }
        this.f2438e -= iA0;
        return iA0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void c(com.google.android.exoplayer2.j jVar) {
        com.google.android.exoplayer2.j jVar2 = new com.google.android.exoplayer2.j(gj9.r(jVar.f3399a, 0.1f, 8.0f), gj9.r(jVar.b, 0.1f, 8.0f));
        if (!this.f2429b || gj9.f41922a < 23) {
            Q(jVar2, getSkipSilenceEnabled());
        } else {
            R(jVar2);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public com.google.android.exoplayer2.audio.a d() {
        return this.f2410a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void disableTunneling() {
        if (this.f2447i) {
            this.f2447i = false;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void e(pi0 pi0Var) {
        if (this.f2415a.equals(pi0Var)) {
            return;
        }
        int i2 = pi0Var.f18849a;
        float f2 = pi0Var.f43985a;
        AudioTrack audioTrack = this.f2401a;
        if (audioTrack != null) {
            if (this.f2415a.f18849a != i2) {
                audioTrack.attachAuxEffect(i2);
            }
            if (i2 != 0) {
                this.f2401a.setAuxEffectSendLevel(f2);
            }
        }
        this.f2415a = pi0Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void enableTunnelingV21() {
        sb0.i(gj9.f41922a >= 21);
        sb0.i(this.f2446h);
        if (this.f2447i) {
            return;
        }
        this.f2447i = true;
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void experimentalFlushWithoutAudioTrackRelease() {
        if (gj9.f41922a < 25) {
            flush();
            return;
        }
        this.f2427b.a();
        this.f2408a.a();
        if (J()) {
            P();
            if (this.f2403a.i()) {
                this.f2401a.pause();
            }
            this.f2401a.flush();
            this.f2403a.q();
            AudioTrackPositionTracker audioTrackPositionTracker = this.f2403a;
            AudioTrack audioTrack = this.f2401a;
            d dVar = this.f2425b;
            audioTrackPositionTracker.s(audioTrack, dVar.b == 2, dVar.f, dVar.c, dVar.g);
            this.f2437d = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public int f(com.google.android.exoplayer2.d dVar) {
        if (!"audio/raw".equals(dVar.k)) {
            return ((this.f2448j || !Y(dVar, this.f2410a)) && !this.f2417a.j(dVar)) ? 0 : 2;
        }
        if (gj9.J0(dVar.W)) {
            int i2 = dVar.W;
            return (i2 == 2 || (this.f2420a && i2 == 4)) ? 2 : 1;
        }
        Log.n(f30544a, "Invalid PCM encoding: " + dVar.W);
        return 0;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void flush() {
        if (J()) {
            P();
            if (this.f2403a.i()) {
                this.f2401a.pause();
            }
            if (K(this.f2401a)) {
                ((i) sb0.g(this.f2409a)).b(this.f2401a);
            }
            AudioTrack audioTrack = this.f2401a;
            this.f2401a = null;
            if (gj9.f41922a < 21 && !this.f2446h) {
                this.j = 0;
            }
            d dVar = this.f2406a;
            if (dVar != null) {
                this.f2425b = dVar;
                this.f2406a = null;
            }
            this.f2403a.q();
            this.f2416a.d();
            new a("ExoPlayer:AudioTrackReleaseThread", audioTrack).start();
        }
        this.f2427b.a();
        this.f2408a.a();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void g(com.google.android.exoplayer2.d dVar, int i2, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int i3;
        int i4;
        int iIntValue;
        int i5;
        int iP0;
        int iF;
        int i6;
        int iA;
        int[] iArr2;
        if ("audio/raw".equals(dVar.k)) {
            sb0.a(gj9.J0(dVar.W));
            int iP1 = gj9.p0(dVar.W, dVar.U);
            AudioProcessor[] audioProcessorArr2 = X(dVar.W) ? this.f2430b : this.f2422a;
            this.f2412a.d(dVar.X, dVar.Y);
            if (gj9.f41922a < 21 && dVar.U == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i7 = 0; i7 < 6; i7++) {
                    iArr2[i7] = i7;
                }
            } else {
                iArr2 = iArr;
            }
            this.f2411a.b(iArr2);
            AudioProcessor.a aVar = new AudioProcessor.a(dVar.V, dVar.U, dVar.W);
            for (AudioProcessor audioProcessor : audioProcessorArr2) {
                try {
                    AudioProcessor.a aVarA = audioProcessor.a(aVar);
                    if (audioProcessor.isActive()) {
                        aVar = aVarA;
                    }
                } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                    throw new AudioSink.ConfigurationException(e2, dVar);
                }
            }
            int i8 = aVar.c;
            int i9 = aVar.f2360a;
            int iN = gj9.N(aVar.b);
            audioProcessorArr = audioProcessorArr2;
            iP0 = gj9.p0(i8, aVar.b);
            iF = i8;
            i3 = i9;
            iIntValue = iN;
            i5 = iP1;
            i6 = 0;
        } else {
            audioProcessorArr = new AudioProcessor[0];
            i3 = dVar.V;
            if (Y(dVar, this.f2410a)) {
                i4 = 1;
                iF = bp5.f((String) sb0.g(dVar.k), dVar.i);
                i5 = -1;
                iP0 = -1;
                iIntValue = gj9.N(dVar.U);
            } else {
                Pair<Integer, Integer> pairF = this.f2417a.f(dVar);
                if (pairF == null) {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + dVar, dVar);
                }
                int iIntValue2 = ((Integer) pairF.first).intValue();
                i4 = 2;
                iIntValue = ((Integer) pairF.second).intValue();
                i5 = -1;
                iP0 = -1;
                iF = iIntValue2;
            }
            i6 = i4;
        }
        if (i2 != 0) {
            iA = i2;
        } else {
            iA = this.f2405a.a(B(i3, iIntValue, iF), iF, i6, iP0, i3, this.f2429b ? 8.0d : 1.0d);
        }
        if (iF == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i6 + ") for: " + dVar, dVar);
        }
        if (iIntValue == 0) {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i6 + ") for: " + dVar, dVar);
        }
        this.f2448j = false;
        d dVar2 = new d(dVar, i5, i6, iP0, i3, iIntValue, iF, iA, audioProcessorArr);
        if (J()) {
            this.f2406a = dVar2;
        } else {
            this.f2425b = dVar2;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public long getCurrentPositionUs(boolean z) {
        if (!J() || this.f2437d) {
            return Long.MIN_VALUE;
        }
        return u(t(Math.min(this.f2403a.d(z), this.f2425b.h(G()))));
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean getSkipSilenceEnabled() {
        return D().f2460a;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void h(@Nullable at6 at6Var) {
        this.f2414a = at6Var;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean handleBuffer(ByteBuffer byteBuffer, long j, int i2) throws Exception {
        ByteBuffer byteBuffer2 = this.f2428b;
        sb0.a(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (this.f2406a != null) {
            if (!x()) {
                return false;
            }
            if (this.f2406a.b(this.f2425b)) {
                this.f2425b = this.f2406a;
                this.f2406a = null;
                if (K(this.f2401a) && this.f2435d != 3) {
                    if (this.f2401a.getPlayState() == 3) {
                        this.f2401a.setOffloadEndOfStream();
                    }
                    AudioTrack audioTrack = this.f2401a;
                    com.google.android.exoplayer2.d dVar = this.f2425b.f2455a;
                    audioTrack.setOffloadDelayPadding(dVar.X, dVar.Y);
                    this.f2449k = true;
                }
            } else {
                M();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            }
            s(j);
        }
        if (!J()) {
            try {
                if (!H()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e2) {
                if (e2.isRecoverable) {
                    throw e2;
                }
                this.f2408a.b(e2);
                return false;
            }
        }
        this.f2408a.a();
        if (this.f2437d) {
            this.f2442f = Math.max(0L, j);
            this.f2433c = false;
            this.f2437d = false;
            if (this.f2429b && gj9.f41922a >= 23) {
                R(this.f2413a);
            }
            s(j);
            if (this.f2445g) {
                play();
            }
        }
        if (!this.f2403a.k(G())) {
            return false;
        }
        if (this.f2428b == null) {
            sb0.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            d dVar2 = this.f2425b;
            if (dVar2.b != 0 && this.f2441f == 0) {
                int iC = C(dVar2.f, byteBuffer);
                this.f2441f = iC;
                if (iC == 0) {
                    return true;
                }
            }
            if (this.f2407a != null) {
                if (!x()) {
                    return false;
                }
                s(j);
                this.f2407a = null;
            }
            long jK = this.f2442f + this.f2425b.k(F() - this.f2412a.b());
            if (!this.f2433c && Math.abs(jK - j) > 200000) {
                this.f2402a.onAudioSinkError(new AudioSink.UnexpectedDiscontinuityException(j, jK));
                this.f2433c = true;
            }
            if (this.f2433c) {
                if (!x()) {
                    return false;
                }
                long j2 = j - jK;
                this.f2442f += j2;
                this.f2433c = false;
                s(j);
                AudioSink.Listener listener = this.f2402a;
                if (listener != null && j2 != 0) {
                    listener.onPositionDiscontinuity();
                }
            }
            if (this.f2425b.b == 0) {
                this.f2424b += (long) byteBuffer.remaining();
            } else {
                this.f2431c += ((long) this.f2441f) * ((long) i2);
            }
            this.f2428b = byteBuffer;
            this.g = i2;
        }
        N(j);
        if (!this.f2428b.hasRemaining()) {
            this.f2428b = null;
            this.g = 0;
            return true;
        }
        if (!this.f2403a.j(G())) {
            return false;
        }
        Log.n(f30544a, "Resetting stalled audio track");
        flush();
        return true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void handleDiscontinuity() {
        this.f2433c = true;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean hasPendingData() {
        return J() && this.f2403a.h(G());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void i(AudioSink.Listener listener) {
        this.f2402a = listener;
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public boolean isEnded() {
        return !J() || (this.f2440e && !hasPendingData());
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void j(com.google.android.exoplayer2.audio.a aVar) {
        if (this.f2410a.equals(aVar)) {
            return;
        }
        this.f2410a = aVar;
        if (this.f2447i) {
            return;
        }
        flush();
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void pause() {
        this.f2445g = false;
        if (J() && this.f2403a.p()) {
            this.f2401a.pause();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void play() {
        this.f2445g = true;
        if (J()) {
            this.f2403a.u();
            this.f2401a.play();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.f2440e && J() && x()) {
            M();
            this.f2440e = true;
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void reset() {
        flush();
        for (AudioProcessor audioProcessor : this.f2422a) {
            audioProcessor.reset();
        }
        for (AudioProcessor audioProcessor2 : this.f2430b) {
            audioProcessor2.reset();
        }
        this.f2445g = false;
        this.f2448j = false;
    }

    public final void s(long j) {
        com.google.android.exoplayer2.j jVarB = W() ? this.f2404a.b(A()) : com.google.android.exoplayer2.j.f3398a;
        boolean zApplySkipSilenceEnabled = W() ? this.f2404a.applySkipSilenceEnabled(getSkipSilenceEnabled()) : false;
        this.f2419a.add(new f(jVarB, zApplySkipSilenceEnabled, Math.max(0L, j), this.f2425b.h(G()), null));
        V();
        AudioSink.Listener listener = this.f2402a;
        if (listener != null) {
            listener.onSkipSilenceEnabledChanged(zApplySkipSilenceEnabled);
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setAudioSessionId(int i2) {
        if (this.j != i2) {
            this.j = i2;
            this.f2446h = i2 != 0;
            flush();
        }
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setSkipSilenceEnabled(boolean z) {
        Q(A(), z);
    }

    @Override // com.google.android.exoplayer2.audio.AudioSink
    public void setVolume(float f2) {
        if (this.f2400a != f2) {
            this.f2400a = f2;
            S();
        }
    }

    public final long t(long j) {
        while (!this.f2419a.isEmpty() && j >= this.f2419a.getFirst().b) {
            this.f2426b = this.f2419a.remove();
        }
        f fVar = this.f2426b;
        long j2 = j - fVar.b;
        if (fVar.f2459a.equals(com.google.android.exoplayer2.j.f3398a)) {
            return this.f2426b.f30550a + j2;
        }
        if (this.f2419a.isEmpty()) {
            return this.f2426b.f30550a + this.f2404a.getMediaDuration(j2);
        }
        f first = this.f2419a.getFirst();
        return first.f30550a - gj9.l0(first.b - j, this.f2426b.f2459a.f3399a);
    }

    public final long u(long j) {
        return j + this.f2425b.h(this.f2404a.getSkippedOutputFrameCount());
    }

    public final AudioTrack v(d dVar) throws AudioSink.InitializationException {
        try {
            return dVar.a(this.f2447i, this.f2410a, this.j);
        } catch (AudioSink.InitializationException e2) {
            AudioSink.Listener listener = this.f2402a;
            if (listener != null) {
                listener.onAudioSinkError(e2);
            }
            throw e2;
        }
    }

    public final AudioTrack w() throws AudioSink.InitializationException {
        try {
            return v((d) sb0.g(this.f2425b));
        } catch (AudioSink.InitializationException e2) {
            d dVar = this.f2425b;
            if (dVar.g > 1000000) {
                d dVarC = dVar.c(1000000);
                try {
                    AudioTrack audioTrackV = v(dVarC);
                    this.f2425b = dVarC;
                    return audioTrackV;
                } catch (AudioSink.InitializationException e3) {
                    e2.addSuppressed(e3);
                    L();
                    throw e2;
                }
            }
            L();
            throw e2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001c  */
    /* JADX WARN: Code duplicated, block: B:14:0x0028 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:15:0x0029  */
    /* JADX WARN: Code duplicated, block: B:9:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0029 -> B:5:0x0009). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final boolean x() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.i
            r1 = 1
            r2 = 0
            r3 = -1
            if (r0 != r3) goto Lb
            r9.i = r2
        L9:
            r0 = r1
            goto Lc
        Lb:
            r0 = r2
        Lc:
            int r4 = r9.i
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.f2434c
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L2f
            r4 = r5[r4]
            if (r0 == 0) goto L1f
            r4.queueEndOfStream()
        L1f:
            r9.N(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L29
            return r2
        L29:
            int r0 = r9.i
            int r0 = r0 + r1
            r9.i = r0
            goto L9
        L2f:
            java.nio.ByteBuffer r0 = r9.f2432c
            if (r0 == 0) goto L3b
            r9.Z(r0, r7)
            java.nio.ByteBuffer r0 = r9.f2432c
            if (r0 == 0) goto L3b
            return r2
        L3b:
            r9.i = r3
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.x():boolean");
    }

    public final void y() {
        int i2 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.f2434c;
            if (i2 >= audioProcessorArr.length) {
                return;
            }
            AudioProcessor audioProcessor = audioProcessorArr[i2];
            audioProcessor.flush();
            this.f2423a[i2] = audioProcessor.getOutput();
            i2++;
        }
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessors(audioProcessors).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable qe0 qe0Var, AudioProcessor[] audioProcessorArr) {
        this(new c().g((qe0) com.google.common.base.e.a(qe0Var, qe0.f19069a)).i(audioProcessorArr));
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessors(audioProcessors).setEnableFloatOutput(enableFloatOutput).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable qe0 qe0Var, AudioProcessor[] audioProcessorArr, boolean z) {
        this(new c().g((qe0) com.google.common.base.e.a(qe0Var, qe0.f19069a)).i(audioProcessorArr).l(z));
    }

    @InlineMe(imports = {"com.google.android.exoplayer2.audio.DefaultAudioSink"}, replacement = "new DefaultAudioSink.Builder().setAudioCapabilities(audioCapabilities).setAudioProcessorChain(audioProcessorChain).setEnableFloatOutput(enableFloatOutput).setEnableAudioTrackPlaybackParams(enableAudioTrackPlaybackParams).setOffloadMode(offloadMode).build()")
    @InlineMeValidationDisabled("Migrate constructor to Builder")
    @Deprecated
    public DefaultAudioSink(@Nullable qe0 qe0Var, AudioProcessorChain audioProcessorChain, boolean z, boolean z2, int i2) {
        this(new c().g((qe0) com.google.common.base.e.a(qe0Var, qe0.f19069a)).h(audioProcessorChain).l(z).k(z2).m(i2));
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    public DefaultAudioSink(c cVar) {
        this.f2417a = cVar.f2453a;
        AudioProcessorChain audioProcessorChain = cVar.f2451a;
        this.f2404a = audioProcessorChain;
        int i2 = gj9.f41922a;
        this.f2420a = i2 >= 21 && cVar.f2454a;
        this.f2429b = i2 >= 23 && cVar.b;
        this.f2435d = i2 >= 29 ? cVar.f30547a : 0;
        this.f2405a = cVar.f2452a;
        ps1 ps1Var = new ps1(Clock.f31152a);
        this.f2416a = ps1Var;
        ps1Var.f();
        this.f2403a = new AudioTrackPositionTracker(new h(this, null));
        com.google.android.exoplayer2.audio.b bVar = new com.google.android.exoplayer2.audio.b();
        this.f2411a = bVar;
        j jVar = new j();
        this.f2412a = jVar;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new com.google.android.exoplayer2.audio.g(), bVar, jVar);
        Collections.addAll(arrayList, audioProcessorChain.a());
        this.f2422a = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.f2430b = new AudioProcessor[]{new com.google.android.exoplayer2.audio.d()};
        this.f2400a = 1.0f;
        this.f2410a = com.google.android.exoplayer2.audio.a.f2470a;
        this.j = 0;
        this.f2415a = new pi0(0, 0.0f);
        com.google.android.exoplayer2.j jVar2 = com.google.android.exoplayer2.j.f3398a;
        this.f2426b = new f(jVar2, false, 0L, 0L, null);
        this.f2413a = jVar2;
        this.i = -1;
        this.f2434c = new AudioProcessor[0];
        this.f2423a = new ByteBuffer[0];
        this.f2419a = new ArrayDeque<>();
        this.f2408a = new g<>(100L);
        this.f2427b = new g<>(100L);
    }
}
