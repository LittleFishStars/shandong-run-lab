package com.kc.cw.ad.internal.e;

import android.view.MotionEvent;
import android.view.View;
import com.kc.cw.ad.d.i;
import com.kc.cw.ad.internal.q;
import com.kc.cw.ad.internal.utilities.ViewUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f39032a;
    private float b;
    private float c;
    private boolean d;
    private boolean e = false;
    private final boolean f;
    private final a g;
    private final com.kc.cw.ad.a.d h;

    @Keep
    public interface a {
        void a(View view, com.kc.cw.ad.a.d dVar);
    }

    public h(View view, boolean z, a aVar) {
        int screenHeight;
        this.f = z;
        this.g = aVar;
        com.kc.cw.ad.a.d dVar = new com.kc.cw.ad.a.d(1);
        this.h = dVar;
        if (view == null || view.getWidth() <= 0 || view.getHeight() <= 0) {
            dVar.e(ViewUtil.getScreenWidth(q.a().l()));
            screenHeight = ViewUtil.getScreenHeight(q.a().l());
        } else {
            dVar.e(view.getWidth());
            screenHeight = view.getHeight();
        }
        dVar.f(screenHeight);
    }

    private static float a(float f) {
        return f / q.a().r().density;
    }

    public static float a(float f, float f2, float f3, float f4) {
        float f5 = f - f3;
        float f6 = f2 - f4;
        return a((float) Math.sqrt((f5 * f5) + (f6 * f6)));
    }

    private void a(View view) {
        a aVar = this.g;
        if (aVar != null) {
            aVar.a(view, this.h);
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f39032a = System.currentTimeMillis();
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
            this.h.a((int) motionEvent.getRawX());
            this.h.b((int) motionEvent.getRawY());
            this.h.a(String.valueOf(System.currentTimeMillis()));
            this.h.d(String.valueOf(System.currentTimeMillis()));
            this.h.c(String.valueOf(System.currentTimeMillis() / 1000));
            this.d = true;
            if (this.f && !this.e) {
                int iA = i.a(150);
                this.h.c((int) motionEvent.getRawX());
                this.h.d((int) motionEvent.getRawY());
                this.h.b(String.valueOf(System.currentTimeMillis() + ((long) (iA + 50))));
                a(view);
                this.e = true;
            }
        } else if (action != 1) {
            if (action == 2 && this.d && a(this.b, this.c, motionEvent.getX(), motionEvent.getY()) > 15.0f) {
                this.d = false;
            }
        } else if (System.currentTimeMillis() - this.f39032a < 1000 && this.d && (!this.f || this.e)) {
            this.h.c((int) motionEvent.getRawX());
            this.h.d((int) motionEvent.getRawY());
            this.h.b(String.valueOf(System.currentTimeMillis()));
            a(view);
        }
        return true;
    }
}
