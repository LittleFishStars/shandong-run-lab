package com.alibaba.jsi.standard.js;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class aa implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    long f24578a;
    private boolean b = false;

    public aa(long j) {
        this.f24578a = j;
        com.alibaba.jsi.standard.d.a(this);
    }

    public static aa b() {
        return new aa(Bridge.createNative((com.alibaba.jsi.standard.b) null, 20, 0L));
    }

    public static aa c() {
        return new aa(Bridge.createNative((com.alibaba.jsi.standard.b) null, 20, 1L));
    }

    public static aa d() {
        return new aa(Bridge.createNative((com.alibaba.jsi.standard.b) null, 20, 2L));
    }

    private void e() {
        if (this.b) {
            throw new RuntimeException("Template has been deleted: " + this);
        }
    }

    @Override // com.alibaba.jsi.standard.js.b
    public void a() {
        long j = this.f24578a;
        if (j != 0 && !this.b) {
            Bridge.nativeDelete(j, 2);
            this.f24578a = 0L;
            com.alibaba.jsi.standard.d.b(this);
        }
        this.b = true;
    }

    public boolean b(String str, int i) {
        e();
        return Bridge.cmd(null, MediaPlayer.MEDIA_PLAYER_OPTION_DISABLE_ALGORITHM, this.f24578a, (long) i, new Object[]{str}) != null;
    }

    public boolean a(String str, int i) {
        e();
        return Bridge.cmd(null, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_EXPECT_BITRATE, this.f24578a, (long) i, new Object[]{str}) != null;
    }

    public boolean a(String str, p pVar, int i) {
        e();
        return Bridge.cmd(null, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_NULL_TAG, this.f24578a, (long) i, new Object[]{str, pVar}) != null;
    }

    public boolean a(String str, boolean z, int i) {
        return a(str, new f(z), i);
    }

    public boolean a(String str, int i, int i2) {
        return a(str, new m(i), i2);
    }

    public boolean a(String str, double d, int i) {
        return a(str, new m(d), i);
    }

    public boolean a(String str, String str2, int i) {
        return a(str, new s(str2), i);
    }

    public o a(com.alibaba.jsi.standard.b bVar, h hVar) {
        e();
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SKIP_FIND_UNNECESSARY_STREAM, this.f24578a, new Object[]{hVar});
        if (objCmd == null || !(objCmd instanceof o)) {
            return null;
        }
        return (o) objCmd;
    }

    public j a(com.alibaba.jsi.standard.b bVar, String str, h hVar) {
        e();
        Object objCmd = Bridge.cmd(bVar, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, this.f24578a, new Object[]{str, hVar});
        if (objCmd == null || !(objCmd instanceof j)) {
            return null;
        }
        return (j) objCmd;
    }
}
