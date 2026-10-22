package com.byazt.o;

import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME, 71})
public class x extends Exception {
    public Throwable c;
    public int tt;
    public int ve;

    public x(String str, sp spVar, Throwable th) {
        String str2;
        String str3;
        StringBuilder sb = new StringBuilder();
        String str4 = "";
        if (str == null) {
            str2 = "";
        } else {
            str2 = str + " ";
        }
        sb.append(str2);
        if (spVar == null) {
            str3 = "";
        } else {
            str3 = "(position:" + spVar.uj() + ") ";
        }
        sb.append(str3);
        if (th != null) {
            str4 = "caused by: " + th;
        }
        sb.append(str4);
        super(sb.toString());
        this.tt = -1;
        this.ve = -1;
        if (spVar != null) {
            this.tt = spVar.ve();
            this.ve = spVar.a();
        }
        this.c = th;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        if (this.c == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            System.err.println(super.getMessage() + "; nested exception is:");
            m.c(this.c);
        }
    }
}
