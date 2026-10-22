package com.byazt.oj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 46})
public class n extends uj {
    public n(View view, com.byazt.aq.c cVar) {
        super(view, cVar);
    }

    private void tt(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "translationY", 0.0f, -com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.tt.gt())).setDuration((int) (this.tt.da() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oj.n.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                n.this.ve.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(c(duration));
    }

    private void uj(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "translationY", 0.0f, -com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.tt.gt())).setDuration((int) (this.tt.da() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(c(duration));
    }

    private void ve(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "translationY", 0.0f, -com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.tt.gt())).setDuration((int) (this.tt.da() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oj.n.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                n.this.ve.setTranslationY(0.0f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        list.add(c(duration));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:17:0x003d  */
    @Override // com.byazt.oj.uj
    public List<ObjectAnimator> c() {
        byte b;
        ArrayList arrayList = new ArrayList();
        switch (this.tt.rl()) {
            case "both":
                b = 0;
                break;
            case "none":
                b = 3;
                break;
            case "forwards":
                b = 1;
                break;
            case "backwards":
                b = 2;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            c(arrayList);
        } else if (b == 1) {
            uj(arrayList);
        } else if (b != 2) {
            ve(arrayList);
        } else {
            tt(arrayList);
        }
        return arrayList;
    }

    private void c(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.ve, "translationY", 0.0f, -com.byazt.or.x.c(com.byazt.sr.uj.getContext(), this.tt.gt())).setDuration(((int) (this.tt.da() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        com.byazt.aq.c cVar = this.tt;
        cVar.a(cVar.z() * 2);
        list.add(c(duration));
    }
}
