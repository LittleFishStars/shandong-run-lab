package com.byazt.hn;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 25, 54})
public final class ve {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f28619a;
    public final Context c;
    public boolean i;
    public View n;
    public boolean sp;
    public tt tt;
    public com.byazt.hn.c uj;
    public n ve;
    public Application z;
    public boolean x = true;
    public final Rect da = new Rect();
    public final View.OnLayoutChangeListener sl = new View.OnLayoutChangeListener() { // from class: com.byazt.hn.ve.1
        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (ve.this.uj != null) {
                ve.this.uj.setBounds(0, 0, i3 - i, i4 - i2);
            }
            ve.this.x();
        }
    };
    public final ViewTreeObserver.OnScrollChangedListener t = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.byazt.hn.ve.2
        @Override // android.view.ViewTreeObserver.OnScrollChangedListener
        public void onScrollChanged() {
            ve.this.x();
        }
    };
    public final ViewTreeObserver.OnWindowFocusChangeListener u = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: com.byazt.hn.ve.3
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean z) {
            ve.this.x();
        }
    };
    public final View.OnAttachStateChangeListener yp = new View.OnAttachStateChangeListener() { // from class: com.byazt.hn.ve.4
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            ve.this.n();
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            ve.this.a();
        }
    };
    public final Application.ActivityLifecycleCallbacks m = new c() { // from class: com.byazt.hn.ve.5
        @Override // com.byazt.hn.ve.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            if (activity == ve.this.m()) {
                ve.this.x = false;
                ve.this.x();
            }
        }

        @Override // com.byazt.hn.ve.c, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (activity == ve.this.m()) {
                ve.this.x = true;
                ve.this.x();
            }
        }
    };

    @com.byazt.zqa.c(c = {0, 1, 25, 24})
    public static abstract class c implements Application.ActivityLifecycleCallbacks {
        private c() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    public ve(Context context) {
        this.c = context != null ? context.getApplicationContext() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        View view = this.n;
        if (view == null) {
            this.f28619a = false;
            this.sp = false;
            rh();
            this.i = false;
            return;
        }
        if (this.f28619a) {
            this.f28619a = false;
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnScrollChangedListener(this.t);
                ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = this.u;
                if (onWindowFocusChangeListener != null) {
                    viewTreeObserver.removeOnWindowFocusChangeListener(onWindowFocusChangeListener);
                }
            }
            c(false);
            u();
        }
        sl();
        rh();
    }

    private void da() {
        View view = this.n;
        if (view == null || this.i) {
            return;
        }
        view.addOnLayoutChangeListener(this.sl);
        this.n.addOnAttachStateChangeListener(this.yp);
        this.i = true;
    }

    private void i() {
        tt ttVar = this.tt;
        if (ttVar == null) {
            return;
        }
        if (this.ve == null) {
            this.ve = new n(ttVar);
        }
        View view = this.n;
        if (view != null) {
            this.ve.c(view.getWidth(), this.n.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity m() {
        View view = this.n;
        if (view == null) {
            return null;
        }
        return c(view.getContext());
    }

    private void nu() {
        Activity activityM;
        Application application;
        if (this.z != null || (activityM = m()) == null || (application = activityM.getApplication()) == null) {
            return;
        }
        this.z = application;
        application.registerActivityLifecycleCallbacks(this.m);
    }

    private void rh() {
        Application application = this.z;
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(this.m);
            this.z = null;
        }
    }

    private void sl() {
        View view = this.n;
        if (view == null || !this.i) {
            return;
        }
        view.removeOnLayoutChangeListener(this.sl);
        this.n.removeOnAttachStateChangeListener(this.yp);
        this.i = false;
    }

    private boolean sp() {
        View view;
        return this.f28619a && (view = this.n) != null && this.x && view.getVisibility() == 0 && this.n.getWindowVisibility() == 0 && this.n.getWidth() > 0 && this.n.getHeight() > 0 && this.n.getAlpha() > 0.0f && this.n.getGlobalVisibleRect(this.da) && this.da.width() > 1 && this.da.height() > 1;
    }

    private void t() {
        if (this.n == null || this.tt == null || !z()) {
            return;
        }
        i();
        if (this.uj == null) {
            this.uj = new com.byazt.hn.c(this.ve);
        }
        int width = this.n.getWidth();
        int height = this.n.getHeight();
        if (width > 0 && height > 0) {
            this.uj.setBounds(0, 0, width, height);
        }
        this.n.getOverlay().add(this.uj);
    }

    private void u() {
        if (this.n == null || this.uj == null || !z()) {
            return;
        }
        this.n.getOverlay().remove(this.uj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x() {
        c(sp());
    }

    private void yp() {
        com.byazt.hn.c cVar = this.uj;
        if (cVar != null) {
            cVar.tt();
        }
        n nVar = this.ve;
        if (nVar != null) {
            nVar.a();
            this.ve = null;
        }
        this.uj = null;
    }

    private static boolean z() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        if (this.f28619a || this.n == null || this.tt == null || !z()) {
            return;
        }
        da();
        this.f28619a = true;
        t();
        ViewTreeObserver viewTreeObserver = this.n.getViewTreeObserver();
        if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnScrollChangedListener(this.t);
            ViewTreeObserver.OnWindowFocusChangeListener onWindowFocusChangeListener = this.u;
            if (onWindowFocusChangeListener != null) {
                viewTreeObserver.addOnWindowFocusChangeListener(onWindowFocusChangeListener);
            }
        }
        nu();
        x();
    }

    public void tt() {
        a();
        this.n = null;
        yp();
    }

    public void uj() {
        a();
    }

    public void ve() {
        n();
    }

    public void c(String str) {
        tt ttVarC = tt.c(this.c, str);
        if (ttVarC != null && ttVarC.ve()) {
            if (this.tt == ttVarC) {
                return;
            }
            u();
            yp();
            this.tt = ttVarC;
            if (!this.f28619a || this.n == null) {
                return;
            }
            t();
            boolean z = this.sp;
            this.sp = false;
            c(z || sp());
            return;
        }
        if (this.tt != null) {
            u();
            yp();
            this.tt = null;
        }
    }

    public boolean c() {
        return this.tt != null;
    }

    public void c(View view) {
        if (this.n == view) {
            return;
        }
        tt();
        this.n = view;
        if (view == null || this.tt == null || !z()) {
            return;
        }
        da();
        if (this.n.getWindowToken() != null) {
            n();
        }
    }

    private void c(boolean z) {
        if (this.sp == z) {
            return;
        }
        this.sp = z;
        if (z) {
            i();
            n nVar = this.ve;
            if (nVar != null) {
                nVar.uj();
            }
            com.byazt.hn.c cVar = this.uj;
            if (cVar != null) {
                cVar.c();
                return;
            }
            return;
        }
        com.byazt.hn.c cVar2 = this.uj;
        if (cVar2 != null) {
            cVar2.tt();
        }
        n nVar2 = this.ve;
        if (nVar2 != null) {
            nVar2.n();
        }
    }

    private static Activity c(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            Context baseContext = ((ContextWrapper) context).getBaseContext();
            if (baseContext == context) {
                return null;
            }
            context = baseContext;
        }
        return null;
    }
}
