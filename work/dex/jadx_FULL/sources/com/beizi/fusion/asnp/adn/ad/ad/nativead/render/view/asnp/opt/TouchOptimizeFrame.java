package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TouchOptimizeFrame extends BaseOptimizeFrame {
    private final boolean d;
    private final boolean e;

    public TouchOptimizeFrame(@NonNull Context context, OptimizeModel optimizeModel, boolean z, boolean z2) {
        super(context, optimizeModel);
        this.d = z;
        this.e = z2;
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.BaseOptimizeFrame
    public void addToWindow() {
        onViewReappear();
        if (this.c instanceof ViewGroup) {
            ((ViewGroup) this.c).addView(this, new ViewGroup.LayoutParams(-1, -1));
        }
    }

    public boolean isParentUp() {
        return this.e;
    }

    public boolean isQuickTouch() {
        return this.d;
    }
}
