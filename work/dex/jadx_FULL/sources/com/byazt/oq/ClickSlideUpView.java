package com.byazt.oq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.TextView;
import com.byazt.or.x;
import com.byazt.xc.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1400})
public class ClickSlideUpView extends SlideUpView {
    public TextView c;
    public View tt;
    public AnimatorSet ve;

    public ClickSlideUpView(Context context) {
        super(context);
        this.ve = new AnimatorSet();
        tt(context);
    }

    private void tt(Context context) {
        View viewC = tt.c(context);
        this.tt = viewC;
        addView(viewC);
        setClipChildren(false);
        this.c = (TextView) findViewById(2097610748);
    }

    private void uj() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.tt, "translationY", 0.0f, x.c(getContext(), -3.0f));
        objectAnimatorOfFloat.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.tt, "alpha", 1.0f, 0.8f);
        objectAnimatorOfFloat2.setDuration(1000L);
        objectAnimatorOfFloat2.setInterpolator(new CycleInterpolator(1.0f));
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.ve.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
        this.ve.setDuration(1000L);
        this.ve.start();
    }

    @Override // com.byazt.oq.SlideUpView
    public void c() {
        uj();
    }

    @Override // com.byazt.oq.SlideUpView
    public void c(Context context) {
    }

    public void setButtonText(String str) {
        if (this.c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.c.setText(str);
    }

    @Override // com.byazt.oq.SlideUpView
    public void tt() {
        this.ve.cancel();
    }
}
