package com.byazt.yqb;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.byazt.aas.pf;
import com.byazt.ete.da;
import com.byazt.ete.ic;
import com.byazt.ete.xd;
import com.byazt.lcf.TTBaseVideoActivity;
import com.byazt.nr.m;
import com.byazt.or.x;
import com.byazt.yj.gr;
import com.byazt.zd.tt;
import com.gyf.immersionbar.b;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 871, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LinearLayout f29211a;
    public final TTBaseVideoActivity c;
    public final tt da;
    public ObjectAnimator i;
    public View n;
    public TextView sp;
    public final ic tt;
    public ViewGroup uj;
    public ImageView ve;
    public ObjectAnimator x;

    public c(TTBaseVideoActivity tTBaseVideoActivity, ic icVar, tt ttVar) {
        this.c = tTBaseVideoActivity;
        this.tt = icVar;
        this.da = ttVar;
    }

    public void c(ViewGroup viewGroup, View view) {
        this.uj = viewGroup;
        this.n = view;
        this.ve = new ImageView(this.c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pf.ve(this.c, 76.0f));
        layoutParams.gravity = 80;
        this.ve.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.uj.addView(this.ve, layoutParams);
    }

    public int tt() {
        int identifier = this.c.getResources().getIdentifier(b.f6802a, "dimen", "android");
        if (identifier > 0) {
            return this.c.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public void uj() {
        ObjectAnimator objectAnimator = this.x;
        if (objectAnimator != null && objectAnimator.isRunning()) {
            this.x.cancel();
            this.x = null;
        }
        ObjectAnimator objectAnimator2 = this.i;
        if (objectAnimator2 != null && objectAnimator2.isRunning()) {
            this.i.cancel();
            this.i = null;
        }
        LinearLayout linearLayout = this.f29211a;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        View view = this.n;
        if (view != null) {
            view.setTranslationY(0.0f);
        }
        ImageView imageView = this.ve;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this.da.x();
    }

    public void ve() {
        uj();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.n, "alpha", 1.0f, 0.3f);
        objectAnimatorOfFloat.setDuration(1000L);
        objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.yqb.c.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                c.this.n.setAlpha(1.0f);
                c.this.da.i();
            }
        });
        objectAnimatorOfFloat.start();
    }

    public void c() {
        int iZ;
        LinearLayout linearLayout = new LinearLayout(this.c);
        this.f29211a = linearLayout;
        linearLayout.setGravity(1);
        this.f29211a.setPadding(0, pf.ve(this.c, 16.0f), 0, 0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, pf.ve(this.c, 76.0f));
        TextView textView = new TextView(this.c);
        this.sp = textView;
        textView.setTextSize(12.0f);
        this.sp.setTextColor(-1);
        this.sp.setSingleLine();
        this.sp.setEllipsize(TextUtils.TruncateAt.START);
        this.sp.setGravity(5);
        this.sp.setMaxWidth(pf.ve(this.c, 260.0f));
        this.f29211a.addView(this.sp);
        TextView textView2 = new TextView(this.c);
        textView2.setTextSize(12.0f);
        textView2.setTextColor(-1);
        textView2.setTypeface(Typeface.DEFAULT_BOLD);
        textView2.setGravity(17);
        textView2.setSingleLine();
        textView2.setText(OptionsPickerHelper.e);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.byazt.yqb.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.uj();
            }
        });
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = pf.ve(this.c, 10.0f);
        this.f29211a.addView(textView2, layoutParams2);
        c(25, xd.tt(this.tt));
        int iVe = pf.ve(this.c, 76.0f);
        this.uj.addView(this.f29211a, layoutParams);
        try {
            int iTt = x.tt(this.c);
            if (pf.uj((Activity) this.c)) {
                iZ = (x.ve(this.c) - iTt) - tt();
            } else {
                iZ = pf.z(this.c);
            }
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f29211a, "translationY", iTt, (iTt - iVe) + iZ);
            this.x = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration(300L);
            this.x.start();
            ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.n, "translationY", 0.0f, -iVe);
            this.i = objectAnimatorOfFloat2;
            objectAnimatorOfFloat2.setDuration(300L);
            this.i.start();
        } catch (Throwable th) {
            m.uj("layout", th.getMessage());
        }
    }

    public void c(final int i, String str) {
        com.byazt.xky.tt.c(str).type(2).config(Bitmap.Config.ARGB_8888).to(new gr<Bitmap>() { // from class: com.byazt.yqb.c.2
            @Override // com.byazt.yj.gr
            public void onFailed(int i2, String str2, Throwable th) {
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(com.byazt.yj.m<Bitmap> mVar) {
                try {
                    Bitmap result = mVar.getResult();
                    if (result == null) {
                        return;
                    }
                    if (result.getConfig() == Bitmap.Config.RGB_565) {
                        result = result.copy(Bitmap.Config.ARGB_8888, true);
                    }
                    Bitmap bitmapC = com.byazt.or.tt.c(c.this.c, result, i);
                    if (bitmapC == null) {
                        return;
                    }
                    final BitmapDrawable bitmapDrawable = new BitmapDrawable(c.this.c.getResources(), bitmapC);
                    com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.yqb.c.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.f29211a != null) {
                                c.this.f29211a.setBackgroundColor(Color.parseColor("#66000000"));
                            }
                            if (c.this.ve != null) {
                                c.this.ve.setImageDrawable(bitmapDrawable);
                            }
                        }
                    });
                } catch (Throwable th) {
                    m.uj("layout", th.getMessage());
                }
            }
        }, 4);
    }

    public void c(com.byazt.hkv.tt ttVar) {
        da daVar = new da();
        daVar.ve(true);
        if (ttVar != null) {
            ttVar.c(daVar);
            ttVar.c(null, daVar);
        }
    }

    public void c(long j) {
        TextView textView = this.sp;
        if (textView != null) {
            textView.setText("已为您加载更多详情，" + j + "秒后拉起展示");
        }
    }
}
