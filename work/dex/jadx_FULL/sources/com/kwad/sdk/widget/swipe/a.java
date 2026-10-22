package com.kwad.sdk.widget.swipe;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public abstract class a {
    private boolean btP;

    public abstract boolean XR();

    public abstract boolean XS();

    public final boolean b(View view, MotionEvent motionEvent) {
        return !this.btP && XR();
    }

    public final boolean c(View view, MotionEvent motionEvent) {
        return !this.btP && XS();
    }
}
