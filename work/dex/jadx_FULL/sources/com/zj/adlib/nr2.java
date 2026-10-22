package com.zj.adlib;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import com.facebook.drawee.components.DraweeEventTracker;
import com.facebook.drawee.drawable.VisibilityAwareDrawable;
import com.facebook.drawee.drawable.VisibilityCallback;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class nr2<DH extends DraweeHierarchy> implements VisibilityCallback {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DH f18492a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f18493a = false;
    public boolean b = false;
    public boolean c = true;
    public boolean d = true;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DraweeController f18491a = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DraweeEventTracker f43597a = new DraweeEventTracker();

    public nr2(@Nullable DH dh) {
        if (dh != null) {
            p(dh);
        }
    }

    public static <DH extends DraweeHierarchy> nr2<DH> d(@Nullable DH dh, Context context) {
        nr2<DH> nr2Var = new nr2<>(dh);
        nr2Var.m(context);
        return nr2Var;
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void a(boolean z) {
        if (this.c == z) {
            return;
        }
        this.f43597a.a(z ? DraweeEventTracker.Event.ON_DRAWABLE_SHOW : DraweeEventTracker.Event.ON_DRAWABLE_HIDE);
        this.c = z;
        c();
    }

    public final void b() {
        if (this.f18493a) {
            return;
        }
        this.f43597a.a(DraweeEventTracker.Event.ON_ATTACH_CONTROLLER);
        this.f18493a = true;
        DraweeController draweeController = this.f18491a;
        if (draweeController == null || draweeController.c() == null) {
            return;
        }
        this.f18491a.a();
    }

    public final void c() {
        if (this.b && this.c && this.d) {
            b();
        } else {
            e();
        }
    }

    public final void e() {
        if (this.f18493a) {
            this.f43597a.a(DraweeEventTracker.Event.ON_DETACH_CONTROLLER);
            this.f18493a = false;
            DraweeController draweeController = this.f18491a;
            if (draweeController != null) {
                draweeController.onDetach();
            }
        }
    }

    @Nullable
    public DraweeController f() {
        return this.f18491a;
    }

    public DH g() {
        return (DH) ax6.i(this.f18492a);
    }

    public DraweeEventTracker getDraweeEventTracker() {
        return this.f43597a;
    }

    public Drawable h() {
        DH dh = this.f18492a;
        if (dh == null) {
            return null;
        }
        return dh.a();
    }

    public boolean i() {
        return this.f18492a != null;
    }

    public void j() {
        this.f43597a.a(DraweeEventTracker.Event.ON_HOLDER_ATTACH);
        this.b = true;
        c();
    }

    public void k() {
        this.f43597a.a(DraweeEventTracker.Event.ON_HOLDER_DETACH);
        this.b = false;
        c();
    }

    public boolean l(MotionEvent motionEvent) {
        DraweeController draweeController = this.f18491a;
        if (draweeController == null) {
            return false;
        }
        return draweeController.onTouchEvent(motionEvent);
    }

    public void m(Context context) {
    }

    public final void n(boolean z) {
        this.f43597a.a(z ? DraweeEventTracker.Event.ON_ACTIVITY_START : DraweeEventTracker.Event.ON_ACTIVITY_STOP);
        this.d = z;
        c();
    }

    public void o(@Nullable DraweeController draweeController) {
        boolean z = this.f18493a;
        if (z) {
            e();
        }
        if (this.f18491a != null) {
            this.f43597a.a(DraweeEventTracker.Event.ON_CLEAR_OLD_CONTROLLER);
            this.f18491a.e(null);
        }
        this.f18491a = draweeController;
        if (draweeController != null) {
            this.f43597a.a(DraweeEventTracker.Event.ON_SET_CONTROLLER);
            this.f18491a.e(this.f18492a);
        } else {
            this.f43597a.a(DraweeEventTracker.Event.ON_CLEAR_CONTROLLER);
        }
        if (z) {
            b();
        }
    }

    @Override // com.facebook.drawee.drawable.VisibilityCallback
    public void onDraw() {
        if (this.f18493a) {
            return;
        }
        ad3.u0(DraweeEventTracker.class, "%x: Draw requested for a non-attached controller %x. %s", Integer.valueOf(System.identityHashCode(this)), Integer.valueOf(System.identityHashCode(this.f18491a)), toString());
        this.b = true;
        this.c = true;
        this.d = true;
        c();
    }

    public void p(DH dh) {
        this.f43597a.a(DraweeEventTracker.Event.ON_SET_HIERARCHY);
        q(null);
        DH dh2 = (DH) ax6.i(dh);
        this.f18492a = dh2;
        Drawable drawableA = dh2.a();
        a(drawableA == null || drawableA.isVisible());
        q(this);
        DraweeController draweeController = this.f18491a;
        if (draweeController != null) {
            draweeController.e(dh);
        }
    }

    public final void q(@Nullable VisibilityCallback visibilityCallback) {
        Object objH = h();
        if (objH instanceof VisibilityAwareDrawable) {
            ((VisibilityAwareDrawable) objH).j(visibilityCallback);
        }
    }

    public String toString() {
        return h76.f(this).g("controllerAttached", this.f18493a).g("holderAttached", this.b).g("drawableVisible", this.c).g("activityStarted", this.d).f("events", this.f43597a.toString()).toString();
    }
}
