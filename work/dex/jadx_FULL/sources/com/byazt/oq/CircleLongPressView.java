package com.byazt.oq;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.byazt.nr.eo;
import com.byazt.or.i;
import com.byazt.or.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 1396})
public class CircleLongPressView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f28895a;
    public Context c;
    public RingProgressView n;
    public ImageView tt;
    public TextView uj;
    public ImageView ve;

    public CircleLongPressView(Context context) {
        super(context);
        this.f28895a = new AnimatorSet();
        this.c = context;
        n();
        a();
    }

    private void a() {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.ve, "scaleX", 1.0f, 0.9f);
        objectAnimatorOfFloat.setRepeatCount(-1);
        objectAnimatorOfFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimatorOfFloat.setRepeatMode(2);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.ve, "scaleY", 1.0f, 0.9f);
        objectAnimatorOfFloat2.setRepeatCount(-1);
        objectAnimatorOfFloat2.setRepeatMode(2);
        objectAnimatorOfFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f28895a.setDuration(800L);
        this.f28895a.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2);
    }

    private void n() {
        FrameLayout frameLayout = new FrameLayout(this.c);
        this.n = new RingProgressView(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) x.c(this.c, 95.0f), (int) x.c(this.c, 95.0f));
        layoutParams.gravity = 17;
        frameLayout.addView(this.n, layoutParams);
        this.tt = new ImageView(this.c);
        int iC = eo.c(this.c, 60.0f);
        this.tt.setImageDrawable(i.c(1, null, null, new int[]{iC, iC}, Integer.valueOf(eo.c(this.c, 1.0f)), Integer.valueOf(Color.parseColor("#80FFFFFF"))));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) x.c(this.c, 75.0f), (int) x.c(this.c, 75.0f));
        layoutParams2.gravity = 17;
        frameLayout.addView(this.tt, layoutParams2);
        this.ve = new ImageView(this.c);
        int iC2 = eo.c(this.c, 50.0f);
        this.ve.setImageDrawable(i.c(1, Integer.valueOf(Color.parseColor("#80FFFFFF")), null, new int[]{iC2, iC2}, null, null));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) x.c(this.c, 63.0f), (int) x.c(this.c, 63.0f));
        layoutParams3.gravity = 17;
        frameLayout.addView(this.ve, layoutParams3);
        addView(frameLayout);
        TextView textView = new TextView(this.c);
        this.uj = textView;
        textView.setTextColor(-1);
        this.uj.setMaxLines(1);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 81;
        addView(this.uj, layoutParams4);
    }

    public void c() {
        this.f28895a.start();
    }

    public void setGuideText(String str) {
        this.uj.setText(str);
    }

    public void tt() {
        this.f28895a.cancel();
    }

    public void uj() {
        this.n.tt();
        this.n.ve();
    }

    public void ve() {
        this.n.c();
    }
}
