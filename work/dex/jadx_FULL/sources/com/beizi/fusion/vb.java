package com.beizi.fusion;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class vb extends rb {
    private ViewGroup e;

    public vb(Context context, ba baVar) {
        super(context, baVar);
    }

    private boolean b(ViewGroup viewGroup) {
        return viewGroup.getVisibility() == 0;
    }

    @Override // com.beizi.fusion.rb
    public final void a(Context context) {
        if (!this.d.f() || !a(this.e)) {
            this.d.b(n1.ERROR_AD_NOT_READY_TO_SHOW);
            return;
        }
        View viewA = this.d.a(false);
        if (viewA != null) {
            this.e.addView(viewA);
        }
    }

    public void c(ViewGroup viewGroup) {
        this.e = viewGroup;
    }

    private boolean a(ViewGroup viewGroup) {
        return viewGroup != null && b(viewGroup);
    }
}
