package com.kc.dw.player.utils;

import android.media.MediaPlayer;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class a implements com.kc.dw.player.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.kc.dw.player.a.b f39580a;
    public final Object b = new Object();

    /* JADX INFO: renamed from: com.kc.dw.player.utils.a$a, reason: collision with other inner class name */
    @Keep
    public class C1097a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f39581a;

        public C1097a(a aVar) {
            this.f39581a = aVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            cancel();
            this.f39581a.b();
        }
    }

    public a(int i, com.kc.dw.player.a.b bVar) {
        this.f39580a = bVar;
        try {
            new Timer().schedule(new C1097a(this), i > 0 ? i : 5000L);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.kc.dw.player.a.b
    public void a() {
        b();
    }

    @Override // com.kc.dw.player.a.b
    public void a(String str, MediaPlayer mediaPlayer, boolean z) {
        try {
            synchronized (this.b) {
                com.kc.dw.player.a.b bVar = this.f39580a;
                if (bVar != null) {
                    bVar.a(str, null, z);
                    this.f39580a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b() {
        try {
            synchronized (this.b) {
                com.kc.dw.player.a.b bVar = this.f39580a;
                if (bVar != null) {
                    bVar.a();
                    this.f39580a = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.kc.dw.player.a.b
    public void onStartDownload() {
        com.kc.dw.player.a.b bVar = this.f39580a;
        if (bVar != null) {
            bVar.onStartDownload();
        }
    }
}
