package com.byazt.ga;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 256, MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO})
public class gt {
    public final Map<String, String> c;
    public final LottieAnimationView tt;
    public boolean uj;
    public final x ve;

    public gt() {
        this.c = new HashMap();
        this.uj = true;
        this.tt = null;
        this.ve = null;
    }

    public String c(String str) {
        return str;
    }

    public String c(String str, String str2) {
        return c(str2);
    }

    public void tt(String str, String str2) {
        this.c.put(str, str2);
        c();
    }

    public final String ve(String str, String str2) {
        if (this.uj && this.c.containsKey(str2)) {
            return this.c.get(str2);
        }
        String strC = c(str, str2);
        if (this.uj) {
            this.c.put(str2, strC);
        }
        return strC;
    }

    private void c() {
        LottieAnimationView lottieAnimationView = this.tt;
        if (lottieAnimationView != null) {
            lottieAnimationView.invalidate();
        }
        x xVar = this.ve;
        if (xVar != null) {
            xVar.invalidateSelf();
        }
    }

    public gt(LottieAnimationView lottieAnimationView) {
        this.c = new HashMap();
        this.uj = true;
        this.tt = lottieAnimationView;
        this.ve = null;
    }
}
