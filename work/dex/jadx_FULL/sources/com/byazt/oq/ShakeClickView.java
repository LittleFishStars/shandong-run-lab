package com.byazt.oq;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.byazt.aq.da;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2301})
public class ShakeClickView extends ShakeAnimationView {
    public TextView tt;

    public ShakeClickView(Context context, View view, da daVar, boolean z, int i) {
        super(context, view, daVar, z, i);
    }

    @Override // com.byazt.oq.ShakeAnimationView
    public void c(Context context, View view) {
        addView(view);
        this.tt = (TextView) findViewById(2097610747);
    }

    @Override // com.byazt.oq.ShakeAnimationView
    public void setShakeText(String str) {
        if (this.tt == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.tt.setText(str);
            return;
        }
        try {
            this.tt.setText("摇一摇或点击了解更多");
        } catch (Exception e) {
            m.uj("shakeClickView", e.getMessage());
        }
    }
}
