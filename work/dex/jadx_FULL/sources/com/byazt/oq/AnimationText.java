package com.byazt.oq;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;
import com.byazt.du.sl;
import com.byazt.nr.d;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.component.utils.WeakHandler;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_FIRST_PACKET_TIME, 2084})
public class AnimationText extends TextSwitcher implements ViewSwitcher.ViewFactory, WeakHandler.IHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f28891a;
    public Animation.AnimationListener c;
    public int da;
    public float i;
    public Context n;
    public int sl;
    public int sp;
    public int t;
    public List<String> tt;
    public int u;
    public final int uj;
    public int ve;
    public int x;
    public Handler yp;

    public AnimationText(Context context, int i, float f, int i2, int i3) {
        super(context);
        this.tt = new ArrayList();
        this.ve = 0;
        this.uj = 1;
        this.yp = new d(Looper.getMainLooper(), this);
        this.c = new Animation.AnimationListener() { // from class: com.byazt.oq.AnimationText.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (AnimationText.this.f28891a != null) {
                    AnimationText.this.f28891a.setText("");
                }
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        this.n = context;
        this.x = i;
        this.i = f;
        this.da = i2;
        this.u = i3;
        tt();
    }

    private void tt() {
        setFactory(this);
    }

    @Override // android.widget.ViewSwitcher.ViewFactory
    public View makeView() {
        TextView textView = new TextView(getContext());
        this.f28891a = textView;
        textView.setTextColor(this.x);
        this.f28891a.setTextSize(this.i);
        this.f28891a.setMaxLines(this.da);
        this.f28891a.setTextAlignment(this.u);
        return this.f28891a;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.yp.sendEmptyMessageDelayed(1, this.sp);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.yp.removeMessages(1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        try {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(sl.tt(this.tt.get(this.sl), this.i, false)[0], 1073741824), i);
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    public void setAnimationDuration(int i) {
        this.sp = i;
    }

    public void setAnimationText(List<String> list) {
        this.tt = list;
    }

    public void setAnimationType(int i) {
        this.t = i;
    }

    public void setMaxLines(int i) {
        this.da = i;
    }

    public void setTextColor(int i) {
        this.x = i;
    }

    public void setTextSize(float f) {
        this.i = f;
    }

    public void c() {
        int i = this.t;
        if (i == 1) {
            setInAnimation(com.byazt.xc.c.tt());
            setOutAnimation(com.byazt.xc.c.ve());
        } else if (i == 0) {
            setInAnimation(com.byazt.xc.c.c());
            setOutAnimation(com.byazt.xc.c.c());
            getInAnimation().setInterpolator(new LinearInterpolator());
            getOutAnimation().setInterpolator(new LinearInterpolator());
            getInAnimation().setAnimationListener(this.c);
            getOutAnimation().setAnimationListener(this.c);
        }
        this.yp.sendEmptyMessage(1);
    }
}
