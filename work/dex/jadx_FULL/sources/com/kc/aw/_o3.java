package com.kc.aw;

import android.view.MotionEvent;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _o3 implements Runnable {
    public final View _a;
    public final long _b;
    public final long _c;
    public final int _d;
    public final int _e;

    public _o3(View view, long j, long j2, int i, int i2) {
        this._a = view;
        this._b = j;
        this._c = j2;
        this._d = i;
        this._e = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this._a != null) {
            MotionEvent motionEventObtain = MotionEvent.obtain(this._b, this._c, 1, this._d, this._e, 0);
            this._a.dispatchTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }
}
