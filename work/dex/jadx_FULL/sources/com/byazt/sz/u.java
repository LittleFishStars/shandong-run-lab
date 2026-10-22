package com.byazt.sz;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SUB, 67})
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f29049a;
    public Paint c;
    public int n;
    public String sp;
    public c tt;
    public View uj;
    public AnimatorSet ve = new AnimatorSet();

    public u(View view, c cVar) {
        this.uj = view;
        this.tt = cVar;
        Paint paint = new Paint();
        this.c = paint;
        paint.setAntiAlias(true);
    }

    public void tt() {
        AnimatorSet animatorSet = this.ve;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void c() {
        ArrayList arrayList = new ArrayList();
        List<c.C0529c> listVe = this.tt.ve();
        if (listVe == null || listVe.size() <= 0) {
            return;
        }
        for (c.C0529c c0529c : listVe) {
            if (c0529c != null) {
                ObjectAnimator objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0529c.c());
                if (TextUtils.equals(c0529c.getType(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0529c.getType(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0529c.getType());
                }
                objectAnimator.setStartDelay(c0529c.uj());
                objectAnimator.setTarget(this.uj);
                if (TextUtils.equals(c0529c.getType(), "backgroundColor")) {
                    objectAnimator.setIntValues((int) c0529c.n(), (int) c0529c.a());
                } else {
                    objectAnimator.setFloatValues(c0529c.n(), c0529c.a());
                }
                int iTt = (int) this.tt.tt();
                if (iTt != 0) {
                    objectAnimator.setRepeatCount(iTt);
                } else {
                    objectAnimator.setRepeatCount((int) c0529c.tt());
                }
                if (TextUtils.equals(c0529c.getType(), "backgroundColor")) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strA = this.tt.a();
                if (TextUtils.isEmpty(strA)) {
                    strA = c0529c.ve();
                }
                if (TextUtils.equals(strA, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0529c.sp() != null && c0529c.sp().length > 0) {
                    objectAnimator.setFloatValues(c0529c.sp());
                }
                if (TextUtils.equals(c0529c.getType(), "rotationX")) {
                    this.uj.post(new Runnable() { // from class: com.byazt.sz.u.1
                        @Override // java.lang.Runnable
                        public void run() {
                            u.this.uj.setPivotX(u.this.uj.getWidth() / 2.0f);
                            u.this.uj.setPivotY(u.this.uj.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0529c.getType(), "ripple")) {
                    this.sp = c0529c.i();
                }
                String strX = c0529c.x();
                strX.hashCode();
                switch (strX) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.tt.uj() != 0) {
            this.ve.setDuration(this.tt.uj());
        }
        this.ve.setStartDelay(this.tt.n());
        if (TextUtils.equals(this.tt.c(), "sequentially")) {
            this.ve.playSequentially(arrayList);
        } else {
            this.ve.playTogether(arrayList);
        }
        this.ve.start();
    }

    public void c(Canvas canvas, n nVar) {
        try {
            if (nVar.getRipple() == 0.0f || TextUtils.isEmpty(this.sp)) {
                return;
            }
            this.c.setColor(com.byazt.cd.c.c(this.sp));
            this.c.setAlpha(90);
            ((ViewGroup) this.uj.getParent()).setClipChildren(true);
            int i = this.n;
            int i2 = this.f29049a;
            canvas.drawCircle(i, i2, Math.min(i, i2) * 2 * nVar.getRipple(), this.c);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    public void c(int i, int i2) {
        this.n = i / 2;
        this.f29049a = i2 / 2;
    }
}
