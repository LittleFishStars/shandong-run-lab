package com.byazt.lbn;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.byazt.bzd.x;
import com.byazt.nr.da;
import com.byazt.nr.m;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 496, 1578})
public class LazeLayout<T extends View> extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View.OnClickListener f28768a;
    public volatile com.byazt.lbn.c<T> c;
    public AtomicBoolean n;
    public View.OnTouchListener sp;
    public volatile Context tt;
    public AtomicBoolean uj;
    public c ve;
    public T x;

    public interface c<T extends View> {
        void onFill(T t);
    }

    public LazeLayout(Context context, com.byazt.lbn.c cVar, c cVar2) {
        super(context);
        this.uj = new AtomicBoolean(false);
        this.n = new AtomicBoolean(false);
        this.c = cVar;
        this.tt = context;
        this.ve = cVar2;
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.n.set(true);
        if (this.uj.get()) {
            return;
        }
        this.uj.set(true);
        T t = this.x;
        if (t != null) {
            c(t, getParent());
        } else {
            da.ve().post(new Runnable() { // from class: com.byazt.lbn.LazeLayout.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.x = lazeLayout.c.inflate(LazeLayout.this.tt);
                        if (LazeLayout.this.x == null) {
                            return;
                        }
                        LazeLayout lazeLayout2 = LazeLayout.this;
                        lazeLayout2.c(lazeLayout2.x, LazeLayout.this.getParent());
                    } catch (Exception e) {
                        m.tt("LazeLayout", "inflate error", e);
                    }
                }
            });
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.n.set(false);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f28768a = onClickListener;
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.sp = onTouchListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(final T t, final ViewParent viewParent) {
        if (t == null) {
            return;
        }
        if (viewParent == null) {
            if (this.n.get()) {
                da.ve().postDelayed(new Runnable() { // from class: com.byazt.lbn.LazeLayout.2
                    @Override // java.lang.Runnable
                    public void run() {
                        LazeLayout lazeLayout = LazeLayout.this;
                        lazeLayout.c(t, lazeLayout.getParent());
                    }
                }, 50L);
                return;
            } else {
                this.uj.set(false);
                return;
            }
        }
        if (viewParent instanceof ViewGroup) {
            x.c(new Runnable() { // from class: com.byazt.lbn.LazeLayout.3
                @Override // java.lang.Runnable
                public void run() {
                    if (LazeLayout.this.n.get()) {
                        LazeLayout.this.c(t, (ViewGroup) viewParent);
                    } else {
                        LazeLayout.this.uj.set(false);
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(T t, ViewGroup viewGroup) {
        int iIndexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        this.tt = null;
        this.c = null;
        ViewParent parent = t.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(t);
        }
        View.OnClickListener onClickListener = this.f28768a;
        if (onClickListener != null) {
            t.setOnClickListener(onClickListener);
        }
        View.OnTouchListener onTouchListener = this.sp;
        if (onTouchListener != null) {
            t.setOnTouchListener(onTouchListener);
        }
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(t, iIndexOfChild, layoutParams);
        } else {
            viewGroup.addView(t, iIndexOfChild);
        }
        c cVar = this.ve;
        if (cVar != null) {
            cVar.onFill(t);
        }
        this.x = null;
    }

    public void c() {
        this.x = null;
        this.c = null;
        this.tt = null;
        this.ve = null;
    }
}
