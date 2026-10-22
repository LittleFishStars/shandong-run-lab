package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.beizi.fusion.asnp.adn.ad.model.impl.resp.ad3.ad.nativ.income.optimize.OptimizeModel;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class SlideOptimizeFrame extends BaseOptimizeFrame {
    public SlideOptimizeFrame(@NonNull Context context, OptimizeModel optimizeModel) {
        super(context, optimizeModel);
    }

    @Override // com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.opt.BaseOptimizeFrame
    public void addToWindow() {
        onViewReappear();
        if (this.c instanceof ViewGroup) {
            ((ViewGroup) this.c).addView(this, new ViewGroup.LayoutParams(1, 1));
        }
    }
}
