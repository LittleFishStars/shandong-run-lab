package com.byazt.oq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.xc.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1640})
public class ClickSlideUpView2 extends SlideUpView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f28897a;
    public TextView c;
    public int n;
    public ImageView tt;
    public ImageView uj;
    public ImageView ve;

    public ClickSlideUpView2(Context context) {
        super(context);
        this.f28897a = new AnimatorSet();
        tt(context);
    }

    private void tt(Context context) {
        addView(tt.tt(context));
        this.tt = (ImageView) findViewById(2097610751);
        this.ve = (ImageView) findViewById(2097610750);
        this.uj = (ImageView) findViewById(2097610749);
        this.c = (TextView) findViewById(2097610748);
    }

    private void uj() {
        ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(this, "alphaColor", 0, 60);
        objectAnimatorOfInt.setInterpolator(new LinearInterpolator());
        objectAnimatorOfInt.setDuration(2000L);
        objectAnimatorOfInt.setRepeatCount(-1);
        objectAnimatorOfInt.start();
    }

    @Override // com.byazt.oq.SlideUpView
    public void c() {
        uj();
    }

    @Override // com.byazt.oq.SlideUpView
    public void c(Context context) {
    }

    public float getAlphaColor() {
        return this.n;
    }

    public void setAlphaColor(int i) {
        if (i < 0 || i > 60) {
            return;
        }
        int i2 = i + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.uj.setColorFilter(Color.rgb(i2, i2, i2), PorterDuff.Mode.SRC_IN);
        int i3 = ((i + 20) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.ve.setColorFilter(Color.rgb(i3, i3, i3), PorterDuff.Mode.SRC_IN);
        int i4 = ((i + 40) % 60) + MediaPlayer.MEDIA_PLAYER_OPTION_LOOP_PERFER_VIDEO;
        this.tt.setColorFilter(Color.rgb(i4, i4, i4), PorterDuff.Mode.SRC_IN);
    }

    public void setButtonText(String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    @Override // com.byazt.oq.SlideUpView
    public void tt() {
        this.f28897a.cancel();
    }
}
