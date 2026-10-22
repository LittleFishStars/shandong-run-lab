package com.byazt.ng;

import android.content.Context;
import android.os.Looper;
import com.byazt.dna.qp;
import com.byazt.vx.qy;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 72})
public class da implements com.byazt.vb.uj {
    public static String ve(String str) {
        return com.byazt.vx.c.tt(str, com.byazt.vx.tt.c());
    }

    @Override // com.byazt.vb.uj
    public boolean a() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public com.byazt.vb.tt c(JSONObject jSONObject) {
        return null;
    }

    @Override // com.byazt.vb.uj
    public void c(JSONObject jSONObject, JSONObject jSONObject2) {
    }

    @Override // com.byazt.vb.uj
    public boolean c() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public boolean c(Context context) {
        return qy.c(context);
    }

    @Override // com.byazt.vb.uj
    public int da() {
        return 2;
    }

    @Override // com.byazt.vb.uj
    public Executor i() {
        return com.byazt.eu.n.a();
    }

    @Override // com.byazt.vb.uj
    public String n() {
        return "gromore-no-webview";
    }

    @Override // com.byazt.vb.uj
    public com.byazt.epi.ve sl() {
        return null;
    }

    @Override // com.byazt.vb.uj
    public com.byazt.gs.tt sp() {
        return null;
    }

    @Override // com.byazt.vb.uj
    public com.byazt.vb.x t() {
        return null;
    }

    @Override // com.byazt.vb.uj
    public String tt() {
        return "mediation_log";
    }

    @Override // com.byazt.vb.uj
    public String tt(String str) {
        return com.byazt.vx.c.c(str, com.byazt.vx.tt.c());
    }

    @Override // com.byazt.vb.uj
    public boolean u() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public boolean uj() {
        return true;
    }

    @Override // com.byazt.vb.uj
    public boolean ve() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public Executor x() {
        return com.byazt.eu.n.a();
    }

    @Override // com.byazt.vb.uj
    public boolean yp() {
        return false;
    }

    @Override // com.byazt.vb.uj
    public Looper z() {
        return ((qp) com.byazt.ut.uj.getService("thread_service")).getIOHandler().getLooper();
    }

    @Override // com.byazt.vb.uj
    public String c(String str) {
        return ve(str);
    }
}
