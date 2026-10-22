package com.byazt.oj;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.camera.video.AudioStats;
import com.byazt.tm.DynamicBaseWidgetImp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 787, 15})
public abstract class uj implements com.byazt.tm.n {
    public com.byazt.aq.c tt;
    public View ve;
    public Set<ScheduledFuture<?>> uj = new HashSet();
    public List<ObjectAnimator> c = c();

    @com.byazt.zqa.c(c = {0, 1, 787, 123})
    public class c implements Runnable {
        public ObjectAnimator c;
        public ScheduledFuture<?> tt;

        public c(ObjectAnimator objectAnimator) {
            this.c = objectAnimator;
        }

        public void c(ScheduledFuture<?> scheduledFuture) {
            this.tt = scheduledFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (com.byazt.mf.c.c().ve() != null) {
                com.byazt.mf.c.c().ve().tt().post(new Runnable() { // from class: com.byazt.oj.uj.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.c.resume();
                    }
                });
                if (this.tt != null) {
                    uj.this.uj.remove(this.tt);
                }
            }
        }
    }

    public uj(View view, com.byazt.aq.c cVar) {
        this.ve = view;
        this.tt = cVar;
    }

    public abstract List<ObjectAnimator> c();

    @Override // com.byazt.tm.n
    public void tt() {
        List<ObjectAnimator> list = this.c;
        if (list == null) {
            return;
        }
        for (ObjectAnimator objectAnimator : list) {
            objectAnimator.cancel();
            objectAnimator.removeAllUpdateListeners();
        }
        Iterator<ScheduledFuture<?>> it = this.uj.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    public void ve() {
        List<ObjectAnimator> list = this.c;
        if (list == null) {
            return;
        }
        for (final ObjectAnimator objectAnimator : list) {
            objectAnimator.start();
            if (this.tt.nu() > AudioStats.AUDIO_AMPLITUDE_NONE) {
                objectAnimator.addListener(new Animator.AnimatorListener() { // from class: com.byazt.oj.uj.1
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                        objectAnimator.pause();
                        c cVar = uj.this.new c(objectAnimator);
                        ScheduledFuture<?> scheduledFutureC = com.byazt.or.n.c(cVar, (long) (uj.this.tt.nu() * 1000.0d), TimeUnit.MILLISECONDS);
                        cVar.c(scheduledFutureC);
                        uj.this.uj.add(scheduledFutureC);
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
            }
        }
    }

    public ObjectAnimator c(final ObjectAnimator objectAnimator) {
        objectAnimator.setStartDelay((long) (this.tt.yp() * 1000.0d));
        if (this.tt.z() > 0) {
            objectAnimator.setRepeatCount(this.tt.z() - 1);
        } else {
            objectAnimator.setRepeatCount(-1);
        }
        if (!"normal".equals(this.tt.m())) {
            if ("alternate".equals(this.tt.m()) || "alternate-reverse".equals(this.tt.m())) {
                objectAnimator.setRepeatMode(2);
            } else {
                objectAnimator.setRepeatMode(1);
            }
        }
        if ("ease-in-out".equals(this.tt.u())) {
            objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        } else if ("ease-in".equals(this.tt.m())) {
            objectAnimator.setInterpolator(new AccelerateInterpolator());
        } else if ("ease-out".equals(this.tt.m())) {
            objectAnimator.setInterpolator(new DecelerateInterpolator());
        } else {
            objectAnimator.setInterpolator(new LinearInterpolator());
        }
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oj.uj.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (valueAnimator.getCurrentPlayTime() > 0) {
                    uj.this.ve.setVisibility(0);
                    if (uj.this.ve.getParent() instanceof DynamicBaseWidgetImp) {
                        ((View) uj.this.ve.getParent()).setVisibility(0);
                    }
                    objectAnimator.removeAllUpdateListeners();
                }
            }
        });
        return objectAnimator;
    }
}
