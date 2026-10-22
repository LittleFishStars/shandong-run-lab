package com.byazt.oq;

import android.content.Context;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.xc.tt;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1206})
public class DynamicUnlockView extends FrameLayout {
    public final TextView c;
    public final ImageView tt;
    public final RotateAnimation uj;
    public final FlowLightView ve;

    public DynamicUnlockView(Context context) {
        super(context);
        addView(tt.uj(context));
        this.c = (TextView) findViewById(2097610742);
        this.tt = (ImageView) findViewById(2097610745);
        this.ve = (FlowLightView) findViewById(2097610744);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 30.0f, 1, 0.65f, 1, 0.9f);
        this.uj = rotateAnimation;
        rotateAnimation.setDuration(300L);
        rotateAnimation.setRepeatMode(2);
        rotateAnimation.setRepeatCount(1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Runnable getHaloAnimation() {
        return new Runnable() { // from class: com.byazt.oq.DynamicUnlockView.1
            @Override // java.lang.Runnable
            public void run() {
                DynamicUnlockView.this.tt.startAnimation(DynamicUnlockView.this.uj);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.byazt.oq.DynamicUnlockView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.ve.c(4);
                    }
                }, 100L);
                DynamicUnlockView.this.postDelayed(new Runnable() { // from class: com.byazt.oq.DynamicUnlockView.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        DynamicUnlockView.this.ve.c(4);
                    }
                }, 300L);
                DynamicUnlockView dynamicUnlockView = DynamicUnlockView.this;
                dynamicUnlockView.postDelayed(dynamicUnlockView.getHaloAnimation(), 1200L);
            }
        };
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "滑动或点击跳转至详情页或第三方应用";
        }
        TextView textView = this.c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void c() {
        postDelayed(getHaloAnimation(), 300L);
    }

    public void tt() {
        this.uj.cancel();
    }
}
