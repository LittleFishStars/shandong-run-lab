package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29256a;
    public final String n;
    public final com.byazt.dg.c<Integer, Integer> sp;
    public final com.byazt.zk.ve uj;
    public com.byazt.dg.c<ColorFilter, ColorFilter> x;

    public gt(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.rh rhVar) {
        super(xVar, veVar, rhVar.sp().c(), rhVar.x().c(), rhVar.i(), rhVar.ve(), rhVar.uj(), rhVar.n(), rhVar.a());
        this.uj = veVar;
        this.n = rhVar.c();
        this.f29256a = rhVar.da();
        com.byazt.dg.c<Integer, Integer> cVarC = rhVar.tt().c();
        this.sp = cVarC;
        cVarC.c(this);
        veVar.c(cVarC);
    }

    @Override // com.byazt.zy.c, com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        if (this.f29256a) {
            return;
        }
        this.tt.setColor(((com.byazt.dg.tt) this.sp).i());
        com.byazt.dg.c<ColorFilter, ColorFilter> cVar = this.x;
        if (cVar != null) {
            this.tt.setColorFilter(cVar.sp());
        }
        super.c(canvas, matrix, i);
    }
}
