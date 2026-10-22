package com.byazt.gr;

import android.view.View;
import com.byazt.an.ViewPager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 13})
public class tt implements ViewPager.n {
    @Override // com.byazt.an.ViewPager.n
    public void c(View view, float f) {
        int width = view.getWidth();
        if (f < -1.0f || f > 1.0f) {
            view.setAlpha(0.0f);
            return;
        }
        if (f < 0.0f) {
            view.setTranslationX((-width) * f);
        } else {
            view.setTranslationX(width);
            view.setTranslationX((-width) * f);
        }
        view.setAlpha(Math.max(0.0f, 1.0f - Math.abs(f)));
    }
}
