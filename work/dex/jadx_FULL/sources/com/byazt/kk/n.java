package com.byazt.kk;

import com.byazt.ga.sl;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.zj.adlib.vs4;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_SWITCH_SUBID, 46})
public class n implements sl {
    public static final Set<String> c = new HashSet();

    @Override // com.byazt.ga.sl
    public void c(String str) {
        c(str, null);
    }

    @Override // com.byazt.ga.sl
    public void tt(String str, Throwable th) {
        boolean z = com.byazt.ga.n.c;
    }

    @Override // com.byazt.ga.sl
    public void c(String str, Throwable th) {
        Set<String> set = c;
        if (set.contains(str)) {
            return;
        }
        m.tt(vs4.f20320a, str, th);
        set.add(str);
    }
}
