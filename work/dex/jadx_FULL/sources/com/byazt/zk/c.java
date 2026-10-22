package com.byazt.zk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ImageDecoder;
import android.graphics.Matrix;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import com.byazt.ga.LottieAnimationView;
import com.byazt.ga.gt;
import com.byazt.nr.m;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 20})
public class c extends sp {
    public ImageView da;
    public float i;
    public Drawable sl;
    public LottieAnimationView t;
    public final Handler u;
    public float x;
    public final Runnable yp;

    public c(com.byazt.ga.x xVar, x xVar2, Context context) {
        super(xVar, xVar2);
        this.x = -1.0f;
        this.i = -1.0f;
        this.u = new Handler(Looper.getMainLooper());
        this.yp = new Runnable() { // from class: com.byazt.zk.c.5
            @Override // java.lang.Runnable
            public void run() {
                if (c.this.t != null && c.this.t.n()) {
                    c.this.t.invalidate();
                }
                c.this.u.postDelayed(c.this.yp, 40L);
            }
        };
        if (((sp) this).sp == null || xVar == null) {
            return;
        }
        LottieAnimationView lottieAnimationViewTt = xVar.tt();
        this.t = lottieAnimationViewTt;
        if (lottieAnimationViewTt == null) {
            return;
        }
        float fC = com.byazt.kk.da.c();
        this.x = (int) (((sp) this).sp.c() * fC);
        this.i = (int) (((sp) this).sp.tt() * fC);
        gt gtVarZm = xVar.zm();
        String strC = gtVarZm != null ? gtVarZm.c(((sp) this).sp.u()) : null;
        if (TextUtils.isEmpty(strC)) {
            return;
        }
        ImageView imageView = new ImageView(context);
        this.da = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.da.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.zk.c.1
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (c.this.da == view) {
                    c.this.nu();
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (c.this.da == view) {
                    c.this.z();
                    if (Build.VERSION.SDK_INT < 28 || !(c.this.sl instanceof AnimatedImageDrawable)) {
                        return;
                    }
                    ((AnimatedImageDrawable) c.this.sl).stop();
                }
            }
        });
        this.t.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.zk.c.2
            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(View view) {
                if (c.this.t == view) {
                    if (c.this.tt()) {
                        c.this.t.removeOnAttachStateChangeListener(this);
                    } else {
                        c.this.c(new Runnable() { // from class: com.byazt.zk.c.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                c.this.rh();
                            }
                        });
                    }
                }
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(View view) {
                if (c.this.t == view) {
                    c.this.c(new Runnable() { // from class: com.byazt.zk.c.2.2
                        @Override // java.lang.Runnable
                        public void run() {
                            ViewParent parent = c.this.da.getParent();
                            if (parent instanceof ViewGroup) {
                                ((ViewGroup) parent).removeView(c.this.da);
                            }
                        }
                    });
                }
            }
        });
        c(strC, context);
    }

    private void m() {
        z();
        if (this.t != null) {
            this.u.postDelayed(this.yp, 40L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void nu() {
        if (Build.VERSION.SDK_INT >= 28) {
            Drawable drawable = this.sl;
            if (!(drawable instanceof AnimatedImageDrawable) || ((AnimatedImageDrawable) drawable).isRunning()) {
                return;
            }
            ((AnimatedImageDrawable) this.sl).setRepeatCount(-1);
            ((AnimatedImageDrawable) this.sl).start();
            m();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh() {
        if (this.sl != null) {
            ViewParent parent = this.da.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.da);
            }
            ViewParent parent2 = this.t.getParent();
            if (parent2 instanceof ViewGroup) {
                this.da.setTranslationX(2.1474836E9f);
                this.da.setImageDrawable(this.sl);
                ((ViewGroup) parent2).addView(this.da);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z() {
        this.u.removeCallbacksAndMessages(null);
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
        canvas.clipRect(0.0f, 0.0f, this.x, this.i);
        this.da.draw(canvas);
        canvas.restore();
    }

    private void c(String str, Context context) {
        File file = new File(com.byazt.kk.ve.c(context), com.byazt.nr.a.tt(str));
        if (file.exists()) {
            c(file);
        } else {
            com.byazt.kk.ve.c(str, context, new com.byazt.kk.ve.c<File>() { // from class: com.byazt.zk.c.3
                @Override // com.byazt.kk.ve.c
                public void c(File file2) {
                    c.this.c(file2);
                }

                @Override // com.byazt.kk.ve.c
                public void c(int i, String str2) {
                    m.c("TMe", "--==--- webp: " + i + ", " + str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(File file) {
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                Drawable drawable = this.sl;
                if (drawable instanceof AnimatedImageDrawable) {
                    ((AnimatedImageDrawable) drawable).stop();
                }
                this.sl = ImageDecoder.decodeDrawable(ImageDecoder.createSource(file));
                this.u.post(new Runnable() { // from class: com.byazt.zk.c.4
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh();
                    }
                });
            } catch (IOException e) {
                m.c(e);
            }
        }
    }

    private static void c(View view, int i, int i2) {
        view.layout(0, 0, i, i2);
        view.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(i2, 1073741824));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }
}
