package com.kc.dw.platform.ad_adapter.recycler;

import android.view.MotionEvent;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class k implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f39509a;

    public k(i iVar) {
        this.f39509a = iVar;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                this.f39509a.m = motionEvent.getX();
                this.f39509a.n = motionEvent.getY();
                this.f39509a.o = motionEvent.getRawX();
                this.f39509a.p = motionEvent.getRawY();
                this.f39509a.t = System.currentTimeMillis();
                this.f39509a.l = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
