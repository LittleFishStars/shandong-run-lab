package com.kc.dw.platform.ad_adapter.paster;

import android.view.MotionEvent;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d.a f39482a;

    public b(d.a aVar) {
        this.f39482a = aVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f39482a.b.q = System.currentTimeMillis();
            this.f39482a.b.m = (int) motionEvent.getX();
            this.f39482a.b.n = (int) motionEvent.getY();
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        d dVar = this.f39482a.b;
        System.currentTimeMillis();
        dVar.getClass();
        this.f39482a.b.o = (int) motionEvent.getX();
        this.f39482a.b.p = (int) motionEvent.getY();
        return false;
    }
}
