package com.byazt.zk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.rl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 46})
public class n extends sp {
    public VideoFrame da;
    public float i;
    public LottieAnimationView sl;
    public com.byazt.ga.i.c.C0410c t;
    public float x;

    public n(com.byazt.ga.x xVar, x xVar2, Context context, com.byazt.ga.i.c.C0410c c0410c) {
        super(xVar, xVar2);
        this.x = -1.0f;
        this.i = -1.0f;
        this.t = c0410c;
        if (((sp) this).sp == null || xVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewTt = xVar.tt();
        this.sl = lottieAnimationViewTt;
        if (lottieAnimationViewTt == null) {
            return;
        }
        float fC = com.byazt.kk.da.c();
        this.x = (int) (((sp) this).sp.c() * fC);
        this.i = (int) (((sp) this).sp.tt() * fC);
        rl rlVarC = xVar.c();
        View viewC = rlVarC != null ? rlVarC.c("videoview:", null) : null;
        if (viewC instanceof TextureView) {
            this.da = new VideoFrame(context, (TextureView) viewC, c0410c);
        }
        this.sl.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.zk.n.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (n.this.sl == view) {
                    n.this.z();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
            }
        });
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        VideoFrame videoFrame = this.da;
        if (videoFrame != null) {
            ViewParent parent = videoFrame.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.da);
            }
            ViewParent parent2 = this.sl.getParent();
            if (parent2 instanceof ViewGroup) {
                this.da.setTranslationX(2.1474836E9f);
                ((ViewGroup) parent2).addView(this.da);
            }
        }
    }

    private static void c(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    @Override // com.byazt.zk.sp, com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        if (this.x <= 0.0f || this.da == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        c(i);
        float fX = x();
        c(this.da, (int) this.x, (int) this.i);
        this.da.setAlpha(fX);
        this.da.draw(canvas);
        canvas.restore();
    }
}
