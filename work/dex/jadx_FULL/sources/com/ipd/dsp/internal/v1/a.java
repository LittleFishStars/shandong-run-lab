package com.ipd.dsp.internal.v1;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends com.ipd.dsp.internal.x1.c implements Runnable {
    public Handler g;
    public d<?> h;
    public int i;
    public long j;
    public HashSet<c> k;
    public e l;
    public View.OnClickListener m;

    /* JADX INFO: renamed from: com.ipd.dsp.internal.v1.a$a, reason: collision with other inner class name */
    public class AnimationAnimationListenerC0922a implements Animation.AnimationListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f38575a;

        public AnimationAnimationListenerC0922a(c cVar) {
            this.f38575a = cVar;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            try {
                if (a.this.k != null) {
                    a.this.k.add(this.f38575a);
                }
                a.this.removeView(this.f38575a.f38577a);
            } catch (Throwable unused) {
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f38576a = 0;
        public Animation b;
        public Path c;
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f38577a;
        public b b;
        public int c;

        public /* synthetic */ c(View view, AnimationAnimationListenerC0922a animationAnimationListenerC0922a) {
            this(view);
        }

        public c(View view) {
            this.f38577a = view;
            this.b = new b();
            this.c = 0;
        }
    }

    public static abstract class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<T> f38578a;

        public abstract View a(Context context);

        public abstract void a();

        public abstract void a(ViewGroup viewGroup, c cVar);

        public abstract Animation b(ViewGroup viewGroup, c cVar);
    }

    public interface e {
        void onStop();
    }

    public a(Context context) {
        super(context);
        this.g = new Handler();
        this.h = null;
        this.k = new HashSet<>();
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-65536);
        paint.setStrokeWidth(4.0f);
        setWillNotDraw(false);
    }

    public void i() {
        View.OnClickListener onClickListener = this.m;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void j() {
        e eVar = this.l;
        if (eVar != null) {
            eVar.onStop();
            this.l = null;
        }
        l();
    }

    public void k() {
        if (this.h == null) {
            return;
        }
        this.i = 0;
        Handler handler = this.g;
        if (handler != null) {
            handler.post(this);
        }
    }

    public final void l() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.g = null;
        }
        d<?> dVar = this.h;
        if (dVar != null) {
            dVar.a();
            this.h = null;
        }
        HashSet<c> hashSet = this.k;
        if (hashSet != null) {
            try {
                hashSet.clear();
            } catch (Throwable unused) {
            }
            this.k = null;
        }
        for (int i = 0; i < getChildCount(); i++) {
            try {
                getChildAt(i).clearAnimation();
            } catch (Throwable unused2) {
            }
        }
        removeAllViews();
    }

    @Override // java.lang.Runnable
    public void run() {
        d<?> dVar = this.h;
        if (dVar != null) {
            List<?> list = dVar.f38578a;
            if (list == null || list.isEmpty() || this.i > list.size() - 1) {
                j();
            } else {
                a(this.h);
                invalidate();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> void setAdapter(d<T> dVar) {
        this.h = dVar;
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.m = onClickListener;
    }

    public void setOnStopListener(e eVar) {
        this.l = eVar;
    }

    public final void a(d<?> dVar) {
        c next;
        HashSet<c> hashSet = this.k;
        if (hashSet == null || this.g == null) {
            return;
        }
        if (hashSet.isEmpty()) {
            next = new c(dVar.a(getContext()), null);
        } else {
            Iterator<c> it = this.k.iterator();
            next = it.next();
            it.remove();
        }
        next.c = this.i;
        addView(next.f38577a);
        dVar.a(this, next);
        next.b.b = dVar.b(this, next);
        Animation animation = next.b.b;
        if (animation != null) {
            animation.setAnimationListener(new AnimationAnimationListenerC0922a(next));
            next.f38577a.startAnimation(next.b.b);
        }
        this.g.postDelayed(this, next.b.f38576a - this.j);
        this.j = next.b.f38576a;
        this.i++;
    }
}
