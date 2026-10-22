package com.bykv.vk.component.ttvideo;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.bykv.vk.component.ttvideo.log.VideoEventEngineUploader;
import com.bykv.vk.component.ttvideo.log.d;
import com.bykv.vk.component.ttvideo.log.e;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bykv.vk.component.ttvideo.player.TTPlayerConfiger;
import com.bykv.vk.component.ttvideo.utils.EngineThreadPool;
import com.bykv.vk.component.ttvideo.utils.Error;
import com.bykv.vk.component.ttvideo.utils.TTVideoEngineLog;
import com.kuaishou.weapon.p0.t;
import java.io.FileDescriptor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
public class TTVideoEngine implements com.bykv.vk.component.ttvideo.log.a, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    public static final int ENGINE_STATE_ERROR = 4;
    public static final int ENGINE_STATE_PLAYER_RUNNING = 3;
    public static final int ENGINE_STATE_RELEASE = 5;
    public static final int ENGINE_STATE_UNKNOWN = 0;
    public static final int LOAD_STATE_ERROR = 3;
    public static final int LOAD_STATE_PLAYABLE = 1;
    public static final int LOAD_STATE_STALLED = 2;
    public static final int LOAD_STATE_UNKNOWN = 0;
    public static final int PLAYBACK_STATE_ERROR = 3;
    public static final int PLAYBACK_STATE_PAUSED = 2;
    public static final int PLAYBACK_STATE_PLAYING = 1;
    public static final int PLAYBACK_STATE_STOPPED = 0;
    public static final int PLAYER_BUFFERING_DATA_OF_MILLISECONDS = 118;
    public static final int PLAYER_BUFFERING_TIMEOUT = 11;
    public static final int PLAYER_MAX_BUFFERING_DATA_OF_MILLISECONDS = 202;
    public static final int PLAYER_NETWORK_TIMEOUT = 12;
    public static final int PLAYER_OPTION_ENABLE_DATALOADER = 160;
    public static final int PLAYER_OPTION_NOTIFY_BUFFERING_DIRECTLY = 322;
    public static final int PLAYER_OPTION_OUTPUT_LOG = 472;
    public static final int PLAYER_TIME_BASE = 1000000;
    public static final int PLAYER_TYPE_OS = 1;
    public static final int PLAYER_TYPE_OWN = 0;
    private static boolean l0;
    VideoEngineSimpleCallback B;
    SeekCompletionListener C;
    private final Context D;
    private Surface E;
    private SurfaceHolder F;
    private final com.bykv.vk.component.ttvideo.log.b G;
    private MediaPlayer H;
    private Handler I;
    private boolean K;
    private final com.bykv.vk.component.ttvideo.utils.a W;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f29280a;
    private int b;
    private boolean c;
    private boolean d;
    private int e;
    private long e0;
    private long f0;
    private FileDescriptor g0;
    private boolean h;
    private com.bykv.vk.component.ttvideo.b h0;
    private boolean i;
    private boolean j;
    private boolean o;
    private boolean p;
    private boolean t;
    private boolean v;
    private int x;
    private String y;
    private int z;
    private boolean f = true;
    private boolean g = true;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private int q = 0;
    private int r = 30;
    private int s = 5000;
    private int u = 1;
    private boolean w = true;
    private final HashMap<String, String> A = new HashMap<>();
    private int J = 0;
    private float L = -1.0f;
    private boolean M = false;
    private String N = "";
    private boolean O = false;
    private String P = "";
    private int Q = 0;
    private boolean R = false;
    private Error S = null;
    private boolean T = false;
    private boolean U = false;
    private int V = -1;
    private boolean X = false;
    private final Map<String, String> Y = new HashMap();
    private final List<String> Z = new ArrayList();
    private String a0 = null;
    private boolean b0 = false;
    private long c0 = 0;
    private int d0 = -1;
    private int i0 = 0;
    private int j0 = 0;
    private int k0 = 5000;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ MediaPlayer f29281a;

        public a(TTVideoEngine tTVideoEngine, MediaPlayer mediaPlayer) {
            this.f29281a = mediaPlayer;
        }

        @Override // java.lang.Runnable
        public void run() {
            MediaPlayer mediaPlayer = this.f29281a;
            if (mediaPlayer != null) {
                try {
                    mediaPlayer.release();
                } catch (Exception e) {
                    TTVideoEngineLog.i("TTVideoEngine", "release Exception " + e);
                }
            }
        }
    }

    public class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoEngineSimpleCallback videoEngineSimpleCallback;
            super.handleMessage(message);
            if (message.what == 10) {
                String str = (String) message.obj;
                long j = message.arg1;
                if (TTVideoEngine.this.b == 5 || !TTVideoEngine.this.Y.containsKey(str) || (videoEngineSimpleCallback = TTVideoEngine.this.B) == null) {
                    return;
                }
                videoEngineSimpleCallback.onMDLHitCache(str, j);
            }
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<String, String> f29283a;
        private final WeakReference<TTVideoEngine> b;

        public c(TTVideoEngine tTVideoEngine, Map<String, String> map) {
            this.b = new WeakReference<>(tTVideoEngine);
            this.f29283a = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            Map<String, String> map;
            TTVideoEngine tTVideoEngine = this.b.get();
            if (tTVideoEngine == null || tTVideoEngine.b == 5 || (map = this.f29283a) == null || map.size() <= 0) {
                return;
            }
            for (String str : this.f29283a.keySet()) {
                String str2 = this.f29283a.get(str);
                long cacheFileSizeByFilePath = !TextUtils.isEmpty(str2) ? TTVideoEngine.getCacheFileSizeByFilePath(str, str2) : TTVideoEngine.getCacheFileSize(str);
                if (tTVideoEngine.I != null) {
                    int i = (int) cacheFileSizeByFilePath;
                    tTVideoEngine.I.sendMessage(Message.obtain(tTVideoEngine.I, 10, i, i, str));
                }
            }
        }
    }

    public TTVideoEngine(Context context, int i) {
        TTVideoEngineLog.i("TTVideoEngine", "init, type:" + i + ", context:" + context + ", this:" + this);
        this.D = context;
        this.z = i;
        this.t = l0;
        this.G = new d(context, this);
        this.W = new com.bykv.vk.component.ttvideo.utils.a();
        e.instance.a(context);
    }

    private String a(String str, String str2, long j, String[] strArr, String str3) {
        String str_proxyUrl = DataLoaderHelper.getDataLoader()._proxyUrl(str, str2, j, strArr, str3);
        if (!TextUtils.isEmpty(str_proxyUrl)) {
            TTVideoEngineLog.i("TTVideoEngine", "_mdlUrl get proxyUrl: key = " + str + ", videoId = " + str2);
            if (TextUtils.isEmpty(str2)) {
                str2 = str;
            }
            this.a0 = str2;
            if (!TextUtils.isEmpty(str)) {
                this.Y.put(str, str3);
            }
            d();
        }
        return str_proxyUrl;
    }

    private void a(int i, int i2) {
        if (this.l != i) {
            TTVideoEngineLog.i("TTVideoEngine", "load state changed prev:" + this.l + ", new:" + i);
            if (i == 2 && this.f29280a && !this.c && this.l != 3) {
                this.V = i2;
            }
            this.l = i;
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                if (this.T || i != 3) {
                    videoEngineSimpleCallback.onLoadStateChanged(this, i);
                }
            }
        }
    }

    private void a(Error error) {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            this.G.b(aVar.b());
        }
        this.G.a(error, 0);
        this.j = false;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onError(error);
        }
        this.Q = 0;
    }

    /* JADX WARN: Code duplicated, block: B:58:0x01ab  */
    private void a(String str, HashMap map) {
        Surface surface;
        VideoEngineSimpleCallback videoEngineSimpleCallback;
        String str2 = Error.VideoOSPlayer;
        if (this.U) {
            TTVideoEngineLog.w("TTVideoEngine", "_playInternal should stop");
            return;
        }
        if (this.H != null && isSystemPlayer()) {
            this.H.release();
            this.H = null;
            this.b0 = false;
        }
        b(str);
        if (this.H == null) {
            MediaPlayer mediaPlayerA = com.bykv.vk.component.ttvideo.a.a(this.D, this.z);
            this.H = mediaPlayerA;
            int playerType = mediaPlayerA.getPlayerType();
            if (playerType == 0) {
                this.z = 1;
            } else if (playerType == 1) {
                this.z = 0;
            }
            this.H.setOnPreparedListener(this);
            this.H.setOnBufferingUpdateListener(this);
            this.H.setOnCompletionListener(this);
            this.H.setOnErrorListener(this);
            this.H.setOnSeekCompleteListener(this);
            this.H.setOnInfoListener(this);
            this.H.setOnVideoSizeChangedListener(this);
            b(this.K);
            this.h = false;
        } else if (this.S != null) {
            TTVideoEngineLog.i("TTVideoEngine", "mediaPlayer reset, surface holder:" + this.F + " ,surface empty:" + this.E);
            this.H.reset();
            this.h = false;
            this.S = null;
        }
        this.H.setIntOption(100, this.J);
        this.H.setIntOption(82, 1);
        this.H.setIntOption(59, 1);
        this.H.setIntOption(97, 1);
        this.H.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, this.q);
        this.H.setIntOption(81, this.r);
        this.H.setIntOption(9, this.s * 1000000);
        this.H.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, !this.f ? 1 : 0);
        this.H.setIntOption(94, 1);
        float f = this.L;
        if (f >= 0.0f) {
            this.H.setVolume(f, f);
        }
        this.H.setIntOption(86, this.j0);
        this.H.setIntOption(110, this.k0);
        this.H.setIntOption(211, this.i0);
        if (this.t) {
            EngineThreadPool.a().execute(new c(this, new HashMap(this.Y)));
        }
        try {
            this.H.setScreenOnWhilePlaying(this.w);
            int i = this.x;
            if (i != 0) {
                this.H.setWakeMode(this.D, i);
            }
            this.H.setLooping(this.v);
            FileDescriptor fileDescriptor = this.g0;
            if (fileDescriptor != null) {
                this.H.setDataSource(fileDescriptor, this.e0, this.f0);
            } else {
                if (map == null) {
                    map = new HashMap();
                }
                this.H.setDataSource(this.D, Uri.parse(str), map);
            }
            if (!TextUtils.isEmpty(this.y)) {
                this.H.setStringOption(205, this.y);
            }
            if (this.R) {
                this.H.setIntOption(100, this.e);
            }
            if (this.h) {
                o();
            } else {
                try {
                    if (this.F != null) {
                        if (this.h0 == null) {
                            com.bykv.vk.component.ttvideo.b bVar = new com.bykv.vk.component.ttvideo.b(this);
                            this.h0 = bVar;
                            this.F.addCallback(bVar);
                        }
                        surface = this.F.getSurface();
                    } else {
                        surface = this.E;
                        if (surface != null) {
                        }
                        this.H.prepareAsync();
                        videoEngineSimpleCallback = this.B;
                        if (videoEngineSimpleCallback != null) {
                            videoEngineSimpleCallback.onPrepare(this);
                        }
                    }
                    this.H.prepareAsync();
                    videoEngineSimpleCallback = this.B;
                    if (videoEngineSimpleCallback != null) {
                        videoEngineSimpleCallback.onPrepare(this);
                    }
                } catch (Exception e) {
                    if (!this.H.isOSPlayer()) {
                        str2 = Error.VideoOwnPlayer;
                    }
                    b(new Error(str2, Error.PlayerStateIllegal, e.toString()));
                    return;
                }
                a(surface);
            }
            this.b = 3;
        } catch (Throwable th) {
            if (!this.H.isOSPlayer()) {
                str2 = Error.VideoOwnPlayer;
            }
            b(new Error(str2, Error.PlayerStateIllegal, th.toString()));
        }
    }

    private void a(boolean z, int i) {
        com.bykv.vk.component.ttvideo.utils.a aVar;
        TTVideoEngineLog.i("TTVideoEngine", "_stop, mState:" + this.b + ", this:" + this);
        int i2 = this.b;
        if (i2 == 0 || i2 == 3) {
            this.d = true;
        }
        if (this.H != null && z && !isSystemPlayer() && this.h) {
            this.H.stop();
        }
        com.bykv.vk.component.ttvideo.utils.a aVar2 = this.W;
        if (aVar2 != null) {
            aVar2.e();
        }
        if (this.k != 0 && (aVar = this.W) != null) {
            this.G.b(aVar.b());
        }
        this.G.c(i);
        e(0);
        this.f29280a = false;
        this.o = false;
        this.p = false;
        this.c0 = 0L;
        this.Q = 0;
    }

    public static void addTask(PreloaderURLItem preloaderURLItem) {
        DataLoaderHelper.getDataLoader().addTask(preloaderURLItem);
    }

    private void b() {
        this.M = false;
        this.O = false;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null && mediaPlayer.getPlayerType() == 0) {
            this.H.release();
            this.H = null;
        }
        m();
        this.b = 0;
        this.Q = 0;
        this.P = null;
        this.N = null;
        this.y = null;
        this.g0 = null;
        this.b0 = false;
        this.f29280a = false;
        this.o = false;
        this.p = false;
        this.W.c();
        this.X = false;
        this.c0 = 0L;
        this.d0 = -1;
        this.Z.clear();
        this.d = false;
        this.g = true;
        this.e = 0;
    }

    private void b(int i) {
        TTVideoEngineLog.i("TTVideoEngine", "buffering end,this:" + this + ", code:" + i);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && this.f29280a) {
            aVar.d();
        }
        this.V = -1;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferEnd(i);
        }
        a(1, i);
    }

    private void b(Error error) {
        TTVideoEngineLog.i("TTVideoEngine", "videoEngine failed:" + error.toString());
        if (this.d) {
            this.b = 0;
            return;
        }
        int iF = f();
        if (!this.R) {
            int i = this.J;
            if (i != 0) {
                this.e = i;
                this.J = 0;
            } else if (!isSystemPlayer() || (isSystemPlayer() && this.h)) {
                int i2 = this.m;
                if (i2 <= 0 || iF - i2 <= -1000) {
                    this.e = iF;
                } else {
                    this.e = 0;
                }
            }
        }
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null && mediaPlayer.isOSPlayer()) {
            this.H.release();
            this.H = null;
            this.f = true;
            a(error);
            return;
        }
        this.b = 4;
        if (this.Q >= this.u) {
            TTVideoEngineLog.e("TTVideoEngine", "videoEngine retry failed");
            a(error);
            return;
        }
        if (error.notNeedRetry()) {
            TTVideoEngineLog.e("TTVideoEngine", "not need retry");
            a(error);
            return;
        }
        this.R = true;
        if (this.Q == this.u - 1 || error.needFallbackOS()) {
            MediaPlayer mediaPlayer2 = this.H;
            if (mediaPlayer2 != null) {
                mediaPlayer2.release();
                this.H = null;
            }
            this.z = 1;
        }
        this.G.a(error, 0, 0);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onRetry(this.z);
        }
        this.Q++;
        a(this.M ? this.N : this.P, this.A);
    }

    private void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.g) {
            this.g = false;
            this.G.a(str, "");
        }
        this.G.a(str);
    }

    private void c() {
        TTVideoEngineLog.i("TTVideoEngine", "_audioRenderStart, this:".concat(String.valueOf(this)));
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return;
        }
        if (!this.p) {
            this.p = true;
        }
        if (!this.f29280a && mediaPlayer.getIntOption(62, -100) == 0 && !this.i && this.T && this.f) {
            k();
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void c(int i) {
        TTVideoEngineLog.i("TTVideoEngine", "buffering start,this:" + this + ", code:" + i);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
        boolean z = this.b0;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferStart(i, z ? 1 : 0, 0);
        }
        a(2, i);
    }

    private void c(boolean z) {
        TTVideoEngineLog.i("TTVideoEngine", "seek complete");
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && z && this.f29280a) {
            aVar.d();
        }
        SeekCompletionListener seekCompletionListener = this.C;
        if (seekCompletionListener != null) {
            seekCompletionListener.onCompletion(z);
            this.C = null;
        }
    }

    public static void cancelAllPreloadTasks() {
        DataLoaderHelper.getDataLoader().cancelAllTasks();
    }

    public static void cancelPreloadTask(String str) {
        DataLoaderHelper.getDataLoader().cancelTask(str);
    }

    public static void clearAllCaches() {
        DataLoaderHelper.getDataLoader().clearAllCaches();
    }

    public static void closeDataLoader() {
        DataLoaderHelper.getDataLoader().close();
    }

    private void d() {
        DataLoaderHelper.getDataLoader()._addEngine(this, this.a0);
    }

    private void d(int i) {
        TTVideoEngineLog.i("TTVideoEngine", "render seek complete:".concat(String.valueOf(i)));
        this.G.a();
        if (this.c) {
            this.c = false;
        }
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "render seek complete call back ".concat(String.valueOf(i)));
            this.B.onRenderSeekComplete(i);
        }
    }

    private void e() {
        DataLoaderHelper.getDataLoader()._removeEngine(this, this.a0);
        Iterator<String> it = this.Y.keySet().iterator();
        while (it.hasNext()) {
            DataLoaderHelper.getDataLoader()._removePlayTask(it.next());
        }
        n();
    }

    private void e(int i) {
        if (this.k != i) {
            TTVideoEngineLog.i("TTVideoEngine", "playback state changed prev:" + this.k + ", new:" + i);
            this.k = i;
            VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
            if (videoEngineSimpleCallback != null) {
                videoEngineSimpleCallback.onPlaybackStateChanged(this, i);
            }
        }
    }

    private int f() {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return 0;
        }
        return mediaPlayer.getCurrentPosition();
    }

    public static void forceRemoveCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str, true);
    }

    private void g() {
        if (this.I != null) {
            return;
        }
        this.I = new b(getLooper());
    }

    public static long getCacheFileSize(String str) {
        return DataLoaderHelper.getDataLoader().getCacheSize(str);
    }

    public static long getCacheFileSizeByFilePath(String str, String str2) {
        return DataLoaderHelper.getDataLoader().getCacheSizeByFilePath(str, str2);
    }

    public static DataLoaderHelper.DataLoaderCacheInfo getCacheInfoByFilePath(String str, String str2) {
        return DataLoaderHelper.getDataLoader().getCacheInfoByFilePath(str, str2);
    }

    public static String getEngineVersion() {
        return "1.0.2";
    }

    public static Looper getLooper() {
        return Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper();
    }

    private void h() {
        if (this.G != null) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.c0 = jCurrentTimeMillis;
            this.G.a(jCurrentTimeMillis, (String) null);
        }
    }

    private void i() {
        if (this.f29280a) {
            return;
        }
        this.G.a();
        this.f29280a = true;
    }

    private void j() {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.a();
        }
        if (this.M || this.O || this.g0 != null) {
            h();
            b(this.M ? this.N : this.P);
            a(this.M ? this.N : this.P, this.A);
        }
    }

    private void k() {
        TTVideoEngineLog.i("TTVideoEngine", "start to render,this:".concat(String.valueOf(this)));
        if (this.T) {
            e(1);
        }
        i();
        if (!this.o) {
            this.o = true;
        }
        this.b0 = true;
        a(1, -1);
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.d();
        }
        if (this.R) {
            if (this.e != 0 && isSystemPlayer()) {
                a(this.e);
            }
            this.R = false;
        }
        if (this.J != 0 && isSystemPlayer()) {
            a(this.J);
        }
        this.J = 0;
        this.Q = 0;
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "notify render start");
            this.B.onRenderStart(this);
        }
    }

    private void l() {
        if (p()) {
            if (this.M || this.O || this.g0 != null) {
                h();
                a(this.M ? this.N : this.P, this.A);
                return;
            }
            return;
        }
        if (this.X || (this.k == 0 && this.c0 == 0)) {
            h();
            com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
            if (aVar != null) {
                aVar.a();
            }
        }
        o();
    }

    private void m() {
        TTVideoEngineLog.i("TTVideoEngine", "reset, this:".concat(String.valueOf(this)));
        this.T = false;
        this.U = false;
        this.h = false;
        this.A.clear();
        a(true, 6);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(null);
            this.H.reset();
        }
        this.f29280a = false;
        this.o = false;
        this.p = false;
        this.R = false;
        this.G.reset();
    }

    private void n() {
        this.Y.clear();
        this.a0 = null;
    }

    private void o() {
        TTVideoEngineLog.i("TTVideoEngine", "_resumeVideo, shouldplay:" + this.T + ", mediaplayer:" + this.H + ", prepared:" + this.h);
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null || !this.T) {
            return;
        }
        mediaPlayer.setScreenOnWhilePlaying(this.w);
        int i = this.x;
        if (i != 0) {
            this.H.setWakeMode(this.D, i);
        }
        if (!this.h) {
            this.i = false;
            return;
        }
        this.H.setIntOption(100, this.J);
        this.H.start();
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null && this.f29280a) {
            aVar.d();
        }
        if (this.H.getIntOption(62, -100) == 0 && !this.o && (this.k == 0 || this.X)) {
            k();
        } else {
            e(1);
        }
    }

    private boolean p() {
        int i = this.k;
        if ((i == 0 || i == 3) && !this.h) {
            return true;
        }
        return (this.H == null || !isSystemPlayer() || this.h) ? false : true;
    }

    public static void removeCacheFile(String str) {
        DataLoaderHelper.getDataLoader().removeCacheFile(str, false);
    }

    public static void setCacheInfoLists(String[] strArr, long[] jArr) {
        DataLoaderHelper.getDataLoader().setCacheInfoLists(strArr, jArr);
    }

    public static void setIntValue(int i, int i2) {
        DataLoaderHelper.getDataLoader().setIntValue(i, i2);
    }

    public static void setStringValue(int i, String str) {
        DataLoaderHelper.getDataLoader().setStringValue(i, str);
    }

    public static void setVideoEventUploader(VideoEventEngineUploader videoEventEngineUploader) {
        TTVideoEngineLog.i("TTVideoEngine", "setVideoEventUploader uploader");
        e.instance.a(videoEventEngineUploader);
        DataLoaderHelper.getDataLoader().setEngineUploader(videoEventEngineUploader);
    }

    public static void startDataLoader(Context context) throws Exception {
        DataLoaderHelper.getDataLoader().setContext(context);
        try {
            DataLoaderHelper.getDataLoader().start();
            l0 = true;
        } catch (Exception e) {
            throw e;
        }
    }

    public void a() {
        if (this.B != null) {
            TTVideoEngineLog.i("TTVideoEngine", "notify cache end. source id: " + this.a0);
            this.B.onUseMDLCacheEnd();
        }
    }

    public void a(int i) {
        com.bykv.vk.component.ttvideo.utils.a aVar;
        TTVideoEngineLog.i("TTVideoEngine", "_seekTo:".concat(String.valueOf(i)));
        if (this.H == null || !this.j) {
            c(false);
            return;
        }
        if (!this.c && (aVar = this.W) != null) {
            aVar.e();
        }
        this.c = true;
        this.H.seekTo(i);
    }

    public void a(Surface surface) {
        TTVideoEngineLog.i("TTVideoEngine", "_doSetPlayerSurface surface:" + surface + ", pre-surface:" + this.E + ", this:" + this);
        this.E = surface;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    public void a(String str) {
        if (str != null && !str.equals(this.P)) {
            TTVideoEngineLog.i("TTVideoEngine", String.format("set direct url:%s", str));
            b();
        }
        this.j = false;
        this.O = true;
        this.P = str;
    }

    public void a(boolean z) {
        TTVideoEngineLog.i("TTVideoEngine", "_play, mState:" + this.b + ", byPlay:" + z + ", this:" + this);
        this.j = true;
        this.i = false;
        g();
        if (z) {
            this.G.d(10);
        }
        int i = this.b;
        if (i != 0) {
            if (i == 3) {
                l();
                return;
            } else if (i != 4) {
                return;
            }
        }
        j();
    }

    public void b(boolean z) {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setIsMute(z);
        }
    }

    public int getBufferingType() {
        return this.V;
    }

    public int getCurrentPlaybackTime() {
        TTVideoEngineLog.i("TTVideoEngine", "getCurrentPlaybackTime state:" + this.b);
        int i = this.b;
        if (i == 3) {
            return f();
        }
        if (i == 4) {
            return this.e;
        }
        return -1;
    }

    public int getCurrentPlaybackTimeAsync() {
        return isSystemPlayer() ? getCurrentPlaybackTime() : this.d0;
    }

    public int getDuration() {
        return this.m;
    }

    public int getLoadState() {
        return this.l;
    }

    public int getLoadedProgress() {
        return this.n;
    }

    public int getPlaybackState() {
        return this.k;
    }

    public boolean isLooping() {
        return this.v;
    }

    public boolean isMute() {
        MediaPlayer mediaPlayer = this.H;
        return mediaPlayer != null ? mediaPlayer.isMute() : this.K;
    }

    public boolean isSystemPlayer() {
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return this.z == 1;
        }
        return mediaPlayer.isOSPlayer();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (this.M) {
            i = 100;
        }
        this.n = i;
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onBufferingUpdate(this, i);
        }
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "receive onCompletion,this:".concat(String.valueOf(this)));
        if (!this.v) {
            this.X = true;
            e(0);
            com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
            if (aVar != null) {
                aVar.e();
                this.G.b(this.W.b());
            }
            this.G.a(3);
            this.f29280a = false;
            this.o = false;
            this.p = false;
            this.e = 0;
            this.R = false;
            this.j = false;
        }
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onCompletion(this);
        }
        if (mediaPlayer != null && mediaPlayer.isOSPlayer()) {
            this.h = false;
        }
        this.J = 0;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
        e(3);
        a(3, -1);
        Error error = new Error((mediaPlayer == null || !mediaPlayer.isOSPlayer()) ? Error.VideoOwnPlayer : Error.VideoOSPlayer, i, i2, null);
        this.S = error;
        b(error);
        return true;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i == -268435438) {
            TTVideoEngineLog.i("TTVideoEngine", "player position update ".concat(String.valueOf(i2)));
            this.d0 = i2;
        } else if (i == 3) {
            TTVideoEngineLog.i("TTVideoEngine", "player callback render start");
            k();
        } else if (i == 801) {
            c(false);
        } else if (i == 251658248) {
            d(i2);
        } else if (i == 251658252) {
            c();
        } else if (i == 701) {
            c(i2);
        } else if (i == 702) {
            b(i2);
        }
        return false;
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        TTVideoEngineLog.i("TTVideoEngine", "onPrepared");
        if (this.U) {
            return;
        }
        if (mediaPlayer == null) {
            TTVideoEngineLog.e("TTVideoEngine", "onPrepared mediaPlayer is null!");
            return;
        }
        TTVideoEngineLog.i("TTVideoEngine", "onPrepared videoCodecId " + mediaPlayer.getIntOption(141, -1));
        this.S = null;
        int duration = mediaPlayer.getDuration();
        this.m = duration;
        this.h = true;
        this.G.e(duration);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onPrepared(this);
        }
        if ((this.i || !this.T) && this.f) {
            return;
        }
        mediaPlayer.start();
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
        c(true);
    }

    @Override // com.bykv.vk.component.ttvideo.player.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        TTVideoEngineLog.i("TTVideoEngine", "video size changed = " + i + ", " + i2);
        VideoEngineSimpleCallback videoEngineSimpleCallback = this.B;
        if (videoEngineSimpleCallback != null) {
            videoEngineSimpleCallback.onVideoSizeChanged(this, i, i2);
        }
    }

    public void pause() {
        TTVideoEngineLog.i("TTVideoEngine", "pause, ".concat(String.valueOf(this)));
        this.T = false;
        if (!this.h) {
            this.i = true;
            e(2);
            return;
        }
        if (this.H != null) {
            TTVideoEngineLog.i("TTVideoEngine", "player will pause");
            this.H.pause();
            e(2);
        }
        com.bykv.vk.component.ttvideo.utils.a aVar = this.W;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void play() {
        TTVideoEngineLog.i("TTVideoEngine", "play, ".concat(String.valueOf(this)));
        if (this.b == 5) {
            TTVideoEngineLog.e("TTVideoEngine", "already released, return");
            return;
        }
        boolean z = true;
        this.T = true;
        this.U = false;
        this.d = false;
        if (!this.f && this.c0 <= 0 && !this.h) {
            z = false;
        }
        a(z);
        this.X = false;
    }

    public void prepare() {
        TTVideoEngineLog.i("TTVideoEngine", "prepare, ".concat(String.valueOf(this)));
        this.f = false;
        this.T = false;
        this.U = false;
        this.d = false;
        a(false);
        this.X = false;
    }

    public void release() {
        TTVideoEngineLog.i("TTVideoEngine", "release, ".concat(String.valueOf(this)));
        this.U = true;
        this.T = false;
        a(false, 1);
        MediaPlayer mediaPlayer = this.H;
        this.H = null;
        if (mediaPlayer != null) {
            EngineThreadPool.a().execute(new a(this, mediaPlayer));
        }
        e();
        this.b = 5;
    }

    public void reset() {
        b();
    }

    public void seekTo(int i, SeekCompletionListener seekCompletionListener) {
        TTVideoEngineLog.i("TTVideoEngine", "seek to time:".concat(String.valueOf(i)));
        this.C = seekCompletionListener;
        a(i);
    }

    public void setDataSource(FileDescriptor fileDescriptor, long j, long j2) {
        this.e0 = j;
        this.f0 = j2;
        b();
        this.g0 = fileDescriptor;
    }

    public void setDirectURL(String str) {
        a(str);
    }

    public void setDirectUrlUseDataLoader(String str, String str2) {
        setDirectUrlUseDataLoader(str, str2, this.y);
    }

    public void setDirectUrlUseDataLoader(String str, String str2, String str3) {
        setDirectUrlUseDataLoader(str, str2, str3, (String) null);
    }

    public void setDirectUrlUseDataLoader(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        setDirectUrlUseDataLoader(new String[]{str}, str2, str3, str4);
    }

    public void setDirectUrlUseDataLoader(String[] strArr, String str, String str2, String str3) {
        if (strArr == null || strArr.length == 0 || TextUtils.isEmpty(strArr[0])) {
            TTVideoEngineLog.e("TTVideoEngine", "invalid urls list, it is empty");
            return;
        }
        this.y = str2;
        if (TextUtils.isEmpty(str) || !this.t) {
            a(strArr[0]);
            return;
        }
        n();
        TTVideoEngineLog.i("TTVideoEngine", "setDirectUrlUseDataLoader key:" + str + ", videoId:" + str2 + ", filePath:" + str3);
        String strA = a(str, str2, 0L, strArr, str3);
        if (!this.Z.contains(str)) {
            this.Z.add(str);
        }
        if (TextUtils.isEmpty(strA)) {
            setDirectURL(strArr[0]);
        } else {
            setDirectURL(strA);
        }
    }

    public void setIntOption(int i, int i2) {
        MediaPlayer mediaPlayer;
        int i3;
        if (i == 11) {
            this.r = i2;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i3 = 81;
                mediaPlayer.setIntOption(i3, i2);
            }
        } else if (i == 12) {
            this.s = i2;
            MediaPlayer mediaPlayer2 = this.H;
            if (mediaPlayer2 != null) {
                mediaPlayer2.setIntOption(9, 1000000 * i2);
            }
        } else if (i == 118) {
            this.j0 = i2;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i3 = 86;
                mediaPlayer.setIntOption(i3, i2);
            }
        } else if (i == 160) {
            this.t = i2 > 0;
        } else if (i == 202) {
            this.k0 = i2;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i3 = 110;
                mediaPlayer.setIntOption(i3, i2);
            }
        } else if (i == 322) {
            this.i0 = i2;
            mediaPlayer = this.H;
            if (mediaPlayer != null) {
                i3 = 211;
                mediaPlayer.setIntOption(i3, i2);
            }
        } else if (i == 472) {
            this.q = i2;
            MediaPlayer mediaPlayer3 = this.H;
            if (mediaPlayer3 != null) {
                mediaPlayer3.setIntOption(MediaPlayer.MEDIA_PLAYER_OPTION_OUTPUT_LOG, i2);
            }
            DataLoaderHelper.getDataLoader().setIntValue(512, i2);
        }
        TTVideoEngineLog.i("TTVideoEngine", "set int option key:" + i + " value:" + i2);
    }

    public void setIsMute(boolean z) {
        TTVideoEngineLog.i("TTVideoEngine", String.format("setIsMute:%s", Boolean.valueOf(z)));
        this.K = z;
        b(z);
    }

    public void setLocalURL(String str) {
        if (str != null && !str.equals(this.N)) {
            TTVideoEngineLog.i("TTVideoEngine", String.format("set local url:%s", str));
            b();
        }
        this.j = false;
        this.M = true;
        this.N = str;
    }

    public void setLooping(boolean z) {
        TTVideoEngineLog.i("TTVideoEngine", "setLooping:".concat(String.valueOf(z)));
        this.v = z;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z);
        }
    }

    public void setMaxRetryCount(int i) {
        this.u = i;
    }

    public void setScreenOnWhilePlaying(boolean z) {
        TTVideoEngineLog.i("TTVideoEngine", "setScreenOnWhilePlaying:".concat(String.valueOf(z)));
        this.w = z;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setScreenOnWhilePlaying(z);
        }
    }

    public void setStartTime(int i) {
        TTVideoEngineLog.i("TTVideoEngine", "setStartTime:".concat(String.valueOf(i)));
        this.J = i;
    }

    public void setSurface(Surface surface) {
        TTVideoEngineLog.i("TTVideoEngine", "setSurface surface:" + surface + ", pre-surface:" + this.E + ", this:" + this);
        a(surface);
    }

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        Surface surface;
        TTVideoEngineLog.i("TTVideoEngine", "setSurfaceHolder = " + surfaceHolder + ", this:" + this);
        this.F = surfaceHolder;
        if (surfaceHolder == null) {
            surface = null;
        } else {
            com.bykv.vk.component.ttvideo.b bVar = new com.bykv.vk.component.ttvideo.b(this);
            this.h0 = bVar;
            this.F.addCallback(bVar);
            surface = this.F.getSurface();
        }
        a(surface);
    }

    public void setTrackVolume(float f) {
        TTVideoEngineLog.i("TTVideoEngine", "setTrackVolume ".concat(String.valueOf(f)));
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer == null) {
            return;
        }
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        this.L = f;
        mediaPlayer.setVolume(f, f);
    }

    public void setVideoEngineSimpleCallback(VideoEngineSimpleCallback videoEngineSimpleCallback) {
        this.B = videoEngineSimpleCallback;
    }

    public void setWakeMode(int i) {
        TTVideoEngineLog.i("TTVideoEngine", "setWakeMode:".concat(String.valueOf(i)));
        this.x = i;
        MediaPlayer mediaPlayer = this.H;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(this.D, i);
        }
    }

    public void start() {
        TTVideoEngineLog.i("TTVideoEngine", "start, ".concat(String.valueOf(this)));
        this.T = true;
        this.U = false;
        this.d = false;
        a(true);
        this.X = false;
    }

    public void stop() {
        TTVideoEngineLog.i("TTVideoEngine", "stop, ".concat(String.valueOf(this)));
        this.T = false;
        this.b0 = false;
        this.U = true;
        a(true, 0);
        e();
    }

    @Override // com.bykv.vk.component.ttvideo.log.a
    public Map versionInfo() {
        HashMap map = new HashMap();
        String value = TTPlayerConfiger.getValue(14, "");
        TTVideoEngineLog.i("TTVideoEngine", "SDK version:1.0.2, player version:".concat(String.valueOf(value)));
        map.put(t.x, value);
        map.put("sdk_version", "1.0.2");
        map.put(com.alipay.sdk.m.w.a.v, "5.6");
        return map;
    }
}
