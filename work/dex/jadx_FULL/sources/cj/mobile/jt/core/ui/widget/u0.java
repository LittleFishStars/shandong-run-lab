package cj.mobile.jt.core.ui.widget;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class u0 extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public TextView f22606a;
    public FrameLayout b;
    public final cj.mobile.jt.core.modle.b0 c;
    public t0 d;

    public u0(Context context, cj.mobile.jt.core.modle.b0 b0Var) {
    }

    public final void a() {
    }

    public final void b() {
    }

    public View getRewardContainer() {
        return this.b;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setCallback(t0 t0Var) {
        this.d = t0Var;
    }
}
