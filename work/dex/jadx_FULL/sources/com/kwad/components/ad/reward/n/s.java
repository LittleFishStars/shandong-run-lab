package com.kwad.components.ad.reward.n;

import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.annotation.IdRes;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public abstract class s extends d {
    protected ViewGroup wT;

    public final void a(ViewGroup viewGroup, @IdRes int i, @IdRes int i2) {
        if (this.wT != null) {
            return;
        }
        ViewStub viewStub = (ViewStub) viewGroup.findViewById(i);
        if (viewStub != null) {
            this.wT = (ViewGroup) viewStub.inflate();
        } else {
            this.wT = (ViewGroup) viewGroup.findViewById(i2);
        }
    }

    @Override // com.kwad.components.ad.reward.n.d
    public ViewGroup ib() {
        return this.wT;
    }
}
