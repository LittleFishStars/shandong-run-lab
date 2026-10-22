package com.acse.ottn;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.acse.ottn.adapter.AutoScrollViewPager;
import java.util.Timer;
import java.util.TimerTask;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t extends ViewPager {
    public static final String g = "AutoViewPager";
    public static final int h = 3000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Timer f23261a;
    public c b;
    public boolean c;
    public int d;
    public Runnable e;
    public b f;

    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t.this.a();
        }
    }

    public static final class b extends Handler {
        public b() {
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public class c extends TimerTask {
        public c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            t.this.f.post(t.this.e);
        }

        public /* synthetic */ c(t tVar, a aVar) {
            this();
        }
    }

    public t(Context context) {
        this(context, null);
    }

    public void d() {
        f();
    }

    public void e() {
        g();
    }

    public void f() {
        this.c = false;
        Timer timer = this.f23261a;
        if (timer != null) {
            timer.cancel();
            this.f23261a = null;
        }
    }

    public void g() {
        if (((e0) getAdapter()).a() == 0) {
            return;
        }
        f();
        b();
    }

    public TextView getSubTitle() {
        if (getParent() instanceof AutoScrollViewPager) {
            return ((AutoScrollViewPager) getParent()).getSubTitle();
        }
        return null;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            f();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            e();
        }
        return super.onTouchEvent(motionEvent);
    }

    public t(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = new a();
        this.f = new b(null);
    }

    public void a(t tVar, e0 e0Var) {
        e0Var.a(tVar, e0Var);
    }

    public final void b() {
        this.c = true;
        if (this.f23261a == null) {
            this.f23261a = new Timer();
        }
        this.f23261a.schedule(new c(this, null), 3000L, 3000L);
    }

    public boolean c() {
        return this.c;
    }

    public final void a() {
        int currentItem = getCurrentItem();
        this.d = currentItem;
        if (currentItem == getAdapter().getCount() - 1) {
            this.d = 0;
        } else {
            this.d++;
        }
        setCurrentItem(this.d);
        a(this.d % ((e0) getAdapter()).a());
    }

    public void b(int i) {
        a(i, 0);
    }

    public void a(int i, int i2) {
        if (getParent() instanceof AutoScrollViewPager) {
            ((AutoScrollViewPager) getParent()).a(i, i2);
        } else {
            Log.e(g, "parent view not be AutoScrollViewPager");
        }
    }

    public void a(int i) {
        if (getParent() != null && (getParent() instanceof AutoScrollViewPager)) {
            ((AutoScrollViewPager) getParent()).b(i);
        }
    }
}
