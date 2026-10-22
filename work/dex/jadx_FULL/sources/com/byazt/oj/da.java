package com.byazt.oj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.byazt.tm.DynamicBaseWidget;
import com.ipd.dsp.internal.e1.f;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 72})
public class da extends uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28871a;
    public float n;
    public c uj;

    @com.byazt.zqa.c(c = {0, 1, 787, 45})
    public class c {
        public View tt;

        public c(View view) {
            this.tt = view;
        }

        public void c(int i) {
            if (!f.l.equals(da.this.tt.c())) {
                ViewGroup.LayoutParams layoutParams = this.tt.getLayoutParams();
                layoutParams.height = i;
                this.tt.setLayoutParams(layoutParams);
                this.tt.requestLayout();
                return;
            }
            if (da.this.ve instanceof ViewGroup) {
                for (int i2 = 0; i2 < ((ViewGroup) da.this.ve).getChildCount(); i2++) {
                    ((ViewGroup) da.this.ve).getChildAt(i2).setTranslationY(i - da.this.n);
                }
            }
            da daVar = da.this;
            daVar.ve.setTranslationY(daVar.n - i);
        }
    }

    public da(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        int i;
        String str;
        View view = this.ve;
        if ((view instanceof ImageView) && (view.getParent() instanceof DynamicBaseWidget)) {
            this.ve = (View) this.ve.getParent();
        }
        this.ve.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "alpha", 0.0f, 1.0f).setDuration((int) (this.tt.da() * 1000.0d));
        this.uj = new c(this.ve);
        final int i2 = this.ve.getLayoutParams().height;
        this.n = i2;
        this.f28871a = this.ve.getLayoutParams().width;
        if ("left".equals(this.tt.c()) || "right".equals(this.tt.c())) {
            i = (int) this.f28871a;
            str = "width";
        } else {
            str = "height";
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.uj, str, 0, i).setDuration((int) (this.tt.da() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(c(duration));
        arrayList.add(c(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.byazt.oj.da.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                da.this.uj.c(i2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }
        });
        return arrayList;
    }
}
