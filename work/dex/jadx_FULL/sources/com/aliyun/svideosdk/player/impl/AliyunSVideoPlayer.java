package com.aliyun.svideosdk.player.impl;

import android.content.Context;
import android.view.Surface;
import com.aliyun.common.c.b.d;
import com.aliyun.svideosdk.common.struct.common.VideoDisplayMode;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.editor.EditorCallBack;
import com.aliyun.svideosdk.editor.NativeEditor;
import com.aliyun.svideosdk.editor.c;
import com.aliyun.svideosdk.nativeload.a;
import com.aliyun.svideosdk.player.AliyunISVideoPlayer;
import com.aliyun.svideosdk.player.PlayerCallback;
import com.aliyun.svideosdk.transcode.NativeParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class AliyunSVideoPlayer extends a implements AliyunISVideoPlayer {
    private static final String h = "com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer";
    private boolean c;
    private d f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f25814a = com.aliyun.common.c.c.a.a();
    private NativeEditor b = new NativeEditor();
    private PlayerCallback d = null;
    private NativeParser e = new NativeParser();
    private EditorCallBack g = new EditorCallBack() { // from class: com.aliyun.svideosdk.player.impl.AliyunSVideoPlayer.1
        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onCustomRender(int i, int i2, int i3, long j) {
            return 0;
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onDataReady() {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onEnd(int i) {
            if (AliyunSVideoPlayer.this.d != null) {
                AliyunSVideoPlayer.this.d.onPlayComplete();
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onError(int i) {
            if (AliyunSVideoPlayer.this.d != null) {
                AliyunSVideoPlayer.this.d.onError(i);
            }
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public void onPlayProgress(long j, long j2) {
        }

        @Override // com.aliyun.svideosdk.editor.EditorCallBack
        public int onTextureRender(int i, int i2, int i3, long j) {
            return 0;
        }
    };

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int draw(long j) {
        return this.b.draw(j * 1000);
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public long getCurrentPosition() {
        return this.b.getPlayTime();
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int init(Context context) {
        d dVar = new d(context, this.f25814a);
        this.f = dVar;
        int iInit = this.b.init(1, 1, 0, dVar.a(), this.g);
        if (iInit == 0) {
            this.c = true;
        }
        this.f.c();
        return iInit;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int pause() {
        int iPause = this.b.pause();
        d dVar = this.f;
        if (dVar != null) {
            dVar.d();
        }
        return iPause;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int play() {
        if (!this.b.isNativePrepared()) {
            this.b.prepare();
        }
        int iStart = this.b.start();
        d dVar = this.f;
        if (dVar != null) {
            dVar.e();
        }
        return iStart;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public void release() {
        this.b.release();
        this.b.dispose();
        this.e.dispose();
        d dVar = this.f;
        if (dVar != null) {
            dVar.f();
            this.f.b();
        }
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int resume() {
        int iResume = this.b.resume();
        d dVar = this.f;
        if (dVar != null) {
            dVar.g();
        }
        return iResume;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int seek(long j) {
        return this.b.seek(j * 1000);
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int setDisplay(Surface surface) {
        if (!this.c) {
            com.aliyun.common.c.a.a.b(h, "Editor not initialized!");
            return -4;
        }
        d dVar = this.f;
        if (dVar != null) {
            dVar.h();
        }
        int display = (surface == null || !surface.isValid()) ? 0 : this.b.setDisplay(surface);
        if (display == 0) {
            int mode = this.b.setMode(c.PROCESS_MODE_PLAY);
            this.b.setDisplayMode(VideoDisplayMode.SCALE.getDisplayMode());
            return mode;
        }
        com.aliyun.common.c.a.a.b(h, "set surface failed! ret is" + display);
        return display;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int setDisplaySize(int i, int i2) {
        int displaySize = this.b.setDisplaySize(i, i2);
        d dVar = this.f;
        if (dVar != null) {
            dVar.a(i, i2);
        }
        return displaySize;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public void setPlayerCallback(PlayerCallback playerCallback) {
        this.d = playerCallback;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int setSource(String str) {
        int i;
        if (str != null && !str.isEmpty()) {
            this.e.init(str);
            try {
                long j = Long.parseLong(this.e.getValue(3));
                int i2 = Integer.parseInt(this.e.getValue(6));
                int i3 = Integer.parseInt(this.e.getValue(7));
                int i4 = Integer.parseInt(this.e.getValue(14));
                if (i4 == 90 || i4 == 270) {
                    i = i3;
                } else {
                    i = i2;
                    i2 = i3;
                }
                d dVar = this.f;
                if (dVar != null) {
                    dVar.a(str);
                }
                this.b.addVideoElement(str, 0L, j, new TransitionBase(), i, i2, 1.0f, 0.0f);
                this.e.release();
                int iPrepare = this.b.prepare();
                this.b.draw(0L);
                PlayerCallback playerCallback = this.d;
                if (playerCallback != null) {
                    playerCallback.onDataSize(i, i2);
                }
                return iPrepare;
            } catch (Exception unused) {
            }
        }
        return -20011015;
    }

    @Override // com.aliyun.svideosdk.player.AliyunISVideoPlayer
    public int stop() {
        int iStop = this.b.stop();
        d dVar = this.f;
        if (dVar != null) {
            dVar.i();
        }
        return iStop;
    }
}
