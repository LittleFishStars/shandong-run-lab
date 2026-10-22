package cj.mobile.wm;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Message;
import android.view.Surface;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class rb implements qb, MediaPlayer.OnPreparedListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnVideoSizeChangedListener, d1.dexa {
    public MediaPlayer dexa;
    public com.wangmai.insightvision.openadsdk.l.d.i dexc;
    public int dexd;
    public tb dexe;
    public vb dexf;
    public wb dexg;
    public sb dexh;
    public ub dexi;
    public d1 dexl;
    public boolean dexb = true;
    public String dexj = "";
    public float dexk = 1.0f;

    public rb(boolean z) {
        this.dexa = null;
        try {
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.dexa = mediaPlayer;
            this.dexc = com.wangmai.insightvision.openadsdk.l.d.i.a;
            mediaPlayer.setLooping(z);
            this.dexa.setScreenOnWhilePlaying(true);
            this.dexa.setOnPreparedListener(this);
            this.dexa.setOnCompletionListener(this);
            this.dexa.setOnBufferingUpdateListener(this);
            this.dexa.setOnSeekCompleteListener(this);
            this.dexa.setOnErrorListener(this);
            this.dexa.setOnInfoListener(this);
            this.dexa.setOnVideoSizeChangedListener(this);
            this.dexl = new d1(this);
        } catch (Exception e) {
            f1.dexa("FantiPlayer", "InsightPlayer init error", e.getMessage());
        }
    }

    private void dexa(com.wangmai.insightvision.openadsdk.l.d.i iVar) {
        MediaPlayer mediaPlayer;
        f1.dexa("FantiPlayer", iVar.name());
        this.dexc = iVar;
        if (iVar == com.wangmai.insightvision.openadsdk.l.d.i.d && (mediaPlayer = this.dexa) != null) {
            mediaPlayer.setVideoScalingMode(1);
        }
        wb wbVar = this.dexg;
        if (wbVar != null) {
            wbVar.dexa(this, iVar);
        }
    }

    private boolean dexa(com.wangmai.insightvision.openadsdk.l.d.i... iVarArr) {
        com.wangmai.insightvision.openadsdk.l.d.i iVarB = b();
        for (com.wangmai.insightvision.openadsdk.l.d.i iVar : iVarArr) {
            if (iVarB == iVar) {
                return true;
            }
        }
        return false;
    }

    private void dexb() {
        dexc();
        this.dexl.obtainMessage(100).sendToTarget();
    }

    private void dexc() {
        this.dexl.removeMessages(100);
    }

    @Override // cj.mobile.wm.qb
    public void a() {
        try {
            if (dexa(com.wangmai.insightvision.openadsdk.l.d.i.f)) {
                f1.dexa("FantiPlayer", "pause ... " + b());
                MediaPlayer mediaPlayer = this.dexa;
                if (mediaPlayer != null) {
                    mediaPlayer.pause();
                    dexa(com.wangmai.insightvision.openadsdk.l.d.i.g);
                    dexc();
                }
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void a(long j) {
        MediaPlayer mediaPlayer;
        try {
            if (!dexa(com.wangmai.insightvision.openadsdk.l.d.i.d, com.wangmai.insightvision.openadsdk.l.d.i.f, com.wangmai.insightvision.openadsdk.l.d.i.g, com.wangmai.insightvision.openadsdk.l.d.i.i) || (mediaPlayer = this.dexa) == null) {
                return;
            }
            mediaPlayer.seekTo(j, 3);
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void a(String str) {
        try {
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.setDataSource(str);
                dexa(com.wangmai.insightvision.openadsdk.l.d.i.b);
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public com.wangmai.insightvision.openadsdk.l.d.i b() {
        return this.dexc;
    }

    @Override // cj.mobile.wm.qb
    public boolean c() {
        return this.dexb;
    }

    @Override // cj.mobile.wm.qb
    public void d() {
        try {
            f1.dexa("FantiPlayer", "release ... " + b());
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.release();
                dexa(com.wangmai.insightvision.openadsdk.l.d.i.k);
                dexc();
                this.dexa = null;
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    public void dexa() {
        try {
            f1.dexa("FantiPlayer", "reset ... " + b());
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.reset();
                dexa(com.wangmai.insightvision.openadsdk.l.d.i.a);
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void dexa(float f) {
        try {
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.setVolume(f, f);
                this.dexk = f;
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    public void dexa(int i) {
        ub ubVar = this.dexi;
        if (ubVar != null) {
            ubVar.a(i);
        }
    }

    @Override // cj.mobile.wm.qb
    public void dexa(Context context, Uri uri, Map<String, String> map) {
        try {
            f1.dexa("FantiPlayer", "setDataSource ");
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.setDataSource(context, uri, map);
                dexa(com.wangmai.insightvision.openadsdk.l.d.i.b);
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void dexa(Context context, String str) {
        try {
            f1.dexa("FantiPlayer", "setDataSource ");
            this.dexj = str;
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.setDataSource(str);
                dexa(com.wangmai.insightvision.openadsdk.l.d.i.b);
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void dexa(Surface surface) {
        try {
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.setSurface(surface);
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void dexa(sb sbVar) {
        this.dexh = sbVar;
    }

    @Override // cj.mobile.wm.qb
    public void dexa(tb tbVar) {
        this.dexe = tbVar;
    }

    @Override // cj.mobile.wm.qb
    public void dexa(ub ubVar) {
        this.dexi = ubVar;
    }

    @Override // cj.mobile.wm.qb
    public void dexa(vb vbVar) {
        this.dexf = vbVar;
    }

    @Override // cj.mobile.wm.qb
    public void dexa(wb wbVar) {
        this.dexg = wbVar;
    }

    public void dexa(boolean z) {
        try {
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                mediaPlayer.setLooping(z);
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    public void dexb(boolean z) {
        this.dexb = z;
    }

    @Override // cj.mobile.wm.qb
    public boolean e() {
        try {
            f1.dexa("FantiPlayer", "isPlaying ... mediaPlayer " + this.dexa + " this : " + this);
            MediaPlayer mediaPlayer = this.dexa;
            if (mediaPlayer != null) {
                return mediaPlayer.isPlaying();
            }
            return false;
        } catch (Exception e) {
            f1.dexa(e);
            return false;
        }
    }

    @Override // cj.mobile.wm.qb
    public void f() {
        MediaPlayer mediaPlayer;
        try {
            f1.dexa("FantiPlayer", "prepareAsync ");
            if (!dexa(com.wangmai.insightvision.openadsdk.l.d.i.b, com.wangmai.insightvision.openadsdk.l.d.i.h) || (mediaPlayer = this.dexa) == null) {
                return;
            }
            mediaPlayer.prepareAsync();
            dexa(com.wangmai.insightvision.openadsdk.l.d.i.c);
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public float g() {
        return this.dexk;
    }

    @Override // cj.mobile.wm.qb
    public long getDuration() {
        MediaPlayer mediaPlayer;
        try {
            if (!dexa(com.wangmai.insightvision.openadsdk.l.d.i.f, com.wangmai.insightvision.openadsdk.l.d.i.g, com.wangmai.insightvision.openadsdk.l.d.i.h, com.wangmai.insightvision.openadsdk.l.d.i.i) || (mediaPlayer = this.dexa) == null) {
                return 0L;
            }
            return mediaPlayer.getDuration();
        } catch (Exception e) {
            f1.dexa(e);
            return 0L;
        }
    }

    @Override // cj.mobile.wm.qb
    public long h() {
        MediaPlayer mediaPlayer;
        try {
            if (!dexa(com.wangmai.insightvision.openadsdk.l.d.i.d, com.wangmai.insightvision.openadsdk.l.d.i.f, com.wangmai.insightvision.openadsdk.l.d.i.g, com.wangmai.insightvision.openadsdk.l.d.i.h, com.wangmai.insightvision.openadsdk.l.d.i.i) || (mediaPlayer = this.dexa) == null) {
                return 0L;
            }
            return mediaPlayer.getCurrentPosition();
        } catch (Exception e) {
            f1.dexa(e);
            return 0L;
        }
    }

    @Override // cj.mobile.wm.d1.dexa
    public void handleMessage(Message message) {
        if (message.what == 100) {
            try {
                dexa((int) h());
                this.dexl.removeMessages(100);
                d1 d1Var = this.dexl;
                d1Var.sendMessageDelayed(d1Var.obtainMessage(100), 500L);
            } catch (Exception e) {
                f1.dexa("FantiPlayer", "InsightPlayer handleMessage error", e.getMessage());
            }
        }
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.dexd = i;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        dexa(com.wangmai.insightvision.openadsdk.l.d.i.i);
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        f1.dexb("FantiPlayer", "onError , what = " + i + " , extra = " + i2);
        dexa(com.wangmai.insightvision.openadsdk.l.d.i.j);
        tb tbVar = this.dexe;
        if (tbVar == null) {
            return true;
        }
        tbVar.dexa(this, new com.wangmai.insightvision.openadsdk.l.a("playerError", i, i2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        f1.dexa("FantiPlayer", "onInfo , what = " + i + " , extra = " + i2);
        sb sbVar = this.dexh;
        if (sbVar == null) {
            return false;
        }
        sbVar.dexa(i == 701 ? com.wangmai.insightvision.openadsdk.l.d.h.a : com.wangmai.insightvision.openadsdk.l.d.h.b);
        return false;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        dexa(com.wangmai.insightvision.openadsdk.l.d.i.d);
    }

    @Override // android.media.MediaPlayer.OnSeekCompleteListener
    public void onSeekComplete(MediaPlayer mediaPlayer) {
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        vb vbVar = this.dexf;
        if (vbVar != null) {
            vbVar.dexa(this, i, i2);
        }
    }

    @Override // cj.mobile.wm.qb
    public void start() {
        try {
            if (dexa(com.wangmai.insightvision.openadsdk.l.d.i.d, com.wangmai.insightvision.openadsdk.l.d.i.g, com.wangmai.insightvision.openadsdk.l.d.i.i)) {
                f1.dexa("FantiPlayer", "start ... " + b());
                MediaPlayer mediaPlayer = this.dexa;
                if (mediaPlayer != null) {
                    mediaPlayer.start();
                    dexa(com.wangmai.insightvision.openadsdk.l.d.i.f);
                    dexb();
                }
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }

    @Override // cj.mobile.wm.qb
    public void stop() {
        try {
            if (dexa(com.wangmai.insightvision.openadsdk.l.d.i.f, com.wangmai.insightvision.openadsdk.l.d.i.g, com.wangmai.insightvision.openadsdk.l.d.i.d, com.wangmai.insightvision.openadsdk.l.d.i.c)) {
                f1.dexa("FantiPlayer", "stop ... " + b());
                MediaPlayer mediaPlayer = this.dexa;
                if (mediaPlayer != null) {
                    mediaPlayer.stop();
                    dexa(com.wangmai.insightvision.openadsdk.l.d.i.h);
                    dexc();
                }
            }
        } catch (Exception e) {
            f1.dexa(e);
        }
    }
}
