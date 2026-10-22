package com.byazt.gr;

import android.view.View;
import com.byazt.an.ViewPager;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 54})
public class ve implements ViewPager.n {
    public final float c = 0.8f;
    public final float tt = 0.5f;

    @Override // com.byazt.an.ViewPager.n
    public void c(View view, float f) {
        float f2 = ((f < 0.0f ? 0.19999999f : -0.19999999f) * f) + 1.0f;
        float f3 = (f * (f < 0.0f ? 0.5f : -0.5f)) + 1.0f;
        if (f < 0.0f) {
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight() / 2);
        } else {
            view.setPivotX(0.0f);
            view.setPivotY(view.getHeight() / 2);
        }
        view.setScaleX(f2);
        view.setScaleY(f2);
        view.setAlpha(Math.abs(f3));
    }
}
