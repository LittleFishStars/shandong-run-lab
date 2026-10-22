package com.byazt.oq;

import android.content.Context;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.byazt.aq.da;
import com.byazt.xc.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2168})
public class ClickSlideUpShakeView extends SlideUpView {
    public ShakeClickView c;

    public ClickSlideUpShakeView(Context context, da daVar, boolean z, int i) {
        super(context);
        c(context, daVar, z, i);
    }

    private void c(Context context, da daVar, boolean z, int i) {
        ShakeClickView shakeClickView = new ShakeClickView(context, tt.ve(context), daVar, z, i);
        this.c = shakeClickView;
        addView(shakeClickView);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(14);
        layoutParams.addRule(12);
        this.c.setLayoutParams(layoutParams);
    }

    public ShakeClickView getShakeView() {
        return this.c;
    }

    public void setShakeText(String str) {
        if (this.c == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.c.setShakeText("");
        } else {
            this.c.setShakeText(str);
        }
    }
}
