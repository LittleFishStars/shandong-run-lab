package com.acse.ottn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class s2 extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23194a;
    public float b;
    public float c;
    public r2 d;
    public WindowManager e;

    public s2(@NonNull Context context) {
        this(context, null);
    }

    public final void a(Context context) {
        this.f23194a = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 || action != 2) {
                return false;
            }
            return Math.abs(motionEvent.getX() - this.b) > ((float) this.f23194a) || Math.abs(motionEvent.getY() - this.c) > ((float) this.f23194a);
        }
        this.b = motionEvent.getX();
        this.c = motionEvent.getY();
        this.d.a((int) motionEvent.getRawX());
        this.d.b((int) motionEvent.getRawY());
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.d == null || this.e == null) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d.a((int) motionEvent.getRawX());
            this.d.b((int) motionEvent.getRawY());
        } else if (action == 1) {
            performClick();
        } else if (action == 2) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            int iB = rawX - this.d.b();
            int iC = rawY - this.d.c();
            this.d.a(rawX);
            this.d.b(rawY);
            this.d.a().x += iB;
            this.d.a().y += iC;
            this.e.updateViewLayout(this, this.d.a());
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public s2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void a(r2 r2Var, WindowManager windowManager) {
        this.d = r2Var;
        this.e = windowManager;
    }

    public s2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23194a = 0;
        a(context);
    }
}
