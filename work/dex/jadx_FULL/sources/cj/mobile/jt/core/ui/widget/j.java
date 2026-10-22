package cj.mobile.jt.core.ui.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public abstract class j extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cj.mobile.jt.core.modle.g0 f22591a;
    public final cj.mobile.jt.core.modle.b0 b;

    public j(Context context, cj.mobile.jt.core.modle.g0 g0Var, cj.mobile.jt.core.modle.b0 b0Var) {
    }

    public abstract void a();

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }
}
