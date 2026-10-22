package com.byazt.oq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.byazt.nr.z;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 691})
public class ClickInteractView extends FrameLayout {
    public ImageView c;
    public AnimatorSet tt;

    public ClickInteractView(Context context) {
        super(context);
        ve();
        uj();
    }

    private void uj() {
        this.tt = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.c, "scaleX", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat.setDuration(2000L);
        objectAnimatorOfFloat.setRepeatMode(2);
        objectAnimatorOfFloat.setRepeatCount(-1);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.c, "scaleY", 1.0f, 1.5f, 1.0f, 1.0f, 1.0f);
        objectAnimatorOfFloat2.setDuration(2000L);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        this.tt.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void ve() {
        this.c = new ImageView(getContext());
        z.c(getContext(), "tt_white_hand", this.c, 320);
        int iC = (int) x.c(getContext(), 20.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(iC, iC);
        layoutParams.gravity = 17;
        addView(this.c, layoutParams);
    }

    public void c() {
        AnimatorSet animatorSet = this.tt;
        if (animatorSet != null) {
            animatorSet.start();
        }
    }

    public void tt() {
        AnimatorSet animatorSet = this.tt;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
