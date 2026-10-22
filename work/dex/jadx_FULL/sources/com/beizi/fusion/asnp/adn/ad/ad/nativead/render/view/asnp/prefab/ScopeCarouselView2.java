package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.beizi.fusion.R;
import com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.render.RenderModel;
import com.beizi.fusion.ff;
import com.beizi.fusion.gf;
import com.beizi.fusion.he;
import com.beizi.fusion.ob;
import com.beizi.fusion.yk;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeCarouselView2 extends ScopeViewGroup implements ob {
    private static final int n = R.id.scope_animator_tag;
    private final List e;
    private int f;
    private long g;
    private final long h;
    private boolean i;
    private final e j;
    private final ff k;
    private int l;
    private final yk m;

    public class a extends yk {
        public a(long j, long j2) {
            super(j, j2);
        }

        @Override // com.beizi.fusion.yk
        public void a(long j) {
            ScopeCarouselView2 scopeCarouselView2 = ScopeCarouselView2.this;
            int i = scopeCarouselView2.l + 1000;
            scopeCarouselView2.l = i;
            scopeCarouselView2.k.a(gf.a.VIDEO_PROCESS, scopeCarouselView2, Integer.valueOf(i));
        }

        @Override // com.beizi.fusion.yk
        public void c() {
            ScopeCarouselView2.this.l = 0;
        }

        @Override // com.beizi.fusion.yk
        public void d() {
            ScopeCarouselView2.this.l = 0;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ScopeCarouselView2.this.nextCarousel();
        }
    }

    public class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27036a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        public c(int i, View view, View view2) {
            this.f27036a = i;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScopeCarouselView2 scopeCarouselView2 = ScopeCarouselView2.this;
            scopeCarouselView2.f = this.f27036a;
            scopeCarouselView2.f();
            ScopeCarouselView2.this.a(this.b);
            ScopeCarouselView2.this.a(this.c);
            ScopeCarouselView2 scopeCarouselView3 = ScopeCarouselView2.this;
            if (scopeCarouselView3.i) {
                scopeCarouselView3.startCarousel();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f27037a;
        final /* synthetic */ View b;
        final /* synthetic */ View c;

        public d(int i, View view, View view2) {
            this.f27037a = i;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ScopeCarouselView2 scopeCarouselView2 = ScopeCarouselView2.this;
            scopeCarouselView2.f = this.f27037a;
            scopeCarouselView2.f();
            ScopeCarouselView2.this.a(this.b);
            ScopeCarouselView2.this.a(this.c);
            ScopeCarouselView2 scopeCarouselView3 = ScopeCarouselView2.this;
            if (scopeCarouselView3.i) {
                scopeCarouselView3.e();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public static class e extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WeakReference f27038a;

        public e(WeakReference weakReference) {
            super(Looper.getMainLooper());
            this.f27038a = weakReference;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            ScopeCarouselView2 scopeCarouselView2 = (ScopeCarouselView2) this.f27038a.get();
            if (scopeCarouselView2 == null || scopeCarouselView2.e.isEmpty()) {
                removeCallbacksAndMessages(null);
            } else if (message.what == 1001) {
                scopeCarouselView2.a();
            }
        }
    }

    public ScopeCarouselView2(Context context) {
        super(context);
        this.e = new ArrayList();
        this.f = 0;
        this.g = 3000L;
        this.h = 500L;
        this.i = false;
        this.j = new e(new WeakReference(this));
        this.k = new ff();
        this.l = 0;
        this.m = new a(100000L, 1000L);
        b();
    }

    private void b() {
        setWillNotDraw(false);
        setDrawingCacheEnabled(true);
        setDrawingCacheQuality(1048576);
        setChildrenDrawingCacheEnabled(true);
        setOnClickListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.f = 0;
        f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void d() {
        this.i = true;
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.j.removeMessages(1001);
        this.j.sendEmptyMessageDelayed(1001, this.g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        if (this.e.isEmpty() || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        int i = 0;
        while (i < this.e.size()) {
            View view = (View) this.e.get(i);
            if (view != null) {
                c(view);
                a(view);
                view.setTranslationX(0.0f);
                view.setVisibility(i == this.f ? 0 : 4);
                view.invalidate();
            }
            i++;
        }
        invalidate();
    }

    private View getCurrentView() {
        int i;
        if (this.e.isEmpty() || (i = this.f) < 0 || i >= this.e.size()) {
            return null;
        }
        return (View) this.e.get(this.f);
    }

    @Override // com.beizi.fusion.ob
    public synchronized void addCarouseItemView(View view) {
        if (view != null) {
            if (!this.e.contains(view)) {
                view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                view.setDrawingCacheEnabled(true);
                view.setVisibility(4);
                this.e.add(view);
                addView(view);
                if (this.e.size() == 1) {
                    post(new Runnable() { // from class: com.zj.adlib.ow7
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f43846a.c();
                        }
                    });
                }
            }
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void bindRenderModel(RenderModel renderModel) {
        super.bindRenderModel(renderModel);
        if (renderModel.getViewModel() == null || renderModel.getViewModel().getScrollInterval() <= 0) {
            return;
        }
        this.g = renderModel.getViewModel().getScrollInterval();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void fillContent(he.a aVar) {
        aVar.b(this.b.getId());
    }

    @Override // com.beizi.fusion.ob
    public void nextCarousel() {
        int i = this.f + 1;
        if (i >= this.e.size()) {
            i = 0;
        }
        a(i);
        e();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.i = false;
        this.j.removeCallbacksAndMessages(null);
        for (View view : this.e) {
            c(view);
            a(view);
        }
        setDrawingCacheEnabled(false);
        setChildrenDrawingCacheEnabled(false);
        this.e.clear();
        removeAllViews();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.e.size() > 0) {
            post(new Runnable() { // from class: com.zj.adlib.mw7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43400a.f();
                }
            });
        }
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewPause(boolean z) {
        super.onViewPause(z);
        this.k.b();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void onViewResume(boolean z) {
        super.onViewResume(z);
        this.k.a();
    }

    @Override // com.beizi.fusion.ob
    public synchronized void pauseCarousel() {
        if (!this.i) {
            this.m.e();
            return;
        }
        this.i = false;
        this.j.removeMessages(1001);
        Iterator it = this.e.iterator();
        while (it.hasNext()) {
            c((View) it.next());
        }
        f();
        this.m.e();
    }

    @Override // com.beizi.fusion.ob
    public void registerAsVideoObserver(gf gfVar) {
        ff ffVar = this.k;
        if (ffVar != null) {
            ffVar.a(gfVar);
        }
    }

    /* JADX INFO: renamed from: seekToItemPosition, reason: merged with bridge method [inline-methods] */
    public void a(final int i) {
        if (this.e.isEmpty() || i < 0 || i >= this.e.size() || this.f == i) {
            return;
        }
        if (getWidth() == 0 || getHeight() == 0) {
            post(new Runnable() { // from class: com.zj.adlib.pw7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f44073a.a(i);
                }
            });
            return;
        }
        pauseCarousel();
        View currentView = getCurrentView();
        View view = (View) this.e.get(i);
        if (currentView == null || view == null) {
            return;
        }
        b(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(currentView, "translationX", 0.0f, -getWidth());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", getWidth(), 0.0f);
        a(objectAnimatorOfFloat, currentView);
        a(objectAnimatorOfFloat2, view);
        objectAnimatorOfFloat2.addListener(new c(i, currentView, view));
        objectAnimatorOfFloat.start();
        objectAnimatorOfFloat2.start();
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.render.ScopeViewGroup, com.beizi.fusion.he
    public void setExpressRoot(ScopeExpressContainer scopeExpressContainer) {
        super.setExpressRoot(scopeExpressContainer);
        ScopeExpressContainer.d.a(scopeExpressContainer, (ob) this);
    }

    @Override // com.beizi.fusion.ob
    public synchronized void startCarousel() {
        yk ykVar = this.m;
        if (ykVar != null) {
            if (ykVar.b()) {
                this.m.f();
            } else {
                this.m.g();
            }
        }
        if (this.e.size() >= 2 && !this.i) {
            if (getWidth() != 0 && getHeight() != 0) {
                this.i = true;
                e();
                return;
            }
            post(new Runnable() { // from class: com.zj.adlib.nw7
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43620a.d();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        if (this.e.size() < 2 || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        int size = (this.f + 1) % this.e.size();
        View currentView = getCurrentView();
        View view = (View) this.e.get(size);
        if (currentView == null || view == null) {
            return;
        }
        b(view);
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(currentView, "translationX", 0.0f, -getWidth());
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, "translationX", getWidth(), 0.0f);
        a(objectAnimatorOfFloat, currentView);
        a(objectAnimatorOfFloat2, view);
        objectAnimatorOfFloat2.addListener(new d(size, currentView, view));
        objectAnimatorOfFloat.start();
        objectAnimatorOfFloat2.start();
    }

    private void c(View view) {
        if (view == null) {
            return;
        }
        Object tag = view.getTag(n);
        if (tag instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) tag;
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            }
        }
    }

    private void b(View view) {
        if (view == null || getWidth() == 0 || getHeight() == 0) {
            return;
        }
        c(view);
        view.setTranslationX(getWidth());
        view.setVisibility(0);
        if (view.getMeasuredWidth() <= 0 || view.getMeasuredHeight() <= 0) {
            try {
                view.measure(View.MeasureSpec.makeMeasureSpec(getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getHeight(), 1073741824));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            } catch (Exception unused) {
            }
        }
        view.invalidate();
    }

    public ScopeCarouselView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new ArrayList();
        this.f = 0;
        this.g = 3000L;
        this.h = 500L;
        this.i = false;
        this.j = new e(new WeakReference(this));
        this.k = new ff();
        this.l = 0;
        this.m = new a(100000L, 1000L);
        b();
    }

    private void a(ObjectAnimator objectAnimator, View view) {
        if (objectAnimator == null || view == null) {
            return;
        }
        objectAnimator.setDuration(500L);
        objectAnimator.setTarget(view);
        view.setTag(n, objectAnimator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view) {
        if (view == null) {
            return;
        }
        view.setTag(n, null);
    }

    public ScopeCarouselView2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = new ArrayList();
        this.f = 0;
        this.g = 3000L;
        this.h = 500L;
        this.i = false;
        this.j = new e(new WeakReference(this));
        this.k = new ff();
        this.l = 0;
        this.m = new a(100000L, 1000L);
        b();
    }
}
