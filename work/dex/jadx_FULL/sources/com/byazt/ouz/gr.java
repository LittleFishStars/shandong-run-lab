package com.byazt.ouz;

import android.content.Context;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE})
public class gr extends zm {
    public gr(Context context, ic icVar, com.byazt.dj.tt ttVar, int i) {
        super(context, icVar, ttVar, i);
    }

    @Override // com.byazt.ouz.zm, com.byazt.ouz.gu
    public void initExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        this.uj = "draw_ad";
        NativeExpressDrawVideoView nativeExpressDrawVideoView = new NativeExpressDrawVideoView(context, icVar, ttVar, "draw_ad");
        ((gu) this).c = nativeExpressDrawVideoView;
        c(nativeExpressDrawVideoView, this.ve);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setCanInterruptVideoPlay(boolean z) {
        NativeExpressView nativeExpressView = ((gu) this).c;
        if (nativeExpressView != null) {
            ((NativeExpressVideoView) nativeExpressView).setCanInterruptVideoPlay(z);
        }
    }
}
