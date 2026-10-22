package com.aliyun.player.a;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.media.TimedText;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import com.aliyun.player.ApasaraExternalPlayer;
import com.aliyun.player.IPlayer;
import com.aliyun.player.bean.ErrorCode;
import com.aliyun.player.nativeclass.MediaInfo;
import com.aliyun.player.nativeclass.Options;
import com.aliyun.player.nativeclass.TrackInfo;
import com.cicada.player.utils.Logger;
import com.zj.adlib.u15;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a extends ApasaraExternalPlayer {
    private ApasaraExternalPlayer.OnVideoRenderedListener A;
    private ApasaraExternalPlayer.OnErrorListener B;
    private ApasaraExternalPlayer.OnEventListener C;
    private ApasaraExternalPlayer.OnStreamInfoGetListener D;
    private ApasaraExternalPlayer.OnStreamSwitchSucListener E;
    private ApasaraExternalPlayer.OnCaptureScreenListener F;
    private ApasaraExternalPlayer.OnSubtitleListener G;
    private ApasaraExternalPlayer.OnDRMCallback H;
    private long I;
    private boolean J;
    private Map<String, String> K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f25587a;
    private MediaPlayer b;
    private MediaPlayer.TrackInfo[] c;
    private Handler d;
    private ApasaraExternalPlayer.PlayerStatus e;
    private String f;
    private long g;
    private float h;
    private IPlayer.ScaleMode i;
    private boolean j;
    private boolean k;
    private String l;
    private String m;
    private float n;
    private boolean o;
    private ApasaraExternalPlayer.OnPreparedListener p;
    private ApasaraExternalPlayer.OnLoopingStartListener q;
    private ApasaraExternalPlayer.OnCompletionListener r;
    private ApasaraExternalPlayer.OnFirstFrameRenderListener s;
    private ApasaraExternalPlayer.OnLoadStatusListener t;
    private ApasaraExternalPlayer.OnAutoPlayStartListener u;
    private ApasaraExternalPlayer.OnSeekStatusListener v;
    private ApasaraExternalPlayer.OnPositionUpdateListener w;
    private ApasaraExternalPlayer.OnBufferPositionUpdateListener x;
    private ApasaraExternalPlayer.OnVideoSizeChangedListener y;
    private ApasaraExternalPlayer.OnStatusChangedListener z;

    /* JADX INFO: renamed from: com.aliyun.player.a.a$a, reason: collision with other inner class name */
    public class HandlerC0215a extends Handler {
        public HandlerC0215a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 1000) {
                if (a.this.e.getValue() >= ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED.getValue() && a.this.e.getValue() <= ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED.getValue()) {
                    if (a.this.x != null) {
                        a.this.x.onBufferPositionUpdate(a.this.getBufferPosition());
                    }
                    if (a.this.w != null) {
                        a.this.w.onPositionUpdate(a.this.getPlayingPosition());
                    }
                }
                a.this.b();
            }
            super.handleMessage(message);
        }
    }

    public class b implements MediaPlayer.OnBufferingUpdateListener {
        public b() {
        }

        @Override // android.media.MediaPlayer.OnBufferingUpdateListener
        public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
            a aVar = a.this;
            aVar.g = (long) ((((long) i) * aVar.getDuration()) / 100.0f);
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {
        public c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            if (a.this.r != null) {
                a.this.r.onCompletion();
            }
            a.this.a(ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION, true);
        }
    }

    public class d implements MediaPlayer.OnErrorListener {
        public d() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
            if (a.this.B != null) {
                a.this.B.onError(ErrorCode.ERROR_UNKNOWN.getValue(), "what=" + i + ", extra=" + i2);
            }
            a.this.a(ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR, true);
            return true;
        }
    }

    public class e implements MediaPlayer.OnInfoListener {
        public e() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
            if (i == 702) {
                if (a.this.t == null) {
                    return false;
                }
                a.this.t.onLoadingEnd();
                return false;
            }
            if (i == 701) {
                if (a.this.t == null) {
                    return false;
                }
                a.this.t.onLoadingStart();
                return false;
            }
            if (i != 3 || a.this.s == null) {
                return false;
            }
            a.this.s.onFirstFrameRender();
            return false;
        }
    }

    public class f implements MediaPlayer.OnPreparedListener {
        public f() {
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            a aVar = a.this;
            aVar.c = aVar.b.getTrackInfo();
            a.this.a();
            if (a.this.o) {
                if (a.this.u != null) {
                    a.this.u.onAutoPlayStart();
                }
                a.this.a(ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED, false);
                a.this.start();
            } else {
                a.this.a(ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED, true);
                if (a.this.p != null) {
                    a.this.p.onPrepared();
                }
            }
            if (a.this.I >= 0) {
                a aVar2 = a.this;
                aVar2.seekTo(aVar2.I, a.this.J);
                a.this.I = -1L;
            }
        }
    }

    public class g implements MediaPlayer.OnSeekCompleteListener {
        public g() {
        }

        @Override // android.media.MediaPlayer.OnSeekCompleteListener
        public void onSeekComplete(MediaPlayer mediaPlayer) {
            if (a.this.v != null) {
                a.this.v.onSeekEnd(false);
            }
        }
    }

    public class h implements MediaPlayer.OnTimedTextListener {
        public h(a aVar) {
        }

        @Override // android.media.MediaPlayer.OnTimedTextListener
        public void onTimedText(MediaPlayer mediaPlayer, TimedText timedText) {
        }
    }

    public class i implements MediaPlayer.OnVideoSizeChangedListener {
        public i() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
            if (a.this.y != null) {
                a.this.y.onVideoSizeChanged(i, i2);
            }
        }
    }

    public a() {
        this.f25587a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE;
        this.f = null;
        this.g = 0L;
        this.h = 1.0f;
        this.i = IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = 1.0f;
        this.o = false;
        this.p = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.D = null;
        this.I = -1L;
        this.J = false;
        this.K = new HashMap();
    }

    private a(Context context, Options options) {
        this.f25587a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE;
        this.f = null;
        this.g = 0L;
        this.h = 1.0f;
        this.i = IPlayer.ScaleMode.SCALE_ASPECT_FIT;
        this.j = false;
        this.k = false;
        this.l = null;
        this.m = null;
        this.n = 1.0f;
        this.o = false;
        this.p = null;
        this.r = null;
        this.s = null;
        this.t = null;
        this.u = null;
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.D = null;
        this.I = -1L;
        this.J = false;
        this.K = new HashMap();
        this.f25587a = context;
        Looper looperMyLooper = Looper.myLooper();
        this.d = new HandlerC0215a(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper);
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.b = mediaPlayer;
        mediaPlayer.setOnBufferingUpdateListener(new b());
        this.b.setOnCompletionListener(new c());
        this.b.setOnErrorListener(new d());
        this.b.setOnInfoListener(new e());
        this.b.setOnPreparedListener(new f());
        this.b.setOnSeekCompleteListener(new g());
        this.b.setOnTimedTextListener(new h(this));
        this.b.setOnVideoSizeChangedListener(new i());
    }

    private TrackInfo a(MediaPlayer.TrackInfo trackInfo, int i2) {
        TrackInfo.Type type;
        TrackInfo trackInfo2 = new TrackInfo();
        trackInfo2.index = i2;
        int trackType = trackInfo.getTrackType();
        if (trackType == 2) {
            type = TrackInfo.Type.TYPE_AUDIO;
        } else if (trackType == 1) {
            type = TrackInfo.Type.TYPE_VIDEO;
        } else {
            type = trackType == 4 ? TrackInfo.Type.TYPE_SUBTITLE : TrackInfo.Type.TYPE_VOD;
        }
        trackInfo2.mType = type;
        trackInfo2.description = trackInfo.getLanguage();
        return trackInfo2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.D == null || this.c == null) {
            return;
        }
        MediaInfo mediaInfo = new MediaInfo();
        TrackInfo[] trackInfoArr = new TrackInfo[this.c.length];
        int i2 = 0;
        while (true) {
            MediaPlayer.TrackInfo[] trackInfoArr2 = this.c;
            if (i2 >= trackInfoArr2.length) {
                mediaInfo.setTrackInfos(trackInfoArr);
                mediaInfo.setDuration((int) getDuration());
                this.D.OnStreamInfoGet(mediaInfo);
                return;
            }
            trackInfoArr[i2] = a(trackInfoArr2[i2], i2);
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApasaraExternalPlayer.PlayerStatus playerStatus, boolean z) {
        ApasaraExternalPlayer.OnStatusChangedListener onStatusChangedListener;
        if (this.e != playerStatus) {
            this.e = playerStatus;
            if (z && (onStatusChangedListener = this.z) != null) {
                onStatusChangedListener.onStatusChanged(playerStatus.getValue(), playerStatus.getValue());
            }
        }
        b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.d.removeMessages(1000);
        if (this.e.getValue() < ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED.getValue() || this.e.getValue() > ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED.getValue()) {
            return;
        }
        this.d.sendEmptyMessageDelayed(1000, 500L);
    }

    private void c() {
        if (this.b == null) {
            return;
        }
        HashMap map = new HashMap();
        String str = this.l;
        if (str != null) {
            map.put("Referer", str);
        }
        String str2 = this.m;
        if (str2 != null) {
            map.put("User-Agent", str2);
        }
        map.putAll(this.K);
        try {
            this.b.setDataSource(this.f25587a, Uri.parse(this.f), map);
        } catch (IOException e2) {
            e2.printStackTrace();
            ApasaraExternalPlayer.OnErrorListener onErrorListener = this.B;
            if (onErrorListener != null) {
                onErrorListener.onError(ErrorCode.ERROR_GENERAL_EIO.getValue(), "set dataSource error :" + e2.getMessage());
            }
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void addCustomHttpHeader(String str) {
        Logger.v("MediaPlayer", "addCustomHttpHeader() " + str);
        if (!TextUtils.isEmpty(str) || str.contains(u15.f19942b)) {
            String[] strArrSplit = str.split(u15.f19942b);
            this.K.put(strArrSplit[0], strArrSplit[1]);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void addExtSubtitle(String str) {
        Logger.v("MediaPlayer", "addExtSubtitle() " + str);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void captureScreen() {
        Logger.v("MediaPlayer", "captureScreen() ");
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public ApasaraExternalPlayer create(Context context, Options options) {
        return new a(context, options);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void enterBackGround(boolean z) {
        Logger.v("MediaPlayer", "enterBackGround() " + z);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getBufferPosition() {
        Logger.v("MediaPlayer", "getBufferPosition() ");
        return this.g;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getCurrentStreamIndex(ApasaraExternalPlayer.StreamType streamType) {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "getCurrentStreamIndex() " + streamType);
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        int i2 = 0;
        if (!(playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) || (mediaPlayer = this.b) == null) {
            return -1;
        }
        if (streamType == ApasaraExternalPlayer.StreamType.ST_TYPE_AUDIO) {
            i2 = 2;
        } else if (streamType == ApasaraExternalPlayer.StreamType.ST_TYPE_VIDEO) {
            i2 = 1;
        } else if (streamType == ApasaraExternalPlayer.StreamType.ST_TYPE_SUB) {
            i2 = 4;
        }
        return mediaPlayer.getSelectedTrack(i2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public TrackInfo getCurrentStreamInfo(ApasaraExternalPlayer.StreamType streamType) {
        MediaPlayer.TrackInfo[] trackInfoArr;
        Logger.v("MediaPlayer", "getCurrentStreamInfo() " + streamType);
        int currentStreamIndex = getCurrentStreamIndex(streamType);
        if (currentStreamIndex < 0 || (trackInfoArr = this.c) == null || currentStreamIndex >= trackInfoArr.length) {
            return null;
        }
        return a(trackInfoArr[currentStreamIndex], currentStreamIndex);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public ApasaraExternalPlayer.DecoderType getDecoderType() {
        Logger.v("MediaPlayer", "getDecoderType() ");
        return ApasaraExternalPlayer.DecoderType.DT_HARDWARE;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getDuration() {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "getDuration() ");
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if ((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.b) != null) {
            return Math.max(playerStatus != ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR ? mediaPlayer.getDuration() : 0, 0);
        }
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getMasterClockPts() {
        Logger.v("MediaPlayer", "getMasterClockPts() ");
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public IPlayer.MirrorMode getMirrorMode() {
        Logger.v("MediaPlayer", "getMirrorMode() ");
        return IPlayer.MirrorMode.MIRROR_MODE_NONE;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public String getName() {
        return "MediaPlayer";
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public String getOption(String str) {
        Logger.v("MediaPlayer", "getOption() " + str);
        return null;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public ApasaraExternalPlayer.PlayerStatus getPlayerStatus() {
        Logger.v("MediaPlayer", "getPlayerStatus() ");
        return this.e;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getPlayingPosition() {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "getPlayingPosition() ");
        long j = this.I;
        if (j >= 0) {
            return j;
        }
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if ((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_INITIALZED) && (mediaPlayer = this.b) != null) {
            return mediaPlayer.getCurrentPosition();
        }
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getPropertyInt(ApasaraExternalPlayer.PropertyKey propertyKey) {
        Logger.v("MediaPlayer", "getPropertyInt() " + propertyKey);
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public long getPropertyLong(ApasaraExternalPlayer.PropertyKey propertyKey) {
        Logger.v("MediaPlayer", "getPropertyLong() " + propertyKey);
        return 0L;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public String getPropertyString(ApasaraExternalPlayer.PropertyKey propertyKey) {
        Logger.v("MediaPlayer", "getPropertyString() " + propertyKey);
        return null;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public IPlayer.RotateMode getRotateMode() {
        Logger.v("MediaPlayer", "getRotateMode() ");
        return IPlayer.RotateMode.ROTATE_0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public IPlayer.ScaleMode getScaleMode() {
        Logger.v("MediaPlayer", "getScaleMode() ");
        return IPlayer.ScaleMode.SCALE_TO_FILL;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getSpeed() {
        Logger.v("MediaPlayer", "getSpeed() ");
        return this.n;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getVideoDecodeFps() {
        Logger.v("MediaPlayer", "getVideoDecodeFps() ");
        return 0.0f;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getVideoHeight() {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "getVideoHeight() ");
        if ((this.e != ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.b) != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getVideoRenderFps() {
        Logger.v("MediaPlayer", "getVideoRenderFps() ");
        return 0.0f;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getVideoRotation() {
        Logger.v("MediaPlayer", "getVideoRotation() ");
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int getVideoWidth() {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "getVideoWidth() ");
        if ((this.e != ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.b) != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public float getVolume() {
        Logger.v("MediaPlayer", "getVolume() ");
        return this.h;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int invokeComponent(String str) {
        Logger.v("MediaPlayer", "invokeComponent() " + str);
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isAutoPlay() {
        Logger.v("MediaPlayer", "isAutoPlay() ");
        return this.o;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isLooping() {
        Logger.v("MediaPlayer", "isLooping() ");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            return mediaPlayer.isLooping();
        }
        return false;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isMute() {
        Logger.v("MediaPlayer", "isMute() ");
        return this.j;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public boolean isSupport(Options options) {
        return options != null && "MediaPlayer".equals(options.get("name"));
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void mute(boolean z) {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "mute() " + z);
        this.j = z;
        if ((this.e != ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.b) != null) {
            float f2 = z ? 0.0f : this.h;
            mediaPlayer.setVolume(f2, f2);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void pause() {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "pause() ");
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if ((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.b) != null) {
            mediaPlayer.pause();
            a(ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED, true);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void prepare() {
        Logger.v("MediaPlayer", "prepare() ");
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            c();
            setScaleMode(this.i);
            setSpeed(this.n);
            setLooping(this.k);
            mute(this.j);
            setVolume(this.h);
            a(ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARING, true);
            this.b.prepareAsync();
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void reLoad() {
        Logger.v("MediaPlayer", "reLoad() ");
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void release() {
        Logger.v("MediaPlayer", "release() ");
        a(ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE, false);
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
        this.b = null;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void removeAllCustomHttpHeader() {
        Logger.v("MediaPlayer", "removeAllCustomHttpHeader() ");
        this.K.clear();
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void seekTo(long j, boolean z) {
        Logger.v("MediaPlayer", "seekTo() " + j + " , accurate = " + z);
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if (!(playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION)) {
            this.I = j;
            this.J = z;
            return;
        }
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            if (z) {
                mediaPlayer.seekTo(j, 3);
            } else {
                mediaPlayer.seekTo((int) j);
            }
            ApasaraExternalPlayer.OnSeekStatusListener onSeekStatusListener = this.v;
            if (onSeekStatusListener != null) {
                onSeekStatusListener.onSeekStart(false);
            }
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int selectExtSubtitle(int i2, boolean z) {
        Logger.v("MediaPlayer", "selectExtSubtitle() " + i2 + " , bSelect = " + z);
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setAutoPlay(boolean z) {
        Logger.v("MediaPlayer", "setAutoPlay() " + z);
        this.o = z;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDataSource(String str) {
        Logger.v("MediaPlayer", "setDataSource() " + str);
        this.f = str;
        if (this.b != null) {
            a(ApasaraExternalPlayer.PlayerStatus.PLAYER_INITIALZED, true);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDecoderType(ApasaraExternalPlayer.DecoderType decoderType) {
        Logger.v("MediaPlayer", "setDecoderType() " + decoderType);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDrmCallback(ApasaraExternalPlayer.OnDRMCallback onDRMCallback) {
        this.H = onDRMCallback;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setDropBufferThreshold(int i2) {
        Logger.v("MediaPlayer", "setDropBufferThreshold() " + i2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setLooping(boolean z) {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "setLooping() " + z);
        this.k = z;
        if ((this.e != ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) && (mediaPlayer = this.b) != null) {
            mediaPlayer.setLooping(z);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setMirrorMode(IPlayer.MirrorMode mirrorMode) {
        Logger.v("MediaPlayer", "setMirrorMode() " + mirrorMode);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnAutoPlayStartListener(ApasaraExternalPlayer.OnAutoPlayStartListener onAutoPlayStartListener) {
        this.u = onAutoPlayStartListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnBufferPositionUpdateListener(ApasaraExternalPlayer.OnBufferPositionUpdateListener onBufferPositionUpdateListener) {
        this.x = onBufferPositionUpdateListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnCaptureScreenListener(ApasaraExternalPlayer.OnCaptureScreenListener onCaptureScreenListener) {
        this.F = onCaptureScreenListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnCompletionListener(ApasaraExternalPlayer.OnCompletionListener onCompletionListener) {
        this.r = onCompletionListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnErrorListener(ApasaraExternalPlayer.OnErrorListener onErrorListener) {
        this.B = onErrorListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnEventListener(ApasaraExternalPlayer.OnEventListener onEventListener) {
        this.C = onEventListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnFirstFrameRenderListener(ApasaraExternalPlayer.OnFirstFrameRenderListener onFirstFrameRenderListener) {
        this.s = onFirstFrameRenderListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnLoadStatusListener(ApasaraExternalPlayer.OnLoadStatusListener onLoadStatusListener) {
        this.t = onLoadStatusListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnLoopingStartListener(ApasaraExternalPlayer.OnLoopingStartListener onLoopingStartListener) {
        this.q = onLoopingStartListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnPositionUpdateListener(ApasaraExternalPlayer.OnPositionUpdateListener onPositionUpdateListener) {
        this.w = onPositionUpdateListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnPreparedListener(ApasaraExternalPlayer.OnPreparedListener onPreparedListener) {
        this.p = onPreparedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnSeekStatusListener(ApasaraExternalPlayer.OnSeekStatusListener onSeekStatusListener) {
        this.v = onSeekStatusListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnStatusChangedListener(ApasaraExternalPlayer.OnStatusChangedListener onStatusChangedListener) {
        this.z = onStatusChangedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnStreamInfoGetListener(ApasaraExternalPlayer.OnStreamInfoGetListener onStreamInfoGetListener) {
        this.D = onStreamInfoGetListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnStreamSwitchSucListener(ApasaraExternalPlayer.OnStreamSwitchSucListener onStreamSwitchSucListener) {
        this.E = onStreamSwitchSucListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnSubtitleListener(ApasaraExternalPlayer.OnSubtitleListener onSubtitleListener) {
        this.G = onSubtitleListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnVideoRenderedListener(ApasaraExternalPlayer.OnVideoRenderedListener onVideoRenderedListener) {
        this.A = onVideoRenderedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setOnVideoSizeChangedListener(ApasaraExternalPlayer.OnVideoSizeChangedListener onVideoSizeChangedListener) {
        this.y = onVideoSizeChangedListener;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public int setOption(String str, String str2) {
        Logger.v("MediaPlayer", "setOption() " + str + " : " + str2);
        return 0;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setRefer(String str) {
        Logger.v("MediaPlayer", "setRefer() " + str);
        this.l = str;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setRotateMode(IPlayer.RotateMode rotateMode) {
        Logger.v("MediaPlayer", "setRotateMode() " + rotateMode);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setScaleMode(IPlayer.ScaleMode scaleMode) {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "setScaleMode() " + scaleMode);
        this.i = scaleMode;
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if (((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE) ? false : true) && (mediaPlayer = this.b) != null) {
            if (scaleMode == IPlayer.ScaleMode.SCALE_ASPECT_FILL) {
                mediaPlayer.setVideoScalingMode(2);
            } else {
                mediaPlayer.setVideoScalingMode(1);
            }
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setSpeed(float f2) {
        Logger.v("MediaPlayer", "setSpeed() " + f2);
        this.n = f2;
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if (((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_IDLE || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED) ? false : true) && this.b != null) {
            PlaybackParams playbackParams = new PlaybackParams();
            playbackParams.setSpeed(f2);
            this.b.setPlaybackParams(playbackParams);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setSurface(Surface surface) {
        Logger.v("MediaPlayer", "setSurface() " + surface);
        MediaPlayer mediaPlayer = this.b;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setTimeout(int i2) {
        Logger.v("MediaPlayer", "setTimeout() " + i2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setUserAgent(String str) {
        Logger.v("MediaPlayer", "setUserAgent() " + str);
        this.m = str;
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setVideoBackgroundColor(long j) {
        Logger.v("MediaPlayer", "setVideoBackgroundColor() " + j);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void setVolume(float f2) {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "setVolume() " + f2);
        this.h = f2;
        if (!(this.e != ApasaraExternalPlayer.PlayerStatus.PLAYER_ERROR) || this.j || (mediaPlayer = this.b) == null) {
            return;
        }
        mediaPlayer.setVolume(f2, f2);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void start() {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "start() ");
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if ((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.b) != null) {
            mediaPlayer.start();
            a(ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING, true);
        }
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public void stop() {
        MediaPlayer mediaPlayer;
        ApasaraExternalPlayer.PlayerStatus playerStatus;
        Logger.v("MediaPlayer", "stop() ");
        ApasaraExternalPlayer.PlayerStatus playerStatus2 = this.e;
        if (!(playerStatus2 == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus2 == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus2 == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus2 == ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus2 == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) || (mediaPlayer = this.b) == null || playerStatus2 == (playerStatus = ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED)) {
            return;
        }
        mediaPlayer.stop();
        a(playerStatus, true);
    }

    @Override // com.aliyun.player.ApasaraExternalPlayer
    public ApasaraExternalPlayer.StreamType switchStream(int i2) {
        MediaPlayer mediaPlayer;
        Logger.v("MediaPlayer", "switchStream() " + i2);
        ApasaraExternalPlayer.PlayerStatus playerStatus = this.e;
        if ((playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PREPARED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PLAYING || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_PAUSED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_STOPPED || playerStatus == ApasaraExternalPlayer.PlayerStatus.PLAYER_COMPLETION) && (mediaPlayer = this.b) != null) {
            mediaPlayer.selectTrack(i2);
            MediaPlayer.TrackInfo[] trackInfoArr = this.c;
            if (trackInfoArr == null) {
                return ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
            }
            int trackType = trackInfoArr[i2].getTrackType();
            if (trackType == 2) {
                return ApasaraExternalPlayer.StreamType.ST_TYPE_AUDIO;
            }
            if (trackType == 4) {
                return ApasaraExternalPlayer.StreamType.ST_TYPE_SUB;
            }
            if (trackType == 1) {
                return ApasaraExternalPlayer.StreamType.ST_TYPE_VIDEO;
            }
            return trackType == 0 ? ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN : ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
        }
        return ApasaraExternalPlayer.StreamType.ST_TYPE_UNKNOWN;
    }
}
