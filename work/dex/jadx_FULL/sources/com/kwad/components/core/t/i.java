package com.kwad.components.core.t;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class i implements View.OnClickListener {
    private j aly;

    public i() {
        this(false);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.aly.a(view, this);
    }

    private i(boolean z) {
        this.aly = new j(false);
    }
}
