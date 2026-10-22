package com.zj.adlib;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class e27 extends StateListDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Drawable f41330a;

    public Drawable a() {
        return this.f41330a;
    }

    @Override // android.graphics.drawable.StateListDrawable
    public void addState(int[] stateSet, Drawable drawable) {
        if (stateSet != null && stateSet.length == 1 && stateSet[0] == 0) {
            this.f41330a = drawable;
        }
        super.addState(stateSet, drawable);
    }
}
