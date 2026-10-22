package com.alibaba.ariver.app.ui.tabbar;

import android.R;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TabStateListDrawable extends StateListDrawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Drawable f23839a;
    private Drawable b;

    public void addCheckedState(Drawable drawable) {
        addState(new int[]{R.attr.state_pressed}, drawable);
        addState(new int[]{R.attr.state_selected}, drawable);
        this.b = drawable;
        Drawable drawable2 = this.f23839a;
        if (drawable2 != null) {
            addNormalState(drawable2);
        }
    }

    public synchronized void addNormalState(Drawable drawable) {
        if (this.b == null) {
            this.f23839a = drawable;
        } else {
            addState(new int[0], drawable);
        }
    }
}
