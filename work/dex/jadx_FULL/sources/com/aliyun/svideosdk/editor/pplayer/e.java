package com.aliyun.svideosdk.editor.pplayer;

import android.view.Surface;
import com.aliyun.svideosdk.player.NativePasterPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final NativePasterPlayer f25768a;
    private final long b;

    public e() {
        NativePasterPlayer nativePasterPlayer = new NativePasterPlayer();
        this.f25768a = nativePasterPlayer;
        this.b = nativePasterPlayer.initialize();
    }

    public void a() {
        this.f25768a.release(this.b);
    }

    public void a(long j) {
        this.f25768a.draw(this.b, j);
    }

    public void a(long j, int i) {
        this.f25768a.addTimeIndex(this.b, j, i);
    }

    public void a(Surface surface) {
        this.f25768a.setWindow(this.b, surface);
    }

    public void a(String str) {
        this.f25768a.setSource(this.b, str);
    }
}
