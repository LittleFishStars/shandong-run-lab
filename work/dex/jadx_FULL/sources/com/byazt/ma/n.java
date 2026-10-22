package com.byazt.ma;

import android.view.View;
import android.view.ViewGroup;
import com.byazt.ete.ic;
import com.byazt.ete.ir;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_GET_MASTER_CLOCK_BY_PTS, 46})
public class n extends c {
    public n(ic icVar, com.byazt.sy.c cVar, ir irVar) {
        super(icVar, cVar, irVar);
    }

    public void c(View view) {
        ir irVar;
        ViewGroup viewGroupVe;
        if (view == null || (irVar = ((c) this).uj) == null || !com.byazt.sy.uj.c(irVar.uj()) || (viewGroupVe = com.byazt.sy.uj.ve(view)) == null) {
            return;
        }
        tt(viewGroupVe, viewGroupVe);
    }
}
